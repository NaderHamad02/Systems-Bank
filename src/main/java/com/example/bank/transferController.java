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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class transferController implements Initializable {

    @FXML
    private TextField ToNumber;

    @FXML
    private TextArea description;

    @FXML
    private Button makeTransfer;

    @FXML
    private Label message;

    @FXML
    private Button returnButton;

    @FXML
    private TextField transferAmount;
    private Stage primaryStage;
    Bank bk;
    @FXML
    void goToDashboard(ActionEvent event) throws IOException {
        changeScene("accountDashboard.fxml",event);
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
    void resolveTransfer(ActionEvent event) {
        message.setText("");
        float amount=Float.parseFloat(transferAmount.getText());
        System.out.println(amount);
        System.out.println(bk.current.credit-amount);
        if(bk.current.credit-amount>0) {
            String accNumber = ToNumber.getText();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String datee = formatter.format(date);
            String Description = description.getText();
            Transfer obj = new Transfer(amount, Description, datee);
            boolean check=false;
            if (bk.current != null) {
                obj.setAccount(bk.current);
            check=true;
            }
            boolean check2=false;
            if (bk.getAccount(accNumber) != null) {
                obj.setToAccount(bk.getAccount(accNumber));
            check2=true;
            }
            if(check==true && check2==true)
            {
                bk.addTransfer(obj);
                message.setText("Transfer request has been made");

            }
            else
            {
                message.setText("Transfer could not be made due to invalid details");
            }

            ToNumber.setText("");
            description.setText("");
            transferAmount.setText("");


        }
        else {
            message.setText("The account has less credit to make a transfer");
        }

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
