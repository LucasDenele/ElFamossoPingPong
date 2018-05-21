package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.stage.Stage;

public class RankingController extends AbstractController{


    public ListView nameList;
    public ListView idList;
    public ListView countryList;
    public ListView scoreList;
    public ListView genderList;

    public CheckBox menChecker;
    public CheckBox womenChecker;

    public ScrollBar scollerForLists;

    public Button nameButton;
    public Button idButton;
    public Button countryButton;
    public Button scoreButton;
    public Button genderButton;
    public Button searchButton;

    public void sortByName(ActionEvent actionEvent) {
    }

    public void sortByCountry(ActionEvent actionEvent) {
    }

    public void sortByScore(ActionEvent actionEvent) {
    }

    public void sortByID(ActionEvent actionEvent) {
    }

    public void sortByGender(ActionEvent actionEvent) {
    }

    public void watchMen(ActionEvent actionEvent) {
    }

    public void watchWomen(ActionEvent actionEvent) {
    }


    public void searchLaunch(ActionEvent actionEvent) {

        System.out.println("Launch FriendlyGame");
        try {
            sceneSwitcher.uploadNewScene((Stage)searchButton.getScene().getWindow(),"fxml/SearchMenuFXML.fxml",600, 400);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
