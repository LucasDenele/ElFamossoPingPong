package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.SceneSwitcher;

public class WomenRankingController {

    SceneSwitcher sceneSwitcher = new SceneSwitcher();

    @FXML
    public Button backToMainMenuButton;

    @FXML
    public void backToMainMenu(ActionEvent actionEvent) {
        try {
            sceneSwitcher.uploadNewScene((Stage)backToMainMenuButton.getScene().getWindow(),"fxml/MainMenuFXML.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
