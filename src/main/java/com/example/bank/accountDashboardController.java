package com.example.bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class accountDashboardController implements Initializable {

    @FXML
    private Label accountNumber;

    @FXML
    private Label credit;

    @FXML
    private Button logs;

    @FXML
    private Button makeLoan;

    @FXML
    private Button makeTransfer;

    @FXML
    private Label name;

    @FXML
    private Button returnButton;
     Bank bk;
    private Stage primaryStage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            bk=Bank.getInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(bk.current!=null)
        {
            name.setText(bk.current.getName());
            accountNumber.setText(bk.current.getAccount_number());
            credit.setText(Float.toString( bk.current.getCredit()));
        }
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

    @FXML
    void goToDashboard(ActionEvent event) throws IOException {
        bk.current=null;
        changeScene("LandingPage.fxml",event);

    }

    @FXML
    void goToLogs(ActionEvent event) throws IOException {
        changeScene("logs.fxml",event);

    }

    @FXML
    void goToLoan(ActionEvent event) throws IOException {
        changeScene("loan.fxml",event);
    }

    @FXML
    void goToTransfer(ActionEvent event) throws IOException {
        changeScene("transfer.fxml",event);
    }
}
