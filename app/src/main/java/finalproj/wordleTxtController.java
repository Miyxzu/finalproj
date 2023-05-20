package finalproj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;

public class wordleTxtController {
    @FXML
    private TextArea txtArea;

    @FXML
    private Button btnEnter;

    private Stage primaryStage;

    private Alert alert;

    private String[] words;

    private Wordle wordle = new Wordle();

    @FXML
    public void onBtnEnter(ActionEvent event) {
        int count = 0;
        String reoccuring = "";
        String text = txtArea.getText();
        words = text.split("\n");
        found: {
            for (String string : words) {
                if(wordle.addWord(string) == false) {
                    reoccuring = string;
                    break found;
                }
                count++;
            }

            if(wordle.ifCountSame() == false) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error: 1 or more words are not equal to 4 letters");
                alert.setContentText("There are " + (count - wordle.countWords()) + " words that have more or less than 4 letters, please change the words");
            }else{
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setContentText("There are " + wordle.countWords() + " in the list, would you like to play with these words or edit the list?");

                ButtonType playBtn = new ButtonType("Play Wordle", ButtonBar.ButtonData.OK_DONE);
                ButtonType closeBtn = new ButtonType("Re-Edit Text", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(playBtn, closeBtn);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == playBtn) {
                    // openWordleBoard();
                } else if (result.isPresent() && result.get() == closeBtn) {

                } else {

                }
            }
        }

        alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error: Already Existing Word in List");
        alert.setContentText(reoccuring + "already exists in the list, please remove the duplicate");
    }

    private void openWordleBoard() {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("app/src/main/resources/finalproj/wordleGameplayMock-view.fxml"));
            Parent root = fxml.load();
            wordleGameController wordleBoard = fxml.getController();
            Scene scene = new Scene(root, 600, 400);
            Stage boardStage = new Stage(null);
            boardStage.setScene(scene);
            boardStage.show();

            primaryStage = boardStage;
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
