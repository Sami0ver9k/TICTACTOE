/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.rmi.ServerException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author u
 * 
 * 
 * 
 */
public class Connection implements Runnable{
    
     private Socket socket;
    private ObjectOutputStream outStream;
    private ObjectInputStream inputStream;
    private boolean  running;
    private Game game;
    public Connection(Game game,Socket socket) 
    {    this.game=game;
        
         try {
             outStream=new ObjectOutputStream( socket.getOutputStream()  );
              inputStream= new  ObjectInputStream( socket.getInputStream());
         } catch (IOException ex) {
             Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
         }
       
        new Thread(this).start();
        
    }
    
    
     @Override
    public void run() {
         running=true;
        while(running){
            
             try {
                 Object object= inputStream.readObject();
                 game.packetRecieved(object);
                 
             } catch (IOException  ex) {
                 running=false;
                 Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
             } 
            
            
        }
        
    }
    
    public  void sendPakcet(Object object){
        
        try {
            outStream.reset();
            outStream.writeObject(object);
            outStream.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    public void close ( ) throws IOException
    {
        running =false;
        inputStream.close();
        outStream.close();
    }
   
    
    
}
