package models;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Plongeur extends Aventurier {

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
            if (type == 1) {
                ArrayList<Tuile> tuiles = new ArrayList();
                tuiles.add(emplacement);
                tuiles = autourTuiles(g,tuiles);
                while (!tuiles.equals(union(tuiles,autourTuiles(g, tuiles)))) {
                    tuiles = union(tuiles,autourTuiles(g, tuiles));
                }
                tuiles.remove(emplacement);
                ta = new HashMap();
                for (Tuile t : tuiles) {
                    if (!t.estMorte())
                        ta.put(t.getNom(), t);
                }
            }
            return ta;
	}
        
        public ArrayList<Tuile> autourTuiles(Grille g, ArrayList<Tuile> a) {
        ArrayList<Tuile> ta = new ArrayList();
            for (Tuile t : a) {
                if (!t.estSeche() || t == getPos()) {
                    if (t.getLigne() != 0) {
                        if (g.getGrille()[t.getLigne() - 1][t.getColonne()] != null) {
                            ta.add(g.getGrille()[t.getLigne() - 1][t.getColonne()]);
                        }
                    }
                    if (t.getLigne() != 5) {
                        if (g.getGrille()[t.getLigne() + 1][t.getColonne()] != null) {
                            ta.add(g.getGrille()[t.getLigne() + 1][t.getColonne()]);
                        }
                    }
                    if (t.getColonne() != 0) {
                        if (g.getGrille()[t.getLigne()][t.getColonne() - 1] != null) {
                            ta.add(g.getGrille()[t.getLigne()][t.getColonne() - 1]);
                        }
                    }
                    if (t.getColonne() != 5) {
                        if (g.getGrille()[t.getLigne()][t.getColonne() + 1] != null) {
                            ta.add(g.getGrille()[t.getLigne()][t.getColonne() + 1]);
                        }
                    }
                }
            }
            return ta;
        }
        
        public ArrayList<Tuile> union(ArrayList<Tuile> a1, ArrayList<Tuile> a2) {
            ArrayList<Tuile> a = new ArrayList();
            for (Tuile t : a1) {
                a.add(t);
            }
            for (Tuile t : a2) {
                if (!a.contains(t))
                    a.add(t);
            }
            return a;
        }
        
        public void deplacer(Grille g) {
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

}