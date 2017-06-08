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

}