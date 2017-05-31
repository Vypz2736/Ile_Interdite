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
            if (emplacement.getLigne() !=0 && emplacement.getColonne() !=0)
                if (g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()-1] != null && !g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()-1].estMorte()) {
                    ta.put(g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()-1].getNom(),g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()-1]);
                }
            if (emplacement.getLigne() !=5 && emplacement.getColonne() !=5)
                if (g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()+1] != null && !g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()+1].estMorte()) {
                    ta.put(g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()+1].getNom(),g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()+1]);
                }
            if (emplacement.getLigne() !=5 && emplacement.getColonne() !=0)
                if (g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()-1] != null && !g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()-1].estMorte()) {
                    ta.put(g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()-1].getNom(),g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()-1]);
                }
            if (emplacement.getLigne() !=0 && emplacement.getColonne() !=5)
                if (g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()+1] != null && !g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()+1].estMorte()) {
                    ta.put(g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()+1].getNom(),g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()+1]);
                }
            if (type == 2) {
                ta.put(emplacement.getNom(), emplacement);
                ArrayList<Tuile> at = new ArrayList();
                for (Tuile t : ta.values()) {
                    if (!t.estInonde()) {
                        at.add(t);
                    }
                }
                for (Tuile t : at) {
                    ta.remove(t.getNom());
                }
            }
            return ta;
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