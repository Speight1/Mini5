/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Network.Network;
import Network.RequestHeader;
import Network.ResponceHeader;
import Network.Settings;

/**
 *
 * @author mathew
 */
public class Session {
    public String sessionHost = null;
    public String cookie = null;
    public boolean authenticated = false;
    public Session(String ip){
        sessionHost = ip;
    }
    
    public ResponceHeader executeCommand(String[] parameters, Object[] assets){
        try{
            
        if(authenticated){
        Network.send(sessionHost, Settings.port, new RequestHeader(Network.getIp(), RequestHeader.COMMAND, cookie, parameters, assets));
            System.out.println("Request sent");
        ResponceHeader res = Network.recieve(Settings.port);
            System.out.println("Responce captured - good job team!!");
        return res;
        }
        else{
            System.out.println("Not authenticated!");
        return null;
            
        
        }
        
        
        }
        catch(Exception e){
            System.out.println("Send Failed - host disconnected???!!!");
            
            return null;}
    }
    
    
    public boolean intiateSession(String userName, String password){
        String[] array = {userName, password};
        RequestHeader req = new RequestHeader(Network.getIp(), RequestHeader.AUTHENTICATE, array);
        try{
        Network.send(sessionHost, Settings.port, req);
        ResponceHeader  res = Network.recieve(Settings.port);
        
        if(res.RESPONCE_CODE == ResponceHeader.SUCCESSFUL){
            System.out.println(res.RESPONCE_ASSETS.getClass());
            cookie =  (String) res.RESPONCE_ASSETS[0];
           
            authenticated = true;
            return true;
        }
        else if(res.RESPONCE_CODE == ResponceHeader.FAILED){
            
            
            return false;
        }
        else{return false;}
        
        }
        catch(Exception e){
            System.out.println("Failed to connect");
        return false;
        }
    }
    
   static  double time =0;
   static boolean run = true;
    public static void main(String[] args){
        
        
        new Thread(new Runnable(){public void run(){
        try{
        while(run){
            Thread.sleep(100);
            time += 0.1;
        }
        }
        catch(Exception e){
            
        }
        
        }}).start();
        
        for(int i = 0; i<=100; i++){
        Session s = new Session("10.59.0.23");
        s.intiateSession(Settings.userName, Settings.password);
        }
        run = false;
        
        System.out.println("Time: "+time);
        
        
    }
    
    
}
