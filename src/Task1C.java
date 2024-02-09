import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task1C {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String nextLine = reader.readLine();
            while (nextLine != null) {
                String[] fullName = nextLine.split(" ", 4);
                nextLine = reader.readLine();
                if (fullName.length < 3) {
                    continue;
                }
                validateAndPrint:
                {
                    for (int i = 0; i < 3; ++i) {
                        if (!validate(fullName[i])) {
                            System.out.println("Некорректная фамилия, имя или отчество: " + fullName[i]);
                            break validateAndPrint;
                        }
                    }
                    System.out.printf("%s %s %s -> %s %s. %s.\n",
                            fullName[0], fullName[1], fullName[2], fullName[1], fullName[0].charAt(0), fullName[2].charAt(0));
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка в чтении файла.\n" + e.getMessage());
        }
    }

    public static boolean validate(String name) {
        return name.matches("^\\p{L}*$");
    }
}
