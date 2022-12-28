import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {
    JLabel label;
    String str = "joueur 1";

    BottomPanel(){
        setPreferredSize(new Dimension(420, 75));
        setBackground(Color.BLACK);
        label = new JLabel();
        label.setForeground(Color.WHITE);
        label.setText("À " + str + " de jouer");
        add(label);
    }

    public void setText(String s){
        str = s;
        label.setText("À " + str + " de jouer");
    }

}
