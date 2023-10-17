import java.util.Scanner;

public class NewtonMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double h = 0.001, x, fx, fxl, fxp, fxc, fxx1, fxx;
        System.out.println("Введите x: ");
        x = scanner.nextDouble();

        fxl = (f(x) - f(x - h)) / h;
        fxp = (f(x + h) - f(x)) / h;
        fxc = (f(x + h) - f(x - h)) / (2 * h);
        fxx1 = (f(x + h) - 2 * f(x) + f(x - h)) / (Math.pow(h, 2));

        fx = (9 * Math.pow(x, 5)) / (2 * Math.sqrt(1 - Math.pow(x, 3)));
        fxx = (90 * Math.pow(x, 4) - 63 * Math.pow(x, 7)) / (Math.sqrt(1 - Math.pow(x, 3)) * (4 - 4 * Math.pow(x, 3)));

        System.out.println("левая производная " + fxl);
        System.out.println("математическая производная " + fx);
        pogr(fx, fxl);

        System.out.println("Правая производная " + fxp);
        System.out.println("математическая производная " + fx);
        pogr(fx, fxp);

        System.out.println("центральная производная " + fxc);
        System.out.println("математическая производная " + fx);
        pogr(fx, fxc);

        System.out.println("двойная производная " + fxx1);
        System.out.println("математическая производная " + fxx);
        pogr(fxx, fxx1);
    }

    public static void pogr(double fx1, double fx2) {
        double ot = Math.abs(fx2 - fx1);
        double op = ot / Math.abs(fx1);
        System.out.println("относительная погрешность " + ot);
        System.out.println("абсолютная погрешность " + op);
    }

    public static double f(double x) {
        return (Math.pow(x, 6) + Math.pow(x, 3) - 2) / (Math.sqrt(1 - Math.pow(x, 3)));
    }
}
