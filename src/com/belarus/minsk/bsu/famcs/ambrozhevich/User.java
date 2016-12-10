package com.belarus.minsk.bsu.famcs.ambrozhevich;

public class User {
    private String surname;
    private String name;
    private int course;
    private int group;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(surname).append(" ")
                .append(name).append(" ")
                .append(course).append(" ")
                .append(group);
        return sb.toString();
    }
}