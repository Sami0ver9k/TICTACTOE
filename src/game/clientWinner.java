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
public class clientWinner implements  Serializable{
    
    
    int winner;

    public clientWinner(int winner) {
        this.winner=winner;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }
    
    
    
    
    
    
    
}
