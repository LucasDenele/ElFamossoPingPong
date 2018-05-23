package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Modality;
import javafx.stage.Stage;
import match.Tournament;

public class PlayTournamentController extends SwitcherController {


    public RadioButton maleChecker;
    public RadioButton femaleChecker;
    public Button launchButton;
    public ChoiceBox<String> tournamentSelecter;
    public Label warningLabel;

    public void initialize(){
        tournamentSelecter.getItems().add("-");
        tournamentSelecter.getSelectionModel().selectFirst();
        tournamentSelecter.getItems().add("OpenAus");
        tournamentSelecter.getItems().add("OpensBra");
        tournamentSelecter.getItems().add("OpenChi");
        tournamentSelecter.getItems().add("OpenFra");
        tournamentSelecter.getItems().add("OpenGer");
        tournamentSelecter.getItems().add("OpenUS");
    }

    public void femaleUnchecker(ActionEvent actionEvent) {
        femaleChecker.setSelected(false);
    }

    public void maleUnchecker(ActionEvent actionEvent) {
        maleChecker.setSelected(false);
    }

    public void launchTournament(ActionEvent actionEvent) {
        if(maleChecker.isSelected() || femaleChecker.isSelected() || !tournamentSelecter.getValue().equals("-")) {
            warningLabel.setText("");

            String tournamentToLaunchName = tournamentSelecter.getValue();

            if (maleChecker.isSelected()) {
                tournamentToLaunchName += "M";
            } else {
                tournamentToLaunchName += "W";
            }
            Tournament tounamentToLaunch = new Tournament();
            tounamentToLaunch.run(tournamentToLaunchName);

            Stage resultStage = new Stage();
            try {
                startSummaryWindow(resultStage, (Stage) launchButton.getScene().getWindow(), tounamentToLaunch);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            warningLabel.setText("Warning : You must select a gender and a tournament!");
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

