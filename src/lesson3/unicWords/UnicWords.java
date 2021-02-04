package lesson3.unicWords;

import java.awt.*;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class UnicWords {
    public static final String[] words = {
            "Набор",
            "Слов",
            "Самолёт",
            "Велосипед",
            "Компьютер",
            "Слов",
            "Самокат",
            "Клюшка",
            "Гонка",
            "Герой",
            "Самолёт",
            "Самокат",
            "Человек",
            "Герой",
            "Слов"
    };
    //    public static final String[] words = {"Log", "Log", "loh"};
    public static ArrayList<Word> wordList = new ArrayList<>();
    public static HashSet<String> wordsSet = new HashSet<>();


    public static void main(String[] args) {
        for (String word : words) {
            Word unicWord = new Word(word);
            if (!wordsSet.contains(unicWord.getWord())) {
                wordsSet.add(unicWord.getWord());
                wordList.add(unicWord);
            } else {
//                System.out.println(wordList.size());
                wordList.get(wordList.indexOf(unicWord)).incCount();
//                System.out.println(wordList.indexOf(unicWord));
            }
        }
        for (int i = 0; i < wordList.size(); i++) {
            System.out.println(wordList.get(i));
        }
    }
}
