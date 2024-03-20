package ru.sgu;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Введите путь директории: ");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.next();
        System.out.println("Введите целевую строку: ");
        String targetString = scanner.next();
        Archiver archiver = new Archiver(directoryPath, targetString);
        archiver.archive();
        scanner.close();
    }
}
