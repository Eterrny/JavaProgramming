package ru.sgu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                Выберите задание:
                    1. Задача с датами
                    2. Задача с днями недели
                    3. Задача со строкой
                Ваш выбор:\040""");
        try {
            switch (scanner.nextInt()) {
                case 1 -> {
                    TaskA taskA = new TaskA();
                    taskA.execute();
                }
                case 2 -> {
                    TaskB taskB = new TaskB();
                    taskB.execute();
                }
                case 3 -> {
                    StringPerformanceTestService test = new StringPerformanceTestService();
                    test.execute();
                }
                default -> System.out.println("Выбор должен быть числом от 1 до 3.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Выбор должен являться целым числом!");
            return;
        }
        scanner.close();
    }
}