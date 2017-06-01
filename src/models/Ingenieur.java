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

        @Override
        public HashMap<String,Tuile> getTuilesAcc(Grille g, int type) {
            HashMap<String,Tuile> ta = new HashMap();
            if (type == 2) {
                for (int j = 0; j < 6; j++) {
                    for (int i = 0; i < 6; i++) {
                        if (g.getGrille()[j][i] != null && g.getGrille()[j][i].estInonde()) {
                            ta.put(g.getGrille()[j][i].getNom(),g.getGrille()[j][i]);
                        }
                    }
                }  
            }
            else {
                if (emplacement.getLigne() !=0)
                    if (g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()] != null && !g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()].estMorte()) {
                        ta.put(g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()].getNom(),g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()]);
                    }
                if (emplacement.getLigne() !=5)
                    if (g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()] != null && !g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()].estMorte()) {
                        ta.put(g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()].getNom(),g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()]);
                    }
                if (emplacement.getColonne() !=0)
                    if (g.getGrille()[emplacement.getLigne()][emplacement.getColonne()-1] != null && !g.getGrille()[emplacement.getLigne()][emplacement.getColonne()-1].estMorte()) {
                        ta.put(g.getGrille()[emplacement.getLigne()][emplacement.getColonne()-1].getNom(),g.getGrille()[emplacement.getLigne()][emplacement.getColonne()-1]);
                    }
                if (emplacement.getColonne() !=5)
                    if (g.getGrille()[emplacement.getLigne()][emplacement.getColonne()+1] != null && !g.getGrille()[emplacement.getLigne()][emplacement.getColonne()+1].estMorte()) {
                        ta.put(g.getGrille()[emplacement.getLigne()][emplacement.getColonne()+1].getNom(),g.getGrille()[emplacement.getLigne()][emplacement.getColonne()+1]);
                    }
            }
            return ta;
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