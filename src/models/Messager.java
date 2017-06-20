package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Messager extends Aventurier {
    
        public ArrayList<Joueur> getJAcc(ArrayList<Joueur> joueurs) {
            ArrayList<Joueur> aj = new ArrayList();
            for (Joueur j : joueurs)
                if (!j.getAventurier().equals(this))
                    aj.add(j);
            return aj;
        }
        
        public void deplacer(Tuile t1, Tuile t2) {
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
        
        public HashMap<String,Tuile> getTuilesAv(Grille g) {
            // TODO - implement Aventurier.recupTresor
            throw new UnsupportedOperationException();
        }
    
        public HashMap<String,Tuile> getTuilesAccDeplacer(Grille g, Tuile t1) {
            // TODO - implement Aventurier.recupTresor
            throw new UnsupportedOperationException();
        }

	public boolean getSeche() {
            // TODO - implement Aventurier.recupTresor
            throw new UnsupportedOperationException();
	}
        
	public void setSeche(boolean seche) {
            // TODO - implement Aventurier.recupTresor
            throw new UnsupportedOperationException();
	}
        
        public void assecherG(ArrayList<Tuile> at) {
            // TODO - implement Aventurier.recupTresor
            throw new UnsupportedOperationException();
        }

}