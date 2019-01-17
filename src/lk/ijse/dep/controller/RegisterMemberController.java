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
import lk.ijse.dep.business.custom.RegisterMemberBO;
import lk.ijse.dep.dto.IssuedBookDTO;
import lk.ijse.dep.dto.MemberDTO;
import lk.ijse.dep.dto.ReturnBookDTO;
import lk.ijse.dep.view.util.MemberTM;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterMemberController {

    @FXML
    private TextField memberNIC;
    @FXML
    private AnchorPane apMember;
    @FXML
    private TextField memberID;
    @FXML
    private TextField memberName;
    @FXML
    private TextField memberAddress;
    @FXML
    private TextField memberMobile;
    @FXML
    private ComboBox<String> memberType;
    @FXML
    private TableView<MemberTM> memberTable;

    private RegisterMemberBO registerMemberBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_MEMBERS);

    public void initialize() {

        memberID.setEditable(false);
        memberName.setEditable(false);
        memberAddress.setEditable(false);
        memberMobile.setEditable(false);
        memberNIC.setEditable(false);
        memberType.setEditable(false);

        memberTable.getColumns().get(0).setStyle("-app-alignment:center");
        memberTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        memberTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        memberTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        memberTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("mobile"));
        memberTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("nicCard"));
        memberTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("memType"));

        List<MemberDTO> memberDB = null;
        try {
            memberDB = registerMemberBO.getMembers();
        } catch (Exception e) {
            Logger.getLogger("").log(Level.SEVERE,null,e);
        }
        ObservableList<MemberDTO> memberDTOS = FXCollections.observableArrayList(memberDB);
        ObservableList<MemberTM> tblItems = FXCollections.observableArrayList();
        for (MemberDTO memberDTO : memberDTOS) {
            tblItems.add(new MemberTM(memberDTO.getmId(),memberDTO.getmName(),memberDTO.getmAddress(),memberDTO.getMobile(),memberDTO.getNic(),memberDTO.getmType()));
        }
        memberTable.setItems(tblItems);

        memberTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MemberTM>() {
            @Override
            public void changed(ObservableValue<? extends MemberTM> observable, MemberTM oldValue, MemberTM selectedCustomer) {

                if (selectedCustomer == null) {
                    // Clear Selection
                    return;
                }

                memberID.setText(selectedCustomer.getId());
                memberName.setText(selectedCustomer.getName());
                memberAddress.setText(selectedCustomer.getAddress());
                memberMobile.setText(selectedCustomer.getMobile());
                memberNIC.setText(selectedCustomer.getNicCard());

                memberType.setValue(selectedCustomer.getMemType());

                memberID.setEditable(false);
            }
        });
    }


    public void homeFromMember(ActionEvent actionEvent) throws IOException {

        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/view/MainPage.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) apMember.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void newMember(ActionEvent actionEvent) {
        reset();
    }

    public void registerMember(ActionEvent actionEvent) {

        if (memberID.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Member ID is empty", ButtonType.OK).showAndWait();
            memberID.requestFocus();
            return;
        } else if (memberName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Member Name is empty", ButtonType.OK).showAndWait();
            memberName.requestFocus();
            return;
        } else if (memberAddress.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Member Address is empty", ButtonType.OK).showAndWait();
            memberAddress.requestFocus();
            return;
        }else if (memberMobile.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Member Mobile is empty", ButtonType.OK).showAndWait();
            memberMobile.requestFocus();
            return;
        }else if (memberNIC.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Member nic is empty", ButtonType.OK).showAndWait();
            memberNIC.requestFocus();
            return;
        }else if (memberType.getValue() == null) {
            new Alert(Alert.AlertType.ERROR, "Member type is empty", ButtonType.OK).showAndWait();
            memberType.requestFocus();
            return;
        }

        if (!isNICValid(memberNIC.getText())){
            new Alert(Alert.AlertType.ERROR, "Invalid NIC", ButtonType.OK).show();
            return;
        }else if (memberNIC.getText().length() != 10){
            new Alert(Alert.AlertType.ERROR, "NIC should have 10 elements with 'v'", ButtonType.OK).show();
            return;
        }

        if (!isValidPhone(memberMobile.getText())){
            new Alert(Alert.AlertType.ERROR, "Invalid Telephone Number", ButtonType.OK).show();
            return;
        }else if (memberMobile.getText().length() != 11){
            new Alert(Alert.AlertType.ERROR, "Telephone number should have 11 elements with '-'", ButtonType.OK).show();
            return;
        }

        if (memberTable.getSelectionModel().isEmpty()) {
            // New

            ObservableList<MemberTM> items = memberTable.getItems();
            for (MemberTM memberTM : items) {
                if (memberTM.getId().equals(memberID.getText())) {
                    new Alert(Alert.AlertType.ERROR, "Duplicate Member IDs are not allowed").showAndWait();
                    memberID.requestFocus();
                    return;
                }
            }

            MemberTM memberTM = new MemberTM(memberID.getText(),memberName.getText(),memberAddress.getText(),memberMobile.getText(),memberNIC.getText(), (String) memberType.getValue());
            memberTable.getItems().add(memberTM);
            MemberDTO memberDTO = new MemberDTO(memberID.getText(),memberName.getText(),memberAddress.getText(),memberMobile.getText(),memberNIC.getText(), (String) memberType.getValue());
            boolean result = false;
            try {
                result = registerMemberBO.addMembers(memberDTO);
            } catch (Exception e) {
                Logger.getLogger("").log(Level.SEVERE, null, e);
            }

            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Customer has been saved successfully", ButtonType.OK).showAndWait();
                memberTable.scrollTo(memberTM);
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to save the customer", ButtonType.OK).showAndWait();
            }

        } else {
            // Update

            MemberTM selectedCustomer = memberTable.getSelectionModel().getSelectedItem();
            selectedCustomer.setName(memberName.getText());
            selectedCustomer.setAddress(memberAddress.getText());
            selectedCustomer.setMobile(memberMobile.getText());
            selectedCustomer.setNicCard(memberNIC.getText());
            selectedCustomer.setMemType(String.valueOf(memberType.getValue()));

            memberTable.refresh();

            String selectedMemberID = memberTable.getSelectionModel().getSelectedItem().getId();

            boolean result = false;
            try {
                result = registerMemberBO.updateMembers(new MemberDTO(memberID.getText(),
                        memberName.getText(),
                        memberAddress.getText(),
                        memberMobile.getText(),
                        memberNIC.getText(),
                        (String) memberType.getValue()));
            } catch (Exception e) {
                Logger.getLogger("").log(Level.SEVERE, null, e);
            }

            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Member has been updated successfully", ButtonType.OK).showAndWait();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to update the Member", ButtonType.OK).showAndWait();
            }
        }

        reset();

    }

    public void deleteMember(ActionEvent actionEvent) {

        Alert confirmMsg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete this Member?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = confirmMsg.showAndWait();

        if (buttonType.get() == ButtonType.YES) {
            String selectedMember = memberTable.getSelectionModel().getSelectedItem().getId();

            memberTable.getItems().remove(memberTable.getSelectionModel().getSelectedItem());
            boolean result = false;
            try {
                result = registerMemberBO.deleteMembers(selectedMember);
            } catch (Exception e) {
                Logger.getLogger("").log(Level.SEVERE, null, e);
            }
            if (!result){
                new Alert(Alert.AlertType.ERROR, "Failed to delete the Member", ButtonType.OK).showAndWait();
            }else{
                reset();
            }
        }
    }

    private void reset() {
        memberID.clear();
        memberName.clear();
        memberAddress.clear();
        memberMobile.clear();
        memberNIC.clear();

        memberID.requestFocus();
        memberID.setEditable(true);
        memberName.setEditable(true);
        memberAddress.setEditable(true);
        memberMobile.setEditable(true);
        memberNIC.setEditable(true);

        memberTable.getSelectionModel().clearSelection();
    }

    public boolean isValidPhone(String tele){
        return tele.matches("\\d{3}-\\d{7}");
    }

    public boolean isNICValid(String nic){
        return nic.matches("\\d{9}[Vv]");
    }

    public void setInitData(String memberId) throws Exception {

        MemberDTO memberDTO = null;
        memberDTO = registerMemberBO.findMembers(memberId);
        memberTable.getSelectionModel().equals(memberDTO);

        memberID.setEditable(false);
        memberName.setEditable(true);
        memberAddress.setEditable(true);
        memberMobile.setEditable(true);
        memberNIC.setEditable(true);
       // memberMobile.setEditable(true);

        memberID.setText(memberDTO.getmId());
        memberName.setText(memberDTO.getmName());
        memberAddress.setText(memberDTO.getmAddress());
        memberMobile.setText(memberDTO.getMobile());
        memberNIC.setText(memberDTO.getNic());
        memberType.setValue(memberDTO.getmType());

        initialize();
    }

}
