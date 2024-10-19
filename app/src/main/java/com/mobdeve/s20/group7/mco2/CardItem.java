package com.mobdeve.s20.group7.mco2;

import java.util.ArrayList;
import java.util.List;

public class CardItem {

    private List<Pair<String, String>> questionAnswerPairs;

    public CardItem() {
        this.questionAnswerPairs = new ArrayList<>();
    }

    public void addQuestionAnswerPair(String question, String answer) {
        questionAnswerPairs.add(new Pair<>(question, answer));
    }

    public List<Pair<String, String>> getQuestionAnswerPairs() {
        return questionAnswerPairs;
    }

    public Pair<String, String> getQuestionAnswerPair(int index) {
        if (index >= 0 && index < questionAnswerPairs.size()) {
            return questionAnswerPairs.get(index);
        }
        return null; // Handle out-of-bounds access
    }

    public static class Pair<K, V> {
        private K question;
        private V answer;

        public Pair(K question, V answer) {
            this.question = question;
            this.answer = answer;
        }

        public K getQuestion() {
            return question;
        }

        public V getAnswer() {
            return answer;
        }

        @Override
        public String toString() {
            return "Question: " + question + ", Answer: " + answer;
        }
    }
}
