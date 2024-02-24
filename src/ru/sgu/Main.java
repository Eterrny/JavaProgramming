package ru.sgu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                Выберите задание:
                    1. Задача с фильтром Stream
                    2. Задача с поиском элементов в массиве
                    3. Реализация адаптера
                Ваш выбор:\040""");
        try {
            switch (scanner.nextInt()) {
                case 1 -> {
                    TaskA task = new TaskA();
                    task.execute();
                }
                case 2 -> {
                    TaskB taskB = new TaskB();
                    taskB.findNumbers();
                }
                case 3 -> {
                    Adaptee adaptee = new Adaptee();
                    Target target = new Adapter(adaptee);
                    target.request(); // объект target может использовать метод specificRequest() класса Adaptee
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