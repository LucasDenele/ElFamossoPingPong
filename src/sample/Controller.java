package sample;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

public class Controller {

    @FXML
    public void playFriendlyGameLaunch(ActionEvent event) {
        System.out.println("Launch FriendlyGame");
    }

    public void playTournamentLaunch(ActionEvent actionEvent) {
        System.out.println("Launch Tournament");
    }

    public void playYearLaunch(ActionEvent actionEvent) {
        System.out.println("Launch Year");
    }

    public void menRaningLaunch(ActionEvent actionEvent) {
        System.out.println("Launch Men Ranking");
    }

    public void womenRankingLaunch(ActionEvent actionEvent) {
        System.out.println("Launch Women Ranking");
    }
}
