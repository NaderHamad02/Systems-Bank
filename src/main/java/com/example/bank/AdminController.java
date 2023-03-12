

package com.example.bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private Button resolveLoans;

    @FXML
    private Button resolveTransfers;

    @FXML
    private Button returnButton;

    @FXML
    private Button viewAccounts;
    private Stage primaryStage;

    Bank bk;
    @FXML
    void goBackToLogin(ActionEvent event) throws IOException {
        changeScene("adminLogin.fxml",event);

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
    void goToLoans(ActionEvent event) throws IOException {
        while (bk.loanQueue.size()>0)
        {
            Loan L=bk.loanQueue.remove();
            String log=L.getLog();
            Account setLogAccount=L.acc;
            setLogAccount.logs.add(2,log);
            int k=setLogAccount.logs.returnKey(2);
            bk.saveLogs(Integer.parseInt(setLogAccount.account_number),k,log);
            setLogAccount.add(L.amount);


        }

        // changeScene("loan.fxml",event);
    }

    @FXML
    void goToTransfers(ActionEvent event) throws IOException {
     for(int i=0 ; i<bk.transfers.size() ;i++)
     {
         String log=bk.transfers.get(i).getLog();
         Account setLogAccount=bk.transfers.get(i).account;
         System.out.println("Set Log Account");
         setLogAccount.Print();

         Account ToAccount=bk.transfers.get(i).toAccount;
         setLogAccount.logs.add(1,log);
         int k=setLogAccount.logs.returnKey(1);
         bk.saveLogs(Integer.parseInt(setLogAccount.account_number),k,log);
         setLogAccount.deduct(bk.transfers.get(i).amount);
         ToAccount.add(bk.transfers.get(i).amount);

     }
     bk.transfers=new ArrayList<Transfer>();
    }

    @FXML
    void viewAccounts(ActionEvent event) throws IOException {
        changeScene("accounts.fxml",event);
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
