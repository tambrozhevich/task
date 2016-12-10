package com.belarus.minsk.bsu.famcs.ambrozhevich;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private String question;
    private List<String> answers;
    private int correct;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    Task() {
        this.answers = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("question: ").append(question).append("?\n");
        int count = 1;
        for (String answer : answers) {
            sb.append(count).append(": ").append(answer).append(".\n");
            count++;
        }
        return sb.toString();
    }
}