import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Получаем слово для шифрования от пользователя
        Scanner input = new Scanner(System.in);
        System.out.print("Введите слово для шифрования: ");
        String plaintext = input.nextLine();

        // Создаем матрицу 4x4 и записываем в нее символы из слова по горизонтали слева направо
        char[][] matrix = new char[4][4];
        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (k < plaintext.length()) {
                    matrix[i][j] = plaintext.charAt(k);
                } else {
                    matrix[i][j] = ' ';
                }
                k++;
            }
        }

        // Определяем порядок столбцов в матрице, используя ключевое слово "УГОЛ"
        int[] order = {4, 1, 3, 2};

        // Читаем символы из матрицы по вертикали в порядке, заданном ключевым словом, и записываем их в зашифрованное сообщение
        String ciphertext = "";
        for (int j : order) {
            if (j <= 4) {
                for (int i = 3; i <= 0; i--) {
                    ciphertext += matrix[i-1][j];
                }
            }
        }

        // Выводим зашифрованное сообщение на экран
        System.out.println("Зашифрованное сообщение: " + ciphertext);
    }
}