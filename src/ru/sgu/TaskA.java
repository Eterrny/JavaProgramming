package ru.sgu;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskA {
    private LocalDate minDate;
    private LocalDate maxDate;

    public TaskA() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите даты в формате \"год месяц день\". Чтобы прекратить ввод, введите 0");
        try {
            for (; ; ) {
                int year = scanner.nextInt();
                if (year == 0) {
                    break;
                }
                LocalDate date = LocalDate.of(year, scanner.nextInt(), scanner.nextInt());
                if (this.minDate == null || date.isBefore(minDate)) {
                    this.minDate = date;
                }
                if (this.maxDate == null || date.isAfter(maxDate)) {
                    this.maxDate = date;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Среди входных данных передано не число.\n" + e.getMessage());
            System.exit(1);
        } catch (DateTimeException e) {
            System.out.println("Передана некорректная дата.");
        }
        scanner.close();
    }

    public void execute() {
        if (this.minDate == null || this.maxDate == null) {
            System.out.println("Минимальная или максимальная дата отсутствует.");
            return;
        }
        System.out.println("Число дней между минимальной и максимальной датами: "
                + ChronoUnit.DAYS.between(this.minDate, this.maxDate));
    }
}
