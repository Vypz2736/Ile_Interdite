/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import controleur.Controleur;


public class Message {

    public enum TypeMessage {
        SAISIEFINIE,
        CASECLIQUEE,
        DEPLACER,
        SEDEPLACER,
        ASSECHER,
        PASSER,
        DONNER,
        TRESOR,
        JOUEUR,
        CARTE,
        RELANCER,
        DFORCE;
    }
    
    private TypeMessage type;
    private int colonne = -66;
    private int ligne = - 66;
    private int niveauindice = - 66;
    
    public Message(TypeMessage t, int l, int c) {
        type = t;
        colonne = c;
        ligne = l;
    }
    
    public Message(TypeMessage t) {
        type = t;
    }
    
    public Message(TypeMessage t, int n) {
        type = t;
        niveauindice = n;
    }

    /**
     * @return the type
     */
    public TypeMessage getType() {
        return type;
    }

    /**
     * @return the colonne
     */
    public int getColonne() {
        return colonne;
    }

    /**
     * @return the ligne
     */
    public int getLigne() {
        return ligne;
    }

    /**
     * @return the niveau
     */
    public int getNiveau() {
        return niveauindice+1;
    }
    
    public int getIndice() {
        if (niveauindice != -66)
            return niveauindice;
        else
            return ligne;
    }
    
    public int getJoueur() {
        return colonne;
    }
}
