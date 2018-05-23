package controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.ScrollEvent;
import match.Match;
import match.Round;
import match.Tournament;


public class TournamentSummaryController {
    public ChoiceBox<String> roundSelecter;
    public Button launchRoundViewButton;
    public ScrollBar listViewScrollBar;
    public ListView<String> matchsList;
    public ListView<String> setsScoresList;

    private Tournament tournament;

    public void setResults(Tournament newTounament){
        listViewScrollBar.setVisible(false);
        tournament = newTounament;

        roundSelecter.getItems().add("-");
        roundSelecter.getSelectionModel().selectFirst();
        for(Round it : tournament.getRounds()){
            roundSelecter.getItems().add(it.getRoundName());
        }
    }

    public void launchRoundView(ActionEvent actionEvent) {
        Round roundToDisplay = new Round();
        for(Round it : tournament.getRounds()){
            if(it.getRoundName().equals(roundSelecter.getValue())){
                roundToDisplay = it;
                break;
            }
        }
        displayLists(roundToDisplay);
    }

    private void displayLists(Round roundToDisplay) {
        matchsList.getItems().clear();
        setsScoresList.getItems().clear();

        listViewScrollBar.setVisible(true);
        int scrollBarSize = 0;
        for(Match it : roundToDisplay.getMatches()){
            matchsList.getItems().add(it.getPlayerA().getLastName()+" vs "+it.getPlayerB().getLastName());
            setsScoresList.getItems().add("Sets :");
            scrollBarSize++;
            for(String its : it.getResults()){
                matchsList.getItems().add("");
                setsScoresList.getItems().add(its);
                scrollBarSize++;
            }
        }
        listViewScrollBar.setMin(0);
        listViewScrollBar.setMax(scrollBarSize-6);
    }

    public void scrollSynchro(ScrollEvent scrollEvent) {
        matchsList.scrollTo((int)listViewScrollBar.getValue());
        setsScoresList.scrollTo((int)listViewScrollBar.getValue());
    }
}
