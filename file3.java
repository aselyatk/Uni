import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class file3 {
    public static void main(String[] args) {
        String notAvailableFileName = "Отсутствуют.txt";
        String plannedFileName = "Планируется закупить.txt";

        try {
            // Чтение из файла "Отсутствуют"
            BufferedReader reader = new BufferedReader(new FileReader(notAvailableFileName));

            // Создание файла "Планируется закупить" и объекта для записи в файл
            PrintWriter writer = new PrintWriter(new FileWriter(plannedFileName));

            // Чтение и запись строк из файла "Отсутствуют"
            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }

            // Закрытие файлов и объектов для записи в файлы
            reader.close();
            writer.close();

            System.out.println("Значения из файла \"Отсутствуют\" успешно скопированы в файл \"Планируется закупить\"!");

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
