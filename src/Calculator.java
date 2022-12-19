package Calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        CalculatorHelper calculatorHelper = new CalculatorHelper();
        System.out.println("Input:");
        Scanner myObj = new Scanner(System.in);
        String input = myObj.nextLine();
        System.out.println(calculatorHelper.calc(input));
    }
}

class CalculatorHelper {
    public Integer calc(String input) throws Exception {
        String[] splitText = input.split(" ");
        if (splitText.length > 3) {
            throw new Exception("throws Exception");
        }
        int letter1, letter2;

        int countLetters = 0;

        for (int i = 0; i < 3; i += 2) {
            try {
                Integer.parseInt(splitText[i]);
            } catch (NumberFormatException e) {
                countLetters++;
            }
        }

        if (countLetters == 1) {
            throw new Exception("throws Exception");
        }

        letter1 = Integer.parseInt(splitText[0]);
        letter2 = Integer.parseInt(splitText[2]);
        int result = getResult(letter1, letter2, splitText[1]);

        if (letter1 < 1 || letter1 > 10 || letter2 < 1 || letter2 > 10 || letter1 % 1 != 0 || letter2 % 1 != 0) {
            throw new Exception("throws Exception");
        }


        return result;

    }

    public Integer getResult(int letter1, int letter2, String s) throws Exception {
        int result = 0;
        switch (s) {
            case "/":
                result = letter1 / letter2;
                break;
            case "+":
                result = letter1 + letter2;
                break;
            case "-":
                result = letter1 - letter2;
                break;
            case "*":
                result = letter1 * letter2;
                break;
            default:
                throw new Exception("throws Exception");
        }

        return result;
    }
}