# test-kata-academy
///
Этот код представляет собой простой калькулятор, который принимает входные данные от пользователя, выполняет арифметическую операцию и выводит результат.

1. В начале кода импортируется класс Scanner из пакета java.util, чтобы можно было считывать ввод пользователя.
2. Затем определен основной класс Main.
3. В методе main создается объект Scanner для считывания ввода пользователя.
4. Считывается строка ввода пользователя и сохраняется в переменную input.
5. Метод scanner.close() вызывается для закрытия сканнера и освобождения ресурсов.
6. В блоке try-catch вызывается метод calc(input), который выполняет вычисления.
7. Если при выполнении метода calc(input) возникает исключение, оно перехватывается в блоке catch и выводится сообщение об ошибке.
8. Метод calc(input) разбивает входную строку на три части (число, оператор, число) с помощью метода split(" ").
9. Если количество частей не равно 3, выбрасывается исключение с сообщением "Некорректное выражение".
10. Затем числа преобразуются из строкового формата в целочисленный с помощью метода parseNumber().
11. Если при преобразовании чисел возникает исключение, выбрасывается исключение с сообщением "Некорректные числа".
12. Затем определяется оператор и выполняется соответствующая арифметическая операция.
13. Если оператор равен "/", проверяется, равно ли второе число нулю. Если да, выбрасывается исключение с сообщением "Деление на ноль".
14. Результат вычислений преобразуется в римскую цифру с помощью метода convertToRoman() и возвращается из метода calc().
15. Метод parseNumber() пытается преобразовать строку в целое число с помощью метода Integer.parseInt(). Если преобразование не удалось, выбрасывается исключение с сообщением "Некорректное число".
16. Метод convertToRoman() принимает целое число и проверяет, что оно находится в диапазоне от 1 до 10. Если число некорректно, выбрасывается исключение с сообщением "Некорректное число". Затем число преобразуется в римскую цифру с помощью массива romanNumerals и возвращается из метода.

В итоге, программа считывает строку ввода пользователя, выполняет арифметическую операцию и выводит результат в виде римской цифры. Если возникают ошибки при считывании ввода или выполнении операции, выводится соответствующее сообщение об ошибке.
///
