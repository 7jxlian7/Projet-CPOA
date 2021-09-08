/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
 *
 * @author Julian
 */
public class Heros extends APersonnage {
    
    ISalle currentPosition;
    
    public Heros(ISalle salleChoisie) {
        this.currentPosition = salleChoisie;
        this.salleChoisie = salleChoisie;
    }
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if(sallesAccessibles.contains(salleChoisie)){
            currentPosition = salleChoisie;
            return salleChoisie;
        } else {
            return currentPosition;
        }
    }
    
    public void setSalleChoisie(ISalle salleChoisie){
        this.salleChoisie = salleChoisie;
    }
}
