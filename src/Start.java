import java.io.IOException;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) throws IOException {

        System.out.println("Введите выражение. Аргументы и знак должны быть разделены пробелом");
        System.out.println("Программа принимает арабские и римские числа");
        System.out.println("Числа от 0 до 10 включительно и от I до X включительно");

        try (Scanner sc = new Scanner(System.in)) {
            String result = new Calculator().calculate(sc.nextLine().trim().split(" "));
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Введены неверные данные");
        }

    }

}

class Calculator {

    private final Convert converter;

    public Calculator() {
        this.converter = new Convert();
    }

    public String calculate(String [] args) {
        if (args.length!=3) throw new IllegalArgumentException();
        try {
            int result = calculate(Integer.parseInt(args[0]), Integer.parseInt(args[2]), args[1]);
            return String.valueOf(result);
        } catch (NumberFormatException e) {
            int result = calculate (converter.toArabic(args[0]), converter.toArabic(args[2]), args[1]);
            return converter.toRoman(result);
        }
    }

    private int calculate(int first, int second, String arithmetic) {
        if (first < 1 || first > 10 || second < 1 || second > 10) throw new IllegalArgumentException();
        switch (arithmetic) {
            case "+": return first + second;
            case "/": return first / second;
            case "*": return first * second;
            case "-": return first - second;
            default: throw new IllegalArgumentException();
        }
    }

}