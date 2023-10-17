import java.text.DecimalFormat;

public class Integral {
    public static void main(String[] args) {
        double a = -2, b = 2, e = 0.001;
        int n = 6;
        double h = (b - a) / n;
        int i = 0;
        double[] arr = new double[7];
        double x0 = a;
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.println("X0\tF(x)");
        while (i <= 6) {
            arr[i] = Math.pow(x0, 2) + Math.sqrt(x0 + 2) - 1;
            System.out.println(x0 + "\t" + df.format(arr[i]));
            x0 = x0 + h;
            i++;
        }
        System.out.println();
        double Ip = 0, Il = 0, It, Ipa;
        for (int j = 1; j < 7; j++) {
            Ip += arr[j];
        }
        Ip = Ip * h;
        Ip = Math.round(Ip * 1000) / 1000.0;

        for (int j = 0; j < 6; j++) {
            Il += arr[j];
        }
        Il = Il * h;
        Il = Math.round(Il * 1000) / 1000.0;

        It = arr[6] * 0.5;
        It = It + arr[0] * 0.5;
        for (int j = 1; j < 6; j++) {
            It += arr[j];
        }
        It = It * h;
        It = Math.round(It * 1000) / 1000.0;

        Ipa = arr[6];
        Ipa += arr[0];
        for (int j = 1; j < 6; j++) {
            if (j % 2 == 0) {
                Ipa += arr[j] * 2;
            } else {
                Ipa += arr[j] * 4;
            }
        }
        Ipa = Ipa * (h / 3);
        Ipa = Math.round(Ipa * 1000) / 1000.0;
        System.out.println();
        System.out.println("Ip= " + Ip + "\n" + "Il= " + Il + "\n" + "It= " + It + "\n" + "Ipa= " + Ipa);
    }
}
