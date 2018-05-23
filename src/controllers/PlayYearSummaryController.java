package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import match.Tournament;

import java.util.List;

public class PlayYearSummaryController {

    public ChoiceBox<String> tournamentSelecter;
    public Button launchTournamentSummaryButton;
    private List<Tournament> saveTournamentYear;

    public void setResults(List<Tournament> newSaveTournamentYear){

        saveTournamentYear = newSaveTournamentYear;

        tournamentSelecter.getItems().add("-");
        tournamentSelecter.getSelectionModel().selectFirst();
        for(Tournament it : newSaveTournamentYear){
            tournamentSelecter.getItems().add(it.getName());
        }
    }

    public void launchTournamentSummary(ActionEvent actionEvent) {
        if(!tournamentSelecter.getValue().equals("-")){
            Tournament saveTournament = new Tournament();
            for(Tournament it : saveTournamentYear){
                if(it.getName().equals(tournamentSelecter.getValue())){
                    saveTournament = it;
                    break;
                }
            }
            Stage resultStage = new Stage();
            try {
                startSummaryWindow(resultStage, (Stage)launchTournamentSummaryButton.getScene().getWindow(), saveTournament);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void startSummaryWindow(Stage window, Stage parentStage, Tournament saveTournament) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/TournamentSummaryFXML.fxml"));
        Parent root = loader.load();
        TournamentSummaryController controller = loader.getController();
        controller.setResults(saveTournament);

        Scene scene =  new Scene(root, 600 ,400);

        window.initModality(Modality.WINDOW_MODAL);
        window.initOwner(parentStage);
        window.setTitle(saveTournament.getName());
        window.setResizable(false);
        window.setScene(scene);
        window.show();
    }
}
