package lk.ijse.dep.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Startup extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        FileHandler fileHandler = new FileHandler("error.log", true);
        fileHandler.setFormatter(new SimpleFormatter());
        Logger.getLogger("").addHandler(fileHandler);

        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/view/MainPage.fxml"));

        Scene mainScene = new Scene(root);

        primaryStage.setTitle("IJSE FX POS - In Memory DB");
        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);

        primaryStage.show();

    }
}
