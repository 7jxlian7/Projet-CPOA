/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import java.util.Collection;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import labyrinthe.Salle;
import personnages.IPersonnage;

/**
 *
 * @author Julian
 */
public abstract class ASprite implements ISprite {
    
    IPersonnage sprite;
    ILabyrinthe labyrinthe;
    ISalle salle;
    Image spriteImg;

    public ASprite(IPersonnage sprite, ILabyrinthe laby) {
        this.labyrinthe = laby;
        this.sprite = sprite;
    }
    
    @Override
    public void dessiner(GraphicsContext g) {
        int unite = 15;
        g.drawImage(spriteImg, salle.getX()*unite, salle.getY()*unite);
    }

    @Override
    public void setCoordonnees(int xpix, int ypix) {
        salle = new Salle(xpix, ypix);
    }
}
