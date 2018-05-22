package controllers;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.List;

public class PlayFrendlyGameResultController {
    public ListView<String> resultsList;

    void setResults(String lastName, List<String> results) {
        resultsList.getItems().clear();
        resultsList.getItems().add("The winner is "+lastName);
        resultsList.getItems().add("Sets Results :");
        for(String it : results) resultsList.getItems().add(it);
    }
}
