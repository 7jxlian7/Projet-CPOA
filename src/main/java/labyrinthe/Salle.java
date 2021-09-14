package labyrinthe;

/**
 * Représente une salle.
 * @author jforme
 */
public class Salle implements ISalle {

    public int x;
    public int y;

    /**
     * Construit une salle
     * @param x abscisse de la salle
     * @param y ordonnée de la salle
     */
    public Salle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Renvoie l'abscisse de la salle
     * @return l'abscisse de la salle
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Renvoie l'ordonnée de la salle
     * @return l'ordonnée de la salle
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Vérifie si une salle est adjacente à une autre
     * @param autre salle à tester
     * @return true ssi notre salle est adjacente à l'autre
     */
    @Override
    public boolean estAdjacente(ISalle autre) {
        // Retourne les 4 cases adjacentes (NORD, SUD, EST, OUEST)
        return (this.x == autre.getX() + 1 && this.y == autre.getY()) || (this.x == autre.getX() - 1 && this.y == autre.getY()) || (this.x == autre.getX() && this.y == autre.getY() + 1) || (this.x == autre.getX() && this.y == autre.getY() - 1);
    }

    /**
     * Redéfinis la méthode hashcode
     * @return le hashcode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.x;
        hash = 53 * hash + this.y;
        return hash;
    }

    /**
     * Redéfinis la méthode equals
     * @return true ssi les deux salles ont les mêmes coordonées
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salle other = (Salle) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
}
