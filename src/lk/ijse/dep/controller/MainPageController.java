package lk.ijse.dep.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {

    @FXML
    private AnchorPane apMainPage;

    public void addBookImage(MouseEvent mouseEvent) throws IOException {

        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/view/AddBook.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) apMainPage.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void addMemberImage(MouseEvent mouseEvent) throws IOException {

        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/view/RegisterMember.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) apMainPage.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void issueBookImage(MouseEvent mouseEvent) throws IOException {

        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/view/IssuedBook.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) apMainPage.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void returnBookImage(MouseEvent mouseEvent) throws IOException {

        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/view/ReturnBook.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) apMainPage.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void viewDetImage(MouseEvent mouseEvent) throws IOException {

        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/view/ViewPages.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) apMainPage.getScene().getWindow();
        primaryStage.setScene(scene);
    }
}
