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
        for (int i = 0; i < 10; i++) {
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
        int nbTour = 0;
        while (!labyrinthe.getSortie().equals(heros.getPosition())) {
            // choix et deplacement
            for (IPersonnage p : vue) {
                ISprite p2 = (ISprite) p;
                boolean isMoving = false;
                Collection<ISalle> sallesAccessibles = labyrinthe.sallesAccessibles(p);
                    destination = p.faitSonChoix(sallesAccessibles); // on demande au personnage de faire son choix de salle
                    // deplacement
                // Si le personnage va bouger
                if(!destination.equals(p.getPosition())){
                   isMoving = true; 
                }
                // Si mon héros n'est pas à sa destination (est en mouvement)
                if(isMoving){
                    // Retourne la différence entre la position du joueur et sa destination (en salle)
                    int xDiff = p.getPosition().getX() - destination.getX();
                    int yDiff = p.getPosition().getY() - destination.getY();
                         
                    // Si on va vers le BAS
                    if(yDiff < 0){
                        p2.setCoordonnees(0, 1);
                        nbTour++;
                    }
                    // Si on va vers le HAUT
                    if(yDiff > 0){
                        p2.setCoordonnees(0, -1);
                        nbTour++;
                    }
                    // Si on va vers la GAUCHE
                    if(xDiff > 0){
                        p2.setCoordonnees(-1, 0);
                        nbTour++;
                    }
                    // Si on va vers la DROITE
                    if(xDiff < 0){
                        p2.setCoordonnees(1, 0);
                        nbTour++;
                    }
                    
                    if(nbTour >= 15){
                        isMoving = false;
                        p.setPosition(destination);
                        nbTour = 0;
                    }
                }
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
