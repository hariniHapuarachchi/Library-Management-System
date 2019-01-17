package lk.ijse.dep.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.business.BOFactory;
import lk.ijse.dep.business.custom.AddBookBO;
import lk.ijse.dep.business.custom.RegisterMemberBO;
import lk.ijse.dep.dto.CustomDTO;
import lk.ijse.dep.dto.MemberDTO;
import lk.ijse.dep.view.util.AddBookTM;
import lk.ijse.dep.view.util.MemberTM;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewBookController {

    @FXML
    private AnchorPane apViewBook;
    @FXML
    private TextField searchBookDet;
    @FXML
    private TableView<AddBookTM> tableViewBook;

    private ObservableList<AddBookTM> tblItems;

    private AddBookBO addBookBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_BOOKS);

    public void initialize() throws Exception {

        tableViewBook.getColumns().get(0).setStyle("-app-alignment:center");
        tableViewBook.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("bookId"));
        tableViewBook.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("bookName"));
        tableViewBook.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("authorName"));
        tableViewBook.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("publishName"));
        tableViewBook.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("publishDate"));
        tableViewBook.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("copies"));
        tableViewBook.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("availableBooks"));

        List<CustomDTO> bookDB = null;
        try {
            bookDB = addBookBO.getBooks();
        } catch (Exception e) {
            Logger.getLogger("").log(Level.SEVERE,null,e);
        }
        ObservableList<CustomDTO> customDTOS = FXCollections.observableArrayList(bookDB);
        tblItems = FXCollections.observableArrayList();
        for (CustomDTO customDTO : customDTOS) {

            int available = customDTO.getCopies() - customDTO.getAvailableBooks();
            tblItems.add(new AddBookTM(customDTO.getbId(),customDTO.getbName(),customDTO.getaName(),customDTO.getpName(),customDTO.getPublishDate(),customDTO.getCopies(),available));

        }
        tableViewBook.setItems(tblItems);



    }

    public void homeFromViewBook(ActionEvent actionEvent) throws IOException {

        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/view/MainPage.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) apViewBook.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void searchViewBook(ActionEvent actionEvent) {

        if (searchBookDet.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Search Bar is empty", ButtonType.OK).showAndWait();
            searchBookDet.requestFocus();
            return;
        }

        ObservableList<AddBookTM> tempList = FXCollections.observableArrayList();

        for (AddBookTM addBookTM : tblItems) {
            if (addBookTM.getBookId().startsWith(searchBookDet.getText())){

                tempList.add(addBookTM);

            }else if (addBookTM.getBookName().startsWith(searchBookDet.getText())){

                tempList.add(addBookTM);

            }else if (addBookTM.getAuthorName().startsWith(searchBookDet.getText())){

                tempList.add(addBookTM);

            }else if (addBookTM.getPublishName().startsWith(searchBookDet.getText())){

                tempList.add(addBookTM);

            }else if (addBookTM.getPublishDate().startsWith(searchBookDet.getText())){

                tempList.add(addBookTM);
            }
        }

        tableViewBook.setItems(tempList);
    }

    public void resetViewBook(ActionEvent actionEvent) throws Exception {
        initialize();
    }

    public void tblViewBook_OnClick(MouseEvent mouseEvent) throws Exception {

        if (mouseEvent.getClickCount() == 2){

            AddBookTM selectedBook = tableViewBook.getSelectionModel().getSelectedItem();

            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/lk/ijse/dep/view/AddBook.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            AddBookController controller = fxmlLoader.getController();
            controller.setInitData(selectedBook.getBookId());
            Scene scene = new Scene(root);
            ((Stage)tableViewBook.getScene().getWindow()).setScene(scene);
        }
    }
}
