package labyrinthe;

import exceptions.ExceptionInvalidFile;
import java.util.ArrayList;
import java.util.Collection;

import outils.Fichier;
import personnages.IPersonnage;

/**
 *
 * @author INFO Professors team
 */
public class Labyrinthe extends ArrayList<ISalle> implements ILabyrinthe {

    protected ISalle entree;
    protected ISalle sortie;
    private int largeur;
    private int hauteur;

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
        int nextInt = f.lireNombre();
        while (nextInt != -1) {
            Salle s = new Salle(nextInt, f.lireNombre());
            this.add(s);
            nextInt = f.lireNombre();
        }
    }

    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage bob) {
        Collection<ISalle> sallesAccessibles = null;
        for(ISalle salle : this){
            if(salle.estAdjacente(bob.getPosition())){
                sallesAccessibles.add(salle);
            }
        }
        return sallesAccessibles;
    }

    @Override
    public ISalle getEntree() {
        return entree;
    }

    @Override
    public ISalle getSortie() {
        return sortie;
    }

    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        return null;
    }

    @Override
    public int getLargeur() {
        return largeur;
    }

    @Override
    public int getHauteur() {
        return hauteur;
    }

}
