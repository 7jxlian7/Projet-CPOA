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
public class Heros extends APersonnage{

    public ISalle salleChoisie;
    
    public Heros(ISalle salleChoisie) {
        this.salleChoisie = salleChoisie;
    }
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if(sallesAccessibles.contains(salleChoisie)){
            return salleChoisie;
        } else {
            return currentPosition;
        }
    }
}
