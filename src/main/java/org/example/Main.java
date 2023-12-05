package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1:");
        TaskOne taskOne = new TaskOne("file1.txt");
        taskOne.printValidPhoneNumber();

        System.out.println("Task 2:");
        TaskTwo taskTwo = new TaskTwo("file2.txt");
        taskTwo.writeDTO();

        System.out.println("Task 3:");
        TaskThree taskThree = new TaskThree("words.txt");
        taskThree.readFile();
    }
}
