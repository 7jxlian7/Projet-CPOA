/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe;

import exceptions.ExceptionInvalidFile;
import java.util.ArrayList;
import java.util.Collection;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import outils.Fichier;

/**
 *
 * @author jforme
 */
public class LabyrintheGraphe extends Labyrinthe implements ILabyrinthe {

    SimpleGraph<ISalle, DefaultEdge> graphe;
    protected ISalle entree;
    protected ISalle sortie;
    private int largeur;
    private int hauteur;
    public ArrayList<ISalle> cheminCourt;

    public LabyrintheGraphe() {
        this.graphe = new SimpleGraph<>(DefaultEdge.class);
    }

    @Override
    public void creerLabyrinthe(String file) {
        Fichier f;

        try {
            if (!Fichier.testValide(file)) {
                throw new ExceptionInvalidFile();
            } else {
                f = new Fichier(file);
            }
        } catch (ExceptionInvalidFile e) {
            System.out.println("Exception : Fichier invalide.");
            String rescueLevel = "labys/level7.txt";
            f = new Fichier(rescueLevel);
            if (!Fichier.testValide(rescueLevel)) {
                System.exit(1);
            }
        }

        // dimensions
        largeur = f.lireNombre();
        hauteur = f.lireNombre();
        entree = new Salle(f.lireNombre(), f.lireNombre());
        graphe.addVertex(entree);
        sortie = new Salle(f.lireNombre(), f.lireNombre());
        graphe.addVertex(sortie);
        this.add(entree);
        this.add(sortie);
        int nextInt = f.lireNombre();
        while (nextInt != -1) {
            Salle s = new Salle(nextInt, f.lireNombre());
            this.add(s);
            graphe.addVertex(s);
            nextInt = f.lireNombre();
        }

        for (ISalle s : this) {
            for (ISalle s2 : this) {
                if (s.estAdjacente(s2) && !s.equals(s2)) {
                    graphe.addEdge(s, s2);
                }
            }
        }
    }

    /**
     * Renvoie l'entree du labyrinthe.
     *
     * @return l'entree du labyrinthe
     */
    @Override
    public ISalle getEntree() {
        return entree;
    }

    /**
     * Renvoie la sortie du labyrinthe.
     *
     * @return la sortie du labyrinthe
     */
    @Override
    public ISalle getSortie() {
        return sortie;
    }

    /**
     * Not implemented yet.
     * @param u
     * @param v
     * @return 
     */
    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        DijkstraShortestPath<ISalle, DefaultEdge> dsp = new DijkstraShortestPath<ISalle, DefaultEdge>(graphe);
        GraphPath<ISalle, DefaultEdge> path = dsp.getPath(u, v);
        return path.getVertexList();
    }

    /**
     * Renvoie la largeur du labyrinthe.
     *
     * @return la largeur du labyrinthe
     */
    @Override
    public int getLargeur() {
        return largeur;
    }

    /**
     * Renvoie la hauteur du labyrinthe.
     *
     * @return la hauteur du labyrinthe
     */
    @Override
    public int getHauteur() {
        return hauteur;
    }
}
