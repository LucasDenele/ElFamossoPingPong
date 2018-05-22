package controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;

public class PlayTournamentController extends AbstractController{


    public RadioButton maleChecker;
    public RadioButton femaleChecker;
    public RadioButton autoplayChecker;
    public Button launchButton;
    public ChoiceBox tournamentSelecter;


    public void femaleUnchecker(ActionEvent actionEvent) {
        femaleChecker.setSelected(false);
    }

    public void maleUnchecker(ActionEvent actionEvent) {
        maleChecker.setSelected(false);
    }

    public void launchTournament(ActionEvent actionEvent) {
        
    }
}
