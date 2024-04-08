import java.io.*;
import java.time.*;

public class Main {

    /**
     * main запрашивает Имя, Фамилию, Отчество и дату рождения
     * выводит Фамилию, Инициалы, пол и количество полных лет
     */
    public static void main(String[] args) {

        /*
         * Получение текущего года, месяца и дня
         */
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();

        Reader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(inputStreamReader);

        /*
         * Получение Имени от пользователя
         */
        System.out.print("Введите Имя: ");
        String name;
        try {
            name = buf.readLine();
        } catch (IOException Ex1) {
            System.out.print("Ошибка ввода Имени\n");
            return;
        }

        /*
         * Получение Фамилии от пользователя
         */
        System.out.print("Введите Фамилию: ");
        String surname;
        try {
            surname = buf.readLine();
        } catch (IOException Ex1) {
            System.out.print("Ошибка ввода Фамилии\n");
            return;
        }

        /*
         * Получение Отчества от пользователя
         */
        System.out.print("Введите Отчество: ");
        String patronymic;
        try {
            patronymic = buf.readLine();
        } catch (IOException Ex1) {
            System.out.print("Ошибка ввода Отчества\n");
            return;
        }

        /*
         * Получение даты рождения от пользователя
         */
        System.out.print("Введите дату рождения (в формате dd-mm-yyyy): ");
        String date;
        try {
            date = buf.readLine();
        } catch (IOException Ex1) {
            System.out.print("Ошибка ввода даты\n");
            return;
        }

        /*
         * Проверка на правильный формат введенных данных
         */
        if (name.isEmpty() || surname.isEmpty() || patronymic.isEmpty()) {
            System.out.print("Ошибка ввода данных\n");
            return;
        }
        if ((date.length() != 10) || (date.charAt(2) != '-') || (date.charAt(5) != '-')) {
            System.out.print("Ошибка ввода даты\n");
            return;
        }

        /*
         * Обработка полученной даты рождения, разбиение на день, месяц, год
         */
        int b_day = Integer.parseInt(date.substring(0, 2));
        int b_month = Integer.parseInt(date.substring(3, 5));
        int b_year = Integer.parseInt(date.substring(6, 10));

        /*
         * Вывод Фамилии и инициалов
         */
        System.out.print(surname.toUpperCase().charAt(0)+surname.substring(1) + " "+
                name.toUpperCase().charAt(0) +". "+ patronymic.toUpperCase().charAt(0)+".\n");

        /*
         * Определение и вывод пола
         */
        if (patronymic.charAt(patronymic.length()-1) == 'а') {
            System.out.print("Пол: женский\n");
        }
        else System.out.print("Пол: мужской\n");

        /*
         * Подсчёт и вывод полных лет
         */
        if (b_year > year) {
            System.out.print("Полных лет: 0");
            return;
        }
        if ((b_day <= day)&&(b_month <= month)) {
            System.out.print("Полных лет: " + (year - b_year));
        }
        else System.out.print("Полных лет: " + (year - b_year-1));
    }
}