package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Explorateur extends Aventurier {

	/**
	 * 
	 * @param g
	 * @param type
	 */
        
        @Override
	public HashMap<String,Tuile> getTuilesAcc(Grille g, int type) {
            HashMap<String,Tuile> ta = new HashMap();
            for (Tuile t : super.getTuilesAcc(g, type).values()) {
                ta.put(t.getNom(),t);
            }
            if (emplacement.getLigne() !=0)
                if (g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()-1] != null && !g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()-1].estMorte()) {
                    ta.put(g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()-1].getNom(),g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()-1]);
                }
            if (emplacement.getLigne() !=5)
                if (g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()+1] != null && !g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()+1].estMorte()) {
                    ta.put(g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()+1].getNom(),g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()+1]);
                }
            if (emplacement.getColonne() !=0)
                if (g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()-1] != null && !g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()-1].estMorte()) {
                    ta.put(g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()-1].getNom(),g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()-1]);
                }
            if (emplacement.getColonne() !=0)
                if (g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()+1] != null && !g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()+1].estMorte()) {
                    ta.put(g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()+1].getNom(),g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()+1]);
                }
            return ta;
	}

}