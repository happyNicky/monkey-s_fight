import javax.swing.JFrame;
import javax.swing.JLabel;

public class game_Frame extends JFrame {
     private JLabel scoreLable;
    public game_Frame()
    {   scoreLable= new JLabel();
        this.add(scoreLable);
        this.setTitle("Food Fight");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
}