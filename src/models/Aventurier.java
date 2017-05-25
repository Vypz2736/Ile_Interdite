import java.util.*;

public abstract class Aventurier {

	Collection<CarteTresor> cartes;
	Tuile emplacement;
	private Couleur couleur;
	private int nbactions;
	private boolean helicoUtilise;

	public Couleur getCouleur() {
		return this.couleur;
	}

	/**
	 * 
	 * @param c
	 */
	public void utiliserCarte(CarteTresor c) {
		// TODO - implement Aventurier.utiliserCarte
		throw new UnsupportedOperationException();
	}

	public int getNbactions() {
		return this.nbactions;
	}

	/**
	 * 
	 * @param nb
	 */
	public void setNbactions(int nb) {
		this.nbactions = nb;
	}

	/**
	 * 
	 * @param c
	 */
	public void jetercarte(CarteTresor c) {
		// TODO - implement Aventurier.jetercarte
		throw new UnsupportedOperationException();
	}

	public Collection<Cartes> getCartes() {
		// TODO - implement Aventurier.getCartes
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param c
	 */
	public void ajouterCarte(Carte c) {
		// TODO - implement Aventurier.ajouterCarte
		throw new UnsupportedOperationException();
	}

	public Tuile getPos() {
		// TODO - implement Aventurier.getPos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param t
	 */
	public void setPos(Tuile t) {
		// TODO - implement Aventurier.setPos
		throw new UnsupportedOperationException();
	}

	public boolean getHelicoUtilise() {
		return this.helicoUtilise;
	}

	/**
	 * 
	 * @param h
	 */
	public void setHelicoUtilise(boolean h) {
		this.helicoUtilise = h;
	}

	/**
	 * 
	 * @param g
	 */
	public void seDeplacer(Grille g) {
		// TODO - implement Aventurier.seDeplacer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param g
	 */
	public void assecher(Grille g) {
		// TODO - implement Aventurier.assecher
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param g
	 */
	public void donnerCarte(Grille g) {
		// TODO - implement Aventurier.donnerCarte
		throw new UnsupportedOperationException();
	}

	public Tresor recupTresor() {
		// TODO - implement Aventurier.recupTresor
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param t
	 */
	public abstract void deplacer(Tuile t);

	/**
	 * 
	 * @param g
	 * @param type
	 */
	public Collection<Tuiles> getTuilesAcc(Grille g, int type) {
		// TODO - implement Aventurier.getTuilesAcc
		throw new UnsupportedOperationException();
	}

}