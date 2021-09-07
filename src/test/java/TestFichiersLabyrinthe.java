
import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
        for (File f : fichiers) {
            System.out.print("* Test du fichier : " + f.getName());
            if (!testPasDeDoublonFichier(f)) {
                System.out.print(" (fichier invalide)");
            }
            System.out.println();
        }
    }

    @Test
    public void testChemin() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        fail("not implemented");
    }

    public boolean testCoordonneesSallesFichier(File f) {
        Scanner sc = null;
        
        int largeur = 0, hauteur = 0;

        try {
            sc = new Scanner("labys\"" + f.getName());
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
                if (!listeSalles[x][y]) {
                    listeSalles[x][y] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
