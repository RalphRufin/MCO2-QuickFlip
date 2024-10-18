package com.mobdeve.s20.group7.mco2;

import java.util.ArrayList;
import java.util.List;

public class CardItem {

    // A list to hold pairs of question and answer
    private List<Pair<String, String>> questionAnswerPairs;

    // Constructor
    public CardItem() {
        this.questionAnswerPairs = new ArrayList<>();
    }

    // Add a new question and answer pair
    public void addQuestionAnswerPair(String question, String answer) {
        questionAnswerPairs.add(new Pair<>(question, answer));
    }

    // Get the list of question-answer pairs
    public List<Pair<String, String>> getQuestionAnswerPairs() {
        return questionAnswerPairs;
    }

    // Get a question-answer pair by index
    public Pair<String, String> getQuestionAnswerPair(int index) {
        if (index >= 0 && index < questionAnswerPairs.size()) {
            return questionAnswerPairs.get(index);
        }
        return null; // Handle out-of-bounds access
    }

    // Helper class to represent a pair of Strings (Question and Answer)
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
