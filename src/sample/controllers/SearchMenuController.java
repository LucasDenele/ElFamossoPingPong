package sample.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SearchMenuController extends AbstractController{

    public RadioButton maleChecker;
    public RadioButton femaleChecker;

    public Button searchButton;

    public TextField lastNameBox;
    public TextField firstNameBox;

    public ChoiceBox nationalitySelecter;


    public void searchLaunch(ActionEvent actionEvent) {

        if(maleChecker.isSelected()){
            System.out.println("Male Selected");
        }
        if(femaleChecker.isSelected()){
            System.out.println("female Selected");
        }
        if(!lastNameBox.getText().equals("")) {
            System.out.println(lastNameBox.getText());
        }
        if(firstNameBox.getText().equals("")) {
            System.out.println(lastNameBox.getText());
        }
        System.out.println(nationalitySelecter.getValue());
        System.out.println("Launch FriendlyGame");
        try {
            sceneSwitcher.uploadNewScene((Stage)searchButton.getScene().getWindow(),"fxml/RankingMainFXML.fxml",600, 400);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void test(MouseEvent actionEvent) {
        nationalitySelecter.getItems().clear();
        nationalitySelecter.getItems().addAll("FRA","BEL");
    }
}
