package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Ingenieur extends Aventurier {

	private int seche;

	/**
	 * 
	 * @param g
	 */
	public void assecher(Grille g) {
		// TODO - implement Ingenieur.assecher
		throw new UnsupportedOperationException();
	}

	public int getSeche() {
		return this.seche;
	}

	/**
	 * 
	 * @param seche
	 */
	public void setSeche(int seche) {
		this.seche = seche;
	}

        @Override
        public HashMap<String,Tuile> getTuilesAcc(Grille g, int type) {
		HashMap<String,Tuile> ta = new HashMap();
                if (type == 2) {
                    for (int j = 0; j < 6; j++) {
                        for (int i = 0; i < 6; i++) {
                            if (g.getGrille()[j][i] != null && !g.getGrille()[j][i].estMorte()) {
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
                    if (emplacement.getColonne() !=0)
                        if (g.getGrille()[emplacement.getLigne()][emplacement.getColonne()+1] != null && !g.getGrille()[emplacement.getLigne()][emplacement.getColonne()+1].estMorte()) {
                            ta.put(g.getGrille()[emplacement.getLigne()][emplacement.getColonne()+1].getNom(),g.getGrille()[emplacement.getLigne()][emplacement.getColonne()+1]);
                        }
                }
            return ta;
	}
}