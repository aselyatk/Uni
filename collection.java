import java.util.HashSet;
import java.util.Vector;

public class collection {
    public static void main(String[] args) {
        // Создание пустого вектора
        Vector<String> vector = new Vector<>();

        // Добавление элементов в вектор
        vector.add("один");
        vector.add("два");
        vector.add("три");

        // Получение элемента по индексу
        String firstElement = vector.get(0);

        // Удаление элемента по индексу
        vector.remove(0);

        // Изменение элемента по индексу
        vector.set(0, "четыре");

        // Вывод всех элементов вектора
        System.out.println("Вектор:");
        for (String element : vector) {
            System.out.println(element);
        }

        // Создание пустого HashSet
        HashSet<String> hashSet = new HashSet<>();

        // Добавление элементов в HashSet
        hashSet.add("один");
        hashSet.add("два");
        hashSet.add("три");

        // Проверка наличия элемента в HashSet
        boolean containsOne = hashSet.contains("один");

        // Удаление элемента из HashSet
        hashSet.remove("два");

        // Вывод всех элементов HashSet
        System.out.println("HashSet:");
        for (String element : hashSet) {
            System.out.println(element);
        }
    }
}
