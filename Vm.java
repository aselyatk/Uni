import java.util.Scanner;

public class Vm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] x0 = new double[10];
        double[] fx = new double[2];
        double[] fx1 = new double[2];
        double[] fx2 = new double[2];
        double[] x = new double[2];
        double[] fx0 = new double[10];
        double[] fx01 = new double[10];
        double[] x1 = new double[10];

        System.out.println("Введите a");
        double a = scanner.nextDouble();
        System.out.println("Введите b");
        double b = scanner.nextDouble();
        System.out.println("Введите e");
        double e = scanner.nextDouble();
        x[0] = a;
        x[1] = b;
        fx[0] = Math.pow(a, 4) + 3 * Math.pow(a, 2) - a - 2;
        fx1[0] = 4 * Math.pow(a, 3) + 6 * a - 1;
        fx2[0] = 12 * Math.pow(a, 2) + 6;
        fx[1] = Math.pow(b, 4) + 3 * Math.pow(b, 2) - b - 2;
        fx1[1] = 4 * Math.pow(b, 3) + 6 * b - 1;
        fx2[1] = 12 * Math.pow(b, 2) + 6;
        if (fx1[0] * fx2[0] > 0 && fx1[1] * fx2[1] > 0) {
            x0[0] = b;
        } else {
            x0[0] = a;
        }
        fx0[0] = Math.pow(x0[0], 4) + 3 * Math.pow(x0[0], 2) - x0[0] - 2;
        fx01[0] = 4 * Math.pow(x0[0], 3) + 6 * x0[0] - 1;
        x1[0] = x0[0] - (fx0[0] / fx01[0]);
        if (Math.abs(x1[0] - x0[0]) >= e) {
            for (int i = 1; i < 10; i++) {
                x0[i] = x1[i - 1];
                fx0[i] = Math.pow(x0[i], 4) + 3 * Math.pow(x0[i], 2) - x0[i] - 2;
                fx01[i] = 4 * Math.pow(x0[i], 3) + 6 * x0[i] - 1;
                x1[i] = x0[i] - (fx0[i] / fx01[i]);
                fx0[i] = Math.round(fx0[i] * 10000) / 10000.0;
                fx01[i] = Math.round(fx01[i] * 10000) / 10000.0;
                x1[i] = Math.round(x1[i] * 10000) / 10000.0;
                if (Math.abs(x1[i] - x0[i]) < e) {
                    break;
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(x[i] + "\t" + fx[i] + "\t" + fx1[i] + "\t" + fx2[i] + "\t" + x0[0]);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "\t" + x0[i] + "\t" + fx0[i] + "\t" + fx01[i] + "\t" + x1[i]);
            if (Math.abs(x1[i] - x0[i]) < e) {
                break;
            }
        }

    }}