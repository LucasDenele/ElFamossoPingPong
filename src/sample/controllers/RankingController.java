package sample.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.ScrollEvent;
import player.Player;

import java.util.ArrayList;
import java.util.List;

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
        Player p1 = new Player("Joueur1", 0, "FRA", "male", 70, 50, 300);
        Player p2 = new Player("Joueur2", 1, "FRA", "male", 80, 40, 142);
        Player p3 = new Player("Joueur3", 2, "FRA", "male", 90, 50, 340);
        Player p4 = new Player("Joueur4", 3, "FRA", "male", 80, 60, 12);
        Player p5 = new Player("Joueur5", 4, "FRA", "male", 70, 50, 300);
        Player p6 = new Player("Joueur6", 5, "FRA", "male", 80, 40, 142);
        Player p7 = new Player("Joueur7", 6, "FRA", "male", 90, 50, 340);
        Player p8 = new Player("Joueur8", 7, "FRA", "male", 80, 60, 12);
        Player p9 = new Player("Joueur9", 7, "FRA", "male", 80, 60, 12);
        Player p10 = new Player("Joueur10", 7, "FRA", "male", 80, 60, 12);
        Player p11 = new Player("Joueur11", 7, "FRA", "male", 80, 60, 12);
        Player p12 = new Player("Joueur12", 7, "FRA", "male", 80, 60, 12);
        Player p13 = new Player("Joueur13", 7, "FRA", "male", 80, 60, 12);
        List<Player> test = new ArrayList<Player>();
        test.add(p1);test.add(p2);test.add(p3);test.add(p4);
        test.add(p5);test.add(p6);test.add(p7);test.add(p8);
        test.add(p9);test.add(p10);test.add(p11);test.add(p12);
        test.add(p13);

        for (Player aTest : test) {
            nameList.getItems().add(aTest.getName());
            countryList.getItems().add(aTest.getCountry());
            scoreList.getItems().add(aTest.getPoints());
            genderList.getItems().add(aTest.getGender());
        }

        listViewsScrollBar.setMin(0);
        listViewsScrollBar.setMax(test.size()-8);

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
