import java.io.*;

public class file4 {
    public static void main(String[] args) {
        try {
            // Открыть файл для дозаписи и считать с клавиатуры названия товаров
            PrintWriter plannedFile = new PrintWriter(new FileWriter("Планируется закупить.txt", true));
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Введите названия товаров через запятую: ");
            String input = keyboard.readLine();
            String[] products = input.split(","); // Разбить строку на массив товаров

            // Добавить названия товаров в файл "Планируется_закупить"
            for (String product : products) {
                plannedFile.println(product.trim()); // trim() убирает пробелы в начале и конце строки
            }

            // Закрыть файл и вывести на экран его содержимое
            plannedFile.close();
            BufferedReader plannedReader = new BufferedReader(new FileReader("Планируется_закупить.txt"));
            System.out.println("Содержимое файла Планируется_закупить.txt:");
            String line;
            while ((line = plannedReader.readLine()) != null) {
                System.out.println(line);
            }
            plannedReader.close();

        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
