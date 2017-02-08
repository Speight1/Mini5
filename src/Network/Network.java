package Network;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathew
 */
public class Network {

    ObjectInputStream in;
    ServerSocket inSocket;

    public void startNetwork(int port) {
        new Thread(new Runnable() {
            public void run() {
             
                    while(true){
                    in = getInputStream(port);
                
                    processInput(in);
                    cleanUp();
                   
                    
                    }
                
                
            }
        }).start();
    }
    
    private void cleanUp(){
        try{
        in.close();
        inSocket.close();
            //System.out.println("Cleaned up!!");
        } catch(Exception e ){System.out.println("Cleanup failed");}
        
    }
    
    private ObjectInputStream getInputStream(int port){
        try{
                    inSocket = new ServerSocket(port, 10);
                    System.out.println("Attempting to open on " + inSocket.getLocalPort());
                    Socket s = inSocket.accept();
                    System.out.println("incoming!");
                    return new ObjectInputStream(s.getInputStream());
        }
        catch(Exception e ){ System.out.println("Failed to get input stream.");
        return null;
        }

                    
    }
    
    private void processInput(ObjectInputStream inp) {
        try{
        
        Object recieved = new Object[500];
        Object current;
        
            recieved = in.readObject();

       
        
        if(recieved.getClass().equals(RequestHeader.class)){
            RequestHeader h = (RequestHeader) recieved;
            System.out.println("New Responce from "+h.IP+"\nRequest code: "+h.REQUEST_TYPE);
            Security.processHeader(h);
            
            
        }
        
        }
        
        catch(Exception e){
            
            System.out.println("Failed to process input");
        }
    }
    public static ResponceHeader recieve(int port){
        try{
        ServerSocket sock = new ServerSocket(port);
        ObjectInputStream inp = new ObjectInputStream(sock.accept().getInputStream());
        ResponceHeader recieved = (ResponceHeader) inp.readObject();
        inp.close(); sock.close();
        System.out.println("Recieved a responce");
        return recieved;
        }
        catch(Exception e){
            System.out.println(e);
        return null;
        }
    }
    
    public static void sendFailedResponce(RequestHeader h, Object[] returnObjects){
        try{
       Network.send(h.IP, Settings.port, new ResponceHeader(ResponceHeader.FAILED, returnObjects));} catch(Exception e){System.out.println("Failed to send responce.");}
        
    }
    
     public static void sendSuccessfulResponce(RequestHeader h, Object[] returnObjects){
        try{
       Network.send(h.IP, Settings.port, new ResponceHeader(ResponceHeader.SUCCESSFUL, returnObjects));} catch(Exception e){System.out.println("Failed to send responce.");}
        
    }
    
    
    public static void send(String ip, int port, Object toSend) throws IOException
    {
      
        Socket socket = new Socket(ip, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        
       
           out.writeObject(toSend);
           
       
       out.close();
       socket.close();
        System.out.println("Done!");
       
        
    }
    public Network(int port) throws IOException {

        startNetwork(port);

    }

    public static String getIp(){
        try{
        return InetAddress.getLocalHost().getHostAddress();
           // return "10.59.0.23";
        }
        catch(Exception e){
            return null;
        }
    }
    
    
    
    public static void main(String[] args) throws IOException {
       
       // String[] s = {Settings.userName,Settings.password,"am"};
        //Network.send("localhost", Settings.port,s );
        
       //Network.send("localhost", Settings.port, new RequestHeader("localhost", RequestHeader.AUTHENTICATE, s) );
       
        System.out.println(getIp());
    }

}
