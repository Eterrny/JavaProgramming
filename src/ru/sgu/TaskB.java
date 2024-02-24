package ru.sgu;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    private int[] numbers;

    public TaskB() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целые числа через пробел:");
        String input = scanner.nextLine();
        try {
            this.numbers = Arrays.stream(input.split("\\s+"))
                    .filter(StreamFilter::isInteger)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        scanner.close();
    }

    public void findNumbers() {
        try {
            System.out.printf("""
                    Второй наибольший элемент массива: %d
                    Третий наименьший элемент массива: %d
                    """, findSecondLargest(), findThirdSmallest());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private int findSecondLargest() {
        return Arrays.stream(numbers)
                .sorted()
                .skip(Math.max(0, numbers.length - 2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Массив пуст или содержит менее двух элементов."));
    }

    private int findThirdSmallest() {
        return Arrays.stream(numbers)
                .sorted()
                .skip(2)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Массив пуст или содержит менее трех элементов."));
    }
}
