package ru.sgu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        List<CompanyRating> companies = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/ru/sgu/data1.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                StringBuilder fullName = new StringBuilder();
                for (int i = 0; i < parts.length - 2; i++) {
                    fullName.append(parts[i]).append(" ");
                }
                fullName = new StringBuilder(fullName.toString().trim());
                String companyName = parts[parts.length - 2];
                int rating = Integer.parseInt(parts[parts.length - 1]);
                CompanyRating owner = new CompanyRating(fullName.toString(), companyName, rating);
                companies.add(owner);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        Collections.sort(companies);
        Set<String> seenCompanies = new HashSet<>();
        for (CompanyRating cr : companies) {
            if (!seenCompanies.contains(cr.toString())) {
                System.out.println(cr);
                seenCompanies.add(cr.toString());
            }
        }
    }
}
