package lesson3.unicWords;

import java.util.Objects;

public class Word {
    private final String word;
    private int count;
    public Word(String word){
        this.word=word;
        count=1;
    }

    public int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }
    public void incCount(){
        count++;
    }

    @Override
    public String toString() {
        return "Word{\n" +
                "word= " + word + '\n' +
                "count= " + count +
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}
