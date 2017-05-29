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

	public Tuile[][] getGrille() {
            return tuiles;
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
        
        public ArrayList<Tuile> getTuiles() {
            ArrayList<Tuile> at = new ArrayList();
            for (int j = 0; j < 6; j++) {
                for (int i = 0; i < 6; i++) {
                    if (this.tuiles[j][i] != null) 
                        at.add(tuiles[j][i]);
                }
            }
            return at;
        }

        
}