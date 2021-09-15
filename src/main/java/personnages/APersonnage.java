package personnages;

import labyrinthe.ISalle;

/**
 * Modélise un personnage
 * @author Julian
 */
public abstract class APersonnage implements IPersonnage {
    
    public ISalle position;
    
    /**
     * Renvoie la position courante du personnage
     * @return la salle dans laquelle le personnage se trouve
     */
    @Override
    public ISalle getPosition(){
        return position;
    }
    
    /**
     * Définit la position du personnage
     * @param s la salle où va se placer le personnage
     */
    @Override
    public void setPosition(ISalle s){
         position = s;
    }
}
