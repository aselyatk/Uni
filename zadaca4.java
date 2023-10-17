import java.util.*;

public class zadaca4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        double[] arr = new double[size];

        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            double num = rand.nextDouble() * 20 - 10; // случайное вещественное число от -10 до 10
            arr[i] = Math.round(num * 10) / 10.0; // округляем до одной десятичной цифры
        }
        System.out.print("Массив: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]+"   ");
        }
        System.out.println();

        int firstNegIndex = -1; // индекс первого отрицательного числа
        int secondNegIndex = -1; // индекс второго отрицательного числа
        double minBetweenNeg = Double.MAX_VALUE; // минимальный элемент между первым и вторым отрицательными числами
        double sumBetweenNeg = 0; // сумма всех элементов между первым и вторым отрицательными числами
        boolean foundFirstNeg = false; // флаг, что первое отрицательное число найдено

        for (int i = 0; i < size; i++) {
            if (arr[i] < 0) {
                if (!foundFirstNeg) {
                    firstNegIndex = i;
                    foundFirstNeg = true;
                } else {
                    secondNegIndex = i;
                    break;
                }
            }
        }

        if (firstNegIndex == -1 || secondNegIndex == -1) {
            System.out.println("В массиве меньше двух отрицательных чисел.");
        } else {
            if (firstNegIndex == secondNegIndex - 1) {
                System.out.println("Между первым и вторым отрицательными числами всего один элемент: " + arr[firstNegIndex + 1]);
            } else {
                for (int i = firstNegIndex + 1; i < secondNegIndex; i++) {
                    sumBetweenNeg += arr[i];
                    if (arr[i] < minBetweenNeg) {
                        minBetweenNeg = arr[i];
                    }
                }
                int minIndex = firstNegIndex + 1;
                for (int i = firstNegIndex + 1; i < secondNegIndex; i++) {
                    if (arr[i] == minBetweenNeg) {
                        minIndex = i;
                        break;
                    }
                }
                System.out.println("Номер минимального элемента: " + minIndex);
                System.out.println("Сумма всех элементов между первым и вторым отрицательными числами: " + sumBetweenNeg);
            }
        }
    }
}
