package finalproj;

public class wordOTG {
    private String word;
    private boolean chosenWord;

    public wordOTG(String word){
        this.word = word;
        chosenWord = false;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean isChosenWord() {
        return chosenWord;
    }

    public void setChosenWord(boolean chosenWord) {
        this.chosenWord = chosenWord;
    }
}
