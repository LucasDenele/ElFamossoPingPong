package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.ScrollEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import match.Match;
import player.Player;

import java.util.TreeSet;
import java.util.Vector;


public class PlayFriendlyGameController extends SearchController {

    public ListView<CheckBox> selectedList;
    public CheckBox autoplayCheckBox;

    public Button launchButton;
    public ScrollBar listViewsScrollBar;

    public Label warningLabel;

    private int nomberOfSelectedPlayers = 0;
    private String playerA = "";
    private  String playerB = "";
    private Match frendlyMatch = new Match();


    public void initialize(){
        sortLists("select * from PLAYER");
    }

    public void launchFrendlyGame(ActionEvent actionEvent) throws InterruptedException {
        if(nomberOfSelectedPlayers != 2){
            warningLabel.setText("Warning : you must select two players!");
        }else{
            warningLabel.setText("");

            rankingAccessBDD.request("select * from PLAYER where " +
                    "FIRST_NAME = '"+playerB.substring(0,playerB.indexOf(" "))+
                    "' && LAST_NAME = '"+playerB.substring(playerB.indexOf(" ")+1, playerB.length())+"'").get(0).display();
            frendlyMatch.setPlayerA(rankingAccessBDD.request("select * from PLAYER where " +
                    "FIRST_NAME = '"+playerA.substring(0,playerA.indexOf(" "))+
                    "' && LAST_NAME = '"+playerA.substring(playerA.indexOf(" ")+1, playerA.length())+"'").get(0));
            frendlyMatch.setPlayerB(rankingAccessBDD.request("select * from PLAYER where " +
                    "FIRST_NAME = '"+playerB.substring(0,playerB.indexOf(" "))+
                    "' && LAST_NAME = '"+playerB.substring(playerB.indexOf(" ")+1, playerB.length())+"'").get(0));

            frendlyMatch.setFriendly(true);
            frendlyMatch.setAutoplay(true);

            frendlyMatch.run();

            frendlyMatch.join();

            Stage resultStage = new Stage();
            try {
                startResultWindow(resultStage, (Stage) launchButton.getScene().getWindow());
            } catch (Exception e) {
                e.printStackTrace();
            }

            frendlyMatch.setFinished(false);

        }
    }

    private void startResultWindow(Stage window, Stage parentStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/PlayFrendlyGameResultFXML.fxml"));
        Scene scene =  new Scene(root, 300 ,200);
        //MainController controller = FXMLLoader.<MainController>getController();
        //controller.setUser(user_id);
        window.initModality(Modality.WINDOW_MODAL);
        window.initOwner(parentStage);
        window.setResizable(false);
        window.setScene(scene);
        window.show();
    }

    @Override
    public void sortLists(String request){

        nameList.getItems().clear();
        countryList.getItems().clear();
        scoreList.getItems().clear();
        genderList.getItems().clear();
        nationalitySelecter.getItems().clear();
        selectedList.getItems().clear();


        Vector<Player> players = rankingAccessBDD.request(request);
        TreeSet<String> nationalities = new TreeSet<>();

        int i = 0;
        for(Player it : players){
            nameList.getItems().add(it.getFirstName()+" "+it.getLastName());
            countryList.getItems().add(it.getCountry());
            scoreList.getItems().add(it.getPoints());
            genderList.getItems().add(it.getGender());
            selectedList.getItems().add(new CheckBox());

            if((it.getFirstName()+it.getLastName()).equals(playerA.replace(" ", ""))
                    || (it.getFirstName()+it.getLastName()).equals(playerB.replace(" ", ""))){
                selectedList.getItems().get(i).setSelected(true);
            }

            selectedList.getItems().get(selectedList.getItems().size()-1)
                    .selectedProperty().addListener((observable, oldValue, newValue) -> {

                        nomberOfSelectedPlayers++;
                        if(nomberOfSelectedPlayers > 2) {
                            for (CheckBox its : selectedList.getItems()) its.setSelected(false);
                            nomberOfSelectedPlayers = 0;
                            playerA = "";
                            playerB = "";
                        }else {
                            int j = 0;
                            for (CheckBox its : selectedList.getItems()) {
                                if (its.isSelected()
                                        && !playerA.equals(nameList.getItems().get(j).replace(" ", ""))
                                        && !playerB.equals(nameList.getItems().get(j).replace(" ", ""))) {
                                    if (playerA.equals("")) {
                                        playerA = nameList.getItems().get(j);
                                    } else {
                                        playerB = nameList.getItems().get(j);
                                    }
                                }
                                j++;
                            }
                        }
                    });
            nationalities.add(it.getCountry());
            i++;
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

    @Override
    public void scrollSynchro(ScrollEvent scrollEvent){
        super.scrollSynchro(scrollEvent);
        selectedList.scrollTo((int)listViewsScrollBar.getValue());
    }

}
