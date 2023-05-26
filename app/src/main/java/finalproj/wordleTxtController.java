package finalproj;

import java.io.IOException;
import java.util.Optional;
import javafx.scene.Node;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public class wordleTxtController {
    @FXML
    private TextArea txtArea;

    private Stage primaryStage;

    private Alert alert;

    private Node source;

    private Stage currentStage;

    static Wordle wordle = new Wordle();

    @FXML
    public void onBtnEnter(ActionEvent event) throws IOException {
        source = (Node) event.getSource();
        currentStage = (Stage) source.getScene().getWindow();
        int count = 0;
        boolean check = true;
        String[] lines;
        String reoccuring = "";
        String text = txtArea.getText();
        lines = text.split("\n");

        for (String line : lines) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (wordle.addWord(word) == false) {
                    check = false;
                    reoccuring = word;
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error: Already Existing Word in List");
                    alert.setContentText(reoccuring + " already exists in the list, please remove the duplicate");
                    alert.show();
                    wordle.clearList();
                    break;
                }
                count++;
            }
        }

        if (!wordle.ifCountSame() && check == true) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error: 1 or more words are not equal to 5 letters");
            alert.setContentText("There are " + (count - wordle.countWords())
                    + " word(s) that have more or less than 5 letters, please change the words");
            alert.show();
            wordle.clearList();
        } else if (wordle.ifCountSame() && check == true) {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("There are " + wordle.countWords()
                    + " words in the list, would you like to play with these words or edit the list?");

            ButtonType playBtn = new ButtonType("Play Wordle", ButtonBar.ButtonData.OK_DONE);
            ButtonType closeBtn = new ButtonType("Re-Edit Words", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(playBtn, closeBtn);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == playBtn) {
                openWordleBoard();
                hideScene();
            } else if (result.isPresent() && result.get() == closeBtn) {
                wordle.clearList();
            } else {

            }
        } else {

        }
    }

    private void hideScene() {
        currentStage.hide();
    }

    void quitTxtArea() {
        Platform.exit();
    }

    void openWordleBoard() {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("wordleGameplay-view.fxml"));
            Parent root = fxml.load();
            wordleGameController wordleBoard = fxml.getController();
            Scene scene = new Scene(root, 600, 750);
            Stage boardStage = new Stage(StageStyle.DECORATED);
            boardStage.setScene(scene);
            boardStage.show();
            primaryStage = boardStage;
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
