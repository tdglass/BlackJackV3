package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage login) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        login.setTitle("Sign in");
        login.setScene(new Scene(root, 435, 435));
        login.show();
        login.setResizable(false);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
