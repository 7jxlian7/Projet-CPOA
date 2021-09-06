package labyrinthe;

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
        Fichier f = new Fichier(file);
        // dimensions
        largeur = f.lireNombre();
        hauteur = f.lireNombre();
        Salle s = new Salle();
        s.x = f.lireNombre();
        s.y = f.lireNombre();
        entree = s;
        s = new Salle();
        s.x = f.lireNombre();
        s.y = f.lireNombre();
        sortie = s;
        int nextInt = f.lireNombre();
        while (nextInt != -1) {
            s = new Salle();
            s.x = nextInt;
            s.y = f.lireNombre();
            nextInt = f.lireNombre();
            this.add(s);
        }
    }

    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage bob) {
        return null;
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
