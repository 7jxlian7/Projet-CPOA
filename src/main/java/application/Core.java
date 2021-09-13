package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import labyrinthe.Salle;
import personnages.IPersonnage;
import vue2D.IVue;
import vue2D.sprites.HerosSprite;
import vue2D.sprites.ISprite;
import vue2D.sprites.MonstreSprite;

/**
 *
 * @author INFO Professors team
 */
public class Core {

    ArrayList<ISprite> personnagesLaby = new ArrayList<>();
    ILabyrinthe labyrinthe;

    protected void initLabyrinthe() {
        // creation du labyrinthe
        labyrinthe = new labyrinthe.Labyrinthe();
        chargementLaby("labys/level3.txt");
    }

    protected void initSprites(IVue vue) {
        // creation du heros 
        IPersonnage h = new personnages.Heros(labyrinthe.getEntree());
        ISprite heros = new HerosSprite(h, labyrinthe);
        vue.add(heros);
        personnagesLaby.add(heros);
        for (int i = 0; i < 1; i++) {
            IPersonnage m = new personnages.Monstre(labyrinthe.getSortie());
            ISprite monstre = new MonstreSprite(m, labyrinthe);
            vue.add(monstre);
            personnagesLaby.add(monstre);
        }
    }

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

            temporisation(50);
        }
        System.out.println("Gagné!");
    }

    private void chargementLaby(String fic) {
        try {
            labyrinthe.creerLabyrinthe(fic);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected void temporisation(int nb) {
        try {
            Thread.sleep(nb); // pause de nb millisecondes
        } catch (InterruptedException ie) {
        };
    }
}
