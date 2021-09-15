package outils;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Représente un fichier
 * @author INFO Professors team
 */
public class Fichier {

    Scanner sc = null;

    /**
     * Construit un fichier
     * @param nomFichier nom du fichier à construire
     */
    public Fichier(String nomFichier) {
        try {
            sc = new Scanner(new File(nomFichier));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Lit un fichier
     * @return le prochain entier du fichier, -1 si il n'y en a pas
     */
    public int lireNombre() {
        if (sc.hasNextInt()) {
            return sc.nextInt();
        }
        return -1;
    }

    /**
     * Vérifie si un fichier est valide (qu'il soit possible de créer un labyrinthe à partie de ce fichier)
     * @param nomFichier nom du fichier à tester
     * @return true ssi le fichier est valide
     */
    public static boolean testValide(String nomFichier) {
        boolean isValid = true;

        File fichier = new File(nomFichier);

        Scanner sc = null;

        try {
            sc = new Scanner(fichier);
        } catch (Exception e) {
            System.out.println(e);
        }

        // Test coordonnées salles fichier
        int largeur = 0, hauteur = 0;
        if (sc.hasNextLine()) {
            largeur = sc.nextInt();
            hauteur = sc.nextInt();
        }
        while (sc.hasNextInt()) {
            int nextInt = sc.nextInt();
            if (nextInt < 0 || nextInt >= largeur || nextInt >= hauteur) {
                isValid = false;
            }
        }

        // Remise à zéro du scanner
        try {
            sc = new Scanner(fichier);
        } catch (Exception e) {
            System.out.println(e);
        }

        // Test pas de doublon fichier
        // On récupère les coordonnées du labyrinthe
        largeur = sc.nextInt();
        hauteur = sc.nextInt();

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
                        isValid = false;
                    }
                }
            }
        }
        return isValid;
    }

}
