package vue2D.javafx;

import java.util.ArrayList;
import java.util.Collection;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import vue2D.sprites.ISprite;

/**
 * Représente le dessin
 *
 * @author INFO Professors team
 */
public class Dessin extends Canvas {

    private Collection<ISprite> sprites;
    private ILabyrinthe labyrinthe;
    private int unite = 15;
    private int porteeVue = 10;
    private GraphicsContext tampon;
    private Image solImage;
    private Image salleImage;
    private Image sortieImage;
    private Image entreeImage;
    private Color yellow = new Color(1, 0.9, 0.5, 0.4);
    private Collection<ISalle> listeSalles = new ArrayList<ISalle>();
    private ISalle positionActuelle;

    /**
     * Construit un dessin
     *
     * @param labyrinthe le labyrinthe du jeu
     * @param sprites les sprites du jeu
     */
    public Dessin(ILabyrinthe labyrinthe, Collection<ISprite> sprites) {
        this.sprites = sprites;
        this.labyrinthe = labyrinthe;
        this.positionActuelle = labyrinthe.getEntree();
        setWidth(labyrinthe.getLargeur() * unite);
        setHeight(labyrinthe.getHauteur() * unite);
        tampon = this.getGraphicsContext2D();
        chargementImages();
    }

    /**
     * Charge les images du jeu
     */
    public void chargementImages() {
        solImage = new Image("file:icons/pyramide.jpg");
        sortieImage = new Image("file:icons/sortie.gif");
        entreeImage = new Image("file:icons/groundP.gif");
        salleImage = new Image("file:icons/ground.gif");
    }

    /**
     * Dessine le fond du labyrinthe (murs, salles, entrée et sortie)
     */
    public void dessinFond() {
        tampon.drawImage(solImage, 0, 0, unite * labyrinthe.getLargeur(),
                unite * labyrinthe.getHauteur());
    }

    public void dessinSalles() {
        // Dessine les salles
        ISprite heros = (ISprite) sprites.toArray()[0];
        for (ISalle salle : labyrinthe) {
            if (labyrinthe.distanceGraphe(salle, heros.getPosition()) < porteeVue) {
                tampon.drawImage(salleImage, salle.getX() * unite, salle.getY() * unite);
            }
        };

        // Dessine l'entree
        ISalle entree = labyrinthe.getEntree();
        tampon.drawImage(entreeImage, entree.getX() * unite, entree.getY() * unite);

        // Dessine la sortie
        ISalle sortie = labyrinthe.getSortie();
        tampon.drawImage(sortieImage, sortie.getX() * unite, sortie.getY() * unite);
    }

    public void dessinPlusCourtChemin(ISprite heros) {
        // Si mon héros bouge, je recalcule le chemin le plus court entre sa position et la sortie
        if (!heros.getPosition().equals(positionActuelle)) {
            positionActuelle = heros.getPosition();
            listeSalles = this.labyrinthe.chemin(heros.faitSonChoix(labyrinthe), labyrinthe.getSortie());
        }
        // Je dessine le chemin le plus court
        tampon.setFill(yellow);
        for (ISalle s : listeSalles) {
            tampon.fillRect(s.getX() * unite, s.getY() * unite, unite, unite);
        }
    }
}
