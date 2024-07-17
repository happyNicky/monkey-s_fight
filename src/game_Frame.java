import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class game_Frame extends JFrame {
     protected static JLabel scoreLable;
     

     game_panel gp=new game_panel();
   public static int score=0;
     JPanel northPanel;
    public game_Frame()
    {    
         northPanel= new JPanel();
         northPanel.setLayout(new FlowLayout());
         scoreLable= new JLabel();

        
        scoreLable= new JLabel();
        scoreLable.setText("Score: "+score);
        scoreLable.setSize(400,300);
        scoreLable.setBackground(Color.BLACK);
        scoreLable.setForeground(Color.WHITE);
        scoreLable.setOpaque(true);
        northPanel.add(scoreLable);
        
      
        this.add(northPanel,BorderLayout.NORTH);
        this.add(gp,BorderLayout.CENTER);
        //this.setResizable(false);
        
        this.setTitle("Food Fight");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
}