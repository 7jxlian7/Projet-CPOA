/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe;

import java.util.Objects;
import labyrinthe.ISalle;

/**
 *
 * @author jforme
 */
public class Salle implements ISalle {

    public int x;
    public int y;

    public Salle(int x, int y) {
        this.x = x;
        this.y = y;
    }

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
