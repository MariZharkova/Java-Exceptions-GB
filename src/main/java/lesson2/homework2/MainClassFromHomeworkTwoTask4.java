//Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

package lesson2.homework2;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainClassFromHomeworkTwoTask4 {
    public static void main(String[] args) {
        inputAndPrint();

    }

    public static void inputAndPrint() {

        String input = null;
        boolean entered = false;
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите строку: ");
            try {
                input = in.nextLine();
                entered = !input.isEmpty();
                if (input.isEmpty()){
                    throw new NoSuchElementException("No any character.");
                };
            } catch (NoSuchElementException e) {
                System.out.println("Нельзя вводить пустые строки.");
            }
        } while (!entered);

        System.out.printf("Введенная строка: %s", input);
    }
}
