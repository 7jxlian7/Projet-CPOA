package labyrinthe;

import java.io.IOException;
import java.util.Collection;
import personnages.IPersonnage;

/**
 * Une interface pour un labyrinthe.
 * @author INFO Professors team
 */
public interface ILabyrinthe extends Collection<ISalle> {

    public void creerLabyrinthe(String file) throws IOException; // creer le labyrinthe a partir d'un fichier 

    public Collection<ISalle> sallesAccessibles(IPersonnage heros); // renvoie les salles accessibles pour le heros

    public ISalle getEntree(); // accesseur sur l'entree 

    public ISalle getSortie(); // accesseur sur la sortie

    public Collection<ISalle> chemin(ISalle u, ISalle v); // un plus court chemin entre u et v
    
    public int distanceGraphe(ISalle s, ISalle t); // distance entre deux salles

    // dimensions grille
    public int getLargeur();

    public int getHauteur();
}
