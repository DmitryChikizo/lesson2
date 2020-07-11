package homework;
/*
Написать программу, вычисляющую корни квадратного уравнения
вида ax ² + bx + c = 0, где a, b и c - вводимые пользователем из консоли
данные.
    Учитывать только реальные корни (в случае отрицательного
дискриминанта выводить сообщение пользователю).
    При решении создать и использовать следующие вынесенные
функции:
    - функция isPositive, определяющая, является ли число
положительным
    - функция isZero, определяющая, является ли число нулём
    - функция discriminant, вычисляющая дискриминант
* */

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите a");
        int a = scanner.nextInt();
        System.out.println("Введите b");
        int b = scanner.nextInt();
        System.out.println("Введите c");
        int c = scanner.nextInt();
        int D = discriminant(a, b, c);

        if (isPositive(D)) {
            double x1 = (-b + Math.sqrt(D)) / (2 * a);
            double x2 = (-b - Math.sqrt(D)) / (2 * a);
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else if (isZero(D)) {
            double x = (double) (-b) / (2 * a);
            System.out.println("x = " + x);
        } else {
            System.out.println("Нет корней");
        }
    }

    public static boolean isPositive(int discriminant) {
        return discriminant > 0;
    }

    public static boolean isZero(int discriminant) {
        return discriminant == 0;
    }

    public static int discriminant(int a, int b, int c) {
        return b * b - (4 * a * c);
    }
}
