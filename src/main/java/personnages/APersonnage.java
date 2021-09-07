/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import labyrinthe.ISalle;

/**
 *
 * @author Julian
 */
public abstract class APersonnage implements IPersonnage {
    
    public ISalle currentPosition; 
    
    // renvoie sa position courante
    @Override
    public ISalle getPosition(){
        return currentPosition;
    }
    
    // definit sa position courante
    @Override
    public void setPosition(ISalle s){
        currentPosition = s;
    }
}
