package controllers;

import AccessBDD.AccessBDD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.ScrollEvent;
import javafx.stage.Stage;
import player.Player;

import java.util.TreeSet;
import java.util.Vector;

public class SearchController {

    @FXML
    public ListView<String> nameList;
    public ListView<String> countryList;
    public ListView<Double> scoreList;
    public ListView<String> genderList;

    public ChoiceBox<String> nationalitySelecter;

    public Button backToMainMenuButton;

    public RadioButton maleChecker;
    public RadioButton femaleChecker;

    public TextField firstNameBox;
    public TextField lastNameBox;

    public ScrollBar listViewsScrollBar;

    private SceneSwitcher sceneSwitcher = new SceneSwitcher();


    AccessBDD rankingAccessBDD = new AccessBDD();

    @FXML
    void sortLists(String request){
        nameList.getItems().clear();
        countryList.getItems().clear();
        scoreList.getItems().clear();
        genderList.getItems().clear();
        nationalitySelecter.getItems().clear();

        Vector<Player> players = rankingAccessBDD.request(request);
        TreeSet<String> nationalities = new TreeSet<>();

        for(Player it : players){
            nameList.getItems().add(it.getFirstName()+" "+it.getLastName());
            countryList.getItems().add(it.getCountry());
            scoreList.getItems().add(it.getPoints());
            genderList.getItems().add(it.getGender());
            nationalities.add(it.getCountry());
        }


        nationalitySelecter.getItems().add("-");

        for(String it : nationalities){
            nationalitySelecter.getItems().add(it);
        }

        nationalitySelecter.getSelectionModel().selectFirst();

        listViewsScrollBar.setMin(0);
        listViewsScrollBar.setMax(players.size()-8);

        players.clear();
    }

    @FXML
    public void searchLaunch(ActionEvent actionEvent) {
        String request = "select * from PLAYER where";

        if(maleChecker.isSelected()) request += " GENDER = 'h' &&";
        if(femaleChecker.isSelected()) request += " GENDER = 'f' &&";
        if(!firstNameBox.getText().equals("")) request += " FIRST_NAME = '"+firstNameBox.getText()+"' &&";
        if(!lastNameBox.getText().equals("")) request += " LAST_NAME = '"+lastNameBox.getText()+"' &&";
        if(!nationalitySelecter.getValue().equals("-")) request += " COUNTRY = '"+nationalitySelecter.getValue()+"' &&";

        if(request.endsWith("&&")) request = request.substring(0, request.length() - 2);
        if(request.endsWith("where")) request = request.substring(0, request.length() - 5);

        sortLists(request);
    }

    @FXML
    public void scrollSynchro(ScrollEvent scrollEvent) {
        nameList.scrollTo((int)listViewsScrollBar.getValue());
        countryList.scrollTo((int)listViewsScrollBar.getValue());
        genderList.scrollTo((int)listViewsScrollBar.getValue());
        scoreList.scrollTo((int)listViewsScrollBar.getValue());

    }

    @FXML
    public void backToMainMenu(ActionEvent actionEvent) {
        try {
            sceneSwitcher.uploadNewScene((Stage)backToMainMenuButton.getScene().getWindow(),"../fxml/MainMenuFXML.fxml", 600, 400);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
