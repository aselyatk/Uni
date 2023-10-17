import java.util.Scanner;

public class string2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String input = scanner.nextLine();

        int count = 0;
        int[] vowelsCount = new int[5];
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        for (int i = 0; i < input.length(); i++) {
            char c = Character.toLowerCase(input.charAt(i));
            if (isVowel(c)) {
                count++;
                for (int j = 0; j < vowels.length; j++) {
                    if (c == vowels[j]) {
                        vowelsCount[j]++;
                    }
                }
            }
        }

        System.out.println("Количество гласных: " + count);
        for (int i = 0; i < vowels.length; i++) {
            System.out.println("Частота повторяемости гласной '" + vowels[i] + "': " + vowelsCount[i]);
        }
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
