package models;

import models.Tuile;

public class CarteInondation extends Carte {

	private Tuile zone;

        public CarteInondation(Tuile t) {
            zone = t;
        }

	public Tuile getTuile() {
            return zone;
	}

    @Override
    public String toString() {
        return zone.toString();
    }

    @Override
    public String getNom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}