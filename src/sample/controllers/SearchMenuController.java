package sample.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SearchMenuController extends AbstractController{

    public RadioButton maleChecker;
    public RadioButton femaleChecker;

    public Button searchButton;

    public TextField lastNameBox;
    public TextField firstNameBox;

    public SplitMenuButton nationalitySelecter;

    public void searchLaunch(ActionEvent actionEvent) {

        if(maleChecker.isSelected()){
            System.out.println("Male Selected");            
        }
        System.out.println("Launch FriendlyGame");
        try {
            sceneSwitcher.uploadNewScene((Stage)searchButton.getScene().getWindow(),"fxml/RankingMainFXML.fxml",600, 400);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
