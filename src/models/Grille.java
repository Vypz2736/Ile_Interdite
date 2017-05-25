package models;

import java.util.*;

public class Grille {

	private Tuile[][] tuiles = new Tuile[6][6];
        
        public Grille(ArrayList<Tuile> at) {
            int j = 0;
            for (int n = 1, i = 1; n < 37; n++, i++) {
                if ((i+1) % 6 == 0) {
                    i = 0;
                    j = j + 1;
                }
                if ((i==0 && j==0) || (i==1 && j==0) || (i==0 && j==1) ||
                   (i==5 && j==0) || (i==4 && j==0) || (i==5 && j==1) ||
                   (i==0 && j==5) || (i==1 && j==5) || (i==0 && j==4) ||
                   (i==5 && j==5) || (i==5 && j==4) || (i==4 && j==5)) {
                    this.tuiles[j][i] = null;
                    n = n - 1;
                }
                else {
                    this.tuiles[j][i] = at.get(n);
                    at.get(n).setLigne(j);
                    at.get(n).setColonne(i);
                }
            }  
        }

	public Collection<Tuile> getTuilesIn() {
		// TODO - implement Grille.getTuilesIn
		throw new UnsupportedOperationException();
	}

	public Collection<Tuile> getTuilesPres() {
		// TODO - implement Grille.getTuilesPres
		throw new UnsupportedOperationException();
	}

	public Collection<Tuile> getTuiles() {
		// TODO - implement Grille.getTuiles
		throw new UnsupportedOperationException();
	}

	public Tuile[][] getGrille() {
		// TODO - implement Grille.getGrille
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nom
	 */
	public Tuile getTuile(String nom) {
		// TODO - implement Grille.getTuile
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param l
	 * @param c
	 */
	public Tuile getTuile(int l, int c) {
		// TODO - implement Grille.getTuile
		throw new UnsupportedOperationException();
	}

        @Override
        public String toString() {
            String grille = null;
            int j = 0;
            for (int n = 1, i = 1; n < 37; n++, i++) {
                if ((i+1) % 6 == 0) {
                    i = 0;
                    j = j + 1;
                    grille = grille + "\n";
                }
                if (this.tuiles[j][i] == null) {
                    grille = grille + " " + j + i + " :      Tuile vide     ";
                }
                else
                    grille = grille + " " + j + i + " : " + this.tuiles[j][i];
            }
            return grille;
        }

        
}