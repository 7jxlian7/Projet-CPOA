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
import personnages.IPersonnage;

/**
 *
 * @author Julian
 */
public abstract class ASprite implements ISprite {

    public IPersonnage sprite;
    public ILabyrinthe labyrinthe;
    public Image spriteImg;

    public int unite = 15;
    int x = 0;
    int y = 0;

    public ASprite(IPersonnage sprite, ILabyrinthe laby) {
        this.labyrinthe = laby;
        this.sprite = sprite;
        x = sprite.getPosition().getX() * unite;
        y = sprite.getPosition().getY() * unite;
    }

    @Override
    public void dessiner(GraphicsContext g) {
        g.drawImage(spriteImg, x, y - (spriteImg.getHeight() / 2));
    }

    @Override
    public void setCoordonnees(int xpix, int ypix) {
        x += xpix;
        y += ypix;
    }

    @Override
    public ISalle getPosition() {
        return sprite.getPosition();
    }

    @Override
    public void setPosition(ISalle s) {
        sprite.setPosition(s);
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return sprite.faitSonChoix(sallesAccessibles);
    }
}
