import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class game_panel extends JPanel implements ActionListener,KeyListener {

    protected Image[] foods = new Image[10];
    protected Image[] predators = new Image[5];
    protected int[] predatorsYposition = new int[5];
    protected int[] predatorsXposition = new int[5];
    protected final int PANEL_HEIGHT = 500; 
    protected final int PANEL_WIDTH = 800; 
    protected int[] imageYposition = new int[10];
    protected int[] imageXposition = new int[10];
    protected JButton monkeyButton;
  protected boolean Alife;
    int ySideIncrementer = 10;

    Timer timer;
    int yVelocity = 1;
    game_logic gl= new game_logic();
    ImageIcon monkeyImage;

    public game_panel() {
       monkeyImage= new ImageIcon("monkey1.png");
         this.setDoubleBuffered(true);// this will remove tha annoying flickering thing that happens when we make the panels layout set to null
         monkeyButton= new JButton();
         monkeyButton.setIcon(monkeyImage);
         monkeyButton.setFocusable(false);
         monkeyButton.setBounds(225,390,50,50);
         monkeyButton.setBackground(Color.BLACK);
         monkeyButton.setBorder(null);
         

         // this will make the background of a button transparent 
        monkeyButton.setContentAreaFilled(false);
        monkeyButton.setBorderPainted(false);
       monkeyButton.setOpaque(false);

         this.setFocusable(true);
        this.addKeyListener(this);
         this.setLayout(null);
         this.add(monkeyButton);
        this.setBackground(Color.BLACK);

        instantiateImageArrays();

        timer = new Timer(10, this); 
        timer.start();


        this.setVisible(true);
        this.requestFocusInWindow();// this is because JPanel is not focusable by default so we need to requiest focus 
    }

    public void instantiateImageArrays() {
    
        int tempX=-100;
        int predatorTemp=-30;
        // instantiate the foods array 
        for (int i = 0; i < foods.length; i++) {
            foods[i] = new ImageIcon("food" + i + ".png").getImage();
            tempX +=foods[i].getWidth(null);
            imageXposition[i]= tempX;
            gl.randomYPosition(imageYposition,i);
            gl.randomXPosition(imageXposition, i);
        }
        // instantiate the predators array

        for (int i = 0; i < predators.length; i++) {
            predators[i] = new ImageIcon("predator" + i + ".png").getImage();
            predatorTemp +=predators[i].getWidth(null)+40;
            predatorsXposition[i]= predatorTemp;
            gl.randomPredatorsYPosition(predatorsYposition,i);
            gl.randomPredatorsXPosition(predatorsXposition, i);
        }
           
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i <foods.length; i++) {
            g2d.drawImage(foods[i], imageXposition[i], imageYposition[i], null);
        }
        for (int i = 0; i <predators.length; i++) {
            g2d.drawImage(predators[i], predatorsXposition[i], predatorsYposition[i], null);
        }

        gl.checkPoint(imageYposition, imageXposition, monkeyButton, foods);
        Alife  =   gl.checkAlife(predatorsXposition, predatorsYposition, monkeyButton, predators);
        this.setDoubleBuffered(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // this is the animation for food images 
        if(Alife){
        for (int i = 0; i < imageYposition.length; i++) {
            imageYposition[i] += yVelocity; 
            if (imageYposition[i] > PANEL_HEIGHT) {
                gl.randomYPosition(imageYposition,i);
            }
        }
              // this is the animation for predators images 
            for (int j = 0; j < predatorsYposition.length; j++) {
                predatorsYposition[j] += yVelocity; 
                if (predatorsYposition[j] > PANEL_HEIGHT) {
                    gl.randomYPosition(predatorsYposition,j);
                }
        }
         }
      
        
        repaint();

    }

        
    

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int x= monkeyButton.getX();
        int y= monkeyButton.getY();
       if(e.getKeyCode()==38)
       {
        monkeyButton.setLocation(x,y-10);
        if(monkeyButton.getY()<0)
        {
            monkeyButton.setLocation(x,0);
        }
        
       }
       else if(e.getKeyCode()==40)
       {
        monkeyButton.setLocation(x,y+10);
    
        if(monkeyButton.getY()>=400)
        {
            monkeyButton.setLocation(x,390);
            
        }
       }
       else if(e.getKeyCode()== 37)
       {
        monkeyButton.setLocation(x-10,y);
        if(monkeyButton.getX()<0)
        {
            monkeyButton.setLocation(0,y);
        }
       }
       else if(e.getKeyCode()==39)
       {
        monkeyButton.setLocation(x+10,y);
        if(monkeyButton.getX()>445)
        {
            monkeyButton.setLocation(445,y);
        }
       }
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
}
