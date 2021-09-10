/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import java.util.Collection;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import labyrinthe.Salle;
import personnages.Heros;
import personnages.IPersonnage;

/**
 *
 * @author Julian
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent> {

    Heros heros;
    private Image leftSpriteImage;
    private Image upSpriteImage;
    private Image downSpriteImage;
    private Image rightSpriteImage;

    public HerosSprite(IPersonnage sprite, ILabyrinthe laby) {
        super(sprite, laby);
        chargementImages();
        spriteImg = downSpriteImage;
        heros = (Heros) sprite;
    }

    public void chargementImages() {
        leftSpriteImage = new Image("file:icons/link/LinkRunShieldL1.gif");
        upSpriteImage = new Image("file:icons/link/LinkRunU1.gif");
        downSpriteImage = new Image("file:icons/link/LinkRunShieldD1.gif");
        rightSpriteImage = new Image("file:icons/link/LinkRunR1.gif");
    }

    @Override
    public void handle(KeyEvent event) {

        switch (event.getCode()) {
            case LEFT:
                heros.salleChoisie = new Salle(sprite.getPosition().getX() - 1, sprite.getPosition().getY());
                spriteImg = leftSpriteImage;
                break;
            case RIGHT:
                heros.salleChoisie = new Salle(sprite.getPosition().getX() + 1, sprite.getPosition().getY());
                spriteImg = rightSpriteImage;
                break;
            case UP:
                heros.salleChoisie = new Salle(sprite.getPosition().getX(), sprite.getPosition().getY() - 1);
                spriteImg = upSpriteImage;
                break;
            case DOWN:
                heros.salleChoisie = new Salle(sprite.getPosition().getX(), sprite.getPosition().getY() + 1);
                spriteImg = downSpriteImage;
                break;
        }

        heros.faitSonChoix(labyrinthe);
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ISalle getPosition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPosition(ISalle s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
