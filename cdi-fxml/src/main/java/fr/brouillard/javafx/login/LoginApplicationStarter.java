package fr.brouillard.javafx.login;

import java.io.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import fr.brouillard.javafx.weld.StartupScene;

public class LoginApplicationStarter {
	@Inject FXMLLoader fxmlLoader;
	
	public void launchJavaFXApplication(@Observes @StartupScene Stage s) {
		InputStream is = null;

		try {
			is = getClass().getResourceAsStream("login.fxml");
			Parent root = (Parent) fxmlLoader.load(is);
			s.setTitle("Login");
			s.setScene(new Scene(root, 300, 275));
			s.show();
		} catch (IOException e) {
			throw new IllegalStateException("cannot load FXML login screen", e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
