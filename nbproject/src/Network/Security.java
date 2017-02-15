/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.util.Random;

/**
 *
 * @author mathew
 */
public class Security {
    private static String[] AUTHENTICATED = new String[100];
    private static int amountAuthenticated = 0;
    public static void processHeader(RequestHeader h){
        
        switch(h.REQUEST_TYPE){
            case RequestHeader.AUTHENTICATE:
                processNewSession(h);
                break;
                
            case RequestHeader.COMMAND:
                if(cookieIsValid(h.COOKIE)){
                    Tools.parseCommand(h);
                }
                else{
                    
                }
                break;
        }
        
        
    
        
        
    }
    
    
    
    
    private static boolean cookieIsValid(String cookie){
        for(int i = 0; i<amountAuthenticated; i++){
            if(AUTHENTICATED[i].equals(cookie)) return true;
            
        }
        
        return false;
    }
    
    private static void processNewSession(RequestHeader h){
        Print.print("Authenticating...");
                if(authenticate(h.PARAMETERS[0],h.PARAMETERS[1])){
                    Object[] assets = new Object[1];
                    assets[0] = genCookie(Settings.cookieLength);
                    
                    try{
                    Thread.sleep(100);
                    Network.send(h.IP, Settings.port, new ResponceHeader(ResponceHeader.SUCCESSFUL,assets));
                    
                    }
                    catch(Exception e){
                        Print.print("Failed to send back");
                    }
                    
                }
                else{
                    try{
                    Network.send(h.IP, Settings.port, new ResponceHeader(ResponceHeader.FAILED,null)); 
                    }
                    catch(Exception e){Print.print("Thief!");}
                }
        
    }
    
    private static boolean authenticate(String username, String password){
        
        if(username.equalsIgnoreCase(Settings.userName)&&password.equals(Settings.password)){
        return true;
        
    }
        else{
            return false;
        }
        
    }
    
    private static String genCookie(int length){
       
        String str = "";
        String seed = "qwertyuiopasdfghjk1234567890QWERTYUIOPASDFGHJKLZXCVBNM";
        for(int i =0; i<length;i++){
            str += seed.charAt(new Random().nextInt(seed.length()));
            
        }
        Print.print("New Cookie "+str);
        AUTHENTICATED[amountAuthenticated] = str;
        amountAuthenticated++;
        return str;
    }
    
} 
