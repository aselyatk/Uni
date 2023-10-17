import java.util.Scanner;
//1) Сформировать массив из случайных чисел, в которых ровно две единицы, стоящие на случайных позициях.
public class LB1_Ex1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int n = in.nextInt();
        int arr[] = new int [n];
        for (int i=0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * n);
            while (arr[i] == 1){
                arr[i] = (int) (Math.random() * n);
            }
        }
        int a = (int) (Math.random() * n - 1);
        int b = (int) (Math.random() * n) - 1;
        arr[a] = 1;
        arr[b] = 1;

        for (int i: arr)
            System.out.print( i + " " );
    }
}
