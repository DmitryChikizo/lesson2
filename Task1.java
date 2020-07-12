package homework.lesson2;
/*
* Имеются три числа - день, месяц и год, вводимые пользователем с
консоли.
    Вывести дату следующего дня в формате "День.Месяц.Год".
    Учесть переход на следующий месяц, а также следующий год.
    Форматирование строки "День.Месяц.Год" вынести в отдельную
функцию.
* */
// 31     - 1 3 5 7 8 10 12
// 30     - 4 6 9 11
// 28(29) - 2

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите день:");
        int day = scanner.nextInt();
        System.out.println("Введите месяц:");
        int month = scanner.nextInt();
        System.out.println("Введите год:");
        int year = scanner.nextInt();

        datePlusOneDay(day, month, year);
    }

    public static void datePlusOneDay(int day, int month, int year) {
        if (isCorrectDate(day, month, year)) {
            System.out.println("Дата введена не корретно");
        } else if (isTheEndOfYear(day, month)) {
            year++;
            System.out.println("1.1." + year);
        } else if (isTheEndOfMonth(day, month, year)) {
            month++;
            System.out.println("1." + month + "." + year);
        } else {
            day++;
            System.out.println(day + "." + month + "." + year);
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    public static boolean isTheEndOfYear(int day, int month) {
        return (day == 31) && (month == 12);
    }

    public static boolean isTheEndOfMonth(int day, int month, int year) {
        return ((day == 31) && ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10)))
                ||
                (day == 30) && ((month == 4) || (month == 6) || (month == 9) || (month == 11))
                ||
                (day == 29) && ((month == 2) && isLeapYear(year))
                ||
                (day == 28) && ((month == 2) && !isLeapYear(year));
    }

    public static boolean isCorrectDate(int day, int month, int year) {
        return (day > 31
                || (month > 12 && !isTheEndOfMonth(day, month, year))
                || (month == 2 && !isTheEndOfMonth(day, month, year)));
    }
}
