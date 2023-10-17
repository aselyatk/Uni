import java.util.Scanner;

public class string3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String str = scanner.nextLine();
        System.out.print("Введите количество символов для извлечения: ");
        int n = scanner.nextInt();
        if (n > str.length()) {
            System.out.println("Ошибка: количество символов превышает длину строки");
        } else {
            String lastNChars = str.substring(str.length() - n);
            System.out.println("Последние " + n + " символов строки: " + lastNChars);
        }
    }
}
