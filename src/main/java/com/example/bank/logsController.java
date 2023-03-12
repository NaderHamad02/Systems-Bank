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
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class logsController implements Initializable {
    @FXML
    private ListView<String> logs;

    @FXML
    private Label message;

    @FXML
    private Button returnButton;
    private Stage primaryStage;
    Bank bk;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            bk=Bank.getInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        bk.current.getLogs().logs.inorder();
//        ArrayList<String> val= (ArrayList<String>)  bk.current.getLogs().getLogs();
//        for(int i=0 ; i<val.size() ;i++)
//        {
//            System.out.println(val.get(i));
//        }
        logs.getItems().addAll(bk.current.getLogs().getLogs());
    }
    @FXML
    void returnToAccountDashboard(ActionEvent event) throws IOException {
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
}
