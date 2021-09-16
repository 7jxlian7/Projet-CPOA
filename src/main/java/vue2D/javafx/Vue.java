package vue2D.javafx;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import labyrinthe.ILabyrinthe;
import vue2D.IVue;
import vue2D.AVue;
import vue2D.sprites.ISprite;

/**
 * Représente la vue
 * @author INFO Professors team
 */
public class Vue extends AVue implements IVue {

    Dessin dessin;
    ILabyrinthe labyrinthe;
    public Scene scene;

    /**
     * Construit la vue
     * @param labyrinthe le labyrinthe du jeu
     */
    public Vue(ILabyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
        dessin = new Dessin(labyrinthe, this);
        Group root = new Group();
        this.scene = new Scene(root);
        root.getChildren().add(dessin);
    }

    /**
     * Dessine la vue
     */
    @Override
    public void dessiner() {
        // recopie du fond (image); murs + salles
        dessin.dessinFond();
        dessin.dessinSalles();
        ISprite sprite = this.get(0);
        dessin.dessinPlusCourtChemin(sprite);
        this.forEach(s -> {
            s.dessiner(dessin.getGraphicsContext2D());
        });
    }

    /**
     * Associe un sprite aux contrôles du clavier
     * @param sprite à controler
     * @return true
     */
    @Override
    public boolean add(ISprite sprite) {
        super.add(sprite);
        
        // si le sprite est controle par le clavier
        if (sprite instanceof EventHandler) {
            System.out.println("registering keylistener");
        // association de l'ecouteur sur le clavier avec le composant graphique principal
            this.scene.setOnKeyPressed((EventHandler) sprite);
        }
        return true;
    }

}
