import java.util.*;

public class collection4 {
    public static void main(String[] args) {
        String firstString = "Привет! Я использую Java.";
        String secondString = "Моя программа была написана на Java.";

        // Частотный анализ символов первой строки
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : firstString.toCharArray()) {
            if (charFrequency.containsKey(c)) {
                charFrequency.put(c, charFrequency.get(c) + 1);
            } else {
                charFrequency.put(c, 1);
            }
        }
        System.out.println("Частотный анализ символов первой строки:");
        for (char c : charFrequency.keySet()) {
            System.out.println("'" + c + "': " + charFrequency.get(c));
        }

        // Определение символов, которые входят и в первую и во вторую строку
        Set<Character> commonChars = new HashSet<>();
        for (char c : firstString.toCharArray()) {
            if (secondString.indexOf(c) >= 0) {
                commonChars.add(c);
            }
        }
        System.out.println("Символы, которые входят и в первую и во вторую строку: " + commonChars);
    }
}
