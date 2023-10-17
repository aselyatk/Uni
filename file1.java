import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class file1 {
    public static void main(String[] args) {
        try {
            // Создание файлов и объектов для записи в файлы
            PrintWriter productsFile = new PrintWriter(new FileWriter("Товары.txt"));
            PrintWriter notAvailableFile = new PrintWriter(new FileWriter("Отсутствуют.txt"));
            // Запрос на ввод количества товаров
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите количество товаров: ");
            int n = scanner.nextInt();
            scanner.nextLine(); // Считываем перевод строки

            // Заполнение информации о товарах и запись в файлы
            for (int i = 1; i <= n; i++) {
                System.out.println("Введите информацию о товаре " + i + ":");
                System.out.print("Название товара: ");
                String name = scanner.nextLine();
                System.out.print("Категория товара: ");
                String category = scanner.nextLine();
                System.out.print("Единица измерения: ");
                String unit = scanner.nextLine();
                System.out.print("Дата изготовления (в формате дд.мм.гггг): ");
                String dateStr = scanner.nextLine();
                LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                System.out.print("Срок годности (в днях): ");
                int shelfLife = scanner.nextInt();
                scanner.nextLine(); // Считываем перевод строки
                System.out.print("Номер партии: ");
                int batchNumber = scanner.nextInt();
                scanner.nextLine(); // Считываем перевод строки
                System.out.print("Наличие на складе (true/false): ");
                boolean available = scanner.nextBoolean();
                scanner.nextLine(); // Считываем перевод строки
                System.out.println();

                // Запись в файл "Товары"
                productsFile.println(name + ";" + category + ";" + unit + ";" + date + ";" +
                        shelfLife + ";" + batchNumber + ";" + available);

                // Запись в файл "Отсутствуют", если товара нет на складе
                if (!available) {
                    notAvailableFile.println(name);
                }
            }

            // Закрытие файлов и объектов для записи в файлы
            productsFile.close();
            notAvailableFile.close();

            System.out.println("Информация о товарах успешно записана в файлы!");

        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
