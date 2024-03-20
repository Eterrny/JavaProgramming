package ru.sgu;

public class CompanyRating implements Comparable<CompanyRating> {
    String fullName;
    String companyName;
    int rating;

    public CompanyRating(String fullName, String companyName, int rating) {
        this.fullName = fullName;
        this.companyName = companyName;
        this.rating = rating;
    }

    @Override
    public int compareTo(CompanyRating other) {
        if (this.rating != other.rating) {
            return Integer.compare(other.rating, this.rating);
        } else {
            String[] nameParts = this.fullName.split(" ");
            String[] otherNameParts = other.fullName.split(" ");
            int lastNameComparison = nameParts[0].compareTo(otherNameParts[0]);
            if (lastNameComparison != 0 || nameParts.length < 2) {
                return lastNameComparison;
            }
            int firstNameComparison = otherNameParts[1].compareTo(nameParts[1]);
            if (firstNameComparison != 0 || nameParts.length < 3) {
                return firstNameComparison;
            }
            return nameParts[2].compareTo(otherNameParts[2]);
        }
    }

    @Override
    public String toString() {
        return fullName + " " + companyName + " " + rating;
    }
}