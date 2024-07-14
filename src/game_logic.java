import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer; 

public class game_logic implements ActionListener {

    game_panel gp1 = new game_panel();
    protected Timer timer;

    public game_logic() {
        timer = new Timer(1000, this);
        timer.start(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++)
        {
            
        }
    }

    
}
