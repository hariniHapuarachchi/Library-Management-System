package lk.ijse.dep.controller;

//import com.sun.java.util.jar.pack.Instruction;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.dep.business.BOFactory;
import lk.ijse.dep.business.custom.AddBookBO;
import lk.ijse.dep.business.custom.IssuedBookBO;
import lk.ijse.dep.dto.*;
import lk.ijse.dep.view.util.AddBookTM;
import lk.ijse.dep.view.util.MemberTM;
import lk.ijse.dep.view.util.ReturnAndIssuedTM;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IssuedBookController {

    @FXML
    private AnchorPane apIssuedBook;
    @FXML
    private TextField issueID;
    @FXML
    private TextField issueMemID;
    @FXML
    private TextField issueBookID;
    @FXML
    private TextField issueDate;
    @FXML
    private TableView<ReturnAndIssuedTM> tableIssueBook;
    @FXML
    private TextField issueReturnID;
    @FXML
    private TextField issueexpireDt;

    private int count = 0;
    private IssuedBookBO issuedBookBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_ISSUED);
    private AddBookBO addBookBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_BOOKS);

    public void initialize() throws Exception {
        issueReturnID.setText(issuedBookBO.generateReturnId());
        calcDate();
        System.out.println(LocalDate.now());

        tableIssueBook.getColumns().get(0).setStyle("-app-alignment:center");
        tableIssueBook.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tableIssueBook.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("memId"));
        tableIssueBook.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("bookId"));
        tableIssueBook.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("expireDate"));
        tableIssueBook.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("returnId"));


        List<CustomDTO> customDB = null;
        try {
            customDB = issuedBookBO.getIssuedBooks();
        } catch (Exception e) {
            Logger.getLogger("").log(Level.SEVERE,null,e);
        }
        ObservableList<CustomDTO> customDTOS = FXCollections.observableArrayList(customDB);
        ObservableList<ReturnAndIssuedTM> tblItems = FXCollections.observableArrayList();

        for (CustomDTO customDTO : customDTOS) {

            tblItems.add(new ReturnAndIssuedTM(customDTO.getIssuedId(),customDTO.getiMemId(),customDTO.getiBookId(),customDTO.getExDate(),customDTO.getrId()));

        }
        tableIssueBook.setItems(tblItems);

        tableIssueBook.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ReturnAndIssuedTM>() {
            @Override
            public void changed(ObservableValue<? extends ReturnAndIssuedTM> observable, ReturnAndIssuedTM oldValue, ReturnAndIssuedTM selectedIssueBook) {

                if (selectedIssueBook == null) {
                    // Clear Selection
                    return;
                }

                issueID.setText(selectedIssueBook.getId());
                issueMemID.setText(selectedIssueBook.getMemId());
                issueBookID.setText(selectedIssueBook.getBookId());
                issueDate.setText(selectedIssueBook.getIssueDate());
                issueReturnID.setText(selectedIssueBook.getReturnId());
                issueexpireDt.setText(selectedIssueBook.getExpireDate());

                issueID.setEditable(false);
                issueexpireDt.setEditable(false);
                issueDate.setEditable(false);
                issueReturnID.setEditable(false);
            }
        });

    }
    public void homeFromIssue(ActionEvent actionEvent) throws IOException {

        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/view/MainPage.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) apIssuedBook.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void newIssue(ActionEvent actionEvent) throws Exception {
        reset();
        calcDate();
    }

    public void registerIssuedBook(ActionEvent actionEvent) {

        if (issueID.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Issue ID is empty", ButtonType.OK).showAndWait();
            issueID.requestFocus();
            return;
        } else if (issueBookID.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Book ID is empty", ButtonType.OK).showAndWait();
            issueBookID.requestFocus();
            return;
        } else if (issueMemID.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Member ID is empty", ButtonType.OK).showAndWait();
            issueMemID.requestFocus();
            return;
        } else if (issueDate.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Issue Date is empty", ButtonType.OK).showAndWait();
            issueDate.requestFocus();
            return;
        } else if (issueexpireDt.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Expire Date is empty", ButtonType.OK).showAndWait();
            issueexpireDt.requestFocus();
            return;
        } else if (issueReturnID.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Return ID is empty", ButtonType.OK).showAndWait();
            issueReturnID.requestFocus();
            return;
        }

        if (tableIssueBook.getSelectionModel().isEmpty()) {
            // New

            ObservableList<ReturnAndIssuedTM> items = tableIssueBook.getItems();
            for (ReturnAndIssuedTM returnAndIssuedTM : items) {
                if (returnAndIssuedTM.getId().equals(issueID.getText())) {
                    new Alert(Alert.AlertType.ERROR, "Duplicate Issued IDs are not allowed").showAndWait();
                    issueID.requestFocus();
                    return;
                }
            }


            ReturnAndIssuedTM returnAndIssuedTM = new ReturnAndIssuedTM(issueID.getText(), issueMemID.getText(), issueBookID.getText(), issueexpireDt.getText(),issueReturnID.getText());
            tableIssueBook.getItems().add(returnAndIssuedTM);

            System.out.println(issueexpireDt.getText());
            ReturnBookDTO returnBookDTO = new ReturnBookDTO(issueReturnID.getText(),issueexpireDt.getText());
            IssuedBookDTO issuedBookDTO = new IssuedBookDTO(issueID.getText(),issueBookID.getText(),issueMemID.getText(),issueDate.getText(),
                    issueReturnID.getText(),returnBookDTO);


            //List<CustomDTO> cus = null;
            List<CustomDTO> cusDB=null;
            try {
               // cus = addBookBO.getBooks();
                cusDB = issuedBookBO.showBorrowed();

            } catch (Exception e) {
                Logger.getLogger("").log(Level.SEVERE,null,e);
            }
            boolean result = false;
            try {

                ObservableList<CustomDTO> customDTOS = FXCollections.observableArrayList(cusDB);
               // ObservableList<CustomDTO> customDTOS1 = FXCollections.observableArrayList(cus);
                System.out.println(customDTOS.isEmpty());
                if (customDTOS.isEmpty()){
                    issuedBookBO.addIssuedBooks(issuedBookDTO);
                    int available = 1;
                    issuedBookBO.updateAvailableBook(new BookDTO(available, issueBookID.getText()));
                    reset();

                    return;
                }
                for (CustomDTO customDTO : customDTOS){
//                    System.out.println("ISSUE ID :"+customDTO.getIssuedId());

                    if (issueBookID.getText().equals(customDTO.getiBookId()) && issueMemID.getText().equals(customDTO.getiMemId())){
                        new Alert(Alert.AlertType.ERROR, "Member cannot get same book without return the previous book", ButtonType.OK).showAndWait();
                        issueBookID.requestFocus();
                       initialize();
                        return;
                    }
                    System.out.println("BOOKID:"+customDTO.getiBookId());
                    if (issueBookID.getText().equals(customDTO.getiBookId())){

                        System.out.println("COP :"+customDTO.getCopies());
                        System.out.println("AVb:"+customDTO.getAvailableBooks());

                        if (customDTO.getCopies() > customDTO.getAvailableBooks()) {
                            int available = customDTO.getAvailableBooks() + 1;

                            issuedBookBO.addIssuedBooks(issuedBookDTO);
                            issuedBookBO.updateAvailableBook(new BookDTO(available, issueBookID.getText()));
                            reset();

                        } else {
                            new Alert(Alert.AlertType.ERROR, "Book is not available", ButtonType.OK).showAndWait();
                            issueBookID.requestFocus();
                            initialize();
                            return;
                        }


                    }

                }


            } catch (Exception e) {
                Logger.getLogger("").log(Level.SEVERE, null, e);
            }
        }
    }
        public void deleteIssuedBook (ActionEvent actionEvent) throws Exception {

            Alert confirmMsg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete this Transaction?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> buttonType = confirmMsg.showAndWait();

            if (buttonType.get() == ButtonType.YES) {
                String selectedTransaction = tableIssueBook.getSelectionModel().getSelectedItem().getId();
                String selectedReturn = tableIssueBook.getSelectionModel().getSelectedItem().getReturnId();

                List<CustomDTO> cusDB=null;
                try {
                    // cus = addBookBO.getBooks();
                    cusDB = issuedBookBO.showBorrowed();

                } catch (Exception e) {
                    Logger.getLogger("").log(Level.SEVERE,null,e);
                }
                //boolean result = false;
                try {

                    ObservableList<CustomDTO> customDTOS = FXCollections.observableArrayList(cusDB);


                    for (CustomDTO customDTO : customDTOS) {

                        if (customDTO.getIssuedId().equals(selectedTransaction)){
                            new Alert(Alert.AlertType.ERROR, "Failed to delete the Transaction", ButtonType.OK).showAndWait();
                            return;
                        }
                    }


                } catch (Exception e) {
                    Logger.getLogger("").log(Level.SEVERE, null, e);
                }
                tableIssueBook.getItems().remove(tableIssueBook.getSelectionModel().getSelectedItem());
                boolean result = false;
                try {
                    result = issuedBookBO.deleteIssuedBooks(selectedTransaction);
                    result = issuedBookBO.deleteReturndBooks(selectedReturn);

                } catch (Exception e) {
                    Logger.getLogger("").log(Level.SEVERE, null, e);
                }

                    reset();


            }
        }

        private void reset () throws Exception {


            issueBookID.clear();
            issueID.clear();
            issueMemID.clear();
            issueReturnID.clear();

            issueID.requestFocus();

            issueID.setEditable(true);
            issueBookID.setEditable(true);
            issueMemID.setEditable(true);
            issueDate.setEditable(false);
            issueReturnID.setEditable(false);
            issueexpireDt.setEditable(false);

            issueReturnID.setText(issuedBookBO.generateReturnId());

            tableIssueBook.getSelectionModel().clearSelection();
        }

    private void calcDate() {


        issueDate.setText(String.valueOf(LocalDate.now()));

        if (LocalDate.now().lengthOfMonth() >= (LocalDate.now().getDayOfMonth() + 7)) {
            issueexpireDt.setText(LocalDate.now().getYear() + "-" + LocalDate.now().getMonthValue() + "-" + (LocalDate.now().getDayOfMonth() + 7));
        } else {
            int days = LocalDate.now().lengthOfMonth() - LocalDate.now().getDayOfMonth();
            int day = 0;
            switch (days) {
                case 6:
                    day = 1;
                    break;
                case 5:
                    day = 2;
                    break;
                case 4:
                    day = 3;
                    break;
                case 3:
                    day = 4;
                    break;
                case 2:
                    day = 5;
                    break;
                case 1:
                    day = 6;
                    break;

            }

            issueexpireDt.setText(LocalDate.now().getYear() + "-" + (LocalDate.now().getMonthValue() + 1) + "-" + day);
        }


    }

}

