package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Navigateur extends Aventurier {

	/**
	 * 
	 * @param t
	 */
	public void deplacer(Tuile t1, Tuile t2) {
            ArrayList<Aventurier> av = new ArrayList();
            for (Aventurier a : t1.getAventuriers()) {
                av.add(a);
            }
            for (Aventurier a : av) {
                t1.retirerAv(a);
                t2.ajouterAv(a);
                a.setPos(t2);
            }
            setNbactions(getNbactions()+1);
	}
        
        public HashMap<String,Tuile> getTuilesAv(Grille g) {
            HashMap<String,Tuile> ta = new HashMap();
            for (int j = 0; j < 6; j++) {
                for (int i = 0; i < 6; i++) {
                    if (g.getGrille()[j][i] != null && g.getGrille()[j][i].getAventuriers().size() != 0) {
                        ta.put(g.getGrille()[j][i].getNom(),g.getGrille()[j][i]);
                    }
                }
            }
            return ta;
        }
        
        public HashMap<String,Tuile> getTuilesAccDeplacer(Grille g, Tuile t1) {
            HashMap<String,Tuile> ta = new HashMap();
            if (t1.getLigne() !=0 && t1.getColonne() !=0)
                if (g.getGrille()[t1.getLigne()-1][t1.getColonne()-1] != null && !g.getGrille()[t1.getLigne()-1][t1.getColonne()-1].estMorte()) {
                    ta.put(g.getGrille()[t1.getLigne()-1][t1.getColonne()-1].getNom(),g.getGrille()[t1.getLigne()-1][t1.getColonne()-1]);
                }
            if (t1.getLigne() !=5 && t1.getColonne() !=5)
                if (g.getGrille()[t1.getLigne()+1][t1.getColonne()+1] != null && !g.getGrille()[t1.getLigne()+1][t1.getColonne()+1].estMorte()) {
                    ta.put(g.getGrille()[t1.getLigne()+1][t1.getColonne()+1].getNom(),g.getGrille()[t1.getLigne()+1][t1.getColonne()+1]);
                }
            if (t1.getLigne() !=5 && t1.getColonne() !=0)
                if (g.getGrille()[t1.getLigne()+1][t1.getColonne()-1] != null && !g.getGrille()[t1.getLigne()+1][t1.getColonne()-1].estMorte()) {
                    ta.put(g.getGrille()[t1.getLigne()+1][t1.getColonne()-1].getNom(),g.getGrille()[t1.getLigne()+1][t1.getColonne()-1]);
                }
            if (t1.getLigne() !=0 && t1.getColonne() !=5)
                if (g.getGrille()[t1.getLigne()-1][t1.getColonne()+1] != null && !g.getGrille()[t1.getLigne()-1][t1.getColonne()+1].estMorte()) {
                    ta.put(g.getGrille()[t1.getLigne()-1][t1.getColonne()+1].getNom(),g.getGrille()[t1.getLigne()-1][t1.getColonne()+1]);
                }
            if (t1.getLigne() >1)
                if (g.getGrille()[t1.getLigne()-2][t1.getColonne()] != null && !g.getGrille()[t1.getLigne()-2][t1.getColonne()].estMorte()  && !g.getGrille()[t1.getLigne()-1][t1.getColonne()].estMorte()) {
                    ta.put(g.getGrille()[t1.getLigne()-2][t1.getColonne()].getNom(),g.getGrille()[t1.getLigne()-2][t1.getColonne()]);
                }
            if (t1.getLigne() <4)
                if (g.getGrille()[t1.getLigne()+2][t1.getColonne()] != null && !g.getGrille()[t1.getLigne()+2][t1.getColonne()].estMorte()  && !g.getGrille()[t1.getLigne()+1][t1.getColonne()].estMorte()) {
                    ta.put(g.getGrille()[t1.getLigne()+2][t1.getColonne()].getNom(),g.getGrille()[t1.getLigne()+2][t1.getColonne()]);
                }
            if (t1.getColonne() >1)
                if (g.getGrille()[t1.getLigne()][t1.getColonne()-2] != null && !g.getGrille()[t1.getLigne()][t1.getColonne()-2].estMorte() && !g.getGrille()[t1.getLigne()][t1.getColonne()-1].estMorte()) {
                    ta.put(g.getGrille()[t1.getLigne()][t1.getColonne()-2].getNom(),g.getGrille()[t1.getLigne()][t1.getColonne()-2]);
                }
            if (t1.getColonne() <4)
                if (g.getGrille()[t1.getLigne()][t1.getColonne()+2] != null && !g.getGrille()[t1.getLigne()][t1.getColonne()+2].estMorte() && !g.getGrille()[t1.getLigne()][t1.getColonne()+1].estMorte()) {
                    ta.put(g.getGrille()[t1.getLigne()][t1.getColonne()+2].getNom(),g.getGrille()[t1.getLigne()][t1.getColonne()+2]);
                }
            if (t1.getLigne() !=0)
                if (g.getGrille()[t1.getLigne()-1][t1.getColonne()] != null && !g.getGrille()[t1.getLigne()-1][t1.getColonne()].estMorte()) {
                    ta.put(g.getGrille()[t1.getLigne()-1][t1.getColonne()].getNom(),g.getGrille()[t1.getLigne()-1][t1.getColonne()]);
                }
            if (t1.getLigne() !=5)
                if (g.getGrille()[t1.getLigne()+1][t1.getColonne()] != null && !g.getGrille()[t1.getLigne()+1][t1.getColonne()].estMorte()) {
                    ta.put(g.getGrille()[t1.getLigne()+1][t1.getColonne()].getNom(),g.getGrille()[t1.getLigne()+1][t1.getColonne()]);
                }
            if (t1.getColonne() !=0)
                if (g.getGrille()[t1.getLigne()][t1.getColonne()-1] != null && !g.getGrille()[t1.getLigne()][t1.getColonne()-1].estMorte()) {
                    ta.put(g.getGrille()[t1.getLigne()][t1.getColonne()-1].getNom(),g.getGrille()[t1.getLigne()][t1.getColonne()-1]);
                }
            if (t1.getColonne() !=5)
                if (g.getGrille()[t1.getLigne()][t1.getColonne()+1] != null && !g.getGrille()[t1.getLigne()][t1.getColonne()+1].estMorte()) {
                    ta.put(g.getGrille()[t1.getLigne()][t1.getColonne()+1].getNom(),g.getGrille()[t1.getLigne()][t1.getColonne()+1]);
                }
            return ta;
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

	public boolean getSeche() {
            // TODO - implement Aventurier.recupTresor
            throw new UnsupportedOperationException();
	}
        
	public void setSeche(boolean seche) {
            // TODO - implement Aventurier.recupTresor
            throw new UnsupportedOperationException();
	}
        
        public void assecherG(ArrayList<Tuile> at) {
            // TODO - implement Aventurier.recupTresor
            throw new UnsupportedOperationException();
        }

}