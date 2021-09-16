package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import personnages.IPersonnage;
import vue2D.IVue;
import vue2D.sprites.DragonSprite;
import vue2D.sprites.HerosSprite;
import vue2D.sprites.ISprite;
import vue2D.sprites.MonstreSprite;

/**
 * Classe permettant le déroulement du jeu
 *
 * @author INFO Professors team
 */
public class Core {

    ArrayList<ISprite> personnagesLaby = new ArrayList<>();
    ILabyrinthe labyrinthe;

    /**
     * Initialise le labyrinthe
     */
    protected void initLabyrinthe() {
        // creation du labyrinthe
        labyrinthe = new labyrinthe.LabyrintheGraphe();
        chargementLaby("labys/level3.txt");
    }

    /**
     * Initialise les sprites et personnages du jeu
     *
     * @param vue la vue
     */
    protected void initSprites(IVue vue) {
        // creation du heros 
        IPersonnage h = new personnages.Heros(labyrinthe.getEntree());
        ISprite heros = new HerosSprite(h, labyrinthe);
        vue.add(heros);
        personnagesLaby.add(heros);
        // creation de monstres
        int nbMonstres = 10;
        for (int i = 0; i < nbMonstres; i++) {
            IPersonnage m = new personnages.Monstre(labyrinthe.getSortie());
            ISprite monstre = new MonstreSprite(m, labyrinthe);
            vue.add(monstre);
            personnagesLaby.add(monstre);
        }
        IPersonnage d = new personnages.Dragon(labyrinthe.getSortie(), labyrinthe, h);
        ISprite dragon = new DragonSprite(d, labyrinthe);
        vue.add(dragon);
        personnagesLaby.add(dragon);
    }

    /**
     * Boucle principale du jeu
     *
     * @param vue la vue
     */
    protected void jeu(IVue vue) {
        // boucle principale
        ISalle destination = null;
        ISprite heros = personnagesLaby.get(0);
        while (!labyrinthe.getSortie().equals(heros.getPosition())) {
            // choix et deplacement
            for (IPersonnage p : vue) {
                Collection<ISalle> sallesAccessibles = labyrinthe.sallesAccessibles(p);
                destination = p.faitSonChoix(sallesAccessibles); // on demande au personnage de faire son choix de salle
                p.setPosition(destination); // deplacement

            }
            // detection des collisions
            boolean collision = false;
            ISprite monstre = null;
            for (ISprite p : vue) {
                if (p != heros) {
                    if (p.getPosition() == heros.getPosition()) {
                        System.out.println("Collision !!");
                        collision = true;
                        monstre = p;
                    }
                }
            }
            if (collision) {
                vue.remove(monstre);
                vue.remove(heros);
                System.out.println("Perdu !");
                System.out.println("Plus que " + vue.size() + " personnages ...");
            }

            temporisation(5);
        }
        System.out.println("Gagné!");
    }

    /**
     * Charge le labyrinthe
     *
     * @param fic le fichier texte contenant le labyrinthe
     */
    private void chargementLaby(String fic) {
        try {
            labyrinthe.creerLabyrinthe(fic);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Temporise
     *
     * @param nb nombre de millisecondes à temporiser
     */
    protected void temporisation(int nb) {
        try {
            Thread.sleep(nb); // pause de nb millisecondes
        } catch (InterruptedException ie) {
        }
    }
}
