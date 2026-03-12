package finalproj;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class wordleGameController {
    // Row 1
    @FXML
    private Label char00, char10, char20, char30, char40;
    // Row 2
    @FXML
    private Label char01, char11, char21, char31, char41;
    // Row 3
    @FXML
    private Label char02, char12, char22, char32, char42;
    // Row 4
    @FXML
    private Label char03, char13, char23, char33, char43;
    // Row 5
    @FXML
    private Label char04, char14, char24, char34, char44;
    // Row 6
    @FXML
    private Label char05, char15, char25, char35, char45;

    @FXML
    private Label label;

    @FXML
    private TextField txtGuess;

    @FXML
    private GridPane gridPane;

    @FXML
    private Button btnGuess, btnStart;

    private Stage primaryStage;

    private Stage currentStage;

    private Node source;

    wordleTxtController wtc = new wordleTxtController();

    private boolean[] checkArray = { false, false, false, false, false, false };

    private String chosenWord;

    @FXML
    public void onBtnStart(ActionEvent event) {
        source = (Node) event.getSource();
        currentStage = (Stage) source.getScene().getWindow();
        chosenWord = wtc.wordle.selectWord();
        btnStart.setDisable(true);
        btnStart.setVisible(false);
        setAllVisible();
        checkArray[0] = true;
    }

    @FXML
    public void onBtnGuess(ActionEvent event) {

        String guess = txtGuess.getText();

        if (guess.length() != 5) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error: Word is not 5 letters");
            alert.setContentText("Please enter a word that is exactly 5 letters long");
            alert.show();
            return;
        }

        // Row 1
        if (checkArray[0]) {
            int count = 0;
            for (int i = 0; i < guess.length(); i++) {
                Label letter = getLabelByIndex(0, i);

                letter.setText(guess.toUpperCase().substring(i, i + 1));

                if (guess.charAt(i) == chosenWord.charAt(i)) {
                    count++;
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #528d4e;");
                } else if (chosenWord.indexOf(guess.substring(i, i + 1)) != -1) {
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #b59f3a;");
                } else {
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #3a3b3c;");
                }
            }

            if (checkIfCorrect(count)) {
                correctAlert();
                checkArray[0] = false;
            } else {
                checkArray[0] = false;
                checkArray[1] = true;
            }

            // Row 2
        } else if (checkArray[1]) {
            int count = 0;
            for (int i = 0; i < guess.length(); i++) {
                Label letter = getLabelByIndex(1, i);

                letter.setText(guess.toUpperCase().substring(i, i + 1));

                if (guess.charAt(i) == chosenWord.charAt(i)) {
                    count++;
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #528d4e;");
                } else if (chosenWord.indexOf(guess.substring(i, i + 1)) != -1) {
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #b59f3a;");
                } else {
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #3a3b3c;");
                }
            }

            if (checkIfCorrect(count)) {
                correctAlert();
                checkArray[1] = false;
            } else {
                checkArray[1] = false;
                checkArray[2] = true;
            }

            // Row 3
        } else if (checkArray[2]) {
            int count = 0;
            for (int i = 0; i < guess.length(); i++) {
                Label letter = getLabelByIndex(2, i);

                letter.setText(guess.toUpperCase().substring(i, i + 1));

                if (guess.charAt(i) == chosenWord.charAt(i)) {
                    count++;
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #528d4e;");
                } else if (chosenWord.indexOf(guess.substring(i, i + 1)) != -1) {
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #b59f3a;");
                } else {
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #3a3b3c;");
                }
            }

            if (checkIfCorrect(count)) {
                correctAlert();
                checkArray[2] = false;
            } else {
                checkArray[2] = false;
                checkArray[3] = true;
            }

            // Row 4
        } else if (checkArray[3]) {
            int count = 0;
            for (int i = 0; i < guess.length(); i++) {
                Label letter = getLabelByIndex(3, i);

                letter.setText(guess.toUpperCase().substring(i, i + 1));

                if (guess.charAt(i) == chosenWord.charAt(i)) {
                    count++;
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #528d4e;");
                } else if (chosenWord.indexOf(guess.substring(i, i + 1)) != -1) {
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #b59f3a;");
                } else {
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #3a3b3c;");
                }
            }

            if (checkIfCorrect(count)) {
                correctAlert();
                checkArray[3] = false;
            } else {
                checkArray[3] = false;
                checkArray[4] = true;
            }

            // Row 5
        } else if (checkArray[4]) {
            int count = 0;
            for (int i = 0; i < guess.length(); i++) {
                Label letter = getLabelByIndex(4, i);

                letter.setText(guess.toUpperCase().substring(i, i + 1));

                if (guess.charAt(i) == chosenWord.charAt(i)) {
                    count++;
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #528d4e;");
                } else if (chosenWord.indexOf(guess.substring(i, i + 1)) != -1) {
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #b59f3a;");
                } else {
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #3a3b3c;");
                }
            }

            if (checkIfCorrect(count) == true) {
                correctAlert();
                checkArray[4] = false;
            } else {
                checkArray[4] = false;
                checkArray[5] = true;
            }

            // Row 6
        } else if (checkArray[5]) {
            int count = 0;
            for (int i = 0; i < guess.length(); i++) {
                Label letter = getLabelByIndex(5, i);

                letter.setText(guess.toUpperCase().substring(i, i + 1));

                if (guess.charAt(i) == chosenWord.charAt(i)) {
                    count++;
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #528d4e;");
                } else if (chosenWord.indexOf(guess.substring(i, i + 1)) != -1) {
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #b59f3a;");
                } else {
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #3a3b3c;");
                }
            }

            if (checkIfCorrect(count)) {
                correctAlert();
                checkArray[5] = false;
            } else {

            }
        } else {

        }
    }

    private void setAllVisible() {
        gridPane.setOpacity(1);
        btnGuess.setOpacity(1);
        txtGuess.setOpacity(1);
        label.setOpacity(1);
    }

    private boolean checkIfCorrect(int i) {
        if (i == 5) {
            return true;
        } else {
            if (checkArray[5]) {
                Dialog<ButtonType> dialog = new Dialog<>();
                dialog.setTitle("Unfortunate");

                Image img = new Image(
                        getClass().getResourceAsStream("negative-squared-cross-mark-emoji-512x512-k111iswl.png"));
                ImageView imgView = new ImageView(img);
                imgView.setFitWidth(100);
                imgView.setPreserveRatio(true);

                Text txtNode = new Text("Good try, the word to guess was " + chosenWord.toUpperCase()
                        + ". would you like to Play Again or Quit the Game?");
                txtNode.setTextAlignment(TextAlignment.LEFT);

                HBox hbox = new HBox(10);
                hbox.setAlignment(Pos.CENTER_LEFT);
                hbox.getChildren().addAll(imgView, txtNode);

                ButtonType playAgain = new ButtonType("Play Again", ButtonData.OK_DONE);
                ButtonType quit = new ButtonType("Quit Wordle", ButtonData.CANCEL_CLOSE);
                ButtonType editTextArea = new ButtonType("Re-Edit List", ButtonData.OK_DONE);

                DialogPane dp = dialog.getDialogPane();
                dp.setContent(hbox);
                dp.getButtonTypes().addAll(editTextArea, quit, playAgain);

                dialog.showAndWait().ifPresent(ButtonType -> {
                    if (ButtonType == playAgain) {
                        wtc.wordle.removeWord(chosenWord);
                        for (int j = 0; j < 30; j++) {
                            Label letter = getLabelByIndex(j / 5, j % 5);
                            letter.setStyle(
                                    "-fx-alignment: center; -fx-background-color: #121213; -fx-border-color: #2f3030; -fx-border-width: 5px;");
                        }
                        checkArray[0] = true;
                        chosenWord = wtc.wordle.selectWord();
                    } else if (ButtonType == quit) {
                        Platform.exit();
                    } else if (ButtonType == editTextArea) {
                        openTextEditScene();
                        currentStage.close();
                    }
                });
                checkArray[5] = false;
            }
            return false;
        }
    }

    private void correctAlert() {
        String message = message();
        int trys = numTrys();

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Congratulations");

        Image img = new Image(getClass().getResourceAsStream("white-heavy-check-mark-emoji-by-twitter.png"));
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(100);
        imgView.setPreserveRatio(true);

        Text txtNode = new Text(
                message + ". You got it in " + trys + " trys, would you like to Play Again or Quit the Game?");
        txtNode.setTextAlignment(TextAlignment.LEFT);

        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.getChildren().addAll(imgView, txtNode);

        ButtonType playAgain = new ButtonType("Play Again", ButtonData.OK_DONE);
        ButtonType quit = new ButtonType("Quit Wordle", ButtonData.CANCEL_CLOSE);
        ButtonType editTextArea = new ButtonType("Re-Edit List", ButtonData.OK_DONE);

        DialogPane dp = dialog.getDialogPane();
        dp.setContent(hbox);
        dp.getButtonTypes().addAll(editTextArea, quit, playAgain);

        dialog.showAndWait().ifPresent(ButtonType -> {
            if (ButtonType == playAgain) {
                wtc.wordle.removeWord(chosenWord);
                for (int i = 0; i < 30; i++) {
                    Label letter = getLabelByIndex(i / 5, i % 5);
                    letter.setStyle(
                            "-fx-alignment: center; -fx-background-color: #121213; -fx-border-color: #2f3030; -fx-border-width: 5px;");
                    letter.setText("");
                }
                checkArray[0] = true;
                chosenWord = wtc.wordle.selectWord();
            } else if (ButtonType == quit) {
                Platform.exit();
            } else if (ButtonType == editTextArea) {
                openTextEditScene();
                currentStage.close();
            }
        });
    }

    private void openTextEditScene() {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("wordleTextArea-view.fxml"));
            Parent root = fxml.load();
            wordleTxtController wordleBoard = fxml.getController();
            Scene scene = new Scene(root, 600, 400);
            Stage editStage = new Stage(StageStyle.DECORATED);
            editStage.setScene(scene);
            editStage.show();
            primaryStage = editStage;
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    private int numTrys() {
        int num = 0;
        if (checkArray[0]) {
            num = 1;
        } else if (checkArray[1]) {
            num = 2;
        } else if (checkArray[2]) {
            num = 3;
        } else if (checkArray[3]) {
            num = 4;
        } else if (checkArray[4]) {
            num = 5;
        } else if (checkArray[5]) {
            num = 6;
        }
        return num;
    }

    private String message() {
        String message = "";
        if (checkArray[0]) {
            message = "Genius";
        } else if (checkArray[1]) {
            message = "Magnificent";
        } else if (checkArray[2]) {
            message = "Impressive";
        } else if (checkArray[3]) {
            message = "Splendid";
        } else if (checkArray[4]) {
            message = "Great";
        } else if (checkArray[5]) {
            message = "Phew";
        }
        return message;
    }

    // What it should have been if I had a brain
    private Label getLabelByIndex(int i, int j) {
        Label[][] labelArray = { { char00, char10, char20, char30, char40 },
                { char01, char11, char21, char31, char41 }, { char02, char12, char22, char32, char42 },
                { char03, char13, char23, char33, char43 }, { char04, char14, char24, char34, char44 },
                { char05, char15, char25, char35, char45 } };

        for (int x = 0; x < labelArray.length; x++) {
            for (int y = 0; y < labelArray[x].length; y++) {
                if (x == i && y == j) {
                    return labelArray[x][y];
                }
            }
        }
        
        return null;

        // This is fucking stupid why did I do this
        // switch (i) {
        // case 0:
        // return letter1;
        // case 1:
        // return letter2;
        // case 2:
        // return letter3;
        // case 3:
        // return letter4;
        // case 4:
        // return letter5;
        // case 5:
        // return letter6;
        // case 6:
        // return letter7;
        // case 7:
        // return letter8;
        // case 8:
        // return letter9;
        // case 9:
        // return letter10;
        // case 10:
        // return letter11;
        // case 11:
        // return letter12;
        // case 12:
        // return letter13;
        // case 13:
        // return letter14;
        // case 14:
        // return letter15;
        // case 15:
        // return letter16;
        // case 16:
        // return letter17;
        // case 17:
        // return letter18;
        // case 18:
        // return letter19;
        // case 19:
        // return letter20;
        // case 20:
        // return letter21;
        // case 21:
        // return letter22;
        // case 22:
        // return letter23;
        // case 23:
        // return letter24;
        // case 24:
        // return letter25;
        // case 25:
        // return letter26;
        // case 26:
        // return letter27;
        // case 27:
        // return letter28;
        // case 28:
        // return letter29;
        // case 29:
        // return letter30;
        // default:
        // return null;
    }
}
