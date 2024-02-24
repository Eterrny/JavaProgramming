package ru.sgu;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TaskA {
    private Stream<Integer> stream;
    private final Predicate<Integer> predicate;

    public TaskA() {
        this.predicate = n -> n % 2 == 0 || n % 3 == 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целые числа через пробел:");
        String input = scanner.nextLine();
        try {
            this.stream = Stream.of(input.split("\\s+")).filter(StreamFilter::isInteger).map(Integer::parseInt);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        scanner.close();
    }

    public void execute() {
        StreamFilter<Integer> streamFilter = new StreamFilter<>(this.predicate);
        Stream<Integer> filteredStream = streamFilter.filter(this.stream);
        filteredStream.forEach(n -> System.out.print(n + " "));
        this.stream.close();
    }
}

class StreamFilter<T> {
    private final Predicate<T> predicate;

    public StreamFilter(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    public Stream<T> filter(Stream<T> stream) {
        return stream.filter(predicate);
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}