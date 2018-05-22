package controllers;

import AccessBDD.AccessBDD;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.ScrollEvent;
import player.Player;

import java.util.Vector;

public class RankingController extends AbstractController{


    public ListView<String> nameList;
    public ListView<String> countryList;
    public ListView<Double> scoreList;
    public ListView<String> genderList;


    public Button nameButton;
    public Button countryButton;
    public Button scoreButton;
    public Button genderButton;
    public Button searchButton;

    public ChoiceBox nationalitySelecter;

    public RadioButton maleChecker;
    public RadioButton femaleChecker;

    public TextField firstNameBox;
    public TextField lastNameBox;

    public ScrollBar listViewsScrollBar;

    public void initialize(){

        AccessBDD rankingAccessBDD = new AccessBDD();

        Vector<Player> players = rankingAccessBDD.request("SELECT * FROM PLAYER");

        for(Player it : players){
            nameList.getItems().add(it.getFirstName()+" "+it.getLastName());
            countryList.getItems().add(it.getCountry());
            scoreList.getItems().add(it.getPoints());
            genderList.getItems().add(it.getGender());
        }

        listViewsScrollBar.setMin(0);
        listViewsScrollBar.setMax(players.size()-8);

    }

    public void sortByName(ActionEvent actionEvent) {
    }

    public void sortByCountry(ActionEvent actionEvent) {
    }

    public void sortByScore(ActionEvent actionEvent) {
    }


    public void sortByGender(ActionEvent actionEvent) {
    }


    public void searchLaunch(ActionEvent actionEvent) {

    }

    public void scrollSynchro(ScrollEvent scrollEvent) {
        nameList.scrollTo((int)listViewsScrollBar.getValue());
        countryList.scrollTo((int)listViewsScrollBar.getValue());
        genderList.scrollTo((int)listViewsScrollBar.getValue());
        scoreList.scrollTo((int)listViewsScrollBar.getValue());

    }

    public void scrollKill(ScrollEvent scrollEvent) {
        System.out.println("Coucou");
    }
}
