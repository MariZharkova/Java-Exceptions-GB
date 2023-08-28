//1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
// вместо этого, необходимо повторно запросить у пользователя ввод данных.

package lesson2.homework2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClassFromHomeworkTwoTask1 {
    public static void main(String[] args) {
        inputFloatAndPrint();

    }

    public static void inputFloatAndPrint() {
        float number = 0.0f;
        boolean entered = false;
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите дробное число: ");
            try {
                number = in.nextFloat();
                entered = true;
            } catch (InputMismatchException e) {
                System.out.println("Неверный формат числа.");
            }
        } while (!entered);

        System.out.printf("Введенное число: %f.", number);
    }
}
