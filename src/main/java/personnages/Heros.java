/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
 * Représente un héros
 * @author Julian
 */
public class Heros extends APersonnage {
    
    public ISalle salleChoisie;
    
    /**
     * Construit un héros
     * @param salle salle de départ du héros
     */
    public Heros(ISalle salle) {
        this.position = salle;
    }
    
    /**
     * Retourne une salle selon le choix du personnage
     * @param sallesAccessibles liste des salles auxquelles le personnage peut accéder
     * @return la salle choisie par le personnage si elle est accessible, sinon sa position courante
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if(sallesAccessibles.contains(salleChoisie)){
            return salleChoisie;
        } else {
            return this.getPosition();
        }
    }
}
