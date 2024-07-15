import javax.swing.*;
import java.awt.Image;
import java.awt.Rectangle;
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
   game_Frame gf;

   public void checkPoint(int[] imageYposition,int[] imageXposition,JButton monkeyButton, Image[] foods)
   {   
      Rectangle buttonBounds = monkeyButton.getBounds();
      int noRepat=0;

      for (int i = 0; i < foods.length; i++) {
          int foodWidth = foods[i].getWidth(null);
          int foodHeight = foods[i].getHeight(null);
          Rectangle foodBounds = new Rectangle(imageXposition[i], imageYposition[i], foodWidth, foodHeight);

          if (buttonBounds.intersects(foodBounds)) {
              
              foods[i].flush();
              randomYPosition(imageYposition, i);
              game_Frame.score++;
              gf.scoreLable.setText("score: "+game_Frame.score);
             

          }

          
      }
      
   }
}

