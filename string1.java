import java.util.Scanner;

public class string1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean exit = false;

        while (!exit) {
            System.out.print("Введите строку: ");
            input = scanner.nextLine();

            if (input.equals("Exit")) {
                exit = true;
                System.out.println("Выход из игры...");
            } else {
                System.out.println("Вы ввели: " + input);
            }
        }

        scanner.close();
    }
}
