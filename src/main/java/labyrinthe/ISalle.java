package labyrinthe;

/**
 * Une interface pour une salle.
 * @author INFO Professors team
 */
public interface ISalle {

    public int getX(); // abscisse

    public int getY(); // ordonnee

    public boolean estAdjacente(ISalle autre);
}
