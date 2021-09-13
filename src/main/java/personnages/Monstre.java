/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import java.util.Collection;
import java.util.Random;
import labyrinthe.ISalle;

/**
 *
 * @author Julian
 */
public class Monstre extends APersonnage {

    Random random = new Random();
    
    public Monstre(ISalle salle) {
       this.position = salle;
    }
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return (ISalle) sallesAccessibles.toArray()[random.nextInt(sallesAccessibles.size())];
    }
}
