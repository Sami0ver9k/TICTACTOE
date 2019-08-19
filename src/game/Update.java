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
public class Update implements  Serializable{
 
    private int[][] fields;
    private int currentPlayer;
    
    public Update(int [][] fields,int currentPlayer)
    {
        this.fields=fields;
        this.currentPlayer=currentPlayer;
    }

    public int[][] getFields() {
        return fields;
    }

    public void setFields(int[][] fields) {
        this.fields = fields;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    
    
    
    
    
    
}
