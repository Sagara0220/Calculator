public class Logic {
    public static void logic(String firstString, String arithmetic, String secondString) {
        int first = 0;
        int second = 0;
        int result = 0;

        boolean flag = false;
        try {
            first = Integer.parseInt(firstString);
            second = Integer.parseInt(secondString);
        } catch (Exception e) {
            try {
                first = Convert.toArabic(firstString);
                second = Convert.toArabic(secondString);
                flag = true;
            } catch (Exception el) {
                System.out.println("Введены неверные данные");
            }
        }
        if (first < 1 || first > 10 || second < 1 || second > 10) {
            System.out.println("Введены неверные данные");
            System.exit(0);
        }
        if (arithmetic.equals("+")) {
            result = Arithmetic.addition(first, second);
        }
        if (arithmetic.equals("/")) {
            result = Arithmetic.division(first, second);
        }
        if (arithmetic.equals("*")) {
            result = Arithmetic.multiplication(first, second);
        }
        if (arithmetic.equals("-")) {
            result = Arithmetic.substraction(first, second);
        }
        if (flag) {
            String roman = Convert
                    .toRoman(result);
            System.out.println(roman);
        } else {
            System.out.println(result);
        }
    }
}