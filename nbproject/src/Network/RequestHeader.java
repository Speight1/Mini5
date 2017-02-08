/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.io.Serializable;

/**
 *
 * @author mathew
 */
public class RequestHeader implements Serializable{
    final public static int AUTHENTICATE = 0; 
    final public static int COMMAND = 1; 
    final public static int UPDATE = 2; 
    //0 - authenticate
    //1 - command
    //2 - update    
    String IP;
    public int REQUEST_TYPE;
    public String COOKIE =null;
    public String[] PARAMETERS = null;
    public Object[] ASSETS = null;
    public RequestHeader(String ip, int requestType, String cookie, String[] parameters, Object[] assets){
    IP = ip;
    REQUEST_TYPE = requestType;
    COOKIE = cookie;
    PARAMETERS = parameters;
    ASSETS = assets;
        
    }
    public RequestHeader(String ip, int requestType, String[] parameters){
    IP = ip;
    REQUEST_TYPE = requestType;
    PARAMETERS = parameters; 
                
    }
    
    
}
