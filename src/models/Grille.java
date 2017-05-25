package models;

import java.util.*;

public class Grille {

	private Tuile[][] tuiles = new Tuile[6][6];
        
        public Grille(ArrayList<Tuile> at) {
            int n = 0;
            for (int j = 0; j < 6; j++) {
                for (int i = 0; i < 6; i++) {
                    //System.out.println(j + "" + i);
                    if ((i==0 && j==0) || (i==1 && j==0) || (i==0 && j==1) ||
                    (i==5 && j==0) || (i==4 && j==0) || (i==5 && j==1) ||
                    (i==0 && j==5) || (i==1 && j==5) || (i==0 && j==4) ||
                    (i==5 && j==5) || (i==5 && j==4) || (i==4 && j==5)) {
                        this.tuiles[j][i] = null;
                        //System.out.println("null");
                    }
                    else {
                        this.tuiles[j][i] = at.get(n);
                        at.get(n).setLigne(j);
                        at.get(n).setColonne(i);
                        n++;
                    }
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
            String grille = "";
            for (int j = 0; j < 6; j++) {
                for (int i = 0; i < 6; i++) {
                if (this.tuiles[j][i] == null) {
                    grille = grille + " " + j + i + " :           Tuile vide          ";
                }
                else
                    grille = grille + " " + j + i + " : " + this.tuiles[j][i];
                }
                grille = grille + "\n";
            }
            return grille;
        }

        
}