package controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class RankingController extends SearchController {


    public Button nameButton;
    public Button countryButton;
    public Button scoreButton;
    public Button genderButton;
    public Button searchButton;

    private boolean sortByNameUp = true;
    private boolean sortByCountryUp = true;
    private boolean sortByScoreUp = true;
    private boolean sortByGenderUp = true;

    public void initialize(){
        sortLists("select * from PLAYER");
    }

    public void sortByName(ActionEvent actionEvent) {
        if(sortByNameUp){
            sortLists("select * from PLAYER order by LAST_NAME desc");
            sortByNameUp = false;
        }else{
            sortLists("select * from PLAYER order by LAST_NAME");
            sortByNameUp = true;
        }
    }

    public void sortByCountry(ActionEvent actionEvent) {
        if(sortByCountryUp){
            sortLists("select * from PLAYER order by COUNTRY desc");
            sortByCountryUp = false;
        }else{
            sortLists("select * from PLAYER order by COUNTRY");
            sortByCountryUp = true;
        }
    }

    public void sortByScore(ActionEvent actionEvent) {
        if(sortByScoreUp){
            sortLists("select * from PLAYER order by POINTS desc");
            sortByScoreUp = false;
        }else{
            sortLists("select * from PLAYER order by POINTS");
            sortByScoreUp = true;
        }
    }


    public void sortByGender(ActionEvent actionEvent) {
        if(sortByGenderUp){
            sortLists("select * from PLAYER order by GENDER desc");
            sortByGenderUp = false;
        }else{
            sortLists("select * from PLAYER order by GENDER");
            sortByGenderUp = true;
        }
    }

}
