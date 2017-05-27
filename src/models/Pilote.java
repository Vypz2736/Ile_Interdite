package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Pilote extends Aventurier {

        private boolean helico;
	/**
	 * 
	 * @param g
	 */
	public void seDeplacer(Grille g) {
            super.seDeplacer(g);
            if (!super.getTuilesAcc(g,1).values().contains(getPosPrec())) {
                setHelico(true);
            }
	}
        
        @Override
        public HashMap<String,Tuile> getTuilesAcc(Grille g, int type) {
            HashMap<String,Tuile> ta = new HashMap();
            if (type == 1 && !helico) {
                for (int j = 0; j < 6; j++) {
                    for (int i = 0; i < 6; i++) {
                        if (g.getGrille()[j][i] != null && !g.getGrille()[j][i].estMorte()) {
                            ta.put(g.getGrille()[j][i].getNom(),g.getGrille()[j][i]);
                        }
                    }
                }
                ta.remove(emplacement.getNom());
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

        /**
         * @return the helico
         */
        public boolean getHelico() {
            return helico;
        }

        /**
         * @param helico the helico to set
         */
        public void setHelico(boolean helico) {
            this.helico = helico;
        }
        
        public void deplacer(Grille g) {
            // TODO - implement Aventurier.recupTresor
            throw new UnsupportedOperationException();
        }

}