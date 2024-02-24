package ru.sgu;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskB {
    private Day currentDay;
    Integer daysToAdd;

    enum Day {
        monday, tuesday, wednesday, thursday, friday, saturday, sunday;

        public Day calculateDay(int daysToAdd) {
            return values()[(ordinal() + daysToAdd) % values().length];
        }
    }

    public TaskB() {
        System.out.println("Введите день недели и число:");
        Scanner scanner = new Scanner(System.in);
        try {
            String dayOfWeek = scanner.next().toLowerCase();
            this.daysToAdd = scanner.nextInt();
            while (this.daysToAdd < 0) {
                this.daysToAdd = this.daysToAdd + 7;
            }
            this.currentDay = Day.valueOf(dayOfWeek);
        } catch (NoSuchElementException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        scanner.close();
    }

    public void execute() {
        if (this.currentDay == null || this.daysToAdd == null) {
            System.out.println("Нет значения для текущего дня или количества дней, которые должны быть прибавлены.");
            return;
        }
        System.out.println(currentDay.calculateDay(this.daysToAdd));
    }
}
