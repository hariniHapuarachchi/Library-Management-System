package lk.ijse.dep.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.business.BOFactory;
import lk.ijse.dep.business.custom.AddBookBO;
import lk.ijse.dep.dto.*;
import lk.ijse.dep.view.util.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddBookController {

    @FXML
    private AnchorPane apBookAuthorPub;
    @FXML
    private TextField bookID;
    @FXML
    private TextField bookName;
    @FXML
    private TextField bookPublishDate;
    @FXML
    private TextField bookCopies;
    @FXML
    private TextField bookAuthor;
    @FXML
    private TextField bookPublishID;
    @FXML
    private TableView<AddBookTM> bookTable;

    private AddBookBO addBookBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_BOOKS);

    public void initialize() throws Exception {

        bookID.setEditable(false);
        bookName.setEditable(false);
        bookAuthor.setEditable(false);
        bookPublishID.setEditable(false);
        bookPublishDate.setEditable(false);
        bookCopies.setEditable(false);


        bookTable.getColumns().get(0).setStyle("-app-alignment:center");
        bookTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("bookId"));
        bookTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("bookName"));
        bookTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("authorName"));
        bookTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("publishName"));
        bookTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("publishDate"));
        bookTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("copies"));

        List<CustomDTO> customDB = null;
        try {
            customDB = addBookBO.getBooks();
        } catch (Exception e) {
            Logger.getLogger("").log(Level.SEVERE,null,e);
        }
        ObservableList<CustomDTO> customDTOS = FXCollections.observableArrayList(customDB);
        ObservableList<AddBookTM> tblItems = FXCollections.observableArrayList();
        for (CustomDTO customDTO : customDTOS) {
            tblItems.add(new AddBookTM(customDTO.getbId(),customDTO.getbName(),customDTO.getaName(),customDTO.getpName(),customDTO.getPublishDate(),customDTO.getCopies()));
        }
        bookTable.setItems(tblItems);


        bookTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<AddBookTM>() {
            @Override
            public void changed(ObservableValue<? extends AddBookTM> observable, AddBookTM oldValue, AddBookTM selectedCustomer) {

                if (selectedCustomer == null) {

                    return;
                }

                bookID.setText(selectedCustomer.getBookId());
                bookName.setText(selectedCustomer.getBookName());
                bookAuthor.setText(selectedCustomer.getAuthorName());
                bookPublishID.setText(selectedCustomer.getPublishName());
                bookPublishDate.setText(selectedCustomer.getPublishDate());
                bookCopies.setText(String.valueOf(selectedCustomer.getCopies()));

                bookID.setEditable(false);


            }
        });
    }

    public void addBook(ActionEvent actionEvent) throws Exception {

        if (bookID.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Book ID is empty", ButtonType.OK).showAndWait();
            bookID.requestFocus();
            return;
        } else if (bookName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Book Name is empty", ButtonType.OK).showAndWait();
            bookName.requestFocus();
            return;
        } else if (bookAuthor.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Author Name is empty", ButtonType.OK).showAndWait();
            bookAuthor.requestFocus();
            return;
        }else if (bookPublishID.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Publisher Name is empty", ButtonType.OK).showAndWait();
            bookPublishID.requestFocus();
            return;
        }else if (bookPublishDate.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Publisher Date is empty", ButtonType.OK).showAndWait();
            bookPublishDate.requestFocus();
            return;
        }else if (bookCopies.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Copies is empty", ButtonType.OK).showAndWait();
            bookCopies.requestFocus();
            return;
        }

        if (!isValidPubDate(bookPublishDate.getText())){
            new Alert(Alert.AlertType.ERROR, "Invalid Date Format", ButtonType.OK).show();
            return;
        }


        if (bookTable.getSelectionModel().isEmpty()) {
            // New

            ObservableList<AddBookTM> items = bookTable.getItems();
            for (AddBookTM addBookTM : items) {
                if (addBookTM.getBookId().equals(bookID.getText())) {
                    new Alert(Alert.AlertType.ERROR, "Duplicate Book IDs are not allowed").showAndWait();
                    bookID.requestFocus();
                    return;
                }
            }

            int availableQty = 0;
            int bookQty = Integer.parseInt(bookCopies.getText());
            AddBookTM addBookTM = new AddBookTM(bookID.getText(),bookName.getText(),bookAuthor.getText(),bookPublishID.getText(),bookPublishDate.getText(),bookQty,availableQty);
            bookTable.getItems().add(addBookTM);

            String aID = addBookBO.generateAuthorId();
            String pubId = addBookBO.generatePublisherId();
            String pubBookID = addBookBO.generatePublisherBookId();
            String bookAuthorID = addBookBO.generateAuthorBookId();

            AuthorDTO authorDTO = new AuthorDTO(aID,bookAuthor.getText());
            PublisherDTO publisherDTO = new PublisherDTO(pubId,bookPublishID.getText());
            BookWithPublisherDTO bookWithPublisherDTO = new BookWithPublisherDTO(pubBookID,bookID.getText(),pubId,bookPublishDate.getText());
            BookWithAuthorDTO bookWithAuthorDTO = new BookWithAuthorDTO(bookAuthorID,bookID.getText(),aID);
            BookDTO bookDTO = new BookDTO(bookID.getText(),bookName.getText(),Integer.parseInt(bookCopies.getText()),availableQty,publisherDTO,authorDTO,bookWithAuthorDTO,bookWithPublisherDTO);
            boolean result = false;
            try {
                addBookBO.addBook(bookDTO);
            } catch (Exception e) {
                Logger.getLogger("").log(Level.SEVERE, null, e);
            }

            if (!result) {
                new Alert(Alert.AlertType.INFORMATION, "Book,Author and Publisher has been saved successfully", ButtonType.OK).showAndWait();
                bookTable.scrollTo(addBookTM);
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to save", ButtonType.OK).showAndWait();
            }

        } else {
            // Update

            bookName.setEditable(true);
            bookAuthor.setEditable(true);
            bookPublishID.setEditable(true);
            bookPublishDate.setEditable(true);
            bookCopies.setEditable(true);
            AddBookTM selectedBook = bookTable.getSelectionModel().getSelectedItem();
            selectedBook.setBookName(bookName.getText());
            selectedBook.setAuthorName(bookAuthor.getText());
            selectedBook.setPublishName(bookPublishID.getText());
            selectedBook.setPublishDate(bookPublishDate.getText());
            selectedBook.setCopies(Integer.parseInt(bookCopies.getText()));
            bookTable.refresh();

            String selectedBookID = bookTable.getSelectionModel().getSelectedItem().getBookId();

            boolean result = false;
            try {
                result = addBookBO.updateBook(new BookDTO(bookID.getText(),
                        bookName.getText(),
                       Integer.parseInt(bookCopies.getText())));

                BookWithAuthorDTO aID = addBookBO.findAuthorFromBook(bookID.getText());

                result = addBookBO.updateAuthor(new AuthorDTO(aID.getAuthorId(),bookAuthor.getText()));

                BookWithPublisherDTO pID = addBookBO.findPublisherFromBook(bookID.getText());

                result = addBookBO.updatePublisher(new PublisherDTO(pID.getPubId(),bookPublishID.getText()));

                result=addBookBO.updateBookPub(new BookWithPublisherDTO(pID.getBpId(),bookPublishDate.getText()));
            } catch (Exception e) {
                Logger.getLogger("").log(Level.SEVERE, null, e);
            }

            if (!result) {
                new Alert(Alert.AlertType.INFORMATION, "Book,Author and Publisher has been updated successfully", ButtonType.OK).showAndWait();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to update", ButtonType.OK).showAndWait();
            }
        }

       reset();
    }

    public void deleteBook(ActionEvent actionEvent) {

        Alert confirmMsg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete this book?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = confirmMsg.showAndWait();

        if (buttonType.get() == ButtonType.YES) {
            String selectedCustomer = bookTable.getSelectionModel().getSelectedItem().getBookId();

            bookTable.getItems().remove(bookTable.getSelectionModel().getSelectedItem());
            boolean result = false;
            try {
                result = addBookBO.deleteBook(selectedCustomer);
                result = addBookBO.deleteBookPub(selectedCustomer);
                result = addBookBO.deleteBookAuthor(selectedCustomer);
            } catch (Exception e) {
                Logger.getLogger("").log(Level.SEVERE, null, e);
            }
            if (!result){
                new Alert(Alert.AlertType.ERROR, "Failed to delete the Book", ButtonType.OK).showAndWait();
            }else{
                reset();
            }
        }
    }

    public void newBook(ActionEvent actionEvent) {
        reset();
    }

    public void homeFromBook(ActionEvent actionEvent) throws IOException {

        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/view/MainPage.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) apBookAuthorPub.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    private void reset() {

        bookID.clear();
        bookName.clear();
        bookAuthor.clear();
        bookPublishID.clear();
        bookPublishDate.clear();
        bookCopies.clear();

        bookID.requestFocus();

        bookID.setEditable(true);
        bookName.setEditable(true);
        bookAuthor.setEditable(true);
        bookPublishID.setEditable(true);
        bookPublishDate.setEditable(true);
        bookCopies.setEditable(true);

        bookTable.getSelectionModel().clearSelection();
    }

    public boolean isValidPubDate(String dateBirth){

        return dateBirth.matches("^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$");

    }

    public void setInitData(String bookId) throws Exception {

        List<CustomDTO> custom = null;

        custom = addBookBO.getBooks();

        ObservableList<CustomDTO> customDTOS = FXCollections.observableArrayList(custom);

        for (CustomDTO customDTO : customDTOS) {

            if (customDTO.getbId().equals(bookId)){

                CustomDTO customDTO1 = new CustomDTO(String.valueOf(customDTO));
                System.out.println("CUSTOM DT ="+customDTO);
                bookTable.getSelectionModel().equals(customDTO1);

                bookID.setEditable(false);
                bookName.setEditable(true);
                bookAuthor.setEditable(true);
                bookPublishID.setEditable(true);
                bookPublishDate.setEditable(true);
                bookCopies.setEditable(true);
                // memberMobile.setEditable(true);

                bookID.setText(customDTO.getbId());
                bookName.setText(customDTO.getbName());
                bookAuthor.setText(customDTO.getaName());
                bookPublishID.setText(customDTO.getpName());
                bookPublishDate.setText(customDTO.getPublishDate());
                bookCopies.setText(String.valueOf(customDTO.getCopies()));

            }

        }



        initialize();
    }

}
