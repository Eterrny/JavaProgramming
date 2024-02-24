package ru.sgu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringPerformanceTestService {
    private int iterations;

    public StringPerformanceTestService() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число итераций: ");
        try {
            this.iterations = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void execute() {
        long startTime, endTime;

        // StringBuilder
        startTime = System.currentTimeMillis();
        useStringBuilder(iterations);
        endTime = System.currentTimeMillis();
        System.out.println("Время StringBuilder: " + (endTime - startTime) + "ms");

        // StringBuffer
        startTime = System.currentTimeMillis();
        useStringBuffer(iterations);
        endTime = System.currentTimeMillis();
        System.out.println("Время StringBuffer: " + (endTime - startTime) + "ms");

        // String
        startTime = System.currentTimeMillis();
        useStringConcatenation(iterations);
        endTime = System.currentTimeMillis();
        System.out.println("Время String: " + (endTime - startTime) + "ms");
    }

    private void useStringBuilder(int iterations) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(generateRandomString());
        }
    }

    private void useStringBuffer(int iterations) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(generateRandomString());
        }
    }

    private void useStringConcatenation(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += generateRandomString();
        }
    }

    private String generateRandomString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            char randomChar = (char) ('a' + Math.random() * ('z' - 'a' + 1));
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
