import java.util.Scanner;

public class DES {
    private static final int[] EXPANSION_TABLE = {
            32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13,
            12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22,
            23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1
    };
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово/текст для шифрования: ");
        String message = scanner.nextLine();
        System.out.print("Введите ключ для шифрования: ");
        String key = scanner.nextLine();
        scanner.close();

        String blocks = getBlocks(message);//преобразование строки в двоичный формат
        key = getBlocks(key); // преобразование ключа в двоичный формат

        System.out.println("Слово в битах"+blocks+" "+blocks.length());
        System.out.println("Ключ в битах"+key+" "+key.length());
        String subKeys = applyExpansionTable(key);
        System.out.println("Расширение ключа в битах"+subKeys+" "+subKeys.length());

        //Наложение по модулю 2 исходного текста и подключа, каждый символ блока исходного текста сравниваетс
        // с соответствующим символом подключа, в шифротекст записывается 0, если символы равны,и 1, если нет

        char []syms=blocks.toCharArray();
        String input="";

        for (int i = 0; i < blocks.length(); i++) {
            char block = syms[i];
             input+=block==subKeys.charAt(i)?"0":"1";
        }
        System.out.println(input);
    }

    private static String applyExpansionTable(String input) {
        String output="";
        for (int i = 0; i < 48; i++) {
            int bitNumber = 32 - EXPANSION_TABLE[i];
            output+=input.charAt(bitNumber);
        }
        return output;
    }

    private static String getBlocks(String s) {
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String binaryChar = Integer.toBinaryString(s.charAt(i));
            while (binaryChar.length() < 8) {
                binaryChar = "0" + binaryChar;
            }
            binary.append(binaryChar);
        }
        return binary.toString();
    }}
