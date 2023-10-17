import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeometryApp extends JFrame {
    private JCheckBox sphereCheckBox;
    private JCheckBox coneCheckBox;
    private JCheckBox torusCheckBox;
    private JCheckBox icosahedronCheckBox;
    private JCheckBox tetrahedronCheckBox;
    private JCheckBox octahedronCheckBox;
    private JCheckBox hexahedronCheckBox;
    private JCheckBox dodecahedronCheckBox;
    private GeometryPanel geometryPanel;

    public GeometryApp() {
        setTitle("Отображение геометрических фигур");
        setSize(730, 635);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание компонентов GUI
        sphereCheckBox = new JCheckBox("Сфера");
        coneCheckBox = new JCheckBox("Конус с гранями/без");
        torusCheckBox = new JCheckBox("Тор");
        icosahedronCheckBox = new JCheckBox("Икосаэдр");
        tetrahedronCheckBox = new JCheckBox("Тетраэдр");
        octahedronCheckBox = new JCheckBox("Октаэдр");
        hexahedronCheckBox = new JCheckBox("Гексаэдр");
        dodecahedronCheckBox = new JCheckBox("Додекаэдр");

        JButton drawButton = new JButton("Отобразить");
        // Создание панели для флажков
        JPanel checkboxPanel = new JPanel();
        checkboxPanel.add(sphereCheckBox);
        checkboxPanel.add(coneCheckBox);
        checkboxPanel.add(torusCheckBox);
        checkboxPanel.add(icosahedronCheckBox);
        checkboxPanel.add(tetrahedronCheckBox);
        checkboxPanel.add(octahedronCheckBox);
        checkboxPanel.add(hexahedronCheckBox);
        checkboxPanel.add(dodecahedronCheckBox);

        // Создание панели для отображения геометрии
        geometryPanel = new GeometryPanel();

        // Добавление компонентов на окно
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(checkboxPanel, BorderLayout.NORTH);
        getContentPane().add(geometryPanel, BorderLayout.CENTER);
        getContentPane().add(drawButton, BorderLayout.SOUTH);

        // Обработчик события нажатия на кнопку "Отобразить"
        drawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                geometryPanel.setDrawSphere(sphereCheckBox.isSelected());
                geometryPanel.setDrawCone(coneCheckBox.isSelected());
                geometryPanel.setDrawTorus(torusCheckBox.isSelected());
                geometryPanel.setDrawIcosahedron(icosahedronCheckBox.isSelected());
                geometryPanel.setDrawTetrahedron(tetrahedronCheckBox.isSelected());
                geometryPanel.setDrawOctahedron(octahedronCheckBox.isSelected());
                geometryPanel.setDrawHexahedron(hexahedronCheckBox.isSelected());
                geometryPanel.setDrawDodecahedron(dodecahedronCheckBox.isSelected());
                // Установите состояния для остальных флажков и фигур
                geometryPanel.repaint();
            }
        });
        // Максимальное количество кнопок, которые можно выбрать
        final int MAX_SELECTIONS = 3;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GeometryApp app = new GeometryApp();
                app.setVisible(true);
            }
        });
    }
}
class GeometryPanel extends JPanel {
    private boolean drawSphere;
    private boolean drawCone;
    private boolean drawTorus;
    private boolean drawIcosahedron;
    private boolean drawTetrahedron;
    private boolean drawOctahedron;
    private boolean drawHexahedron;
    private boolean drawDodecahedron;

    public GeometryPanel() {
        drawSphere = false;
        drawCone = false;
        drawTorus = false;
        drawIcosahedron = false;
        drawTetrahedron = false;
        drawOctahedron = false;
        drawHexahedron = false;
        drawDodecahedron = false;
    }

    public void setDrawSphere(boolean drawSphere) {
        this.drawSphere = drawSphere;
    }

    public void setDrawCone(boolean drawCone) {
        this.drawCone = drawCone;
    }

    public void setDrawTorus(boolean drawTorus) {
        this.drawTorus = drawTorus;
    }

    public void setDrawIcosahedron(boolean drawIcosahedron) {
        this.drawIcosahedron = drawIcosahedron;
    }

    public void setDrawTetrahedron(boolean drawTetrahedron) {
        this.drawTetrahedron = drawTetrahedron;
    }

    public void setDrawOctahedron(boolean drawOctahedron) {
        this.drawOctahedron = drawOctahedron;
    }

    public void setDrawHexahedron(boolean drawHexahedron) {
        this.drawHexahedron = drawHexahedron;
    }

    public void setDrawDodecahedron(boolean drawDodecahedron) {
        this.drawDodecahedron = drawDodecahedron;
    }
    //  методы setDrawX фигур

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        // Сетка
        drawGrid(g, width, height);

        // рисование фигур
        if (drawSphere) {
            drawSphere(g, width, height);
            int centerX = 0; // координата центра по оси X
            int centerY = 0; // координата центра по оси Y
            int radiusX = 150; // радиус по оси X
            int radiusY = 150; // радиус по оси Y

            g.drawOval(centerX + 20, centerY + 20, radiusX, radiusY);
            g.drawOval(centerX + 20, centerY + 80, radiusX, radiusY - 120);
            g.drawOval(centerX + 70, centerY + 20, radiusX - 110, radiusY);
        }
        if (drawCone) {
            drawCone(g, width, height);
//конус без граней
            int radiusX = 100; // радиус по оси X
            int radiusY = 10; // радиус по оси Y
            int centerX = 200; // координата центра по оси X
            int centerY = 95; // координата центра по оси Y
            int centerrY = 100; // координата центра по оси Y
            g.setColor(Color.black);
            g.drawOval(centerX + 4, centerY + 50, radiusX + 50, radiusY + 15);
            g.drawOval(centerX + 33, centerrY - 10, radiusX - 10, radiusY + 5);
            int[] xPoints = {centerX + 75, centerX + 4, centerX + 155};
            int[] yPoints = {centerY - 90, centerY + 70, centerY + 70};
            g.setColor(Color.black);
            g.drawLine(275, 157, 275, 5);
            g.drawLine(205, 157, 355, 157);
            g.drawLine(205, 157, 275, 5);
            g.drawLine(355, 157, 275, 5);
//рисуем конус с гранями
            int xCentere = 425; // координата x центра пятиугольника
            int yCentere = 150; // координата y центра пятиугольника
            int nPoints = 5;
            int[] xPointss = new int[]
                    {xCentere - 50, xCentere + 25, xCentere + 100, xCentere + 50, xCentere - 10};
            int[] yPointss = new int[]
                    {yCentere + 10, yCentere, yCentere + 10, yCentere + 25, yCentere + 25};
            g.setColor(Color.black);
            g.drawPolygon(xPointss, yPointss, nPoints);
            g.drawLine(450, 150, 450, 5);
            g.drawLine(375, 160, 450, 5);
            g.drawLine(415, 175, 450, 5);
            g.drawLine(475, 175, 450, 5);
            g.drawLine(525, 160, 450, 5);
        }
        if (drawTorus) {
            drawTorus(g, width, height);
            int centerX = 540; // координата центра по оси X
            int centerY = 0; // координата центра по оси Y
            int radiusX = 160; // радиус по оси X
            int radiusY = 160; // радиус по оси Y

            g.drawOval(centerX + 20, centerY + 75, radiusX - 20, radiusY - 85);
            g.drawOval(centerX + 10, centerY + 75, radiusX, radiusY - 65);
            g.drawOval(centerX + 50, centerY + 100, radiusX - 80, radiusY - 130);
            g.drawArc(centerX + 11, centerY + 105, radiusX - 120, radiusY - 130, 20, 160);
            g.drawArc(centerX + 130, centerY + 105, radiusX - 120, radiusY - 130, 10, 160);
        }

        if (drawIcosahedron) {
            drawIcosahedron(g, width, height);
            //center triangle
            int xCentere = 90; // координата x центра пятиугольника
            int yCentere = 260; // координата y центра пятиугольника
            int nPoints = 3;
            int[] xPointss = new int[]
                    {xCentere - 30, xCentere + 30, xCentere};
            int[] yPointss = new int[]
                    {yCentere - 5, yCentere - 5, yCentere + 40};
            g.setColor(Color.black);
            g.drawPolygon(xPointss, yPointss, nPoints);

            //left triangle
            int[] xPoints = new int[]
                    {xCentere - 40, xCentere, xCentere - 30};
            int[] yPoints = new int[]
                    {yCentere + 35, yCentere + 40, yCentere - 5};
            g.drawPolygon(xPoints, yPoints, nPoints);
            //bok left triangle
            int[] xPointse = new int[]
                    {xCentere - 40, xCentere - 30, xCentere - 40};
            int[] yPointse = new int[]
                    {yCentere - 10, yCentere - 5, yCentere + 32};
            g.drawPolygon(xPointse, yPointse, nPoints);
            //left niz triangle
            int[] xPoint = new int[]
                    {xCentere - 40, xCentere, xCentere - 2};
            int[] yPoint = new int[]
                    {yCentere + 35, yCentere + 40, yCentere + 60};
            g.drawPolygon(xPoint, yPoint, nPoints);

            //verh left triangle
            int[] xPointb = new int[]
                    {xCentere - 40, xCentere - 30, xCentere - 2};
            int[] yPointb = new int[]
                    {yCentere - 10, yCentere - 5, yCentere - 29};
            g.drawPolygon(xPointb, yPointb, nPoints);

            //right triangle
            int[] xPointso = new int[]
                    {xCentere + 40, xCentere, xCentere + 30};
            int[] yPointso = new int[]
                    {yCentere + 35, yCentere + 40, yCentere - 5};
            g.drawPolygon(xPointso, yPointso, nPoints);

            //bok right triangle
            int[] xPointsea = new int[]
                    {xCentere + 40, xCentere + 30, xCentere + 40};
            int[] yPointsea = new int[]
                    {yCentere - 10, yCentere - 5, yCentere + 32};
            g.drawPolygon(xPointsea, yPointsea, nPoints);
            //verh right triangle
            int[] xPointn = new int[]
                    {xCentere + 40, xCentere + 30, xCentere + 2};
            int[] yPointn = new int[]
                    {yCentere - 10, yCentere - 5, yCentere - 29};
            g.drawPolygon(xPointn, yPointn, nPoints);
            //right niz triangle
            int[] xPointz = new int[]
                    {xCentere + 40, xCentere, xCentere - 2};
            int[] yPointz = new int[]
                    {yCentere + 35, yCentere + 40, yCentere + 60};
            g.drawPolygon(xPointz, yPointz, nPoints);
            //center verh triangle
            int[] xPointsz = new int[]
                    {xCentere - 30, xCentere + 30, xCentere};
            int[] yPointsz = new int[]
                    {yCentere - 5, yCentere - 5, yCentere - 30};
            g.setColor(Color.black);
            g.drawPolygon(xPointsz, yPointsz, nPoints);

        }

        if (drawTetrahedron) {
            drawTetrahedron(g, width, height);
            Color DarkBlue = new Color(23, 55, 145);
            g.setColor(DarkBlue);
            g.drawLine(220, 300, 320, 300);


            int xCentere = 270; // координата x центра пятиугольника
            int yCentere = 270; // координата y центра пятиугольника
            int nPoints = 3;

            int[] xPoints = new int[]
                    {xCentere - 50, xCentere - 5, xCentere - 15};
            int[] yPoints = new int[]
                    {yCentere + 30, yCentere + 50, yCentere - 40};

            int[] xPoint = new int[]
                    {xCentere + 50, xCentere - 5, xCentere - 15};
            int[] yPoint = new int[]
                    {yCentere + 30, yCentere + 50, yCentere - 40};

            g.setColor(Color.black);
            g.drawPolygon(xPoints, yPoints, nPoints);
            g.drawPolygon(xPoint, yPoint, nPoints);

        }
        if (drawOctahedron) {
            drawOctahedron(g, width, height);
            Color DarkBlue = new Color(90, 144, 189);
            g.setColor(DarkBlue);
            g.drawLine(390, 260, 460, 250); //left
            g.drawLine(520, 265, 460, 250);//right
            g.drawLine(450, 200, 460, 250);//verh
            g.drawLine(450, 325, 460, 250);//niz

            int xCentere = 450; // координата x центра пятиугольника
            int yCentere = 270; // координата y центра пятиугольника
            int nPoints = 3;

            //left tri
            int[] xPoints = new int[]
                    {xCentere - 60, xCentere - 15, xCentere};
            int[] yPoints = new int[]
                    {yCentere - 10, yCentere + 10, yCentere - 70};
            //left tri niz
            int[] xPointd = new int[]
                    {xCentere - 60, xCentere - 15, xCentere};
            int[] yPointd = new int[]
                    {yCentere - 10, yCentere + 10, yCentere + 55};

            //right tri
            int[] xPoint = new int[]
                    {xCentere + 70, xCentere - 15, xCentere};
            int[] yPoint = new int[]
                    {yCentere - 5, yCentere + 10, yCentere - 70};
            //right tri nix
            int[] xPointt = new int[]
                    {xCentere + 70, xCentere - 15, xCentere};
            int[] yPointt = new int[]
                    {yCentere - 5, yCentere + 10, yCentere + 55};

            g.setColor(Color.black);
            g.drawPolygon(xPoints, yPoints, nPoints);
            g.drawPolygon(xPoint, yPoint, nPoints);
            g.drawPolygon(xPointd, yPointd, nPoints);
            g.drawPolygon(xPointt, yPointt, nPoints);

        }
        if (drawHexahedron) {
            drawHexahedron(g, width, height);
            Color DarkBlue = new Color(90, 144, 189);
            g.setColor(DarkBlue);
            g.drawRect(610, 210, 90, 90);
            g.drawLine(570, 330, 610, 300); //left

            g.setColor(Color.black);
//            g.drawPolygon(xPoint, yPoint, nPoints);
            g.drawRect(570, 240, 90, 90);
            g.drawLine(570, 240, 610, 210); //left
            g.drawLine(660, 240, 700, 210); //left
            g.drawLine(660, 330, 700, 300); //left
            g.drawLine(610, 210, 700, 210); //left
            g.drawLine(700, 210, 700, 300); //left
        }
        if (drawDodecahedron) {
            drawDodecahedron(g, width, height);
            int xCentere = 90; // координата x центра пятиугольника
            int yCentere = 450; // координата y центра пятиугольника
            int nPoints = 5;
            int[] xPointss = new int[]
                    {xCentere - 25, xCentere - 40, xCentere, xCentere + 40, xCentere + 25};
            int[] yPointss = new int[]
                    {yCentere - 30, yCentere + 10, yCentere + 40, yCentere + 10, yCentere - 30};

            Color Lasure = new Color(208, 234, 255);
            Color Lasur = new Color(122, 169, 205);
            Color Lasu = new Color(134, 143, 150);
            Color Las = new Color(160, 178, 191);
            Color Verh = new Color(160, 213, 254);

            g.setColor(Lasure);
            g.fillPolygon(xPointss, yPointss, nPoints);
            g.drawPolygon(xPointss, yPointss, nPoints);

            int[] xPoints = new int[]
                    {xCentere - 25, xCentere - 40, xCentere - 60, xCentere - 55, xCentere - 30};
            int[] yPoints = new int[]
                    {yCentere - 30, yCentere + 10, yCentere + 20, yCentere - 10, yCentere - 40};
            g.setColor(Lasur);
            g.fillPolygon(xPoints, yPoints, nPoints);
            g.drawPolygon(xPoints, yPoints, nPoints);


            int[] xPoint = new int[]
                    {xCentere + 25, xCentere + 40, xCentere + 60, xCentere + 55, xCentere + 30};
            int[] yPoint = new int[]
                    {yCentere - 30, yCentere + 10, yCentere + 20, yCentere - 10, yCentere - 40};
            g.setColor(Lasur);
            g.fillPolygon(xPoint, yPoint, nPoints);
            g.drawPolygon(xPoint, yPoint, nPoints);
            ///////
            int[] xPointse = new int[]
                    {xCentere - 40, xCentere - 60, xCentere - 40, xCentere, xCentere};
            int[] yPointse = new int[]
                    {yCentere + 55, yCentere + 20, yCentere + 10, yCentere + 40, yCentere + 70};

            g.setColor(Lasu);
            g.fillPolygon(xPointse, yPointse, nPoints);
            g.drawPolygon(xPointse, yPointse, nPoints);

            int[] xPointb = new int[]
                    {xCentere + 40, xCentere + 60, xCentere + 40, xCentere, xCentere};
            int[] yPointb = new int[]
                    {yCentere + 55, yCentere + 20, yCentere + 10, yCentere + 40, yCentere + 70};

            g.setColor(Las);
            g.fillPolygon(xPointb, yPointb, nPoints);
            g.drawPolygon(xPointb, yPointb, nPoints);
            //verhhnn
            int[] xPointsn = new int[]
                    {xCentere - 25, xCentere - 30, xCentere, xCentere + 30, xCentere + 25};
            int[] yPointsn = new int[]
                    {yCentere - 30, yCentere - 40, yCentere - 45, yCentere - 40, yCentere - 30};

            g.setColor(Verh);
            g.fillPolygon(xPointsn, yPointsn, nPoints);
            g.drawPolygon(xPointsn, yPointsn, nPoints);
        }
    }

    private void drawDodecahedron(Graphics g, int width, int height) {
    }

    private void drawHexahedron(Graphics g, int width, int height) {
    }

    private void drawOctahedron(Graphics g, int width, int height) {
    }

    private void drawTetrahedron(Graphics g, int width, int height) {
    }

    private void drawIcosahedron(Graphics g, int width, int height) {
    }

    private void drawSphere(Graphics g, int width, int height) {
    }

    private void drawCone(Graphics g, int width, int height) {
    }

    private void drawTorus(Graphics g, int width, int height) {
    }

    private void drawGrid(Graphics g, int width, int height) {
        int gridSize = 180;
        int secgridSize = 20;

        Color mainColor = Color.black;
        Color secColor = Color.LIGHT_GRAY;


        // Горизонтальные линии второстепенной сетки
        g.setFont(new Font("Montserrat", Font.ITALIC, 7));
        g.setColor(secColor);
        for (int y = 0; y < height; y += secgridSize) {
            g.drawLine(0, y, width, y);
            g.drawString(String.valueOf(y), 0, y + 6); // изменяем параметры drawString
        }
        // Вертикальные линии второстепенной сетки
        for (int x = 0; x < width; x += secgridSize) {
            g.drawLine(x, 0, x, height);
            g.drawString(String.valueOf(x), x + 0, 6); // изменяем параметры drawString
        }
        // Горизонтальные линии основной сетки
        g.setColor(mainColor);
        for (int y = 0; y < height; y += gridSize) {
            g.drawLine(0, y, width, y);
        }
        // Вертикальные линии основной сетки
        for (int x = 0; x < width; x += gridSize) {
            g.drawLine(x, 0, x, height);
        }
    }
}
