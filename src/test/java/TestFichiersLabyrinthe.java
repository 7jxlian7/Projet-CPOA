
import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Scanner;
import labyrinthe.Salle;

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
            if (!testCoordonneesSallesFichier(f)) {
                //System.out.println(f.getName());
            }
        }
    }

    @Test
    public void testPasDeDoublon() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        for (File f : fichiers) {
            System.out.println("* Test du fichier : " + f.getName());
            if(!testPasDeDoublonFichier(f)){
                System.out.println("* Fichier invalide : " + f.getName());
                System.out.println();
            };
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

        // On saute la première ligne
        if (sc.hasNextLine()) {
            sc.nextLine();
        }

        ArrayList listeSalles = new ArrayList();
        Salle s = null;

        int x, y = 0;

        while (sc.hasNextInt()) {
            x = sc.nextInt();
            if (sc.hasNextInt()) {
                y = sc.nextInt();
                s = new Salle(x, y);
                if (!listeSalles.contains(s)) {
                    listeSalles.add(s);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
