package models;

import java.util.*;
import util.*;

public class Tuile {

	ArrayList<Aventurier> aventuriers;
	private int inonde;
	private int ligne;
	private int colonne;
	private String nom;
	private Tresor tresor;

        public Tuile(String nom) {
            this.nom = nom;
            inonde = 0;
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
		// TODO - implement Tuile.estMorte
		throw new UnsupportedOperationException();
	}

	public boolean estInonde() {
		// TODO - implement Tuile.estInonde
		throw new UnsupportedOperationException();
	}

	public boolean estSeche() {
		// TODO - implement Tuile.estSeche
		throw new UnsupportedOperationException();
	}

	public void inonder() {
		// TODO - implement Tuile.inonder
		throw new UnsupportedOperationException();
	}

	public void secher() {
		// TODO - implement Tuile.secher
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param a
	 */
	public void ajouterAv(Aventurier a) {
		// TODO - implement Tuile.ajouterAv
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param a
	 */
	public void retirerAv(Aventurier a) {
		// TODO - implement Tuile.retirerAv
		throw new UnsupportedOperationException();
	}

        @Override
        public String toString() {
            return getNom();
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

}