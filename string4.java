import java.util.Scanner;

public class string4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку:");
        String str = scanner.nextLine();

        String upperCaseStr = str.toUpperCase();
        String lowerCaseStr = str.toLowerCase();

        System.out.println("Строка в верхнем регистре: " + upperCaseStr);
        System.out.println("Строка в нижнем регистре: " + lowerCaseStr);
    }
}
