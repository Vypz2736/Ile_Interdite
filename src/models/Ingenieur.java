package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Ingenieur extends Aventurier {

	private boolean seche;

	/**
	 * 
	 * @param g
	 */
        @Override
	public void assecher(ArrayList<Tuile> at) {
                for (Tuile t : at)
                    t.secher();
            setNbactions(getNbactions()+1);
	}

	public boolean getSeche() {
            return this.seche;
	}
        
	public void setSeche(boolean seche) {
            this.seche = seche;
	}
        
        public void assecherG(ArrayList<Tuile> at) {
        at.get(0).secher();
        }
        
        public void deplacer(Tuile t1, Tuile t2) {
            // TODO - implement Aventurier.recupTresor
            throw new UnsupportedOperationException();
        }
        
        public boolean getHelico() {
            // TODO - implement Aventurier.recupTresor
            throw new UnsupportedOperationException();
        }

        /**
         * @param helico the helico to set
         */
        public void setHelico(boolean helico) {
            // TODO - implement Aventurier.recupTresor
            throw new UnsupportedOperationException();
        }
        
        public HashMap<String,Tuile> getTuilesAv(Grille g) {
            // TODO - implement Aventurier.recupTresor
            throw new UnsupportedOperationException();
        }
    
        public HashMap<String,Tuile> getTuilesAccDeplacer(Grille g, Tuile t1) {
            // TODO - implement Aventurier.recupTresor
            throw new UnsupportedOperationException();
        }
}