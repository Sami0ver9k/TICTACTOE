package game;


import Gui.GameWindow;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import java.awt.Graphics;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author u
 */
public class Main {
    
    public static void main(String[] args){
        
  int choice= Integer.parseInt(JOptionPane.showInputDialog("1 for bot 2 fopr human opponent"));
  if (choice==1)
      new Server();
  
     if (choice==2)
         new  Client();
             
        
        
        
        
    }
    
 
    
    
    
    
    
}
