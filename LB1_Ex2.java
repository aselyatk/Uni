import java.util.Arrays;
import java.util.Random;

public class LB1_Ex2 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[20];
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        do {
            count1 = 0;
            count2 = 0;
            count3 = 0;

            for (int i = 0; i < array.length; i++) {
                int randomNumber = random.nextInt(10);
                array[i] = randomNumber;

                if (randomNumber == 1) {
                    count1++;
                } else if (randomNumber == 2) {
                    count2++;
                } else if (randomNumber == 3) {
                    count3++;
                }
            }

            while (count3 > count2 + 1) {
                int index = random.nextInt(array.length);
                if (array[index] == 3) {
                    array[index] = 2;
                    count3--;
                    count2++;
                }
            }

        } while (count1 < 3 || count1 > 5 || count2 <= count3);

        System.out.println(Arrays.toString(array));
    }
}