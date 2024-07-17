import javax.swing.*;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Color;
public  class game_logic 
{   
   public void randomYPosition(int[] imageYposition,int index)
   { 
       int Ynew = (int ) (100+Math.random()*100);
       for(int i=0;i<imageYposition.length;i++)
             {   
              imageYposition[index]=-Ynew;
             }
      
   } 

   public void randomPredatorsYPosition(int[] predatorsYposition,int index)
   { 
       int Ynew = (int ) (50+Math.random()*100);
       for(int i=0;i<predatorsYposition.length;i++)
             {   
              predatorsYposition[index]=Ynew;
             }
      
   } 

   public  void  randomXPosition(int[] imageXposition, int index) {
        int oldX=0;
        int xnew=0;
        oldX=xnew;
         xnew = (int)(Math.random()*10)+90;
         int temp= Math.abs(oldX-xnew) ;
         while (temp<60) {
         imageXposition[index]=temp;
         }
            
        }

        public  void  randomPredatorsXPosition(int[] predatorsXposition, int index) {
            int oldX=0;
            int xnew=0;
            oldX=xnew;
             xnew = (int)(Math.random()*100)+200;
             int temp= Math.abs(oldX-xnew) ;
             while (temp<120) {
             predatorsXposition[index]=temp;
             }
                
            }
    
   game_Frame gf;

   public void checkPoint(int[] imageYposition,int[] imageXposition,JButton monkeyButton, Image[] foods)
   {   
      Rectangle buttonBounds = monkeyButton.getBounds();
      for (int i = 0; i < foods.length; i++) {
          int foodWidth = foods[i].getWidth(null);
          int foodHeight = foods[i].getHeight(null);
          Rectangle foodBounds = new Rectangle(imageXposition[i], imageYposition[i], foodWidth, foodHeight);
          if (buttonBounds.intersects(foodBounds)) {
              foods[i].flush();
              randomYPosition(imageYposition, i);
              game_Frame.score++;
            game_Frame.scoreLable.setText("score: "+game_Frame.score);
          } 
           
      }
   }

   public boolean checkAlife(int[] predatorsXposition, int[] predatorsYposition, JButton monkeyButton, Image[] predator)
   {
    Rectangle buttonBounds = monkeyButton.getBounds();
    for (int i = 0; i < predator.length; i++) {
        int predatorsWidth = predator[i].getWidth(null);
        int predatorsHeight = predator[i].getHeight(null);
        Rectangle foodBounds = new Rectangle(predatorsXposition[i], predatorsYposition[i],predatorsWidth, predatorsHeight);
        if (buttonBounds.intersects(foodBounds)) {
            monkeyButton.setVisible(false);
            monkeyButton.setEnabled(false);
            game_Frame.scoreLable.setText("Game Over!!! Score: " +game_Frame.score);
            return false;
        } 
      }
   return true;
   }
}



