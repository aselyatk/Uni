import java.io.*;
import java.util.Random;

public class file5 {
    public static void main(String[] args) {
        // Создание файла и заполнение его случайными дробными числами
        File file = new File("numbers.txt");
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                double number = random.nextDouble() * 10;
                writer.println(number);
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }

        // Открытие файла и округление значений в нем
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                double number = Double.parseDouble(line);
                int rounded = (int) Math.floor(number);
                System.out.println(number + " -> " + rounded);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения из файла: " + e.getMessage());
        }
    }
}