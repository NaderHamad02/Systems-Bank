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

public class loanController implements Initializable {


    Account account;
    Bank bk;
    @FXML
    private TextField credit;

    @FXML
    private TextArea description;

    @FXML
    private Button makeLoan;

    @FXML
    private Label message;

    @FXML
    private Button returnButton;
    private Stage primaryStage;

    @FXML
    void resolveLoanRequest(ActionEvent event) {
        message.setText("");
        float amount=Float.parseFloat(credit.getText());
        System.out.println(amount);

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String datee = formatter.format(date);
            String Description = description.getText();
            Loan obj = new Loan(amount, Description, datee,account);
            bk.loanQueue.add(obj);
            message.setText("Loan Request have been made");
            description.setText("");
            credit.setText("");



    }

    @FXML
    void returnToDashboard(ActionEvent event) throws IOException {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            bk=Bank.getInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(bk.current!=null)
        {
            account=bk.current;
        }
    }
}
