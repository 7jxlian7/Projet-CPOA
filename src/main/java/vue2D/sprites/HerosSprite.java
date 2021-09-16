package vue2D.sprites;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import personnages.Heros;
import personnages.IPersonnage;

/**
 * Représente le sprite d'un héros
 *
 * @author Julian
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent> {

    private Heros heros;
    private Image leftSpriteImage;
    private Image upSpriteImage;
    private Image downSpriteImage;
    private Image rightSpriteImage;

    /**
     * Construit le sprite d'un héros
     *
     * @param sprite le sprite
     * @param laby le labyrinthe associé
     */
    public HerosSprite(IPersonnage sprite, ILabyrinthe laby) {
        super(sprite, laby);
        chargementImagesSprite();
        spriteImg = downSpriteImage;
        heros = (Heros) sprite;
        vitesse = 1;
    }

    /**
     * Charge les images liées au sprite
     */
    public final void chargementImagesSprite() {
        leftSpriteImage = new Image("file:icons/link/LinkRunShieldL1.gif");
        upSpriteImage = new Image("file:icons/link/LinkRunU1.gif");
        downSpriteImage = new Image("file:icons/link/LinkRunShieldD1.gif");
        rightSpriteImage = new Image("file:icons/link/LinkRunR1.gif");
    }

    /**
     * Renvoie la salle choisie par la personnage en fonction des actions du
     * clavier
     *
     * @param event evènement du clavier
     */
    @Override
    public void handle(KeyEvent event) {

        if (!this.seDeplace) {

            int xPos = heros.getPosition().getX();
            int yPos = heros.getPosition().getY();

            switch (event.getCode()) {
                case LEFT:
                    xPos--;
                    spriteImg = leftSpriteImage;
                    break;
                case RIGHT:
                    xPos++;
                    spriteImg = rightSpriteImage;
                    break;
                case UP:
                    yPos--;
                    spriteImg = upSpriteImage;
                    break;
                case DOWN:
                    yPos++;
                    spriteImg = downSpriteImage;
                    break;
            }

            for (ISalle salle : labyrinthe.sallesAccessibles(heros)) {
                if (salle.getX() == xPos && salle.getY() == yPos) {
                    heros.salleChoisie = salle;
                }
            }
        }
    }
}
