
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import labyrinthe.Labyrinthe;

/**
 *
 * @author INFO Professors team
 */
public class TestFichiersLabyrinthe {

    private File[] getFiles(File repertoire) {
        if (!repertoire.isDirectory()) {
            fail("testCoordonneesSalles - les tests ne concernent pas un répertoire");
        }
        File[] fichiers = repertoire.listFiles();
        return fichiers;
    }

    @Test
    public void testCoordonneesSalles() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        System.out.println();
        System.out.println("** Test coordonnées salles **");
        System.out.println();
        for (File f : fichiers) {
            System.out.print("* Test du fichier : " + f.getName());
            if (!testCoordonneesSallesFichier(f)) {
                System.out.print(" (fichier invalide)");
            }
            System.out.println();
        }
    }

    @Test
    public void testPasDeDoublon() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        System.out.println();
        System.out.println("** Test doublon salles **");
        System.out.println();
        for (File f : fichiers) {
            System.out.print("* Test du fichier : " + f.getName());
            if (!testPasDeDoublonFichier(f)) {
                System.out.print(" (fichier invalide)");
            }
            System.out.println();
        }
    }

    @Test
    public void testChemin() throws IOException {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        System.out.println();
        System.out.println("** Test chemin entrée sortie **");
        System.out.println();
        for (File f : fichiers) {
            System.out.print("* Test du fichier : " + f.getName());
            if (!testCheminFichier(f)) {
                System.out.print(" (pas de chemin entre l'entrée et la sortie)");
            }
            System.out.println();
        }
    }

    public boolean testCheminFichier(File f) throws IOException {
        System.out.println("labys/" + f.getName());
        ILabyrinthe laby = new Labyrinthe();
        laby.creerLabyrinthe("labys/" + f.getName());
        Collection<ISalle> sallesChemin = laby.chemin(laby.getEntree(), laby.getSortie());
        if (sallesChemin != null) {
            return false;
        }
        return true;
    }

    public boolean testCoordonneesSallesFichier(File f) {
        Scanner sc = null;

        int largeur = 0, hauteur = 0;

        try {
            sc = new Scanner(f);
        } catch (Exception e) {
            System.out.println(e);
        }

        if (sc.hasNextLine()) {
            largeur = sc.nextInt();
            hauteur = sc.nextInt();
        }

        while (sc.hasNextInt()) {
            int nextInt = sc.nextInt();
            if (nextInt < 0 || nextInt >= largeur || nextInt >= hauteur) {
                return false;
            }
        }
        return true;
    }

    public boolean testPasDeDoublonFichier(File f) {
        Scanner sc = null;

        try {
            sc = new Scanner(f);
        } catch (Exception e) {
            System.out.println(e);
        }

        // On récupère les coordonnées du labyrinthe
        int largeur = sc.nextInt();
        int hauteur = sc.nextInt();

        // Déclaration et remplissage du tableau de test
        boolean[][] listeSalles = new boolean[500][500];
        for (boolean[] row : listeSalles) {
            Arrays.fill(row, false);
        }

        int x, y = 0;

        while (sc.hasNextInt()) {
            x = sc.nextInt();
            if (sc.hasNextInt()) {
                y = sc.nextInt();
                if (x >= 0 && y >= 0) {
                    if (!listeSalles[x][y]) {
                        listeSalles[x][y] = true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
