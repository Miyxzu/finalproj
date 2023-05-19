package finalproj;

import java.util.ArrayList;
import java.util.Random;

public class Wordle {
    private Random rand;
    private ArrayList<wordOTG> wordList;
    private int currentIndex;
    
    public Wordle(){
        rand = new Random();
        wordList = new ArrayList<>(wordList);
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

    public Boolean countWords(){
        int count = 0;
        int numWords = 0;
        
        for (wordOTG wordOTG : wordList) {
            if(wordOTG.getWord().length() == 4){
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

    public String selectWord(){
        int choice = rand.nextInt(0, wordList.size());
        currentIndex = choice;
        String wordOTD = wordList.get(choice).getWord();
        return wordOTD;
    }
}
