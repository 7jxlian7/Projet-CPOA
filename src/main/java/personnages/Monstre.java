package personnages;

import java.util.Collection;
import java.util.Random;
import labyrinthe.ISalle;

/**
 * Représente un monstre
 * @author Julian
 */
public class Monstre extends APersonnage {

    Random random = new Random();
    
    /**
     * Construis un monstre
     * @param salle salle de départ du monstre
     */
    public Monstre(ISalle salle) {
       this.position = salle;
    }
    
    /**
     * Renvoie une salle aléatoire parmi celles accessibles
     * @param sallesAccessibles liste des salles auxquelles le monstre peut accéder
     * @return une salle aléatoire
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return (ISalle) sallesAccessibles.toArray()[random.nextInt(sallesAccessibles.size())];
    }
}
