package eu.entaksi.cpanel;

import eu.entaksi.cpanel.cdisupport.StartupScene;
import eu.entaksi.cpanel.controller.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.IOException;

public class ApplicationStarter
{
    private static final Logger log = LoggerFactory.getLogger(ApplicationStarter.class);

    @Inject
    FXMLLoader fxmlLoader;

    public void launchJavaFXApplication(@Observes @StartupScene Stage stage) throws IOException {

        Parent root = fxmlLoader.load( getClass().getClassLoader().getResource("fxml/main-scene.fxml") );

        Scene scene = new Scene(root, 300, 275);

        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();

        MainController controller = fxmlLoader.getController();
    }
}
