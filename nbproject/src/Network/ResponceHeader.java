/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.Serializable;

/**            
 *
 * @author mathew
 */
public class ResponceHeader implements Serializable{
    public static int FAILED = 0;
    public static int SUCCESSFUL = 1;
    
    public int RESPONCE_CODE;
    
    public Object[] RESPONCE_ASSETS;
    
    public ResponceHeader(int responceCode, Object[] responceAssets){
        RESPONCE_CODE = responceCode; 
        RESPONCE_ASSETS = responceAssets;
    }
}
