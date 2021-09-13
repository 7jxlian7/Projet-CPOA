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
        /*
        // Retourne les 8 cases adjacentes
        if(this.x <= autre.getX() + 1 && this.x >= autre.getX() - 1 && this.y <= autre.getY() + 1 && this.y >= autre.getY() - 1){
            return true;
        } else {
            return false;
        }*/

        // Retourne les 4 cases adjacentes
        return (this.x == autre.getX() + 1 && this.y == autre.getY()) || (this.x == autre.getX() - 1 && this.y == autre.getY()) || (this.x == autre.getX() && this.y == autre.getY() + 1) || (this.x == autre.getX() && this.y == autre.getY() - 1);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.x;
        hash = 53 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salle other = (Salle) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
}
