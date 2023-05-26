package finalproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class wordleGameController {
    //Row 1
    @FXML
    private Label letter1, letter2, letter3, letter4, letter5;
    //Row 2
    @FXML
    private Label letter6, letter7, letter8, letter9, letter10;
    //Row 3
    @FXML
    private Label letter11, letter12, letter13, letter14, letter15;
    //Row 4
    @FXML
    private Label letter16, letter17, letter18, letter19, letter20;
    //Row 5
    @FXML
    private Label letter21, letter22, letter23, letter24, letter25;
    //Row 6
    @FXML
    private Label letter26, letter27, letter28, letter29, letter30;
    
    @FXML
    private Label label;

    @FXML
    private TextField txtGuess;

    @FXML
    private GridPane gridPane;

    @FXML
    private Button btnGuess, btnStart;


    wordleTxtController wtc = new wordleTxtController();

    private boolean check1 = false, check2 = false, check3 = false, 
                    check4 = false, check5 = false, check6 = false;

    private String chosenWord;



    @FXML
    public void onBtnStart() {
        chosenWord = wtc.wordle.selectWord();
        btnStart.setDisable(true);
        btnStart.setVisible(false);
        setAllVisible();
        check1 = true;
    }

    @FXML
    public void onBtnGuess(ActionEvent event) {
    
        String guess = txtGuess.getText();

        if(check1) {
            int count = 0;
            for (int i = 0; i < guess.length(); i++) {
                Label letter = getLabelByIndex(i);

                letter.setText(guess.toUpperCase().substring(i, i+1));

                if(guess.charAt(i) == chosenWord.charAt(i)){
                    count++;
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #528d4e;");
                } else if(chosenWord.indexOf(guess.substring(i, i+1)) != -1){
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #b59f3a;");
                } else {
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #3a3b3c;");
                }
            }
            
            check1 = false;
            check2 = true;
        } else if(check2) {
            int count = 0;
            for (int i = 0; i < guess.length(); i++) {
                Label letter = getLabelByIndex(i+5);

                letter.setText(guess.toUpperCase().substring(i, i+1));

                if(guess.charAt(i) == chosenWord.charAt(i)){
                    count++;
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #528d4e;");
                } else if(chosenWord.indexOf(guess.substring(i, i+1)) != -1){
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #b59f3a;");
                } else {
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #3a3b3c;");
                }
            }

            check2 = false;
            check3 = true;
        } else if(check3) {
            int count = 0;
            for (int i = 0; i < guess.length(); i++) {
                Label letter = getLabelByIndex(i+10);

                letter.setText(guess.toUpperCase().substring(i, i+1));

                if(guess.charAt(i) == chosenWord.charAt(i)){
                    count++;
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #528d4e;");
                } else if(chosenWord.indexOf(guess.substring(i, i+1)) != -1){
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #b59f3a;");
                } else {
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #3a3b3c;");
                }
            }

            check3 = false;
            check4 = true;
        } else if(check4) {
            int count = 0;
            for (int i = 0; i < guess.length(); i++) {
                Label letter = getLabelByIndex(i+15);

                letter.setText(guess.toUpperCase().substring(i, i+1));

                if(guess.charAt(i) == chosenWord.charAt(i)){
                    count++;
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #528d4e;");
                } else if(chosenWord.indexOf(guess.substring(i, i+1)) != -1){
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #b59f3a;");
                } else {
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #3a3b3c;");
                }
            }

            check4 = false;
            check5 = true;
        } else if(check5) {
            int count = 0;
            for (int i = 0; i < guess.length(); i++) {
                Label letter = getLabelByIndex(i+20);

                letter.setText(guess.toUpperCase().substring(i, i+1));

                if(guess.charAt(i) == chosenWord.charAt(i)){
                    count++;
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #528d4e;");
                } else if(chosenWord.indexOf(guess.substring(i, i+1)) != -1){
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #b59f3a;");
                } else {
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #3a3b3c;");
                }
            }

            if(checkIfCorrect(count) == true){

            } else {
                check5 = false;
                check6 = true;
            }
        } else if (check6) {
            int count = 0;
            for (int i = 0; i < guess.length(); i++) {
                Label letter = getLabelByIndex(i+25);

                letter.setText(guess.toUpperCase().substring(i, i+1));

                if(guess.charAt(i) == chosenWord.charAt(i)){
                    count++;
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #528d4e;");
                } else if(chosenWord.indexOf(guess.substring(i, i+1)) != -1){
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #b59f3a;");
                } else {
                    letter.setStyle("-fx-alignment: center; -fx-background-color: #3a3b3c;");
                }
            }

            checkIfCorrect(count);
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
        String phrase = "";
        if (i == 5) {
            return true;
        } else {
            if(check6) {
                
                check6 = false;
            }
        }
        return true;
    }

    private Label getLabelByIndex(int i){
        switch (i) {
            case 0:
                return letter1;
            case 1:
                return letter2;
            case 2:
                return letter3;
            case 3:
                return letter4;
            case 4:
                return letter5;
            case 5:
                return letter6;
            case 6:
                return letter7;
            case 7:
                return letter8;
            case 8:
                return letter9;
            case 9:
                return letter10;
            case 10:
                return letter11;
            case 11:
                return letter12;
            case 12:
                return letter13;
            case 13:
                return letter14;
            case 14:
                return letter15;
            case 15:
                return letter16;
            case 16:
                return letter17;
            case 17:
                return letter18;
            case 18:
                return letter19;
            case 19:
                return letter20;
            case 20:
                return letter21;
            case 21:
                return letter22;
            case 22:
                return letter23;
            case 23:
                return letter24;
            case 24:
                return letter25;
            case 25:
                return letter26;
            case 26:
                return letter27;
            case 27:
                return letter28;
            case 28:
                return letter29;
            case 29:
                return letter30;
            default:
                return null;
        }
    }
}
