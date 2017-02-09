/*
 JUST A REMINDER, WHEN COMMITING NEW WORK, ONLY CHOOSE THE PACKAGE YOUR WORKING IN, NOT THE MASTER PACKAGE, AS THIS COULD OVERWRITE THE WHOLE
PROJECT IF PEOPLE ARE DOING IT SIMULTANEOUSLY.
 */
package Events;
import javax.swing.*;

/**
 *
 * @author Matthew
 */
public class events extends JFrame{
    
    public static void main(String[] args) {
        JFrame f = new JFrame();
        second p = new second();
        
        f.setTitle("");
        f.setSize(400,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p);
        f.setVisible(true);
        
        
        
    }   
}
