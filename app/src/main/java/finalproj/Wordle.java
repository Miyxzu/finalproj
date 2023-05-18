package finalproj;

import java.util.ArrayList;
import java.util.Random;

public class Wordle {
    private Random rand;
    private ArrayList<wordOTG> wordlist;
    
    public Wordle(){
        rand = new Random();
        wordlist = new ArrayList<>(wordlist);
    }

    public Boolean addWord(String word) {
        for (wordOTG wordOTG : wordlist) {
            if(wordOTG.getWord().equalsIgnoreCase(word) == true){
                return false;
            }
        }

        wordlist.add(new wordOTG(word));
        return true;
    }

    public Boolean countWords(){
        int count = 0;
        int numWords = 0;
        
        for (wordOTG wordOTG : wordlist) {
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
        for (wordOTG wordOTG : wordlist) {
            if(wordOTG.getWord().equals(name) == true){
                wordlist.remove(wordOTG);
            }
        }
    }

    public String selectWord(){
        

        return "0";
    }
}
