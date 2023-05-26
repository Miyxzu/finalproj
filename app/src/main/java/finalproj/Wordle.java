package finalproj;

import java.util.ArrayList;
import java.util.Random;

public class Wordle {
    private Random rand;
    ArrayList<wordOTG> wordList;

    public Wordle() {
        rand = new Random();
        wordList = new ArrayList<>();
    }

    public Boolean addWord(String word) {
        for (wordOTG wordOTG : wordList) {
            if (wordOTG.getWord().equalsIgnoreCase(word) == true) {
                return false;
            }
        }

        wordList.add(new wordOTG(word));
        return true;
    }

    public int countWords() {
        int numWords = 0;

        for (wordOTG wordOTG : wordList) {
            if (wordOTG.getWord().length() == 5) {
                numWords++;
            }
        }

        return numWords;
    }

    public Boolean ifCountSame() {
        int count = 0;
        int numWords = 0;

        for (wordOTG wordOTG : wordList) {
            if (wordOTG.getWord().length() == 5) {
                numWords++;
            }
            count++;
        }

        if (numWords != count) {
            return false;
        } else {
            return true;
        }
    }

    public void removeWord(String word) {
        for (wordOTG wordOTG : wordList) {
            if (wordOTG.getWord().equalsIgnoreCase(word) == true) {
                wordList.remove(wordOTG);
            }
        }
    }

    public void clearList() {
        wordList.clear();
    }

    public String selectWord() {
        int choice = rand.nextInt(0, wordList.size());
        String wordOTD = wordList.get(choice).getWord();
        return wordOTD;
    }
}
