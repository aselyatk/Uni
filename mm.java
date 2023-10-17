public class mm {
    public static void main(String[] args) {
        double x = 1.0; // Заданная точка x
        double h = 0.1; // Шаг

        // Вычисление значения функции f(x) в точке x
        double fx = f(x);

        // Вычисление значения функции f(x + h) в точке x + h
        double fxPlusH = f(x + h);

        // Вычисление приближенного значения первой производной
        double approximateDerivative = (fxPlusH - fx) / h;

        // Вычисление точного значения первой производной
        double exactDerivative = exactDerivative(x);

        // Вычисление абсолютной погрешности
        double absoluteError = Math.abs(approximateDerivative - exactDerivative);

        // Вычисление относительной погрешности в процентах
        double relativeError = (absoluteError / Math.abs(exactDerivative)) * 100;

        // Вывод результатов
        System.out.println("Приближенная производная: " + approximateDerivative);
        System.out.println("Точная производная: " + exactDerivative);
        System.out.println("Абсолютная погрешность: " + absoluteError);
        System.out.println("Относительная погрешность (%): " + relativeError);
    }

    // Определение функции f(x) = -3x^3 + 2x^2 - 4
    public static double f(double x) {
        return -3 * Math.pow(x, 3) + 2 * Math.pow(x, 2) - 4;
    }

    // Определение точной производной функции f'(x) = -9x^2 + 4x
    public static double exactDerivative(double x) {
        return -9 * Math.pow(x, 2) + 4 * x;
    }
}
