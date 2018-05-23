package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuController {

    private SceneSwitcher sceneSwitcher = new SceneSwitcher();

    @FXML
    public Button playFriendlyGameButton;
    public Button playTournamentButton;
    public Button playYearButton;
    public Button rankingButton;

    @FXML
    public void playFriendlyGameLaunch(ActionEvent actionEvent) throws Exception {
        try {
            sceneSwitcher.uploadNewScene((Stage)playFriendlyGameButton.getScene().getWindow(),"../fxml/PlayFriendlyGameMainFXML.fxml",600, 400);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void playTournamentLaunch(ActionEvent actionEvent) {
        try {
            sceneSwitcher.uploadNewScene((Stage)playTournamentButton.getScene().getWindow(),"../fxml/PlayTournamentMainFXML.fxml", 600, 400);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playYearLaunch(ActionEvent actionEvent) {
        try {
            sceneSwitcher.uploadNewScene((Stage)playYearButton.getScene().getWindow(),"../fxml/PlayYearMainFXML.fxml", 600, 400);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rankingLaunch(ActionEvent actionEvent) {
       try {
            sceneSwitcher.uploadNewScene((Stage)rankingButton.getScene().getWindow(),"../fxml/RankingFXML.fxml", 600, 400);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
