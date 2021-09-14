package labyrinthe;

/**
 * Une interface pour une salle.
 * @author INFO Professors team
 */
public interface ISalle {

    public int getX(); // abcisse

    public int getY(); // ordonnee

    public boolean estAdjacente(ISalle autre);
}
