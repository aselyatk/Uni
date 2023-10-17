import java.util.*;

public class collection3 {
    public static void main(String[] args) {
        // Создание генератора случайных чисел
        Random random = new Random();

        // Создание ArrayList и добавление 15 целых чисел от 1 до 9
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(random.nextInt(9) + 1);
        }

        // Вывод исходного списка
        System.out.println("Исходный список: " + list);

        // Задача А: создание нового списка, переписав в него часть элементов из первого списка
        List<Integer> sublist = list.subList(2, 7);
        ArrayList<Integer> newArray = new ArrayList<>(sublist);
        System.out.println("Новый список, скопированный из исходного: " + newArray);

        // Задача Б: определение уникальных чисел
        HashSet<Integer> uniqueNumbers = new HashSet<>(list);
        System.out.println("Уникальные числа: " + uniqueNumbers);

        // Задача В: определение количества каждого уникального числа
        Map<Integer, Integer> numberCount = new HashMap<>();
        for (int element : list) {
            if (numberCount.containsKey(element)) {
                numberCount.put(element, numberCount.get(element) + 1);
            } else {
                numberCount.put(element, 1);
            }
        }
        System.out.println("Количество каждого уникального числа: " + numberCount);
    }
}
