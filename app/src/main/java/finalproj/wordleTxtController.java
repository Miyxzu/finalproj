package finalproj;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;

public class wordleTxtController {
    @FXML
    private TextArea txtArea;

    @FXML
    private Button btnEnter;

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
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error: 1 or more words are not equal to 4 letters");
                alert.setContentText("There are " + (count - wordle.countWords()) + " words that have more or less than 4 letters, please change the words");
            }else{
                
            }
        }
        alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error: Already Existing Word in List");
        alert.setContentText(reoccuring + "already exists in the list, please remove the duplicate");
    }

    private void closeAlert() {
        DialogPane dp = alert.getDialogPane();
        dp.getScene().getWindow().hide();
    }
}
