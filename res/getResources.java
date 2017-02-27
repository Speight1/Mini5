
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matthew
 */
public class getResources {
    static getResources gr = new getResources();
    
    public static BufferedImage getImage(String filename) throws IOException{ // Takes in filename
        URL url = gr.getClass().getResource("imgs\\"+filename); 
        BufferedImage img = ImageIO.read(url); // Loads Image
        return img; // Returns Image
    }
    
}
