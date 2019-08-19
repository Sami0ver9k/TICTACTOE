/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;

/**
 *
 * @author u
 */
public class clientUpdate implements Serializable{
    
    int x;
    int y;

    public clientUpdate(int x, int y) {
    this.x=x;
    this.y=y;
    
    
    
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
        
    
    
    
}
