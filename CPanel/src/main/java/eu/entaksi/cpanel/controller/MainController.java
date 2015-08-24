package eu.entaksi.cpanel.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by uzumaki on 24/08/15.
 */
public class MainController {

    @FXML
    public TextField myTextField;

    @FXML
    protected void doSomething() {
        myTextField.clear();
        myTextField.setText("The button was clicked!");
    }
}
