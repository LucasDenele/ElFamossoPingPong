package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Modality;
import javafx.stage.Stage;
import match.Match;
import match.Tournament;
import match.Year;

import java.util.ArrayList;
import java.util.List;

public class PlayYearController extends SwitcherController {


    public ProgressBar yearProgressBar;

    public Button launchYearButton;
    public Button noButton;
    public Button launchRankingButton;
    public Button launchSummaryButton;
    public Label textLabel;

    private Year year = new Year();
    private List<Tournament> saveYearTournaments = new ArrayList<>();

    public void initialize(){
        yearProgressBar.setVisible(false);
        launchRankingButton.setVisible(false);
        launchSummaryButton.setVisible(false);

    }

    public void launchYear(ActionEvent actionEvent) {
        launchYearButton.setVisible(false);
        noButton.setVisible(false);
        yearProgressBar.setVisible(true);

        saveYearTournaments.add(year.runTournament("OpenAus"));
        yearProgressBar.setProgress(1/6);

        saveYearTournaments.add(year.runTournament("OpenBra"));
        yearProgressBar.setProgress(2/6);

        saveYearTournaments.add(year.runTournament("OpenChi"));
        yearProgressBar.setProgress(3/6);

        saveYearTournaments.add(year.runTournament("OpenFra"));
        yearProgressBar.setProgress(4/6);

        saveYearTournaments.add(year.runTournament("OpenGer"));
        yearProgressBar.setProgress(5/6);

        saveYearTournaments.add(year.runTournament("OpenUS"));
        yearProgressBar.setProgress(1);

        textLabel.setText("Year is Finish!");
        launchRankingButton.setVisible(true);
        launchSummaryButton.setVisible(true);

    }

    public void launchRanking(ActionEvent actionEvent) {
        System.out.println("Launch Ranking");
        try {
            sceneSwitcher.uploadNewScene((Stage)launchRankingButton.getScene().getWindow(),"../fxml/RankingFXML.fxml", 600, 400);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void summaryLaunch(ActionEvent actionEvent) {
        Stage resultStage = new Stage();
        try {
            startSummaryWindow(resultStage, (Stage)launchSummaryButton.getScene().getWindow(), saveYearTournaments);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startSummaryWindow(Stage window, Stage parentStage, List<Tournament> saveYearTournaments) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/PlayYearSummary.fxml"));
        Parent root = loader.load();
        PlayYearSummaryController controller = loader.getController();
        controller.setResults(saveYearTournaments);

        Scene scene =  new Scene(root, 300 ,200);

        window.initModality(Modality.WINDOW_MODAL);
        window.initOwner(parentStage);
        window.setTitle("Results of Year : "+year.getDate());
        window.setResizable(false);
        window.setScene(scene);
        window.show();
    }
}
