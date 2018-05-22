package sample.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.ScrollEvent;
import player.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayFriendlyGameController extends AbstractController{


    public RadioButton maleChecker;
    public RadioButton femaleChecker;

    public TextField firstNameBox;
    public TextField lastNameBox;

    public ChoiceBox nationalitySelecter;

    public ListView<String> nationalityList;
    public ListView<String> nameList;
    public ListView<String> genderList;
    public ListView<CheckBox> selectedList;
    public ListView<Double> scoreList;

    public CheckBox autoplayCheckBox;

    public Button launchButton;
    public ScrollBar listViewsScrollBar;
    public Button searchButton;

    public Label warningLabel;

    private int nomberOfSelectedPlayers = 0;

    public void initialize(){
        Player p1 = new Player("Joueur1", 0, "FRA", "female", 70, 50, 300);
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
            nationalityList.getItems().add(aTest.getCountry());
            genderList.getItems().add(aTest.getGender());
            scoreList.getItems().add(aTest.getPoints());
            selectedList.getItems().add(new CheckBox());
        }

        for(CheckBox it : selectedList.getItems()) {
            it.selectedProperty().addListener((observable, oldValue, newValue) -> {
                nomberOfSelectedPlayers++;
                if(nomberOfSelectedPlayers > 2){
                    for(CheckBox its : selectedList.getItems()) its.setSelected(false);
                    nomberOfSelectedPlayers = 0;
                }
            });
        }

        listViewsScrollBar.setMin(0);
        listViewsScrollBar.setMax(test.size()-8);
    }

    public void launchFrendlyGame(ActionEvent actionEvent) {
        if(nomberOfSelectedPlayers != 2){
            warningLabel.setText("Warning : you must select two players!");
        }else{
            System.out.println("Launch Game!");
        }
    }

    public void launchSearch(ActionEvent actionEvent) {
    }

    public void scrollSyncro(ScrollEvent scrollEvent) {
        nameList.scrollTo((int)listViewsScrollBar.getValue());
        nationalityList.scrollTo((int)listViewsScrollBar.getValue());
        genderList.scrollTo((int)listViewsScrollBar.getValue());
        scoreList.scrollTo((int)listViewsScrollBar.getValue());
        selectedList.scrollTo((int)listViewsScrollBar.getValue());
    }


}
