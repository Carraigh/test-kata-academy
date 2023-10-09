

import java.util.InputMismatchException;
import java.util.Scanner;


public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static void main (String[] args) {
        System.out.println("Введите выражение [2+2] или два римских числа от I до X:[V+V] + Enter ");
//      Считываем строку userInput которую ввёл пользователь
        String userInput = scanner.nextLine();
//      Создаём пустой символьный массив длиной 10 символов:  under_char
        char[] under_char = new char[10];
//      Заполняем символьный массив символами строки которую ввел пользователь и по ходу ловим знак операции
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
            }
            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();
        number1 = romanToNumber(stable00);
        number2 = romanToNumber(string03);
        if (number1 < 0 && number2 < 0) {
            result = 0;
        } else {
            result = calculated(number1, number2, operation);
            System.out.println("---Результат для римских цифр----");
            String resultRoman = convertNumToRoman(result);
            System.out.println(stable00 + " " + operation + " " + string03 + " = " + resultRoman);
        }
        number1 = Integer.parseInt(stable00);
        number2 = Integer.parseInt(string03);
        result = calculated(number1, number2, operation);
        System.out.println("--Результат для арабских цифр----");
        System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
    }

    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }


    private static int romanToNumber (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }

    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}

/*
1. В начале кода импортируется класс Scanner из пакета java.util,
чтобы можно было считывать ввод пользователя.
2. Затем определен основной класс Main.
3. В методе main создается объект Scanner для считывания ввода пользователя.
4. Считывается строка ввода пользователя и сохраняется в переменную input.
5. Метод scanner.close() вызывается для закрытия сканнера и освобождения ресурсов.
6. В блоке try-catch вызывается метод calc(input), который выполняет вычисления.
7. Если при выполнении метода calc(input) возникает исключение,
оно перехватывается в блоке catch и выводится сообщение об ошибке.
8. Метод calc(input) разбивает входную строку на три части (число, оператор, число)
с помощью метода split(" ").
9. Если количество частей не равно 3, выбрасывается исключение с сообщением
"Некорректное выражение".
10. Затем числа преобразуются из строкового формата в целочисленный с помощью метода
parseNumber().
11. Если при преобразовании чисел возникает исключение, выбрасывается исключение
с сообщением "Некорректные числа".
12. Затем определяется оператор и выполняется соответствующая арифметическая операция.
13. Если оператор равен "/", проверяется, равно ли второе число нулю.
Если да, выбрасывается исключение с сообщением "Деление на ноль".
14. Результат вычислений преобразуется в римскую цифру с помощью метода
convertToRoman() и возвращается из метода calc().
15. Метод parseNumber() пытается преобразовать строку в целое число с помощью метода
Integer.parseInt(). Если преобразование не удалось, выбрасывается исключение
с сообщением "Некорректное число".
16. Метод convertToRoman() принимает целое число и проверяет,
что оно находится в диапазоне от 1 до 10. Если число некорректно,
выбрасывается исключение с сообщением "Некорректное число".
Затем число преобразуется в римскую цифру с помощью массива romanNumerals
и возвращается из метода.

В итоге, программа считывает строку ввода пользователя, выполняет арифметическую
операцию и выводит результат в виде римской цифры. Если возникают ошибки
при считывании ввода или выполнении операции, выводится соответствующее сообщение об ошибке.
 */