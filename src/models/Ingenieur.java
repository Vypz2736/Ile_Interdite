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
	public void assecher(Grille g) {
            Scanner st = new Scanner(System.in);
            HashMap<String, Tuile> tuiles = new HashMap();
            for (Tuile t : getTuilesAcc(g, 2).values()) {
                if (!t.estSeche())
                    tuiles.put(t.getNom(), t);
            }
            boolean abandonner = false;
            String nom;
            while (getSeche() < 2 && abandonner == false) {
                for (Tuile t : tuiles.values()) {
                    System.out.println("- " + t.getNom());
                }
                nom = st.nextLine();
                if (tuiles.get(nom) != null) {
                    tuiles.get(nom).secher();
                    if (getSeche() == 1)
                        setNbactions(getNbactions()+1);
                    setSeche(getSeche()+1);
                    tuiles.remove(getTuilesAcc(g, 2).get(nom));
                    System.out.println("Tuile " + getTuilesAcc(g, 2).get(nom) + " asséchée.");
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