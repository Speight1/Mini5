/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import Items.Storage;
import Network.Network;

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
           System.out.println("Starting on: "+Network.getIp());
           
            Storage.LOCAL_STORAGE = new Storage(Settings.spriteLimit);
            Network n = new Network(Settings.port);
            
            System.out.println("Started");
        } catch (Exception e) {
            System.out.println("Catched");
        }
    }
    
}
