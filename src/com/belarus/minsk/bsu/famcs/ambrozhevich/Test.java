package com.belarus.minsk.bsu.famcs.ambrozhevich;


import java.util.List;

public class Test {
    private List<Task> tasks;
    private User user;
    int size;
    int correct = 0;

    public Test(List<Task> tasks, User user) {
        this.tasks = tasks;
        this.user = user;
        size = tasks.size();
    }

    public boolean hasNextTask() {
        return !tasks.isEmpty();
    }

    public String task() {
        return tasks.get(0).toString();
    }

    public void setAnswer(int i) {
        if (tasks.get(0).getCorrect() == i)
            correct++;
    }

    public double getStatistics() {
        return correct / (double) size;
    }

    public void next() {
        tasks.remove(0);
    }
}