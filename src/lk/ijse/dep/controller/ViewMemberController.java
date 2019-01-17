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
import lk.ijse.dep.business.custom.RegisterMemberBO;
import lk.ijse.dep.dto.CustomDTO;
import lk.ijse.dep.dto.MemberDTO;
import lk.ijse.dep.view.util.MemberTM;
import lk.ijse.dep.view.util.ReturnAndIssuedTM;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewMemberController {

    @FXML
    private TableView<MemberTM> tableViewMember;
    @FXML
    private AnchorPane apViewMember;
    @FXML
    private TextField searchDet;

    private ObservableList<MemberTM> tblItems;

    private RegisterMemberBO registerMemberBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_MEMBERS);

    public void initialize() throws Exception {

        tableViewMember.getColumns().get(0).setStyle("-app-alignment:center");
        tableViewMember.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tableViewMember.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tableViewMember.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tableViewMember.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("mobile"));
        tableViewMember.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("nicCard"));
        tableViewMember.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("memType"));

        List<MemberDTO> memberDB = null;
        try {
            memberDB = registerMemberBO.getMembers();
        } catch (Exception e) {
            Logger.getLogger("").log(Level.SEVERE,null,e);
        }
        ObservableList<MemberDTO> memberDTOS = FXCollections.observableArrayList(memberDB);
        tblItems = FXCollections.observableArrayList();
        for (MemberDTO memberDTO : memberDTOS) {

            tblItems.add(new MemberTM(memberDTO.getmId(),memberDTO.getmName(),memberDTO.getmAddress(),memberDTO.getMobile(),memberDTO.getNic(),memberDTO.getmType()));

        }
        tableViewMember.setItems(tblItems);



    }

    public void homeFromViewMember(ActionEvent actionEvent) throws IOException {

        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/view/MainPage.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) apViewMember.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void searchMember(ActionEvent actionEvent) {


        if (searchDet.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Search Bar is empty", ButtonType.OK).showAndWait();
            searchDet.requestFocus();
            return;
        }

        ObservableList<MemberTM> tempList = FXCollections.observableArrayList();

        for (MemberTM memberTM : tblItems) {
            if (memberTM.getId().startsWith(searchDet.getText())){

                tempList.add(memberTM);

            }else if (memberTM.getName().startsWith(searchDet.getText())){

                tempList.add(memberTM);

            }else if (memberTM.getAddress().startsWith(searchDet.getText())){

                tempList.add(memberTM);

            }else if (memberTM.getMobile().startsWith(searchDet.getText())){

                tempList.add(memberTM);

            }else if (memberTM.getNicCard().startsWith(searchDet.getText())){

                tempList.add(memberTM);
            }else if (memberTM.getMemType().startsWith(searchDet.getText())){

                tempList.add(memberTM);
            }
        }

        tableViewMember.setItems(tempList);
    }

    public void resetMember(ActionEvent actionEvent) throws Exception {

        initialize();
    }

    public void tblViewMember_onClick(MouseEvent mouseEvent) throws Exception {


        if (mouseEvent.getClickCount() == 2){

            MemberTM selectedMember = tableViewMember.getSelectionModel().getSelectedItem();

            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/lk/ijse/dep/view/RegisterMember.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            RegisterMemberController controller = fxmlLoader.getController();
            controller.setInitData(selectedMember.getId());
            Scene scene = new Scene(root);
            ((Stage)tableViewMember.getScene().getWindow()).setScene(scene);
        }

    }
}
