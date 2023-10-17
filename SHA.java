import java.math.BigInteger;

public class SHA {
    public static void main(String[] args) {
        String a = "67452301";
        String b = "EFCDAB89";
        String c = "98BADCFE";
        String d = "10325476";
        String e = "C3D2E1F0";
        String t = "8f1bbcdc"; //константа t
        String[] text = {"qwertyas","ezkadena","ballette","carbonar","drawingg","x,charlote","quoteset",
                "seventyx","piyazzah","pollydrm","katalarr","kyrgyzha","ogogogog","homelook","nemoyyoo","aselyatk"};

        String a1 = hexToBinary(a);
        String b1 = hexToBinary(b);
        String c1 = hexToBinary(c);
        String d1 = hexToBinary(d);
        String e1 = hexToBinary(e);
        String t1 = hexToBinary(t);
        String[] text1 = new String[16];
        for (int i = 0; i < 16; i++) {
            text1[i] = stringToBinary(text[i]);//строка в 2чное
        }

        for (int i = 0; i < 16; i++) {
            System.out.println((i + 40) + "-round");
            String f = "";
            for (int j = 0; j < 32; j++) {
                f += (b1.charAt(j) == c1.charAt(j) && b1.charAt(j) == d1.charAt(j) && c1.charAt(j) == d1.charAt(j)) ? '0' : '1';
            }
            String fe = xorBinary(f, e1);
            String fa = xorBinary(fe, a1);
            String fw = xorBinary(fa, text1[i]);
            String kt = xorBinary(fw, t1);
            System.out.println(kt);
            e1 = d1;
            d1 = c1;
            String temp1 = b1.substring(2) + b1.substring(0, 2);
            b1 = temp1;
            c1 = b1;
            b1 = a1;
            a1 = kt;
        }
        for (int i = 0; i < 4; i++) {
            System.out.println((i + 56) + "-round");
            String f = "";
            for (int j = 0; j < 32; j++) {
                f += (b1.charAt(j) == c1.charAt(j) && b1.charAt(j) == d1.charAt(j) && c1.charAt(j) == d1.charAt(j)) ? '0' : '1';
            }
            String fe = xorBinary(f, e1);
            String fa = xorBinary(fe, a1);
            String fw = xorBinary(fa, text1[i]);
            String kt = xorBinary(fw, t1);
            System.out.println(kt);
            e1 = d1;
            d1 = c1;
            String temp1 = b1.substring(2) + b1.substring(0, 2);
            b1 = temp1;
            c1 = b1;
            b1 = a1;
            a1 = kt;
        }
    }

    //преобразование 16чного числа в 2чное
    public static String hexToBinary(String hex) {
        String binary = new BigInteger(hex, 16).toString(2);
        return String.format("%32s", binary).replace(' ', '0');
    }

    //преобразование строки с в 2чное
    public static String stringToBinary(String s) {
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            binary.append(String.format("%8s", Integer.toBinaryString(s.charAt(i))).replace(' ', '0'));
        }
        return binary.toString();
    }

    //побитовая операция XOR
    public static String xorBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            result.append(a.charAt(i) == b.charAt(i) ? '0' : '1');
        }
        return result.toString();
    }
}
