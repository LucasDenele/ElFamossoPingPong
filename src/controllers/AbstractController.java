package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AbstractController {

    SceneSwitcher sceneSwitcher = new SceneSwitcher();

    @FXML
    public Button backToMainMenuButton;

    @FXML
    public void backToMainMenu(ActionEvent actionEvent) {
        try {
            sceneSwitcher.uploadNewScene((Stage)backToMainMenuButton.getScene().getWindow(),"../fxml/MainMenuFXML.fxml", 600, 400);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
