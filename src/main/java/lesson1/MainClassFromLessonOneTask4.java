//Задание 4
//Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив.
//Метод должен пройтись по каждому элементу и проверить что он не равен null.
//А теперь реализуйте следующую логику:
//Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом пользователя
//Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”

package lesson1;

public class MainClassFromLessonOneTask4 {
    public class Task4 {
        public static void main(String[] args) {

            Integer[] ints = {1, null, 3, 4, null, 6, 7, 8, 9};

            checkArray(ints);
        }

        public static void checkArray(Integer[] arr) {
            for (int i = 0; i < arr.length; i++) {
                try {
                    if (arr[i] == null) {
                        throw new RuntimeException("Встретили null по адресу " + i + ".");
                    }
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
