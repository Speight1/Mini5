/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import Misc.Print;

/**
 *
 * @author mathew
 */
public class Cue {
    Thread processor = new Thread( new Runnable(){public void run(){
    
    processRequests();
    
    
    }});
    RequestHeader[] requests;
    int requestLimit;
    int requestsAmount = 0;
    public Cue(int cueLimit){
        Print.print("Cue instance created! Named \""+this.getClass().getCanonicalName()+"\".");
        requestLimit = cueLimit;
        requests = new RequestHeader[cueLimit];
        initialiseArray();
        Print.print("Starting cue master thread...");
        processor.start();    }
    
    public void printRequests(){
        for(int i = 0; i< requestsAmount; i++){
            Print.print("Request ["+i+"] - "+requests[i].IP);
            
        }
    }
    
    public void addToCue(RequestHeader toAdd){
        try{
        Print.print("Adding..");
        
        requests[requestsAmount] = toAdd;
        Print.print("Added to cue - "+requests[0].IP);
        requestsAmount++;
            Print.print("Amount of requests are now: "+requestsAmount);
        } catch(Exception e ){Print.print("Failed to add to cue. Reason "+e.getCause()); }
       
    }
    
    public void removeFromCue(int index){
        for(int i = index; i<requestsAmount-1; i++){
            requests[i] = requests [i+1];
        }
        requestsAmount--;
        
    }
    
    
    public void initialiseArray(){
        for(int i = 0; i< requestLimit; i++){
            requests[i] = null;
        }
    }
    
    public void processRequests(){
        try{
     while(true){
        // System.out.print(" C"+this.requestsAmount);
         Thread.sleep(10);
         if(requestsAmount >0){
           
             Print.print("Processing request - "+requests[0].IP);
         Security.processHeader(requests[0]);
         removeFromCue(0);
         
         }
        
     }   
        } catch(Exception e ){Print.print("Cue master broke down.");}
        
    }
    
    public static void main(String args[]){
        
        Cue c = new Cue(200);
        
        c.addToCue(new RequestHeader("10.59.0.23",0,null));
        c.addToCue(new RequestHeader("10.59.0.24",0,null));
         c.addToCue(new RequestHeader("10.59.0.25",0,null));
         Print.print("Before:");
         c.printRequests();
         c.removeFromCue(1);
         Print.print("\nAfter:");
         c.printRequests();
        
        
    }
    
    
}
