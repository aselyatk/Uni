import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import static java.lang.Math.*;
import static java.lang.System.in;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
//Задание No3. (10 баллов)
//        Помогите Айбеку вспомнить пароль.
//        Пароль состоит из 4 символов(не являются буквами алфавита). Каждый символ соответствует 2хзначному
//        ASCII коду. Для определения этих чисел необходимо выполнить следующие операции:





public class Modul3 {
        public static void main(String[] args) throws IOException {
            String str = "Differences between data protection, security and privacy.\n" +
                    "Although some businesses use the terms data protection, data security and data privacy, they have different\n" +
                    "purposes. 1) Data protection safeguards information from loss through backup and recovery. 2) Data security\n" +
                    "refers specifically to measures taken to protect the integrity of the data itself against manipulation and malware.\n" +
                    "It provides defense from internal and external threats. 3) Data privacy refers to controlling access to the data.\n" +
                    "Organizations must determine who has access to data. Understandably, a privacy breach can lead to data security\n" +
                    "issues.\n";
            //поиск первого символа
            //         Поиск первого 2хзначного числа. Первая цифра отыскивается из отношения количества символов в
//        тексте на количество гласных букв (регистр при этом не учитывать). Вторую цифру первого числа
//        составляет количество цифр, имеющихся в исходном тексте.

            Pattern vocals = Pattern.compile("[auioeAUIOE]"); //поиск гласных в тексте
            Matcher m = vocals.matcher(str);
            int vocalCounter = 0;
            while (m.find()) {
                vocalCounter++;
            }
            int first = str.length()/ vocalCounter;  //отношение количества символов в тексте к количеству гласных букв

            int countnumber = 0; //подсчет количества цифр в тексте
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                    countnumber++;}}
            int birinchi = first * 10 + countnumber; //объединение двух выводов в одну строку
//            System.out.print(birinchi + " " );



            //поиск второго символа
            //         Поиск второго 2хзначного числа. Необходимо найти сумму каждой из цифр такого числа, которое
//        равно количеству согласных, найденных в тексте. Найденную сумму увеличить в 3 раза.
            Pattern consonants = Pattern.compile("[bcdfgyhjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZY]"); //поиск согласных в тексте
            Matcher c = consonants.matcher(str);
            int consonantCounter = 0;
            while (c.find()) {
                consonantCounter++;}
            int summa= ((consonantCounter%10)+((consonantCounter/10)%10)+((consonantCounter/100)%10));//сумма каждой из цифр числа
            int ekinchi = (summa*3);
//            System.out.println( consonantCounter);//увеличить полученную сумму в 3 раза




            //поиск третьего символа
//             Поиск третьего 2хзначного числа. Это число отыскивается из количества найденных в тексте
//            запятых, возведенных в куб.
            int countNulls=0, countOnes = 0;
            for (char element : str.toCharArray()){
                if (element == ',') countNulls++;
            }
            int cube =(int) Math.pow(countNulls, 3);
//            System.out.println (cube);




            //поиск четвертого символа
            //         Поиск четвертого 2хзначного числа. Первая цифра этого числа — количество предложений в тексте.
//        Вторая цифра — кубический корень из количества найденных в тексте заглавных букв.
            int sentence = 0;
            for(int i = 0; i < str.length() - 1; i++)
            {
                if ((str.charAt(i+1) == '.' || str.charAt(i+1) == '!' ||
                        str.charAt(i+1) == '?') &&
                        !(str.charAt(i) == '.' || str.charAt(i) == '!' ||
                                str.charAt(i) == '?')) sentence++;
            }
            Map<Boolean, Long> kol = str.chars().mapToObj(k -> (char) k).collect(groupingBy(Character::isUpperCase, counting()));
//            System.out.printf("Больших: %d", kol.get(true));
            int koren =(int) Math.cbrt(kol.get(true));
            int tort = sentence * 10 + koren; //объединение двух выводов в одну строку



           System.out.print("Символы: ");
            System.out.printf("%d %d %d %d\n", birinchi, ekinchi, cube, tort);

            System.out.print("Символы в ASCII: ");

            int[] password={birinchi,ekinchi,cube,tort};
            for (int symbol=0; symbol<password.length; symbol++){
                System.out.print((char)password[symbol]+" ");
}


        }
        }