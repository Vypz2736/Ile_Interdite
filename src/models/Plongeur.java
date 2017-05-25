package models;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Plongeur extends Aventurier {

	/**
	 * 
	 * @param g
	 */
        @Override
	public void seDeplacer(Grille g) {
            boolean continuer = false;
            Scanner st = new Scanner(System.in);
            for (Tuile t : getTuilesAcc(g,1).values()) {
                System.out.println("- " + t.getNom());
            }
            String nom = st.nextLine();
            if (getTuilesAcc(g,1).get(nom) != null) {
                getPos().retirerAv(this);
                getTuilesAcc(g,1).get(nom).ajouterAv(this);
                setPos(getTuilesAcc(g,1).get(nom));
                setNbactions(getNbactions()+1);
                if (!getPos().estSeche()) {
                    if (!getPos().estMorte())
                        System.out.println("Voulez vous continuer votre déplacement sans utiliser plus d'actions ? o/n");
                        if (st.nextLine() == "o")
                            continuer = true;
                    while ((!getPos().estSeche() && continuer) || getPos().estMorte()) {
                        for (Tuile t : getTuilesAcc(g,1).values()) {
                            System.out.println("- " + t.getNom());
                        }
                        nom = st.nextLine();
                        if (getTuilesAcc(g,1).get(nom) != null) {
                            getPos().retirerAv(this);
                            getTuilesAcc(g,1).get(nom).ajouterAv(this);
                            setPos(getTuilesAcc(g,1).get(nom));
                            setNbactions(getNbactions()+1);
                            if (!getPos().estSeche()) {
                                if (!getPos().estMorte())
                                    System.out.println("Voulez vous continuer votre déplacement sans utiliser plus d'actions ? o/n");
                                    if (st.nextLine() == "o")
                                        continuer = true;
                                    else
                                        continuer = false;
                            }
                        }
                    }
                }
            }
	}

	/**
	 * 
	 * @param g
	 * @param type
	 */
	@Override
	public HashMap<String,Tuile> getTuilesAcc(Grille g, int type) {
            HashMap<String,Tuile> ta = new HashMap();
            if (type == 2)
                for (Tuile t : super.getTuilesAcc(g, type).values()) {
                    ta.put(t.getNom(),t);
                }
            else {
                if (emplacement.getLigne() !=0)
                    if (g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()] != null) {
                        ta.put(g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()].getNom(),g.getGrille()[emplacement.getLigne()-1][emplacement.getColonne()]);
                    }
                if (emplacement.getLigne() !=5)
                    if (g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()] != null) {
                        ta.put(g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()].getNom(),g.getGrille()[emplacement.getLigne()+1][emplacement.getColonne()]);
                    }
                if (emplacement.getColonne() !=0)
                    if (g.getGrille()[emplacement.getLigne()][emplacement.getColonne()-1] != null) {
                        ta.put(g.getGrille()[emplacement.getLigne()][emplacement.getColonne()-1].getNom(),g.getGrille()[emplacement.getLigne()][emplacement.getColonne()-1]);
                    }
                if (emplacement.getColonne() !=0)
                    if (g.getGrille()[emplacement.getLigne()][emplacement.getColonne()+1] != null) {
                        ta.put(g.getGrille()[emplacement.getLigne()][emplacement.getColonne()+1].getNom(),g.getGrille()[emplacement.getLigne()][emplacement.getColonne()+1]);
                    }
            }
            return ta;
	}

}