package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Navigateur extends Aventurier {

	/**
	 * 
	 * @param t
	 */
	public void deplacer(Grille g) {
            Scanner st = new Scanner(System.in);
            for (Tuile t : getTuilesAv(g).values()) {
                System.out.println("- " + t);
            }
            String nom = st.nextLine();
            Tuile t1 = getTuilesAv(g).get(nom);
            for (Tuile t : getTuilesAccDeplacer(g,t1).values()) {
                System.out.println("- " + t);
            }
            nom = st.nextLine();
            if (getTuilesAccDeplacer(g,t1).get(nom) != null) {
                ArrayList<Aventurier> aa = new ArrayList();
                for (Aventurier a : t1.getAventuriers()) {
                    aa.add(a);
                }
                for (Aventurier a : aa) {
                    t1.retirerAv(a);
                    getTuilesAccDeplacer(g,t1).get(nom).ajouterAv(a);
                    a.setPos(getTuilesAccDeplacer(g,t1).get(nom));
                }
                setNbactions(getNbactions()+1);
            }
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

}