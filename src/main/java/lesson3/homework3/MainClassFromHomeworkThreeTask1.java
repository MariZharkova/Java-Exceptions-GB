//Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
// разделенные пробелом:
// Фамилия Имя Отчество дата рождения номер телефона пол
// Форматы данных:
// фамилия, имя, отчество - строки
// датарождения - строка формата dd.mm.yyyy
// номертелефона - целое беззнаковое число без форматирования
// пол - символ латиницей f или m.
// Приложение должно проверить введенные данные по количеству.
// Если количество не совпадает с требуемым, вернуть код ошибки,
// обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
// Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
// Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
// Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
// пользователю выведено сообщение с информацией, что именно неверно.
// Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
// в него в одну строку должны записаться полученные данные, вида
//<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
//
//Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
//Не забудьте закрыть соединение с файлом.
//
// При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
// пользователь должен увидеть стектрейс ошибки.

package lesson3.homework3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;

class DataItem {
    String name;
    String surname;
    String patronymic;
    String date;
    Long phone;
    Character sex;
};

public class MainClassFromHomeworkThreeTask1 {
    public static void main(String[] args) {
        try {
            DataItem dataItem = inputVerificationProcessingData();
            writeToFile(dataItem);
        }catch (RuntimeException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static DataItem inputVerificationProcessingData() throws RuntimeException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите, пожалуйста, данные:");
        String data = in.nextLine();
        String[] items = data.split("\\s+");
        if (items.length != 6) {
            throw new RuntimeException("Вы ввели неверное количество данных");
        }
        DataItem dataItem = new DataItem();
        dataItem.surname = items[0];
        dataItem.name = items[1];
        dataItem.patronymic = items[2];
        if (!items[3].matches("^(0[1-9]|[12][0-9]|3[01])[.](0[1-9]|1[012])[.](19|20)[0-9]{2}$")) {
            throw new RuntimeException("Неверный формат даты рождения");
        }
        dataItem.date = items[3];
        Long number = 0L;
        try {
            number = Long.valueOf(items[4]);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException("Неверный формат номера телефона");
        }
        if (number < 0) {
            throw new IllegalArgumentException("Неверный формат номера телефона");
        }
        dataItem.phone = number;

        if (items[5].length() != 1) {
            throw new IllegalArgumentException("Неверный формат обозначения пола");
        }

        if (items[5].charAt(0) != 'f' && items[5].charAt(0) != 'm') {
            throw new IllegalArgumentException("Неверный формат обозначения пола");
        }

        dataItem.sex = items[5].charAt(0);
        return dataItem;
    }

    private static void writeToFile(DataItem dataItem) {
        StringBuilder fileContent = new StringBuilder();
        fileContent
                .append(dataItem.surname).append(" ")
                .append(dataItem.name).append(" ")
                .append(dataItem.surname).append(" ")
                .append(dataItem.date).append(" ")
                .append(dataItem.phone).append(" ")
                .append(dataItem.sex).append('\n');
        try {
            FileWriter fw = new FileWriter("src/main/resources/files/" + dataItem.surname + ".txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(fileContent.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
//            System.exit(1);
        }
    }
}
