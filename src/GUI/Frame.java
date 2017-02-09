/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Items.Storage;

/**
 *
 * @author 160471
 */
public class Frame {
 
    public Frame(Storage currentStorage){
        System.out.println("Num: "+currentStorage.numberOfSprites);
         Storage  s = currentStorage;
        currentStorage.numberOfSprites =5;
       
        System.out.println("New num"+s.numberOfSprites);
    }    
    
    
    
    public static void main(String[] args){
        
        Storage.LOCAL_STORAGE = new Storage(500);
        Frame f = new Frame(Storage.LOCAL_STORAGE); 
    }
    
}
