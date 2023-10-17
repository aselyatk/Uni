import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class grp1 extends JFrame {

    public grp1() {
        super("Desktop Image Copy"); // задаем заголовок окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // задаем операцию при закрытии окна
        setSize(500, 500); // задаем размер окна
        setLocationRelativeTo(null); // задаем положение окна по центру экрана

        try {
            Robot robot = new Robot(); // создаем экземпляр класса Robot
            BufferedImage desktopImage = robot.createScreenCapture(new Rectangle(0, 0, 500, 500)); // получаем изображение рабочего стола
            JLabel label = new JLabel(new ImageIcon(desktopImage)); // создаем метку с изображением
            add(label); // добавляем метку на форму
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        grp1 app = new grp1(); // создаем экземпляр класса
        app.setVisible(true); // отображаем окно
    }
}
