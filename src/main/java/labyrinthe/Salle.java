/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe;

import labyrinthe.ISalle;

/**
 *
 * @author jforme
 */
public class Salle implements ISalle{
    
    private int x;
    private int y;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public boolean estAdjacente(ISalle autre) {
        return false;
    }
    
}
