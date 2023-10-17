import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class zadaca5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(21) - 10;
        }

        System.out.println("Исходный массив: " + Arrays.toString(array));

        int[] sorted = new int[array.length];


        int negativeIndex = 0;
        int zeroIndex = 0;
        int positiveIndex = sorted.length - 1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                sorted[negativeIndex] = array[i];
                negativeIndex++;
            } else if (array[i] == 0) {
                sorted[positiveIndex - zeroIndex] = array[i];
                zeroIndex++;
            } else {
                sorted[positiveIndex] = array[i];
                positiveIndex--;
            }
        }

        System.out.println("Отсортированный массив: " + Arrays.toString(sorted));
    }
}
