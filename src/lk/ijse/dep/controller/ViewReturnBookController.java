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
import lk.ijse.dep.business.custom.IssuedBookBO;
import lk.ijse.dep.dto.CustomDTO;
import lk.ijse.dep.view.util.AddBookTM;
import lk.ijse.dep.view.util.ReturnAndIssuedTM;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewReturnBookController {

    public TextField searchViewReturnsID;
    @FXML
    private AnchorPane apViewRetunrs;
    @FXML
    private TableView<ReturnAndIssuedTM> tableViewReturns;

    private ObservableList<ReturnAndIssuedTM> tblItems;

    private IssuedBookBO issuedBookBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_ISSUED);

    public void initialize() throws Exception {

        tableViewReturns.getColumns().get(0).setStyle("-app-alignment:center");
        tableViewReturns.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tableViewReturns.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("returnId"));
        tableViewReturns.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("bookId"));
        tableViewReturns.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("memId"));
        tableViewReturns.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        tableViewReturns.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("returnDate"));

        List<CustomDTO> returnDB = null;
        try {
            returnDB = issuedBookBO.showReturnBookList();
        } catch (Exception e) {
            Logger.getLogger("").log(Level.SEVERE,null,e);
        }
        ObservableList<CustomDTO> customDTOS = FXCollections.observableArrayList(returnDB);
        tblItems = FXCollections.observableArrayList();
        for (CustomDTO customDTO : customDTOS) {

            tblItems.add(new ReturnAndIssuedTM(customDTO.getIssuedId(),customDTO.getrId(),customDTO.getiBookId(),customDTO.getiMemId(),customDTO.getIssuedDate(),customDTO.getReturnDate()));

        }
        tableViewReturns.setItems(tblItems);



    }

    public void homeFromViewReturns(ActionEvent actionEvent) throws IOException {

        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/view/MainPage.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) apViewRetunrs.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void searhViewReturns(ActionEvent actionEvent) {

        if (searchViewReturnsID.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Search Bar is empty", ButtonType.OK).showAndWait();
            searchViewReturnsID.requestFocus();
            return;
        }

        ObservableList<ReturnAndIssuedTM> tempList = FXCollections.observableArrayList();

        for (ReturnAndIssuedTM returnAndIssuedTM : tblItems) {
            if (returnAndIssuedTM.getId().startsWith(searchViewReturnsID.getText())) {

                tempList.add(returnAndIssuedTM);

            } else if (returnAndIssuedTM.getBookId().startsWith(searchViewReturnsID.getText())) {

                tempList.add(returnAndIssuedTM);

            } else if (returnAndIssuedTM.getReturnId().startsWith(searchViewReturnsID.getText())) {

                tempList.add(returnAndIssuedTM);

            } else if (returnAndIssuedTM.getMemId().startsWith(searchViewReturnsID.getText())) {

                tempList.add(returnAndIssuedTM);

            } else if (returnAndIssuedTM.getIssueDate().startsWith(searchViewReturnsID.getText())) {

                tempList.add(returnAndIssuedTM);

            }else if (returnAndIssuedTM.getReturnDate().startsWith(searchViewReturnsID.getText())) {

                tempList.add(returnAndIssuedTM);
            }

        }
    }
    public void resetViewReturns(ActionEvent actionEvent) throws Exception {

        initialize();
    }

    public void tblViewReturns_OnClick(MouseEvent mouseEvent) throws Exception {

        if (mouseEvent.getClickCount() == 2){

            ReturnAndIssuedTM selectedReturn = tableViewReturns.getSelectionModel().getSelectedItem();

            issuedBookBO.deleteIssuedBooks(selectedReturn.getId());
            issuedBookBO.deleteReturndBooks(selectedReturn.getReturnId());

            initialize();
        }

    }
}
