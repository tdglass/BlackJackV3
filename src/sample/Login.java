package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Login {
    @FXML private TextField usernameField;
    @FXML private PasswordField pwField;
    @FXML private Label signInOrErrorLabel;
    @FXML private Button signInButton;
    @FXML private Button newUserButton;
    @FXML private Button createNewUserButton;

   Map<String, String> usernameAndPasswordMap = new HashMap<>();


    public void signIn(ActionEvent event) throws IOException, NullPointerException {

        try {
            File toRead=new File("UsernameAndPasswords.txt");
            FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);

           // Map<String,String> usernameAndPasswordMap=(Map<String,String>)ois.readObject();
            usernameAndPasswordMap = (Map<String, String>) ois.readObject();
            ois.close();
            fis.close();

        } catch(Exception ignored) {}

        String username = usernameField.getText();
        String password = pwField.getText();



        if (usernameAndPasswordMap.containsKey(username)) {
            if (usernameAndPasswordMap.get(username).equals(password)) {
                signInOrErrorLabel.setText("Sign in successful.");
                blackJackStage(event);
            } else signInOrErrorLabel.setText("Wrong password.");
        } else signInOrErrorLabel.setText("Username not found.");

    }

    public void writeToFile(Map<String, String> map){
        try {
            File fileOne=new File("UsernameAndPasswords.txt");
            FileOutputStream fos=new FileOutputStream(fileOne);
            ObjectOutputStream oos=new ObjectOutputStream(fos);

            oos.writeObject(map);
            oos.flush();
            oos.close();
            fos.close();
        } catch(Exception ignored) {}
    }



    public void newUser() {
        signInOrErrorLabel.setText(null);
        usernameField.setPromptText("Enter new username here.");
        pwField.setPromptText("Enter password here (case sensitive).");
        signInButton.setVisible(false);
        newUserButton.setVisible(false);
        createNewUserButton.setVisible(true);
    }

    public void createNewUser() {
        String username = usernameField.getText().strip().toLowerCase();
        String password = pwField.getText();

        if (!usernameAndPasswordMap.containsKey(username) && password.length() > 7 && username.length() > 6) {
            usernameAndPasswordMap.put(username, password);
            signInOrErrorLabel.setText("User created successfully!");
            usernameField.setText(null);
            pwField.setText(null);
            signInButton.setVisible(true);
            newUserButton.setVisible(true);
            createNewUserButton.setVisible(false);
            writeToFile(usernameAndPasswordMap);

        } else if (usernameAndPasswordMap.containsKey(username)) {
            signInOrErrorLabel.setText("This username is already in use.");
        }

        if (username.length() <= 6) {
            signInOrErrorLabel.setText("Username length must exceed 6 characters.");
        }

        if (password.length() <= 7) {
            signInOrErrorLabel.setText("Password length must exceed 7 characters.");
        }

    }
    public void blackJackStage(ActionEvent event) throws IOException {

        Parent blackJackParent = FXMLLoader.load(getClass().getResource("BlackJackStage.fxml"));
        Scene blackJackScene = new Scene(blackJackParent);
        Stage blackJackStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        blackJackStage.setScene(blackJackScene);
        blackJackStage.setTitle("Black Jack Table");
        blackJackStage.show();
        blackJackStage.centerOnScreen();
        blackJackStage.setResizable(false);
    }

}