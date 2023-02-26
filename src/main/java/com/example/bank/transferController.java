package com.example.bank;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class transferController {

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

}
