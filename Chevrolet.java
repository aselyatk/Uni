import javax.swing.*;
import java.awt.*;

public class Chevrolet extends JPanel {
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor (Color.BLACK);
        int y = 10;
        while (y <= 500) {
            int x = 40;
            while (x < 500) {
//                g.drawOval(x - 10,  y - 10,  21,  21);
                g.drawLine( x-9, y, x-9, y-6); //lev
                g.drawLine( x+10, y, x+10, y-6); //prav
                g.drawLine(x-9, y-6, x+10, y -6);//verhnyaya chast

                g.drawLine(x-25, y, x-9, y -0);//lev verh
                g.drawLine(x-25, y, x-30, y + 7);//lev bok


                g.drawLine(x+10, y, x+30, y+0);//prav verh
                g.drawLine(x+25, y+7, x+30, y+0);//prav bok

                g.drawLine(x-30, y+7, x-9, y +7);//lev verh
                g.drawLine(x+10, y+7, x+25, y+7);//prav verh

                g.drawLine( x-9, y+7, x-9, y+13);
                g.drawLine( x+10, y+7, x+10, y+13);
                g.drawLine(x-9, y+13, x+10, y +13);//verhnyaya chast
                x += 70;
            }
            y+=50;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Airplane Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 550);
        frame.add(new Chevrolet());
        frame.setVisible(true);
    }
}
