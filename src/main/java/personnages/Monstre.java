/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import labyrinthe.ISalle;

/**
 *
 * @author Julian
 */
public class Monstre extends APersonnage {

    Random random = new Random();
    
    public Monstre(ISalle salleChoisie) {
       // this.salleChoisie = salleChoisie;
    }
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        ArrayList<ISalle> sallesPossibles = new ArrayList<>();
        for(ISalle salle : sallesAccessibles){
            /*if(salle.estAdjacente(salleChoisie)){
                sallesPossibles.add(salle);
            }*/
        }
        return sallesPossibles.get(random.nextInt(sallesAccessibles.size()));
    }
}
