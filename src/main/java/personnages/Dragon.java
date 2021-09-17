/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import java.util.Collection;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;

/**
 * Représente un dragon
 * @author Julian
 */
public class Dragon extends APersonnage {

    ILabyrinthe labyrinthe;
    IPersonnage herosSuivi;

    /**
     * Construit un dragon
     *
     * @param salle salle de départ du dragon
     * @param labyrinthe le labyrinthe du jeu
     * @param heros le heros à suivre
     */
    public Dragon(ISalle salle, ILabyrinthe labyrinthe, IPersonnage heros) {
        this.position = salle;
        this.labyrinthe = labyrinthe;
        this.herosSuivi = heros;
    }

    /**
     * Retourne la salle adjacente menant vers le chemin le plus court pour atteindre le heros
     * @param sallesAccessibles liste des salles auxquelles le dragon peut accéder
     * @return la salle adjacente la plus proche pour atteindre le personnage
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        Collection<ISalle> chemin = labyrinthe.chemin(this.getPosition(), herosSuivi.getPosition());
        ISalle s = (ISalle) chemin.toArray()[1];
        return s;
    }

}
