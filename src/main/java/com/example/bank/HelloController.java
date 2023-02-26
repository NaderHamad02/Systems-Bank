package com.example.bank;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelloController implements Initializable{

    @FXML
    private Button loginAccount;

    @FXML
    private Button loginAdmin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Bank bk=Bank.getInstance();
        try {
            bk.ReadFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
