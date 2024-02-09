import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

class WrongCommandException extends Exception {
    public WrongCommandException(String s) {
        super(s);
    }
}

public class Task1B {
    private static class Command {
        private String command;
        private BigInteger aInt, bInt, resInt;
        private BigDecimal aDec, bDec, resDec;

        public Command(String command) {
            try {
                String[] splitCommand = command.split(" ");
                if (splitCommand.length < 3) {
                    throw new WrongCommandException("Передана некорректная вводная строка.");
                }
                this.aDec = new BigDecimal(splitCommand[0]);
                this.bDec = new BigDecimal(splitCommand[1]);
                this.command = splitCommand[2];
                this.aInt = new BigInteger(splitCommand[0]);
                this.bInt = new BigInteger(splitCommand[1]);
            } catch (PatternSyntaxException e) {
                System.out.println("Ошибка в разделении строки.");
                return;
            } catch (WrongCommandException e) {
                System.out.println(e.getMessage());
                return;
            } catch (NumberFormatException e) {
                if (aDec == null || bDec == null) {
                    System.out.println("Ошибка в чтении числовых параметров.");
                    return;
                }
            }
            this.execute();
        }

        @Override
        public String toString() {
            String res = "";
            if (resInt != null) {
                res += String.format("""
                        BigInteger:
                            %d %s %d = %d
                            """, aInt, command, bInt, resInt);
            }
            if (resDec != null) {
                res += String.format("""
                        BigDecimal:
                            %s %s %s = %s
                            """, aDec, command, bDec, resDec);
            }
            return res;
        }

        private void execute() {
            try {
                switch (command) {
                    case "ADD" -> {
                        resInt = (aInt != null && bInt != null) ? aInt.add(bInt) : null;
                        resDec = aDec.add(bDec);
                    }
                    case "SUB" -> {
                        resInt = (aInt != null && bInt != null) ? aInt.subtract(bInt) : null;
                        resDec = aDec.subtract(bDec);
                    }
                    case "MULT" -> {
                        resInt = (aInt != null && bInt != null) ? aInt.multiply(bInt) : null;
                        resDec = aDec.multiply(bDec);
                    }
                    case "DIV" -> {
                        resInt = (aInt != null && bInt != null) ? aInt.divide(bInt) : null;
                        resDec = aDec.divide(bDec);
                    }
                    case "REM" -> {
                        resInt = (aInt != null && bInt != null) ? aInt.remainder(bInt) : null;
                        resDec = aDec.remainder(bDec);
                    }
                    case "POW" -> {
                        resInt = (aInt != null && bInt != null) ? aInt.pow(bInt.intValueExact()) : null;
                        resDec = aDec.pow(bDec.intValueExact());
                    }
                    default ->
                            throw new WrongCommandException("Вычислить значение невозможно. Передана некорректная команда.");
                }
            } catch (NullPointerException | ArithmeticException | WrongCommandException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = null;
        BigInteger b = null;
        BigDecimal a1, b1;
        System.out.println("Допустимые команды: ADD, SUB, MULT, DIV, REM, POW");
        System.out.println("Введите 2 целых числа и команду через пробел (например, 1 2 ADD):");
        System.out.println(new Command(sc.nextLine()));
        sc.close();
    }
}