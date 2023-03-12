package com.example.bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class adminLoginController implements Initializable {

    @FXML
    private Button loginAdmin;
    @FXML
    private Button goBack;
    @FXML
    private TextField password;

    @FXML
    private TextField username;
    private Stage primaryStage;

    private Bank bk;

    @FXML
    void loginAdmin(ActionEvent event) throws IOException {
        boolean check=bk.admin.Authenticate(username.getText(),password.getText());
        System.out.println("check: "+check);


        if(check)
        {
            changeScene("adminDashboard.fxml",event);
        }

    }
    @FXML
    void goBackToDashboard(ActionEvent event) throws IOException {

        changeScene("LandingPage.fxml",event);
    }
    public void changeScene(String fxml, ActionEvent event) throws IOException {

        //------Following code changes scene to Schedule-------
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        this.primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        //-----------------------------------------------------

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            bk=Bank.getInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
