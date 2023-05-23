package finalproj;

import java.util.ArrayList;
import java.util.Random;

public class Wordle {
    private Random rand;
    private ArrayList<wordOTG> wordList;
    private int index;

    public Wordle(){
        rand = new Random();
        wordList = new ArrayList<>();
    }

    public Boolean addWord(String word) {
        for (wordOTG wordOTG : wordList) {
            if(wordOTG.getWord().equalsIgnoreCase(word) == true){
                return false;
            }
        }

        wordList.add(new wordOTG(word));
        return true;
    }

    public int countWords(){
        int numWords = 0;
        
        for (wordOTG wordOTG : wordList) {
            if(wordOTG.getWord().length() == 5){
                numWords++;
            }
        }

        return numWords;
    }

    public Boolean ifCountSame() {
        int count = 0;
        int numWords = 0;
        
        for (wordOTG wordOTG : wordList) {
            if(wordOTG.getWord().length() == 5){
                numWords++;
            }
            count++;
        }

        if(numWords != count){
            return false;
        }else{
            return true;
        }
    }

    public void removeWord(String name){
        for (wordOTG wordOTG : wordList) {
            if(wordOTG.getWord().equals(name) == true){
                wordList.remove(wordOTG);
            }
        }
    }

    public void clearList(){
        wordList.clear();
    }

    public String selectWord(){
        int choice = rand.nextInt(0, wordList.size());
        index = choice;
        wordList.get(choice).setChosenWord(true);
        String wordOTD = wordList.get(choice).getWord();
        return wordOTD;
    }
}
