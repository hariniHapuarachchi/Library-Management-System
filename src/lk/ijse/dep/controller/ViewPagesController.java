package lk.ijse.dep.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewPagesController {
    public AnchorPane apViewPages;

    public void viewMember(ActionEvent actionEvent) throws IOException {

        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/view/ViewMember.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) apViewPages.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void viewBook(ActionEvent actionEvent) throws IOException {

        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/view/ViewBook.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) apViewPages.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void viewIssueBook(ActionEvent actionEvent) throws IOException {

        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/view/ShowBorrowedBook.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) apViewPages.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void viewReturns(ActionEvent actionEvent) throws IOException {

        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/view/ViewReturnBook.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) apViewPages.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void homeFromView(ActionEvent actionEvent) throws IOException {

        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/view/MainPage.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) apViewPages.getScene().getWindow();
        primaryStage.setScene(scene);
    }
}
