package fr.brouillard.javafx.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application.Parameters;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import javax.inject.Inject;

// Simple application controller that uses injected fields 
// to delegate login process and to get default values from the command line using: --user=SomeUser
public class LoginController implements Initializable {
    // Standard FXML injected fields
	@FXML TextField loginField;
	@FXML PasswordField passwordField;
	@FXML Text feedback;
	
	// CDI Injected field
	@Inject LoginService loginService;
	
    // Default application parameters
	@Inject Parameters applicationParameters;
	
	@FXML protected void handleSubmitButtonAction(ActionEvent event) {
		feedback.setText(loginService.login(loginField.getText(), passwordField.getText()));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loginField.setText(applicationParameters.getNamed().get("user"));
	}
}
