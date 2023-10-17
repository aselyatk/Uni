import java.util.*;

public class zi2{
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int [][] port=new int[31][31];
        int r=1;
        for(int i=0;i<31;i++)
        {
            for(int j=0;j<31 ;j++)
            {
                port[i][j]=r;
                r++;
            }
        }
        String a="абвгдежзиклмнопрстуфхцчшщъыьэюя";
        char []al=a.toCharArray();
        System.out.println("Введите текст");
        String text= cin.nextLine();
        char[]te=text.toLowerCase().toCharArray();
        if(text.length()%2==0) {
            int[] t = new int[text.length()];
            for(int i=0;i<text.length();i++)
            {
                for(int j=0;j< a.length();j++)
                {
                    if(te[i]==al[j]){t[i]=j;
                        break;
                    }
                }
            }
            System.out.println("ответ");
            for(int i=1;i<text.length();i+=2)
            {
                System.out.print(port[t[i-1]][t[i]]+"\t");
            }
        }else {
            int[] t = new int[text.length() + 1];
            for (int i = 0; i < text.length(); i++) {
                for (int j = i + 1; j < a.length(); j++) {
                    if(te[i]==al[j]){t[i]=j;
                        break;
                    }
                }
            }
            t[text.length()]=5;
            System.out.println("ответ кочестве доп буквы использованна буква е");
            for(int i=1;i<text.length()+1;i+=2)
            {
                System.out.print(port[t[i-1]][t[i]]+"\t");
            }
        }
    }
}