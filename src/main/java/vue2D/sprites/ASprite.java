/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import java.util.Collection;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import personnages.IPersonnage;

/**
 * Modélise un sprite
 * @author Julian
 */
public abstract class ASprite implements ISprite {

    public IPersonnage sprite;
    public ILabyrinthe labyrinthe;
    public Image spriteImg;

    private int unite = 15;
    private double x = 0;
    private double y = 0;
    protected double vitesse;
    public boolean seDeplace;
    private ISalle destination;

    /**
     * Construis un modèle de sprite
     * @param sprite le sprite
     * @param laby le labyrinthe associé
     */
    public ASprite(IPersonnage sprite, ILabyrinthe laby) {
        this.labyrinthe = laby;
        this.sprite = sprite;
        this.destination = sprite.getPosition();
        x = sprite.getPosition().getX() * unite;
        y = sprite.getPosition().getY() * unite;
    }

    /**
     * Dessine le sprite
     * @param g contexte graphique
     */
    @Override
    public void dessiner(GraphicsContext g) {
        g.drawImage(spriteImg, x, y-(spriteImg.getHeight()/2), unite, unite*1.5);
    }

    /**
     * Définit les coordonnées graphiques du sprite
     * @param xpix coordonnées honrizontales
     * @param ypix coordonées verticales
     */
    @Override
    public void setCoordonnees(int xpix, int ypix) {
        // Calcul de la direction
        double xDiff = x - xpix;
        double yDiff = y - ypix;
        
        if(xDiff < 0){
            x += vitesse;
        }
        if(xDiff > 0){
            x -= vitesse;
        }
        if(yDiff < 0){
            y += vitesse;
        }
        if(yDiff > 0){
            y -= vitesse;
        }
        if(xDiff == 0 && yDiff == 0){
            seDeplace = false;
        }
    }

    /**
     * Renvoie la position du sprite
     * @return la salle dans laquelle se trouve le sprite
     */
    @Override
    public ISalle getPosition() {
        return sprite.getPosition();
    }

    /**
     * Définit la position du sprite
     * @param s la salle où le sprite va se positionner
     */
    @Override
    public void setPosition(ISalle s) {
        if(!seDeplace){
            seDeplace = true;
            sprite.setPosition(s);
            destination = s;
        }
        if(seDeplace){
            setCoordonnees(destination.getX()*15, destination.getY()*15);
        }
    }

    /**
     * Renvoie le choix du sprite
     * @param sallesAccessibles liste des salles auxquelles le sprite peut accéder
     * @return la salle choisie
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return sprite.faitSonChoix(sallesAccessibles);
    }
}
