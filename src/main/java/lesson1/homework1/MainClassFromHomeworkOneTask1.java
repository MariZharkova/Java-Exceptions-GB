//1. Реализуйте метод, принимающий в качестве аргументов двумерный массив.
//Метод должен проверить что длина строк и столбцов с одинаковым индексом одинакова,
// детализировать какие строки со столбцами не требуется.

package lesson1.homework1;

import java.util.Scanner;

public class MainClassFromHomeworkOneTask1 {
    public static void main(String[] args) {

        int[][] ints = new int[3][];
        ints[0] = new int[]{2, 3, 4};
        ints[1] = new int[]{2, 6, 7, 9};
        ints[2] = new int[]{5, 1, 3};
        //ints[3] = new int[]{3, 1, 0};

        try {
            isLengthEqual(ints);
        } catch (RuntimeException e) {
            e.printStackTrace();
//            System.out.println("Работа прервана.");
//            System.exit(1);
        }
        System.out.println("Работа продолжена.");
    }

    public static void isLengthEqual(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != matrix.length) {
                throw new RuntimeException("Длина не всех строк и столбцов с одинаковым индексом одинакова.");
            }
        }
    }
}
