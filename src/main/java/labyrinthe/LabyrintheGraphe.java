/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe;

import exceptions.ExceptionInvalidFile;
import org.jgrapht.graph.SimpleGraph;
import outils.Fichier;

/**
 *
 * @author jforme
 */
public class LabyrintheGraphe extends Labyrinthe implements ILabyrinthe {
    
    SimpleGraph<Object, Object> graphe;

    @Override
    public void creerLabyrinthe(String file) {
        super.creerLabyrinthe(file);
    }
}
