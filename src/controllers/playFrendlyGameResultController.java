package controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import match.Match;

public class PlayFrendlyGameResultController {

    private Match playableMatch;
    public ListView<String> resultsList;
    public Button playButton;

    void setResults(Match friendlyMatch) {
        resultsList.getItems().clear();

        if(friendlyMatch.isAutoplay()) {
            playButton.setVisible(false);
            resultsList.getItems().add("The winner is " + friendlyMatch.getWinner().getLastName());
            resultsList.getItems().add("Sets Results :");
            for (String it : friendlyMatch.getResults()) resultsList.getItems().add(it);
        }else{
            resultsList.getItems().add("Sets :");
            playableMatch = friendlyMatch;
        }
    }

    public void playPoint(ActionEvent actionEvent) {
        if(!playableMatch.isFinished()){
            playableMatch.runManual();
            if(playableMatch.getResults().size() != resultsList.getItems().size()){
                    resultsList.getItems().set(playableMatch.getResults().size(),playableMatch.getResults()
                            .get(playableMatch.getResults().size()-1));

            }else{
                resultsList.getItems().add(playableMatch.getResults()
                        .get(playableMatch.getResults().size()-1));
            }
            if(playableMatch.isFinished()){
                playableMatch.setAutoplay(true);
                setResults(playableMatch);
            }
        }
    }
}
