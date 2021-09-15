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
 * Représente le sprite d'un monstre
 * @author Julian
 */
public class MonstreSprite extends ASprite {

    /**
     * Construit le sprite d'un monstre
     * @param sprite le sprite
     * @param laby le labyrinthe associé
     */
    public MonstreSprite(IPersonnage sprite, ILabyrinthe laby) {
        super(sprite, laby);
        spriteImg = new Image("file:icons/monstre0.gif");
    }
}
