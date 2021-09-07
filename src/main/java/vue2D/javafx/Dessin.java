package vue2D.javafx;

import java.util.Collection;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import personnages.IPersonnage;
import vue2D.sprites.ISprite;

/**
 *
 * @author INFO Professors team
 */
public class Dessin extends Canvas {

    private Collection<ISprite> sprites;
    private ILabyrinthe labyrinthe;
    private int unite = 15;
    private GraphicsContext tampon;
    private Image solImage;
    private Image salleImage;
    private Image sortieImage;
    private Image entreeImage;
    private Image murImage;

    public Dessin(ILabyrinthe labyrinthe, Collection<ISprite> sprites) {
        this.sprites = sprites;
        this.labyrinthe = labyrinthe;
        setWidth(labyrinthe.getLargeur() * unite);
        setHeight(labyrinthe.getHauteur() * unite);
        tampon = this.getGraphicsContext2D();
        chargementImages();
        dessinFond();
    }

    public void chargementImages() {
        solImage = new Image("file:icons/pyramide.jpg");
        sortieImage = new Image("file:icons/sortie.gif");
        entreeImage = new Image("file:icons/groundP.gif");
        salleImage = new Image("file:icons/ground.gif");
        murImage = new Image("file:icons/mur0.gif");
    }

    public void dessinFond() {
        tampon.drawImage(solImage, 0, 0, unite * labyrinthe.getLargeur(),
                unite * labyrinthe.getHauteur());

        // Dessine les murs (partout pour le moment)
        for (int i = 0; i < labyrinthe.getLargeur(); i++) {
            for (int j = 0; j < labyrinthe.getHauteur(); j++) {
                tampon.drawImage(murImage, i * unite, j * unite);
            }
        }

        // Dessine les salles
        for (ISalle salle : labyrinthe) {
            tampon.drawImage(salleImage, salle.getX() * unite, salle.getY() * unite);
        };

        // Dessine l'entree
        ISalle entree = labyrinthe.getEntree();
        tampon.drawImage(entreeImage, entree.getX() * unite, entree.getY() * unite);
        
        // Dessine la sortie
        ISalle sortie = labyrinthe.getSortie();
        tampon.drawImage(sortieImage, sortie.getX() * unite, sortie.getY() * unite);
    }
}
