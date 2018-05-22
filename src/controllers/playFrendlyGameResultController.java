package controllers;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.List;

public class playFrendlyGameResultController {
    public Label winnerLabel;
    public ListView setList;

    private String winnerName;
    private List<String> sets;

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public void setSets(List<String> sets) {
        this.sets = sets;
    }
}
