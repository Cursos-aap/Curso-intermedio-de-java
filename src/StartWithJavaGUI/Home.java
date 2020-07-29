package StartWithJavaGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Home extends JFrame{

    private int width;
    private int height;
    private final Font font = new Font("Serif", Font.PLAIN, 16);

    private JPanel header;
    private JPanel body;


    public Home (){
        initComponents();

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void initComponents(){

        this.setTitle("Graphical User Interface :D");
        this.setPreferredSize(new Dimension(800, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(600, 200));
        this.setMaximumSize(new Dimension(1500, 1200));
        this.setLayout(new BorderLayout());

        Container container = this.getContentPane();

        width = container.getWidth();
        height = container.getHeight();
        final EmptyBorder margin = new EmptyBorder(height/16, width/16, height/16, width/16);

        header = new HeaderPanel(font);
        body = new BodyPanel();

        this.add(header, BorderLayout.NORTH);
        this.add(body, BorderLayout.CENTER);
    }

}
