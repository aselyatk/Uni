import java.util.*;
public class Modul1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Выберите вариант 1(x1) или 2(x2):");
        int choice=in.nextInt();
        switch (choice){
            case 1:System.out.print("Введите свой вариант: n=");
                int n=in.nextInt();
                double x = 7.86+1.27*n;
                double def=0.7615625;
                int p=5;
                double x1 =Math.pow(2.0,p)*def;
                int e=p/2;
                double x0=Math.pow(2,e);
                double epsilon = 0.000001;
                System.out.println("|     yk    |");
                System.out.println("|-----------|");
                System.out.printf("| %9.5f | \n", x0);
                double result1 = sqrt(x, x0, epsilon);
                System.out.println("Ответ: y="+result1);
                break;
            case 2:System.out.print("Введите свой вариант: n=");
                int m=in.nextInt();
                double b = 0.017+0.012*m;
                int t=-2;
                double b1 = Math.pow(2.0,t)*0.692;
                int e1=(t/2);
                double y0=Math.pow(2.0,e1);
                double eps = 0.000001;
                System.out.println("|     yk    |");
                System.out.println("|-----------|");
                System.out.printf("| %9.5f | \n", y0);
                double result2 = sqrt(b, y0, eps);
                System.out.println("Ответ: y="+result2);
                break;
            default: System.out.print("Выбирайте между 1 или 2!");

        }
    }
    public static double sqrt(double x, double x0, double epsilon) {
        double y0 =x0;
        double yk = (y0 + x / y0) / 2;
        System.out.printf("| %9.5f | \n", yk);
        while (Math.abs(yk - y0) > epsilon) {
            y0 = yk;
            yk = (y0 + x / y0) / 2;
            System.out.printf("| %9.5f | \n", yk);
        }
        return yk;
    }
}
