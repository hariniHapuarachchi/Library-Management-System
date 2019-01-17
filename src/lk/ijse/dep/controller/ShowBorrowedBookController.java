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
import lk.ijse.dep.business.custom.IssuedBookBO;
import lk.ijse.dep.dto.CustomDTO;
import lk.ijse.dep.view.util.ReturnAndIssuedTM;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShowBorrowedBookController {

    public TableView<ReturnAndIssuedTM> tableShowBorrowed;
    public TextField serachDetails;
    @FXML
    private AnchorPane apViewIssued;

    private ObservableList<ReturnAndIssuedTM> tblItems;

    private IssuedBookBO issuedBookBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_ISSUED);
    public void initialize() throws Exception {

        tableShowBorrowed.getColumns().get(0).setStyle("-app-alignment:center");
        tableShowBorrowed.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tableShowBorrowed.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("reId"));
        tableShowBorrowed.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("bookId"));
        tableShowBorrowed.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("bookName"));
        tableShowBorrowed.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("memId"));
        tableShowBorrowed.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("expireDate"));
        tableShowBorrowed.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("status"));
        tableShowBorrowed.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("dateDiff"));
        tableShowBorrowed.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("fine"));

        List<CustomDTO> customDB = null;
        try {
            customDB = issuedBookBO.showBorrowed();
        } catch (Exception e) {
            Logger.getLogger("").log(Level.SEVERE,null,e);
        }
        ObservableList<CustomDTO> customDTOS = FXCollections.observableArrayList(customDB);
        tblItems = FXCollections.observableArrayList();
        for (CustomDTO customDTO : customDTOS) {

            double allFine = calculateFine(customDTO.getExDate(), String.valueOf(LocalDate.now()));
            Long different = ReturendWithin(customDTO.getExDate());

//            tblItems.add(new ReturnAndIssuedTM(different,allFine));
            tblItems.add(new ReturnAndIssuedTM(customDTO.getIssuedId(),customDTO.getrId(),customDTO.getiBookId(),customDTO.getbName(),customDTO.getiMemId(),customDTO.getExDate(),customDTO.getStatus(),different,allFine));
        }
        tableShowBorrowed.setItems(tblItems);



    }

    public void homeFromBorrwedView(ActionEvent actionEvent) throws IOException {

        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/view/MainPage.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) apViewIssued.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void searchBorrowed(ActionEvent actionEvent) {

        if (serachDetails.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Search ID is empty", ButtonType.OK).showAndWait();
            serachDetails.requestFocus();
            return;
        }

        ObservableList<ReturnAndIssuedTM> tempList = FXCollections.observableArrayList();

        for (ReturnAndIssuedTM returnAndIssuedTM : tblItems) {
            if (returnAndIssuedTM.getId().startsWith(serachDetails.getText())){

                tempList.add(returnAndIssuedTM);

            }else if (returnAndIssuedTM.getBookId().startsWith(serachDetails.getText())){

                tempList.add(returnAndIssuedTM);

            }else if (returnAndIssuedTM.getMemId().startsWith(serachDetails.getText())){

                tempList.add(returnAndIssuedTM);

            }else if (returnAndIssuedTM.getBookName().startsWith(serachDetails.getText())){

                tempList.add(returnAndIssuedTM);

            }else if (returnAndIssuedTM.getReturnId().startsWith(serachDetails.getText())){

                tempList.add(returnAndIssuedTM);
            }
        }

        tableShowBorrowed.setItems(tempList);
    }

    public double calculateFine(String eDate,String rDate) throws ParseException {

        boolean ans = checkHigherDate(eDate,rDate);


        if (ans==true){

            double fine = 0.00;
            return fine;

        }else{

            Long df = checkDateDifferent(eDate,rDate);

            double fine = df * 20;
            return fine;

        }
      //  return fine;

    }

    public boolean checkHigherDate(String expire,String returnDt) throws ParseException {

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date firstDate1 = sdf1.parse(expire);
        Date secondDate1 = sdf1.parse(returnDt);

        if (firstDate1.after(secondDate1)) {
            return true;
        } else if (firstDate1.before(secondDate1)) {

            return false;
        } else
            return Boolean.parseBoolean("yyy");
    }

    private Long checkDateDifferent(String expireDate,String returnDate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date firstDate = sdf.parse(expireDate);
        Date secondDate = sdf.parse(returnDate);

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return diff;

    }

    public Long ReturendWithin(String eDate) throws ParseException {

        String currentDate = String.valueOf(LocalDate.now());

        boolean ans = checkHigherDate(eDate,currentDate);

        Long diff = checkDateDifferent(eDate,currentDate);

        if (ans==true){

           return diff;

        }else
            return Long.valueOf(0);

    }

    public void resetDetails(ActionEvent actionEvent) throws Exception {
        initialize();
    }

    public void tblShowBorrowed_OnClick(MouseEvent mouseEvent) throws Exception {

        if (mouseEvent.getClickCount() == 2){

            ReturnAndIssuedTM selectedIssued = tableShowBorrowed.getSelectionModel().getSelectedItem();

            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/lk/ijse/dep/view/ReturnBook.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            ReturnBookController controller = fxmlLoader.getController();
            controller.setInitData(selectedIssued.getReturnId());
            Scene scene = new Scene(root);
            ((Stage)tableShowBorrowed.getScene().getWindow()).setScene(scene);
        }
    }
}
