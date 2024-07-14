import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class game_panel extends JPanel{

    protected Image[] foods=new Image[10];
    protected Image[] predators= new Image[5];
    protected final int PANEL_HIGHT=this.getHeight();
    protected final int PANEL_WIDHT=this.getWidth();
    protected int[]  imageXposition=new int[11];
    int xSideIncrementer=10;

    protected int[]  imageYposition={1,2,3,4,5,6,7,8,9,10};
 

     public game_panel()
     { 
        instantiateImageArrays();
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        
     }

     public  void instantiateImageArrays()
     {   int temp=-100;
      for(int i=0;i<10;i++)
      {
         foods[i]= new ImageIcon("food"+i+".png").getImage();
          temp +=(foods[i].getWidth(null));
         imageXposition[i]=temp;
      }
     }
     public void paint(Graphics g)
     {  super.paint(g);
        Graphics2D g2d= (Graphics2D)g;
    
       
        for(int i=0;i<10;i++)
        {
           g2d.drawImage(foods[i],imageXposition[i],-100,null);
           
        }
       
        repaint();
     }

   
}
