package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Ingenieur extends Aventurier {

	private int seche;

	/**
	 * 
	 * @param g
	 */
        @Override
	public void assecher(Grille g) {
            Scanner st = new Scanner(System.in);
            HashMap<String, Tuile> tuiles = getTuilesAcc(g, 2);
            boolean abandonner = false;
            String nom = "lol";
            int nbi = 1; 
            while (getSeche() < 2 && abandonner == false && nbi != 0) {
                for (Tuile t : tuiles.values()) {
                    if (t.getNom() != nom)
                     System.out.println("- " + t.getNom());
                }
                nom = st.nextLine();
                if (tuiles.get(nom) != null) {
                    tuiles.get(nom).secher();
                    setSeche(getSeche()+1);
                    if (getSeche() == 1)
                        setNbactions(getNbactions()+1);
                    System.out.println("Tuile " + tuiles.get(nom) + " asséchée.");
                    tuiles.remove(tuiles.get(nom));
                }
                nbi = 0;
                for (Tuile t : g.getTuiles()) {
                    if (t != null && t.estInonde()) {
                        nbi++;
                    }
                }
            }
            setSeche(0);
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
                        if (g.getGrille()[j][i] != null && g.getGrille()[j][i].estInonde()) {
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
                if (emplacement.getColonne() !=5)
                    if (g.getGrille()[emplacement.getLigne()][emplacement.getColonne()+1] != null && !g.getGrille()[emplacement.getLigne()][emplacement.getColonne()+1].estMorte()) {
                        ta.put(g.getGrille()[emplacement.getLigne()][emplacement.getColonne()+1].getNom(),g.getGrille()[emplacement.getLigne()][emplacement.getColonne()+1]);
                    }
            }
            return ta;
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