package lk.ijse.dep.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep.business.BOFactory;
import lk.ijse.dep.business.custom.IssuedBookBO;
import lk.ijse.dep.dto.BookDTO;
import lk.ijse.dep.dto.CustomDTO;
import lk.ijse.dep.dto.IssuedBookDTO;
import lk.ijse.dep.dto.ReturnBookDTO;
import lk.ijse.dep.entity.ReturnBook;
import lk.ijse.dep.view.util.ReturnAndIssuedTM;
import lk.ijse.dep.view.util.ReturnBookTM;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReturnBookController {

    public Button btn_fine;
    @FXML
    private AnchorPane apReturnPage;
    @FXML
    private TextField returnID;
    @FXML
    private TextField returnBook;
    @FXML
    private TextField returnMember;
    @FXML
    private TextField returnExpire;
    @FXML
    private TextField returnDate;
    @FXML
    private ComboBox returnStatus;

    private static double fine = 0;
    private IssuedBookBO issuedBookBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_ISSUED);
    public void initialize() throws Exception {

        returnID.setEditable(false);
        returnBook.setEditable(false);
        returnMember.setEditable(false);
        returnExpire.setEditable(false);
        returnDate.setEditable(false);
        returnStatus.setEditable(false);

        btn_fine.setDisable(true);

    }

    public void CalcReturnsFine(ActionEvent actionEvent) throws Exception {

        if (returnID.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Return ID is empty", ButtonType.OK).showAndWait();
            returnID.requestFocus();
            return;
        } else if (returnBook.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Book ID is empty", ButtonType.OK).showAndWait();
            returnID.requestFocus();
            return;
        } else if (returnMember.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Member ID is empty", ButtonType.OK).showAndWait();
            returnID.requestFocus();
            return;
        }else if (returnExpire.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Expire Date is empty", ButtonType.OK).showAndWait();
            returnID.requestFocus();
            return;
        }


        String eDate = returnExpire.getText();

        String rDate = returnDate.getText();

        boolean ans = checkHigherDate(eDate,rDate);

        if (ans==true){
            fine = 0.00;

            new Alert(Alert.AlertType.INFORMATION, "No Fine", ButtonType.OK).showAndWait();

            btn_fine.setDisable(false);

        }else{

            Long df = checkDateDifferent(eDate,rDate);

            fine = df * 20;
           new Alert(Alert.AlertType.INFORMATION, "Fine : "+fine, ButtonType.OK).showAndWait();

            btn_fine.setDisable(false);

        }

    }

    public void deleteReturns(ActionEvent actionEvent) throws Exception {


        List<CustomDTO> cusDB=null;

        try {
            // cus = addBookBO.getBooks();
            cusDB = issuedBookBO.showBorrowed();

        } catch (Exception e) {
            Logger.getLogger("").log(Level.SEVERE,null,e);
        }

        try {

            ObservableList<CustomDTO> customDTOS = FXCollections.observableArrayList(cusDB);

            for (CustomDTO customDTO : customDTOS){


                System.out.println("BOOKID:"+customDTO.getiBookId());
                if (returnBook.getText().equals(customDTO.getiBookId())){

                    System.out.println("COP :"+customDTO.getCopies());
                    System.out.println("AVb:"+customDTO.getAvailableBooks());


                        int available = customDTO.getAvailableBooks() - 1;

                        issuedBookBO.updateAvailableBook(new BookDTO(available, returnBook.getText()));
                        returnStatus.setValue("RETURNED");
                        String st = String.valueOf(returnStatus.getValue());
                        issuedBookBO.updateReturnBooks(new ReturnBookDTO(st,fine,returnDate.getText(),returnID.getText()));
                        reset();



                }

            }


        } catch (Exception e) {
            Logger.getLogger("").log(Level.SEVERE, null, e);
        }



        new Alert(Alert.AlertType.INFORMATION, "Return Successfully", ButtonType.OK).showAndWait();
    }

    public void homeFromReturn(ActionEvent actionEvent) throws IOException {

        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/view/MainPage.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) apReturnPage.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void newReturn(ActionEvent actionEvent) {

        reset();
    }

    public void setOnKeyEnterForReturns(KeyEvent keyEvent) {
        returnID.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent ke)
            {
                if (ke.getCode().equals(KeyCode.ENTER))
                {

                    String oid = returnID.getText();

                    BookDTO cus = null;
                    try {
                        cus = issuedBookBO.checkAvailableQuantity(returnBook.getText());
                    } catch (Exception e) {
                        Logger.getLogger("").log(Level.SEVERE,null,e);
                    }

                    IssuedBookDTO issuedBookDTO = null;
                    ReturnBookDTO returnBookDTO=null;

                    try {


                        issuedBookDTO = issuedBookBO.findIssuedReturns(oid);
                        returnBookDTO = issuedBookBO.findReturnBooks(oid);



                        if (returnBookDTO.getrDate() == null){

                            System.out.println("true");

                            returnBook.setText(issuedBookDTO.getiBookId());
                            returnMember.setText(issuedBookDTO.getiMemId());
                            returnExpire.setText(returnBookDTO.getExDate());
                            returnDate.setText(String.valueOf(LocalDate.now()));
                            returnStatus.setValue(returnBookDTO.getStatus());

                        }else{

                            new Alert(Alert.AlertType.INFORMATION, "Book is Returned", ButtonType.OK).showAndWait();
                            returnID.selectAll();
                            returnID.requestFocus();
                            return;

                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        });


    }

    public void reset(){

        btn_fine.setDisable(true);
        returnID.setEditable(true);

        returnID.clear();
        returnBook.clear();
        returnMember.clear();
        returnExpire.clear();
        returnStatus.setValue("NOT RETURNED");

    }

    private Long checkDateDifferent(String expireDate,String returnDate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date firstDate = sdf.parse(expireDate);
        Date secondDate = sdf.parse(returnDate);

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        System.out.println(diffInMillies);
        System.out.println(diff);
        return diff;

    }

    public boolean checkHigherDate(String expireDate,String returnDate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date firstDate = sdf.parse(expireDate);
        Date secondDate = sdf.parse(returnDate);

        if (firstDate.after(secondDate)) {

            return true;
        } else if (firstDate.before(secondDate)) {

            return false;
        }else
            return false;
    }

    public void setInitData(String returnId) throws Exception {

        IssuedBookDTO issuedBookDTO = null;
        ReturnBookDTO returnBookDTO=null;

        issuedBookDTO = issuedBookBO.findIssuedReturns(returnId);
        returnBookDTO = issuedBookBO.findReturnBooks(returnId);

        returnID.setText(returnBookDTO.getrId());
        returnBook.setText(issuedBookDTO.getiBookId());
        returnMember.setText(issuedBookDTO.getiMemId());
        returnExpire.setText(returnBookDTO.getExDate());
        returnDate.setText(String.valueOf(LocalDate.now()));
        returnStatus.setValue(returnBookDTO.getStatus());
    }

}
