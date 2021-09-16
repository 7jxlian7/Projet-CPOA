/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import personnages.IPersonnage;

/**
 * Représente le sprite d'un dragon
 * @author Julian
 */
public class DragonSprite extends ASprite {
    
    /**
     * Construit le sprite d'un dragon
     * @param sprite le sprite
     * @param laby le labyrinthe associé
     */
    public DragonSprite(IPersonnage sprite, ILabyrinthe laby) {
        super(sprite, laby);
        spriteImg = new Image("file:icons/monstre1.gif");
    }
}