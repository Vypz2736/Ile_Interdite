/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;
import models.*;
import util.*;

/**
 *
 * @author Vypz
 */
public class Ile_Interdite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controleur c = new Controleur();
        c.nouveauJoueur("Philippe");
        c.nouveauJoueur("André");
        c.nouveauJoueur("Gérard");
        c.nouveauJoueur("Hughes");
        c.init();
        System.out.println(c.getGrille());
        while (1 == 1) {
            for (Joueur j : c.getJoueurs()) {
                c.tourJoueur(j);
            }
        }
    }
    
}
