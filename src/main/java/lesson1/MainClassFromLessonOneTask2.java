//Задание 2
// Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
//Необходимо посчитать и вернуть сумму элементов этого массива.
//При этом накладываем на метод 2 ограничения: метод может работать только с квадратными массивами
// (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1.
//Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.

//Задание 3
//Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
//Необходимо посчитать и вернуть сумму элементов этого массива.
//При этом накладываем на метод 2 ограничения: метод может работать только с квадратными массивами
//(кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1.
//Если нарушается одно из условий, метод должен вернуть код ошибки.
//Программа должна корректно обработать код ошибки и вывести соответствующее сообщение пользователю.

package lesson1;

public class MainClassFromLessonOneTask2 {

        public static void main(String[] args) {

            int[][] ints = new int[3][];
            ints[0] = new int[]{0, 1, 0};
            ints[1] = new int[]{1, 2, 1};
            ints[2] = new int[]{0, 1, 0};

//        System.out.println(ints.length);
            try {
                System.out.println(matrixCount2(ints));
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            System.out.println("Работа продолжена.");
        }

        public static int matrixCount(int[][] matrix) {
            int result = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i].length != matrix.length) {
                    throw new RuntimeException("Массив не квадратный.");
                }
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] != 0 && matrix[i][j] != 1) {
                        throw new RuntimeException("Значения отличаются от 0 и 1.");
                    }
                    result += matrix[i][j];
                }
            }
            return result;
        }


        public static int matrixCount2(int[][] matrix) {
            int result = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i].length != matrix.length) {
                    throw new RuntimeException("Массив не квадратный.");
                }
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] != 0 && matrix[i][j] != 1) {
                        throw new RuntimeException("Значения отличаются от 0 и 1.");
                    }
                    result += matrix[i][j];
                }
            }
            return result;
        }

    }

