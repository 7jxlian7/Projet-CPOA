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

    public HerosSprite(IPersonnage sprite, ILabyrinthe laby) {
        super(sprite, laby);
        spriteImg = new Image("file:icons/link/LinkRushShield1.gif");
        heros = new Heros(sprite.getPosition());
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case LEFT:
                heros.setSalleChoisie(new Salle(heros.getPosition().getX() - 1, heros.getPosition().getY()));
                break;
            case RIGHT:
                heros.setSalleChoisie(new Salle(heros.getPosition().getX() + 1, heros.getPosition().getY()));
                break;
            case UP:
                heros.setSalleChoisie(new Salle(heros.getPosition().getX(), heros.getPosition().getY()-1));
                break;
            case DOWN:
                heros.setSalleChoisie(new Salle(heros.getPosition().getX(), heros.getPosition().getY()+1));
        }
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
