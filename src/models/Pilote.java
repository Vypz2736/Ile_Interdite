package models;

import java.util.ArrayList;

public class Pilote extends Aventurier {

        private boolean helico;
	/**
	 * 
	 * @param g
	 */
	public void seDeplacer(Grille g) {
		// TODO - implement Pilote.seDeplacer
		throw new UnsupportedOperationException();
	}
        
        @Override
        public ArrayList<Tuile> getTuilesAcc(Grille g, int type) {
            ArrayList<Tuile> ta = new ArrayList();
            if (type == 1 && ! helico) {
                for (int j = 0; j < 6; j++) {
                    for (int i = 0; i < 6; i++) {
                        if (g.getGrille()[j][i] != null && !g.getGrille()[j][i].estMorte()) {
                            ta.add(g.getGrille()[j][i]);
                        }
                    }
                }
            }
            else {
                if (type == 2)
                    ta.add(emplacement);
                if (emplacement.getLigne() !=0)
                    if (g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()] != null && !g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()].estMorte()) {
                        ta.add(g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()]);
                    }
                if (emplacement.getLigne() !=5)
                    if (g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()] != null && !g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()].estMorte()) {
                        ta.add(g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()]);
                    }
                if (emplacement.getColonne() !=0)
                    if (g.getGrille()[emplacement.getLigne()][emplacement.getColonne()-1] != null && !g.getGrille()[emplacement.getLigne()][emplacement.getColonne()-1].estMorte()) {
                        ta.add(g.getGrille()[emplacement.getLigne()][emplacement.getColonne()-1]);
                    }
                if (emplacement.getColonne() !=0)
                    if (g.getGrille()[emplacement.getLigne()][emplacement.getColonne()+1] != null && !g.getGrille()[emplacement.getLigne()][emplacement.getColonne()+1].estMorte()) {
                        ta.add(g.getGrille()[emplacement.getLigne()][emplacement.getColonne()+1]);
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

}