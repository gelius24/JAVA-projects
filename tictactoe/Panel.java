import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Panel extends JPanel {
    int SIZE = 420;
    int ESPACEMENT = SIZE/3;
    boolean tour = true;
    char[] cases = new char[9];
    BottomPanel bottomPanel;

    Panel(BottomPanel bottomPanel){
        this.bottomPanel = bottomPanel;
        setPreferredSize(new Dimension(SIZE,SIZE));
        setBackground(Color.black);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                // ligne horizontale 1
                if (e.getX() < ESPACEMENT && e.getY() < ESPACEMENT && cases[0] == '\u0000') {
                    if (tour)
                        cases[0] = 'x';
                    else
                        cases[0] = 'o';
                    drawXOrO(getGraphics(), 0, 0, ESPACEMENT, ESPACEMENT);
                    //System.out.println("ligne 1 - case 1");
                }
                if (e.getX() > ESPACEMENT && e.getX() < ESPACEMENT*2 && e.getY() < ESPACEMENT && cases[1] == '\u0000') {
                    if (tour)
                        cases[1] = 'x';
                    else
                        cases[1] = 'o';
                    drawXOrO(getGraphics(), ESPACEMENT, 0, ESPACEMENT * 2, ESPACEMENT);
                    //System.out.println("ligne 1 - case 2");
                }
                if(e.getX() > ESPACEMENT*2 && e.getY() < ESPACEMENT && e.getX() < getWidth() && cases[2] == '\u0000'){
                    if (tour)
                        cases[2] = 'x';
                    else
                        cases[2] = 'o';
                    drawXOrO(getGraphics(), ESPACEMENT*2, 0, getWidth(), ESPACEMENT);
                    //System.out.println("ligne 1 - case 3");
                }
                // ligne 2
                if(e.getX() < ESPACEMENT && e.getY() > ESPACEMENT && e.getY() < ESPACEMENT*2 && cases[3] == '\u0000'){
                    if (tour)
                        cases[3] = 'x';
                    else
                        cases[3] = 'o';
                    drawXOrO(getGraphics(), 0, ESPACEMENT, ESPACEMENT, ESPACEMENT*2);
                    //System.out.println("ligne 2 - case 1");
                }
                if(e.getX() > ESPACEMENT && e.getX() < ESPACEMENT*2 && e.getY() > ESPACEMENT &&
                        e.getY() < ESPACEMENT*2 && cases[4] == '\u0000'){
                    if (tour)
                        cases[4] = 'x';
                    else
                        cases[4] = 'o';
                    drawXOrO(getGraphics(), ESPACEMENT, ESPACEMENT, ESPACEMENT*2, ESPACEMENT*2);
                    //System.out.println("ligne 2 - case 2");
                }
                if(e.getX() > ESPACEMENT*2 && e.getY() > ESPACEMENT && e.getY() < ESPACEMENT*2 && cases[5] == '\u0000'){
                    if (tour)
                        cases[5] = 'x';
                    else
                        cases[5] = 'o';
                    drawXOrO(getGraphics(), ESPACEMENT*2, ESPACEMENT, getWidth(), ESPACEMENT*2);
                    //System.out.println("ligne 2 - case 3");
                }
                // Ligne 3
                if (e.getX() < ESPACEMENT && e.getY() > ESPACEMENT*2 && cases[6] == '\u0000'){
                    if (tour)
                        cases[6] = 'x';
                    else
                        cases[6] = 'o';
                    drawXOrO(getGraphics(),0,ESPACEMENT*2,ESPACEMENT,getHeight());
                    //System.out.println("ligne 3 - case 1");
                }
                if (e.getX() > ESPACEMENT && e.getX() < ESPACEMENT*2 && e.getY() > ESPACEMENT*2 && cases[7] == '\u0000'){
                    if (tour)
                        cases[7] = 'x';
                    else
                        cases[7] = 'o';
                    drawXOrO(getGraphics(),ESPACEMENT,ESPACEMENT*2,ESPACEMENT*2,getHeight());
                    //System.out.println("ligne 3 - case 2");
                }
                if(e.getX() > ESPACEMENT*2 && e.getY() > ESPACEMENT*2 && cases[8] == '\u0000'){
                    if (tour)
                        cases[8] = 'x';
                    else
                        cases[8] = 'o';
                    drawXOrO(getGraphics(), ESPACEMENT*2, ESPACEMENT*2, getWidth(), getHeight());
                    //System.out.println("ligne 3 - case 3");
                }
                update();
                checkWinner();
            }
        });
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0,0,SIZE,SIZE);
        drawGrid(g);
    }

    public void drawXOrO(Graphics g, int minX, int minY, int maxX, int maxY){
        //y1 baisser x2 gauche et y 2 baisser
        int VAL = 10;
        g.setColor(Color.WHITE);
        if (tour) {
            g.drawLine(minX + VAL, minY + VAL, maxX - VAL, maxY - VAL);
            g.drawLine(maxX - VAL, minY + VAL, minX + VAL, maxY - VAL);
            tour = false;
        } else {
            g.drawOval(minX + VAL, minY + VAL, ESPACEMENT - 20, ESPACEMENT - 20);
            tour = true;
        }

    }

    public void checkWinner(){
        // horizontal
        if (cases[0] == cases[1] && cases[1] == cases[2] && cases[0] != '\u0000' || cases[3] == cases[4] && cases[4] == cases[5] && cases[3] != '\u0000' || cases[6] == cases[7] && cases[7] == cases[8] && cases[7] != '\u0000') {
            if (!tour)
                System.out.println("Joueur 1 gange");
            else
                System.out.println("Joueur 2 gagne");
        }
    }

    public void drawGrid(Graphics g){
        g.setColor(Color.WHITE);
        for (int i = 1; i <= 2; i++) {
            g.drawLine(ESPACEMENT * i, 0, ESPACEMENT * i, SIZE);
            g.drawLine(0, ESPACEMENT * i, SIZE, ESPACEMENT * i);
        }
    }

    public void update(){
        if (tour)
            bottomPanel.setText("joueur 1");
        else
            bottomPanel.setText("joueur 2");
    }
}
