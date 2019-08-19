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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author u
 */
public class Client  extends Game{

    private Socket socket;
    private ObjectOutputStream outStream;
    private ObjectInputStream inputStream;
    private Connection connection;
    
    public Client()
    {  super(Game.PLAYER_TWO);
        try {
            socket=new Socket("localhost",5555);
            connection=new Connection(this, socket);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    
    
    
    
    @Override
    public void inputRecieved(int x, int y) {
      if(isMyTurn())
connection.sendPakcet(new clientUpdate(x, y));
        
        
        
    }

    @Override
    public void close() {
        try {
            connection.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void packetRecieved(Object object) {
        Update packet= (Update) object;
        if (object instanceof  Update)
        {
            fields=packet.getFields();
            currentPlayer=packet.getCurrentPlayer();
        }
        else if (object instanceof clientWinner){
            clientWinner winner=(clientWinner) object;
             showWinner(winner.getWinner());
            
        }
        
        gameWindow.repaint();
        
    }
    
    
    
    
    
    
}
