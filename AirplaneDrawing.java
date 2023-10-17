import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Arc2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AirplaneDrawing extends JPanel {

    private void drawGrid(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Montserrat", Font.BOLD, 11));
        int len = 30;
        for (int x = len; x < getWidth() - len; x += len) {
            g.drawLine(x, len, x, getHeight() - len);
            g.drawString(String.valueOf(x), x - 10, 20);
        }
        for (int y = len; y < getHeight() - len; y += len) {
            g.drawLine(len, y, getWidth() - len, y);
            g.drawString(String.valueOf(y), 2, y + 2);
        }
    }

    private void drawArc(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int x = 80;
        int y = 80;
        int width = 85;
        int height = 85;
        int startAngle = 45;
        int arcAngle = 185;

        g2d.setColor(Color.gray);
        g2d.draw(new Arc2D.Double(x, y, width, height, startAngle, arcAngle, Arc2D.OPEN));
    }

    private void plane(Graphics g) {
        g.setColor(Color.black);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2)); // задаем толщину 5 пикселей
        g2.drawLine(360, 330, 150, 90);
            g.drawLine(360, 330, 150, 90); // правый бок
            g.drawLine(90, 150, 330, 360); // левый бок
//        g.drawLine(270, 330, 330, 360); // ле бок
//        g.drawLine(330, 270, 360, 330); // пр бок


        g.drawLine(330, 360, 330, 390); // хвост
        g.drawLine(360, 330, 390, 330); //
        g.drawLine(330, 390, 360, 420); //
        g.drawLine(390, 330, 420, 360); //
        g.drawLine(360, 420, 360, 360); //
        g.drawLine(420, 360, 360, 360); //



        g.drawLine(120, 80, 80, 80); // голова\
        g.drawLine(80, 120, 80, 80); // голова\


        g.drawLine(90, 390, 120, 175); // левое крыло
        g.drawLine(185, 235, 100, 420); // левое нижнее
        g.drawLine(90, 390, 100, 420); // левое кусок

        g.drawLine(390, 90, 175, 120); // правое крыло
        g.drawLine(420, 100, 235, 185); //правое нижнее
        g.drawLine(390, 90, 420, 100); // кусок


//        g.drawLine(100, 150, 100, 125);
//        g.drawLine(100, 125, 125, 125);
//
//        g.drawLine(125, 100, 75, 100);


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        plane(g);
        drawArc(g);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Airplane Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new AirplaneDrawing());
        frame.setVisible(true);
    }
}
