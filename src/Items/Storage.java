/*
This class stores all of the games sprites and any other object types that we decide to add in.

For the server - The static variable will be used to keep a running tally of how many sprites there are and where there positions are
This will be used by the server to allocate all of the clients the positions of the sprites when the clients request them.
 */
package Items;

/**
 *
 * @author Computing Admin
 */
public class Storage {
    //Local storage container where the client's or server's version of the storage is stored
    public static Storage LOCAL_STORAGE;
    //For Storage Object
    public int numberOfSprites =0;
    Sprite[] sprites;
    
    public Storage(int spriteLimit){
        sprites = new Sprite[spriteLimit];
    }
    
    public void addNewSprite(Sprite spriteToAdd){
        sprites[numberOfSprites] = spriteToAdd;
        numberOfSprites++;
    }
    
    public static void main(String[] args){
        //How to create a new sotrage container
        int spriteLimit= 50;
        Storage.LOCAL_STORAGE = new Storage(spriteLimit);
        
        //adding a sprite to the container
        Sprite s1 = new Sprite(5,3); // create a new sprite
        LOCAL_STORAGE.addNewSprite(s1); // add it through the new container created earlier
    }
   
}
