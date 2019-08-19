/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

 
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author u
 */
public class Resources {
    
    public static BufferedImage[] letters;
    
    static{
        
        letters =new BufferedImage[2];
        letters[0]=loadImage("/res/o.png");
        letters[1]=loadImage("/res/x.png");
        
        
        
        
    }
    
    
    public static BufferedImage loadImage(String path)
    {
        try {
            
            return ImageIO.read(Class.class.getResource(path));
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        return null;
    }
    
    
    
}
