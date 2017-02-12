/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

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
        System.out.println("Cue instance created!");
        requestLimit = cueLimit;
        requests = new RequestHeader[cueLimit];
        initialiseArray();
        System.out.println("Starting cue master thread...");
        processor.start();    }
    
    public void printRequests(){
        for(int i = 0; i< requestsAmount; i++){
            System.out.println("Request ["+i+"] - "+requests[i].IP);
            
        }
    }
    
    public void addToCue(RequestHeader toAdd){
        try{
        System.out.println("Adding..");
        System.out.println("Adding to cue - "+requests[0].IP);
        requests[requestsAmount] = toAdd;
        requestsAmount++;
        } catch(Exception e ){System.out.println("Failed to add to cue. Reason "+e.getMessage()); }
       
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
     while(true){
         if(requestsAmount >0){
             System.out.println("Processing request - "+requests[0].IP);
         Security.processHeader(requests[0]);
         this.removeFromCue(0);
         }
     }   
        
    }
    
    public static void main(String args[]){
        
        Cue c = new Cue(200);
        
        c.addToCue(new RequestHeader("10.59.0.23",0,null));
        c.addToCue(new RequestHeader("10.59.0.24",0,null));
         c.addToCue(new RequestHeader("10.59.0.25",0,null));
         System.out.println("Before:");
         c.printRequests();
         c.removeFromCue(1);
         System.out.println("\nAfter:");
         c.printRequests();
        
        
    }
    
    
}
