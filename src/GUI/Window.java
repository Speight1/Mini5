/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Client.Session;
import Events.movement;
import GUI.Processing;
import Items.Sprite;
import Items.Storage;
import Misc.Print;
import Network.ResponceHeader;
import Network.Settings;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;

import javax.swing.*;

/**
 *
 * @author mathew
 */
public class Window extends JPanel implements ActionListener {
   
    public int RefreshRate = 90;
    Timer timer;
    public int velocity = 10;
    public Controller m = new Controller();
    public Window(){
     timer = new Timer((1000/RefreshRate), (ActionListener) this);
     this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
              
                
        int code = e.getKeyCode();
        

        if (code == m.UP) {
            Storage.LOCAL_STORAGE.sprites[0].spriteLocation.y-=velocity;
        }
        if (code == m.DOWN) {
             Storage.LOCAL_STORAGE.sprites[0].spriteLocation.y+=velocity;
        }
        if (code == m.RIGHT) {
             Storage.LOCAL_STORAGE.sprites[0].spriteLocation.x-=velocity;
        }
        if (code == m.LEFT) {
             Storage.LOCAL_STORAGE.sprites[0].spriteLocation.x+=velocity;
        }
            }
        });
     
     
     /*this.addMouseListener(new MouseListener() {
    @Override
    public void mouseClicked(MouseEvent e) {
         Storage.LOCAL_STORAGE.sprites[0].spriteLocation.x = e.getX();
          Storage.LOCAL_STORAGE.sprites[0].spriteLocation.y = e.getY();
        
    }
         @Override
         public void mousePressed(MouseEvent e) {
             
         }

         @Override
         public void mouseReleased(MouseEvent e) {
             
         }

         @Override
         public void mouseEntered(MouseEvent e) {
             Storage.LOCAL_STORAGE.sprites[0].spriteLocation.x = e.getX();
          Storage.LOCAL_STORAGE.sprites[0].spriteLocation.y = e.getY();
         }

         @Override
         public void mouseExited(MouseEvent e) {
          
         }
     });
*/
        
        
    }
    public void paintComponent(Graphics g){
         Graphics2D graph = (Graphics2D) g;
         g.clearRect(this.getX(),this.getY(),this.getWidth(), this.getHeight());
        Processing.drawStorage(graph, Storage.LOCAL_STORAGE);
         graph.finalize();
         this.grabFocus();
           timer.start();
    }
    
    
    
    public void actionPerformed(ActionEvent e) {
        if(Storage.LOCAL_STORAGE.sprites[0].spriteLocation.y > 500){
            Storage.LOCAL_STORAGE.sprites[0].spriteLocation.y = 0;
        }  else 
        if(Storage.LOCAL_STORAGE.sprites[0].spriteLocation.y < 0){
            Storage.LOCAL_STORAGE.sprites[0].spriteLocation.y = 499;
        }  
         if(Storage.LOCAL_STORAGE.sprites[0].spriteLocation.x > 500){
            Storage.LOCAL_STORAGE.sprites[0].spriteLocation.x = 0;
        }   else
        if(Storage.LOCAL_STORAGE.sprites[0].spriteLocation.x < 0){
            Storage.LOCAL_STORAGE.sprites[0].spriteLocation.x = 499;
        }  
       repaint();
      
    }
    
    
  //   @Override
    public void keyPressed(KeyEvent e) {
        Print.print("EEE         ");
        int code = e.getKeyCode();
        movement m = new movement();

        if (code == m.UP) {
            Storage.LOCAL_STORAGE.sprites[0].spriteLocation.y--;
        }
        if (code == m.DOWN) {
             Storage.LOCAL_STORAGE.sprites[0].spriteLocation.y++;
        }
        if (code == m.RIGHT) {
             Storage.LOCAL_STORAGE.sprites[0].spriteLocation.x++;
        }
        if (code == m.LEFT) {
             Storage.LOCAL_STORAGE.sprites[0].spriteLocation.y--;
        }

    }
    
    
    
    public static void main(String[] args){
        Print.print("Starting");
        
       

        
        
        Session s = new Session ("172.16.26.55");
        s.intiateSession(Settings.userName, Settings.password);
        String[] array = {"FetchStorage"};
        Storage.LOCAL_STORAGE = (Storage) s.executeCommand(array,null).RESPONCE_ASSETS[0];
        
        Window w = new Window();
      
        
        JFrame f = new JFrame();
        f.setSize(500, 500);
        w.setBounds(f.getBounds());
       
        f.add(w);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
        
        new Thread(new Runnable(){public void run(){
        
        while(true){
            try{Thread.sleep(100);}catch(Exception e){}
             Storage.LOCAL_STORAGE = (Storage) s.executeCommand(array,null).RESPONCE_ASSETS[0];
            
        }
        
        
        
        }}).start();
        
        
       
        
        
    }
    
    
}
