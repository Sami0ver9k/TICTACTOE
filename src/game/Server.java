/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author u
 */
public class Server extends Game{
    private ServerSocket serverSocket;
    private  Socket  socket;
        private Connection connection;

    
    
    public Server()
    { super(Game.PLAYER_ONE);
        try {
            serverSocket =new ServerSocket(5555);
            socket= serverSocket.accept();
            connection =new Connection(this, socket);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void inputRecieved(int x, int y) {
        if(isMyTurn())
        updateField(x, y);
        
   
    
    }
    
    
    private void updateField(int x, int y){
        
        if(fields[x][y]==Game.FREE)
        {
            fields[x][y]= currentPlayer ;
            
     
        
        if(currentPlayer==Game.PLAYER_ONE)
        {
            currentPlayer=Game.PLAYER_TWO;
        }
        else if(currentPlayer==Game.PLAYER_TWO)
        {
            currentPlayer=Game.PLAYER_ONE;
        }
            
            connection.sendPakcet(new Update(fields, currentPlayer)) ;
                gameWindow.repaint();
            
            }
        int winner= checkWinner(); 
        
        if(winner !=Game.FREE)
        { showWinner(winner);
          connection.sendPakcet(new clientWinner(winner));
        }
     
        else{
        int empty =0;
        
         for(int w = 0; w <3;w++) {
          
            
           for   (int z=0;z<3;z++)
           {
               if(fields[w][z]== Game.FREE)
               {
                empty++;
                   
               }
               
               
           }
        
        
        
        
        }
         if (empty==9)
         {
              showWinner(Game.FREE);
              connection.sendPakcet(new clientWinner(winner));
         }
        
        
    }
    }
    
    private int checkWinner()
    {
        
        for( int player= Game.PLAYER_ONE; player<=Game.PLAYER_TWO;player++)
        {   for(int y = 0; y <3;y++) {
            int playerCount=0;
            
           for   (int x=0;x<3;x++)
           {
               if(fields[x][y]==player)
               {
                   playerCount++;
                   
               }
               
               
           }
           if (playerCount==3)
               return player;
            
            
            
            
            
                }   
        
        for(int x = 0; x <3;x++) {
            int playerCount=0;
            
           for   (int y=0;y<3;y++)
           {
               if(fields[x][y]==player)
               {
                   playerCount++;
                   
               }
               
               
           }
           if (playerCount==3)
               return player;
            
            
            
            
            
                }   
        
        
        
        
   
            int playerCount=0;
            
           for   (int y=0;y<3;y++)
           {
               if(fields[y][y]==player)
               {
                   playerCount++;
                   
               }
               
               
           }
           
           if (playerCount==3)
               return player;
            
            
           playerCount=0;
            
           for   (int y=0;y<3;y++)
           {
               if(fields[2-y][y]==player)
               {
                   playerCount++;
                   
               }
               
               
           }
           if (playerCount==3)
               return player;
            
            
            
   
        
        
        
        
        
        
        
        
        }
                
        
        return Game.FREE;
        
        
        
        
        
    }

    

    @Override
    public void packetRecieved(Object object) {
  
 if (object instanceof   clientUpdate)
 {
     
     clientUpdate packet=(clientUpdate) object;
     
     updateField(((clientUpdate) object).getX(), ((clientUpdate) object).getY());
 }
 gameWindow.repaint();
        
    }
    
    
    
    
    
    
    @Override
    public void close() {
        try {
            connection.close();
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
