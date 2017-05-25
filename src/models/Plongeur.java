package models;
import java.util.ArrayList;

public class Plongeur extends Aventurier {

	/**
	 * 
	 * @param g
	 */
	public void seDeplacer(Grille g) {
		// TODO - implement Plongeur.seDeplacer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param g
	 * @param type
	 */
	@Override
	public ArrayList<Tuile> getTuilesAcc(Grille g, int type) {
            ArrayList<Tuile> ta = new ArrayList();
            if (type == 2)
                for (Tuile t : super.getTuilesAcc(g, type)) {
                    ta.add(t);
                }
            else {
                if (emplacement.getLigne() !=0)
                    if (g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()] != null) {
                        ta.add(g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()]);
                    }
                if (emplacement.getLigne() !=5)
                    if (g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()] != null) {
                        ta.add(g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()]);
                    }
                if (emplacement.getColonne() !=0)
                    if (g.getGrille()[emplacement.getLigne()][emplacement.getColonne()-1] != null) {
                        ta.add(g.getGrille()[emplacement.getLigne()][emplacement.getColonne()-1]);
                    }
                if (emplacement.getColonne() !=0)
                    if (g.getGrille()[emplacement.getLigne()][emplacement.getColonne()+1] != null) {
                        ta.add(g.getGrille()[emplacement.getLigne()][emplacement.getColonne()+1]);
                    }
            }
            return ta;
	}

}