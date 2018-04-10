package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.SceneSwitcher;

public class MainMenuController {

    SceneSwitcher sceneSwitcher = new SceneSwitcher();

    @FXML
    public Button playFriendlyGameButton;
    public Button playTournamentButton;
    public Button playYearButton;
    public Button menRankingButton;
    public Button womenRankingButton;

    @FXML
    public void playFriendlyGameLaunch(ActionEvent actionEvent) throws Exception {

        System.out.println("Launch FriendlyGame");
        try {
            sceneSwitcher.uploadNewScene((Stage)playFriendlyGameButton.getScene().getWindow(),"fxml/PlayFriendlyGameMainFXML.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void playTournamentLaunch(ActionEvent actionEvent) {

        System.out.println("Launch Tournament");
        try {
            sceneSwitcher.uploadNewScene((Stage)playTournamentButton.getScene().getWindow(),"fxml/PlayTournamentMainFXML.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playYearLaunch(ActionEvent actionEvent) {

        System.out.println("Launch Year");
        try {
            sceneSwitcher.uploadNewScene((Stage)playYearButton.getScene().getWindow(),"fxml/PlayYearMainFXML.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void menRankingLaunch(ActionEvent actionEvent) {

        System.out.println("Launch Men Ranking");
        try {
            sceneSwitcher.uploadNewScene((Stage)menRankingButton.getScene().getWindow(),"fxml/MenRankingMainFXML.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void womenRankingLaunch(ActionEvent actionEvent) {

        System.out.println("Launch Women Ranking");
        try {
            sceneSwitcher.uploadNewScene((Stage)womenRankingButton.getScene().getWindow(),"fxml/WomenRankingMainFXML.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
