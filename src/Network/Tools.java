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
    
    
    
    
    
    public static void parseCommand(RequestHeader head){
        System.out.println("Parsing Command \""+head.PARAMETERS[0]+"\"");
        String utility = head.PARAMETERS[0].toLowerCase();
        switch(utility){
           
            case "MoveSprite":
                
                break;
            
            case "CreateSprite":
                
                break;
            
            
        }
        
        
        
        
        
    }
    
    public static void main(String[] args){
        String[] command = {"shell","explorer.exe"};
        Tools.parseCommand(new RequestHeader(null, 1, command));
    }
}
