import java.util.Scanner;

public class BBS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Random random = new Random();

        int p = 11, q = 19, x = 5;
        int M = p * q;//число Блюма,являющееся модулем для генерации псевдослучайной последовательности

        // Выводим сгенерированные значения p и q
        System.out.printf("Сгенерированы значения p=%d, q=%d%n", p, q);
        System.out.print("Введите слово для шифрования: ");
        String word = scanner.nextLine();

        int n = p * q;
        int length = word.length();

        // Создаем массив gamma для хранения битов ключа
        int[] gamma = new int[length];
        System.out.print("Ключ: ");
        for (int i = 0; i < length; i++) {
            // Генерируем псевдослучайное число методом Блюма
            x = (x * x) % n;
            gamma[i] = x % 2;
            // Выводим очередной бит ключа на экран
            System.out.print(gamma[i]);
        }
        System.out.println();

        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int c = (int) word.charAt(i);
            int cBinary = Integer.parseInt(Integer.toBinaryString(c));
            int gBinary = gamma[i % length];
            int e = cBinary ^ gBinary;
            // Выводим процесс операции XOR
            System.out.printf("%d XOR %d = %d\n", cBinary, gBinary, e);
            char encryptedChar = (char) Integer.parseInt(String.valueOf(e), 2);
            encrypted.append(encryptedChar);
        }
        System.out.println("Зашифрованное слово: " + encrypted.toString());

        scanner.close();
    }
}