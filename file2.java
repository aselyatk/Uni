import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class file2 {
    public static void main(String[] args) {
        try {
            // Открытие файлов и создание объектов для чтения и записи
            BufferedReader productsFile = new BufferedReader(new FileReader("Товары.txt"));
            PrintWriter overdueFile = new PrintWriter(new FileWriter("Просрочка.txt"));
            PrintWriter updatedProductsFile = new PrintWriter(new FileWriter("Обновленные_товары.txt"));

            String line;
            while ((line = productsFile.readLine()) != null) {
                String[] data = line.split(";");

                // Проверяем, истек ли срок годности товара
                LocalDate date = LocalDate.parse(data[3], DateTimeFormatter.ISO_LOCAL_DATE);
                int shelfLife = Integer.parseInt(data[4]);
                if (date.plusDays(shelfLife).isBefore(LocalDate.now())) {
                    // Если срок годности истек, записываем строку в файл "Просрочка" и меняем значение отметки о наличии товара на складе на false
                    updatedProductsFile.println(data[0] + ";" + data[1] + ";" + data[2] + ";" + data[3] + ";" +
                            data[4] + ";" + data[5] + ";false");
                    overdueFile.println(line);
                } else {
                    // Если срок годности не истек, записываем строку в файл "Обновленные_товары" без изменений
                    updatedProductsFile.println(line);
                }
            }

            // Закрытие файлов и объектов для чтения и записи
            productsFile.close();
            overdueFile.close();
            updatedProductsFile.close();

            System.out.println("Информация о просроченных товарах успешно записана в файл 'Просрочка'!");

        } catch (IOException e) {
            System.out.println("Ошибка чтения/записи в файл: " + e.getMessage());
        }
    }
}
