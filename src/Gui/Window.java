/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import game.Game;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author u
 */
public class Window extends JFrame {
    public static int game_width=0;
    public static int game_height=0;
    private Game game;

    public Window(Game game ,String title, int height,int width) {
        
        //super(title);
        setTitle(title);
        setSize(width, height);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        game_height=height/3;
        game_width=width/3;
        this.game=game;
        addWindowListener(new Listener());
        
        
        
    }
    
    
    
    public class Listener extends WindowAdapter {
    
    
    public void windowClosing (WindowEvent e)
    {
        
        game.close();
        
        
    }
    
    
    
}
    
    
    
}
