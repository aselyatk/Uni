import java.util.Scanner;

public class string5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст:");
        String str = scanner.nextLine();

        String newStr = replaceKR(str);
        System.out.println(newStr);
    }

    public static String replaceKR(String str) {
        return str.replaceAll("КР", "Кыргызская Республика");
    }
}
