/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this templae file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import GUI.Window;
import Items.Sprite;
import Items.Storage;
import Misc.Print;
import Network.Network;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author mathew
 */
public class Init {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try {
           Print.print("Starting on: "+Network.getIp());
           System.out.println(Network.getIp());
           
             Storage.LOCAL_STORAGE = new Storage(10000);
             
             
             //Get Players username
             boolean nameEntered = false;
             String name = "";
             while(!nameEntered){
                name = JOptionPane.showInputDialog(null, "What is your name?");
                 if(name != null){
                     break;
                 }
             }
             
        Storage.LOCAL_STORAGE.addNewSprite(new Sprite(400,400, name));
        
        Window w = new Window();
      
        
        JFrame f = new JFrame();
        f.setSize(500, 500);
        w.setBounds(f.getBounds());
       
       f.add(w);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
        
        
        
        
        
        
            Network n = new Network(Settings.port);
            
            Print.print("Started");
        } catch (Exception e) {
            Print.print("Catched");
        }
    }
    
}
