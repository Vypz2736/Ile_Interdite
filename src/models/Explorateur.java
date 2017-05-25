package models;

import java.util.ArrayList;

public class Explorateur extends Aventurier {

	/**
	 * 
	 * @param g
	 * @param type
	 */
        
        @Override
	public ArrayList<Tuile> getTuilesAcc(Grille g, int type) {
            ArrayList<Tuile> ta = new ArrayList();
            for (Tuile t : super.getTuilesAcc(g, type)) {
                ta.add(t);
            }
            if (emplacement.getLigne() !=0)
                if (g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()-1] != null && !g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()-1].estMorte()) {
                    ta.add(g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()-1]);
                }
            if (emplacement.getLigne() !=5)
                if (g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()+1] != null && !g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()+1].estMorte()) {
                    ta.add(g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()+1]);
                }
            if (emplacement.getColonne() !=0)
                if (g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()-1] != null && !g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()-1].estMorte()) {
                    ta.add(g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()-1]);
                }
            if (emplacement.getColonne() !=0)
                if (g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()+1] != null && !g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()+1].estMorte()) {
                    ta.add(g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()+1]);
                }
            return ta;
	}

}