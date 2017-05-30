/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Vypz
 */
public class Message {
    public enum TypeMessage {
        SAISIEFINIE,
        CASECLIQUEE;
    }
    
    private TypeMessage type;
    private int colonne;
    private int ligne;
    
    public Message(TypeMessage type, int l, int c) {
        colonne = c;
        ligne = l;
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
}
