import java.util.LinkedList;
import java.util.Queue;

public class collection2 {
    public static void main(String[] args) {
        // Создание пустой очереди
        Queue<String> queue = new LinkedList<>();

        // Заполнение очереди элементами
        queue.add("один");
        queue.add("два");
        queue.add("три");

        // Добавление элемента в конец очереди
        queue.offer("четыре");

        // Удаление элемента из начала очереди
        String removedElement = queue.poll();

        // Вывод всех элементов очереди
        System.out.println("Очередь:");
        for (String element : queue) {
            System.out.println(element);
        }

        // Вывод удаленного элемента
        System.out.println("Удаленный элемент: " + removedElement);
    }
}
