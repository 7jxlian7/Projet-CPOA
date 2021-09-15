package vue2D.javafx;

import java.util.Collection;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import vue2D.sprites.ISprite;

/**
 * Représente le dessin
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

    /**
     * Construit un dessin
     * @param labyrinthe le labyrinthe du jeu
     * @param sprites les sprites du jeu
     */
    public Dessin(ILabyrinthe labyrinthe, Collection<ISprite> sprites) {
        this.sprites = sprites;
        this.labyrinthe = labyrinthe;
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
        murImage = new Image("file:icons/mur0.gif");
    }

    /**
     * Dessine le fond du labyrinthe (murs, salles, entrée et sortie)
     */
    public void dessinFond() {        
        tampon.drawImage(solImage, 0, 0, unite * labyrinthe.getLargeur(),
                unite * labyrinthe.getHauteur());

        // Dessine les murs (partout pour le moment)
        /*for (int i = 0; i < labyrinthe.getLargeur(); i++) {
            for (int j = 0; j < labyrinthe.getHauteur(); j++) {
                tampon.drawImage(murImage, i * unite, j * unite);
            }
        }*/

        // Dessine les salles
        ISprite heros = (ISprite) sprites.toArray()[0];
        int xHeros = heros.getPosition().getX();
        int yHeros = heros.getPosition().getY();
        int porteeVue = 5;
        for (ISalle salle : labyrinthe) {
            
            if(salle.getX()+porteeVue > xHeros && salle.getY()+porteeVue > yHeros && salle.getX()-porteeVue < xHeros && salle.getY()-porteeVue < yHeros){
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
}
