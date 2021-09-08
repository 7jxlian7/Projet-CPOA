/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

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
    Image spriteImg;

    public ASprite(IPersonnage sprite, ILabyrinthe laby) {
        this.labyrinthe = laby;
        this.sprite = sprite;
    }
    
    @Override
    public void dessiner(GraphicsContext g) {
        int unite = 15;
        g.drawImage(spriteImg, sprite.getPosition().getX()*unite, sprite.getPosition().getY()*unite);
    }

    @Override
    public void setCoordonnees(int xpix, int ypix) {
        sprite.setPosition(new Salle(xpix, ypix));
    }
    
}
