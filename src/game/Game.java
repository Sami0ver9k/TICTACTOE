/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import Gui.GameWindow;
import Gui.Window;
import javax.swing.JOptionPane;

/**
 *
 * @author u
 */
public abstract class Game  {
    
   private  Window window;
   protected GameWindow gameWindow; 
   protected int [][] fields;
   public static final int  FREE=0, PLAYER_ONE=1,PLAYER_TWO=2;
   protected int currentPlayer;
   protected int nextPlayer;

    public Game(int player) {
        this.nextPlayer=player;
        String a = "player " + player;
        window= new Window(this,a, 800, 800);
        gameWindow= new GameWindow(this);
      
        fields=new int[3][3];
      
          window.add(gameWindow);
          window.setVisible(true);
          currentPlayer=Game.PLAYER_ONE;
        
    }
 
    
    public void showWinner(int winner){
        if(winner== Game.FREE)
            JOptionPane.showMessageDialog(null, "tie");
     
        else
         JOptionPane.showMessageDialog(null, "the player  "+ winner + " has won");
        
        
    } 
    
    
    public  int getFields (int x,int y){
        
        return fields[x][y];
    }
    
    
    protected boolean isMyTurn()
    { if(nextPlayer==currentPlayer)
    {
        return true;
    }
    return false;
        
    }
    
    
    
    
    
     public abstract void inputRecieved(int x, int y);
       public abstract void close();
    public abstract void packetRecieved(Object object);
    
} 
