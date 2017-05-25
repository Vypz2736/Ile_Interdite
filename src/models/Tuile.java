package models;

import java.util.*;
import util.*;

public class Tuile {

	private ArrayList<Aventurier> aventuriers = new ArrayList();
	private int inonde;
	private int ligne;
	private int colonne;
	private String nom;
	private Tresor tresor;

        public Tuile(String nom, int etat) {
            this.nom = nom;
            inonde = etat;
        }
        
	public int getLigne() {
		return this.ligne;
	}

	public int getColonne() {
		return this.colonne;
	}

	public String getNom() {
		return this.nom;
	}

	public boolean estMorte() {
		return inonde == 2;
	}

	public boolean estInonde() {
		return inonde == 1;
	}

	public boolean estSeche() {
		return inonde == 0;
	}

	public void inonder() {
		inonde++;
	}

	public void secher() {
		inonde--;
	}

	/**
	 * 
	 * @param a
	 */
	public void ajouterAv(Aventurier a) {
		getAventuriers().add(a);
	}

	/**
	 * 
	 * @param a
	 */
	public void retirerAv(Aventurier a) {
		getAventuriers().remove(a);
	}

        @Override
        public String toString() {
            if (estSeche())
                return getNom() + " : sèche  ";
            if (estInonde())
                return getNom() + " : inondée";
            return getNom() + " : coulée ";
        }

        /**
        * @param ligne the ligne to set
        */
        public void setLigne(int ligne) {
           this.ligne = ligne;
        }

        /**
        * @param colonne the colonne to set
        */
        public void setColonne(int colonne) {
           this.colonne = colonne;
        }

        /**
        * @param tresor the tresor to set
        */
        public void setTresor(Tresor tresor) {
           this.tresor = tresor;
        }

        /**
         * @return the aventuriers
         */
        public ArrayList<Aventurier> getAventuriers() {
            return aventuriers;
        }

        /**
         * @return the tresor
         */
        public Tresor getTresor() {
            return tresor;
        }

}