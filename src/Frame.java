import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    int LARGEUR = 500;
    int HAUTEUR = 600;
    Panel myPanel;
    BottomPanel bottomPanel;

    Frame(){
        super("Tic Tac Toe");
        setSize(LARGEUR, HAUTEUR);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel cp = (JPanel) getContentPane();
        cp.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));

        bottomPanel = new BottomPanel();
        myPanel = new Panel(bottomPanel);
        cp.add(myPanel);
        cp.add(bottomPanel);
        setVisible(true);
    }
}
