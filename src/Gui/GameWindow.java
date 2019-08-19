/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import game.Game;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author u
 */
public class GameWindow extends JPanel{
    
    private Game game;
    public GameWindow(Game game ) {
      
       
      this.game=game;
       addMouseListener(new Input_());
    }
    
    
    @Override
        public void paint(Graphics g)
    {
        
        super.paint(g);
        Graphics2D g2D= (Graphics2D) g;
        g2D.setStroke(new BasicStroke(10));
        g.drawLine(WIDTH, WIDTH, WIDTH, WIDTH);
        
        for(int i=Window.game_width; i<=Window.game_width *2;i=i+Window.game_width )
        {
            g2D.drawLine(i, 0, i,800);
            
        }
        
         for(int i=Window.game_width; i<=Window.game_width *2;i=i+Window.game_width )
        {
               g2D.drawLine(0, i, 800,i);
        }
        
        int field;
         for (int x=0;x<3;x++)
         {
             for(int y=0;y<3;y++)
             {
                 
             field=game.getFields(x, y);
                       if(field !=0)  
                 g2D.drawImage(Resources.letters[field-1],x*Window.game_width,y*Window.game_height,Window.game_width,Window.game_height,null);
                 
                 
                 
             }
             
             
             
         }
         
      
        
    }

   
        
        
     class Input_ extends MouseAdapter {
             
             @Override
             public void mousePressed(MouseEvent e){
                 
                 if(e.getButton()==  MouseEvent.BUTTON1)
                 {
                 
                 game.inputRecieved(e.getX() /Window.game_width,e.getY()/ Window.game_height);
                 
                 }
                 
                 
             }
             
         }
    
    
    
}
