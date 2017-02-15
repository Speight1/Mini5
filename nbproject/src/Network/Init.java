/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

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
           Print.print("Starting on: "+Network.getIp());
            Network n = new Network(Settings.port);
            Print.print("Started");
        } catch (Exception e) {
            Print.print("Catched");
        }
    }
    
}
