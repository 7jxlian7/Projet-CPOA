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

    public HerosSprite(IPersonnage sprite, ILabyrinthe laby) {
        super(sprite, laby);
        spriteImg = new Image("file:icons/link/LinkRunShieldD1.gif");
    }

    @Override
    public void handle(KeyEvent event) {
        ISalle salle;

        switch (event.getCode()) {
            case LEFT:
                sprite.setPosition(new Salle(sprite.getPosition().getX() - 1, sprite.getPosition().getY()));
                salle = sprite.faitSonChoix(labyrinthe);
                System.out.println(sprite.getPosition().getX());
                sprite.setPosition(salle);
                break;
            case RIGHT:
                sprite.setPosition(new Salle(sprite.getPosition().getX() + 1, sprite.getPosition().getY()));
                salle = sprite.faitSonChoix(labyrinthe);
                System.out.println(sprite.getPosition().getX());
                sprite.setPosition(salle);
                break;
            case UP:
                sprite.setPosition(new Salle(sprite.getPosition().getX(), sprite.getPosition().getY() - 1));
                salle = sprite.faitSonChoix(labyrinthe);
                System.out.println(sprite.getPosition().getX());
                sprite.setPosition(salle);
                break;
            case DOWN:
                sprite.setPosition(new Salle(sprite.getPosition().getX(), sprite.getPosition().getY() + 1));
                salle = sprite.faitSonChoix(labyrinthe);
                System.out.println(sprite.getPosition().getX());
                sprite.setPosition(salle);
                break;
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
