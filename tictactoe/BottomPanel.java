import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {
    JLabel label, label2;
    String str = "joueur 1";

    BottomPanel(){
        setLayout(new GridLayout(2,1,0,5));
        setPreferredSize(new Dimension(420, 75));
        setBackground(Color.BLACK);
        label = new JLabel("À " + str + " de jouer");
        label.setForeground(Color.WHITE);
        add(label);
        label2 = new JLabel("Score : Joueur 1 :0 Joueur 2 :0 ");
        label2.setForeground(Color.white);
        add(label2);
    }

    public void setText(String s){
        str = s;
        label.setText("À " + str + " de jouer");
    }

    public void setText2(int n1, int n2){
        label2.setText("Score : Joueur 1 :" + n1 + "Joueur 2 :" + n2);
    }

}
