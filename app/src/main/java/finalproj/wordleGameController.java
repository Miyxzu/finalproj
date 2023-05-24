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


    private Wordle wordle = new Wordle();

    private boolean check1 = false, check2 = false, check3 = false, 
                    check4 = false, check5 = false, check6 = false;

    private String chosenWord;

    @FXML
    public void onBtnStart() {
        chosenWord = wordle.selectWord();
        btnStart.setDisable(true);
        btnStart.setVisible(false);
        setAllVisible();
        check1 = true;
    }

    @FXML
    public void onBtnGuess(ActionEvent event) {
        String guess = txtGuess.getText();

        if(check1) {
            for (int i = 0; i < guess.length() - 1; i++) {
                if(guess.charAt(i) == chosenWord.charAt(i)){
                    
                }
                if(chosenWord.indexOf(guess.substring(i, i+1)) != -1){

                }
            }
        } else if(check2) {
            
        } else if(check3) {

        } else if(check4) {

        } else if(check5) {

        } else if (check6) {

        }
    }

    public void setAllVisible() {
        gridPane.setOpacity(1);
        btnGuess.setOpacity(1);
        txtGuess.setOpacity(1);
        label.setOpacity(1);
    }
}
