package models;

public class Joueur {

	private Aventurier aventurier;
	private String nom;
        
        public Joueur(String nm) {
            nom = nm;
        }
        
        public Aventurier getAventurier() {
        return aventurier;
        }

        public String getNom() {
            return nom;
        }
        
        public void setAventurier(Aventurier aventurier) {
            this.aventurier = aventurier;
        }

        @Override
        public String toString() {
            return getNom();
        }
}