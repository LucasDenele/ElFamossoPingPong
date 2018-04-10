package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneSwitcher {

    public void uploadNewScene(Stage newStage, String fileName) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(fileName));
        newStage.setScene(new Scene(root, 479, 385));
        newStage.show();
    }
}
