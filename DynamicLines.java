import javax.swing.*;
import java.awt.*;

public class DynamicLines extends JPanel implements Runnable {
//    public class DynamicLines extends JPanel  {


    private int x1 = 5;
    private int y1 = 5;
    private int x2 = 5;
    private int y2 = 5;


    public DynamicLines() {
        Thread animationThread = new Thread(this);
        animationThread.start();
    }

    public void paint(Graphics g) {
        super.paint(g);


        g.drawLine(x1 +0, y1 +200, x2 + 200, y2 + 200);
        g.drawLine(x1 +0, y1 +190, x2 + 190, y2 + 200);
        g.drawLine(x1 +0, y1 +180, x2 + 180, y2 + 200);
        g.drawLine(x1 +0, y1 +170, x2 + 170, y2 + 200);
        g.drawLine(x1 +0, y1 +160, x2 + 160, y2 + 200);
        g.drawLine(x1 +0, y1 +150, x2 + 150, y2 + 200);
        g.drawLine(x1 +0, y1 +140, x2 + 140, y2 + 200);
        g.drawLine(x1 +0, y1 +130, x2 + 130, y2 + 200);
        g.drawLine(x1 +0, y1 +120, x2 + 120, y2 + 200);
        g.drawLine(x1 +0, y1 +110, x2 + 110, y2 + 200);
        g.drawLine(x1 +0, y1 +100, x2 + 100, y2 + 200);
        g.drawLine(x1 +0, y1 +90, x2 +90, y2 + 200);
        g.drawLine(x1 +0, y1 +80, x2 + 80, y2 + 200);
        g.drawLine(x1 +0, y1 +70, x2 + 70, y2 + 200);
        g.drawLine(x1 +0, y1 +60, x2 + 60, y2 + 200);
        g.drawLine(x1 +0, y1 +50, x2 + 50, y2 + 200);
        g.drawLine(x1 +0, y1 +40, x2 + 40, y2 + 200);
        g.drawLine(x1 +0, y1 +30, x2 + 30, y2 + 200);
        g.drawLine(x1 +0, y1 +20, x2 + 20, y2 + 200);
        g.drawLine(x1 +0, y1 +10, x2 + 10, y2 + 200);
        g.drawLine(x1 +0, y1 +0, x2 + 0, y2 + 200);
    }
    public void run() {
        while (true) { // Бесконечный цикл

            y1--; // Двигаем точку 1 вверх
            x2--; // Двигаем точку 2 вниз
            if (y1 <0) y1 = 80; // Если точка 1 вышла за верхнюю границу окна, перемещаем ее внизу
            if (x2 <0) x2 = 80; // Если точка 2 вышла за нижнюю границу окна, перемещаем ее наверх
            repaint(); // Перерисовываем окно

            try {
                Thread.sleep(10); // Спим на 10 миллисекунд
            } catch (InterruptedException e) {
                e.printStackTrace(); // Обработка исключения прерывания потока
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dynamic Lines");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setContentPane(new DynamicLines());
        frame.setVisible(true);
    }
}
