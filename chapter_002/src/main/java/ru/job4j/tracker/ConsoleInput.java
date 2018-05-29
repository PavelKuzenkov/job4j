package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput {

    public String ask() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
