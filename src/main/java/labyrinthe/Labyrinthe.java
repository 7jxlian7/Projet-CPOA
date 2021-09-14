package labyrinthe;

import exceptions.ExceptionInvalidFile;
import java.util.ArrayList;
import java.util.Collection;
import outils.Fichier;
import personnages.IPersonnage;

/**
 * Représente un labyrinthe.
 * @author INFO Professors team
 */
public class Labyrinthe extends ArrayList<ISalle> implements ILabyrinthe {

    protected ISalle entree;
    protected ISalle sortie;
    private int largeur;
    private int hauteur;

    /**
     * Créer un labyrinthe à partir d'un fichier.
     * @param file le fichier texte contenant le labyrinthe
    */
    @Override
    public void creerLabyrinthe(String file) {
        Fichier f;
        
        try {
            if (!Fichier.testValide(file)) {
                throw new ExceptionInvalidFile();
            } else {
                f = new Fichier(file);
            }
        } catch (ExceptionInvalidFile e) {
            System.out.println("Exception : Fichier invalide.");
            String rescueLevel = "labys/level7.txt";
            f = new Fichier(rescueLevel);
            if(!Fichier.testValide(rescueLevel)){
                System.exit(1);
            }
        }
        
        // dimensions
        largeur = f.lireNombre();
        hauteur = f.lireNombre();
        entree = new Salle(f.lireNombre(), f.lireNombre());
        sortie = new Salle(f.lireNombre(), f.lireNombre());
        this.add(entree);
        this.add(sortie);
        int nextInt = f.lireNombre();
        while (nextInt != -1) {
            Salle s = new Salle(nextInt, f.lireNombre());
            this.add(s);
            nextInt = f.lireNombre();
        }
    }

    /**
     * Renvoie une collection de salles accessibles par le personnage passé en paramètre.
     * @param bob le personnage à tester
     * @return    une collection de salles accessibles
     */
    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage bob) {
        ArrayList<ISalle> sallesAccessibles = new ArrayList<>();
        for(ISalle salle : this){
            if(salle.estAdjacente(bob.getPosition())){
                sallesAccessibles.add(salle);
            }
        }
        return sallesAccessibles;
    }

    /**
     * Renvoie l'entree du labyrinthe.
     * @return l'entree du labyrinthe
     */
    @Override
    public ISalle getEntree() {
        return entree;
    }

    /**
     * Renvoie la sortie du labyrinthe.
     * @return la sortie du labyrinthe
     */
    @Override
    public ISalle getSortie() {
        return sortie;
    }

    /**
     * Not implemented yet.
     */
    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        return null;
    }

     /**
     * Renvoie la largeur du labyrinthe.
     * @return la largeur du labyrinthe
     */
    @Override
    public int getLargeur() {
        return largeur;
    }

     /**
     * Renvoie la hauteur du labyrinthe.
     * @return la hauteur du labyrinthe
     */
    @Override
    public int getHauteur() {
        return hauteur;
    }

}
