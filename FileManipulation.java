import java.io.*;
import java.util.*;

public class FileManipulation {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название каталога: ");
        String directoryName = scanner.nextLine();

        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }

        System.out.print("Введите название файла: ");
        String fileName = scanner.nextLine();

        File file = new File(directory, fileName);
        if (!file.exists()) {
            file.createNewFile();
        }

        System.out.print("Введите текст для записи в файл: ");
        String text = scanner.nextLine();

        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println(text);
        }

        Map<String, Integer> wordCounts = new HashMap<>();
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                String word = fileScanner.next();
                Integer count = wordCounts.get(word);
                wordCounts.put(word, count != null ? count + 1 : 1);
            }
        }

        int maxCount = 0;
        String wordWithMaxCount = "";
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            if (count > maxCount) {
                maxCount = count;
                wordWithMaxCount = word;
            }
        }

        System.out.println("Наибольшее количество повторений: " + maxCount);

        System.out.print("Желаете изменить слово? (Да/Нет): ");
        String answer = scanner.nextLine().toLowerCase();

        if (answer.equals("да")) {
            System.out.print("Введите слово для замены: ");
            String oldWord = scanner.nextLine();
            System.out.print("Введите новое слово: ");
            String newWord = scanner.nextLine();

            String oldText = "";
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    oldText += fileScanner.nextLine() + "\n";
                }
            }

            String newText = oldText.replaceAll(oldWord, newWord);
            newText = "Внесены изменения\n" + newText;

            try (PrintWriter writer = new PrintWriter(file)) {
                writer.print(newText);
            }
        } else {
            String oldText = "";
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    oldText += fileScanner.nextLine() + "\n";
                }
            }

            String newText = oldText.replaceAll(wordWithMaxCount, wordWithMaxCount.toUpperCase());

            try (PrintWriter writer = new PrintWriter(file)) {
                writer.print("Внесены изменения\n" + newText);
            }
        }
    }
}
