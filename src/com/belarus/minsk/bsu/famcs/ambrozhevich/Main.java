package com.belarus.minsk.bsu.famcs.ambrozhevich;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        List<Task> tasks = parseTest(new File("test.txt"));
        System.out.println("user(surname, name, course, group): ");
        User user = parseUser(new Scanner(System.in).nextLine());
        Test test = new Test(tasks, user);
        Scanner scanner = new Scanner(System.in);
        while (test.hasNextTask()) {
            System.out.print(test.task());
            System.out.println("answer: ");
            test.setAnswer(scanner.nextInt());
            test.next();
        }
        double stats = test.getStatistics();
        System.out.println("stat: " + stats);
        FileWriter fw;
        if (stats >= 0.75) {
            fw = new FileWriter("output2.txt", true);
        } else {
            fw = new FileWriter("output1.txt", true);
        }
        fw.write(user.toString());
        fw.write(System.lineSeparator());
        fw.close();
        fw = new FileWriter("logfile.txt", true);
        fw.write(user.toString() + " " + (stats >= 0.75 ? "1" : "0"));
        fw.write(System.lineSeparator());
        fw.close();
    }

    private static User parseUser(String s) throws Exception {
        Scanner scanner = new Scanner(s);
        User user = new User();
        try {
            user.setSurname(scanner.next());
            user.setName(scanner.next());
            user.setCourse(scanner.nextInt());
            user.setGroup(scanner.nextInt());
        } catch (NoSuchElementException e) {
            throw new Exception("wrong format");
        }
        return user;
    }

    private static List<Task> parseTest(File test) throws Exception {
        List<Task> tasks = new ArrayList<>();
        Scanner input = new Scanner(test);
        try {
            while (input.hasNext()) {
                Task task = new Task();
                task.setQuestion(input.nextLine());
                int size = Integer.parseInt(input.nextLine());
                while (size > 0) {
                    task.getAnswers().add(input.nextLine());
                    size--;
                }
                task.setCorrect(Integer.parseInt(input.nextLine()));
                tasks.add(task);
            }
        } catch (NoSuchElementException e) {
            throw new Exception("wrong file format");
        }
        return tasks;
    }
}
