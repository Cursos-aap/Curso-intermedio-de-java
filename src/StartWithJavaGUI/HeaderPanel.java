package StartWithJavaGUI;

import javax.swing.*;
import java.awt.*;


public class HeaderPanel extends JPanel {

    private JTextField input;
    private JLabel output;
    private final Font font;

    protected HeaderPanel(Font font){
        this.font = font;
    }

    private void initComponents(){
        this.setLayout(new FlowLayout());
        this.input = new JTextField();
        this.input.setEditable(false);
        this.input.setFont(font);
        //this.setBorder(new Border);

        this.add(input);
        this.add(output);

    }

}
