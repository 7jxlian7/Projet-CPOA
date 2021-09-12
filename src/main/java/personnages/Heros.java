/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import java.util.Collection;
import labyrinthe.ISalle;
import labyrinthe.Salle;

/**
 *
 * @author Julian
 */
public class Heros extends APersonnage {
    
    public ISalle salleChoisie;
    
    public Heros(ISalle salle) {
        this.position = salle;
    }
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        
        for(ISalle sa : sallesAccessibles){
            if(sa.getX() == salleChoisie.getX() && sa.getY() == salleChoisie.getY()){
              return salleChoisie;  
            }
        }
        return this.getPosition();
        
        /*
        if(sallesAccessibles.contains(salleChoisie)){
            return salleChoisie;
        } else {
            return this.getPosition();
        }*/
    }
    
    public void setSalleChoisie(int x, int y){
        salleChoisie = new Salle(x, y);
    }
    
}
