package models;

import java.util.*;
import util.*;

public abstract class Aventurier {

    ArrayList<CarteTresor> cartes = new ArrayList();
    Tuile emplacement;
    Tuile empPrec;
    private int nbactions = 0;
    private boolean helico;

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
        cartes.remove(c);
    }

    public ArrayList<CarteTresor> getCartes() {
        return cartes;
    }

    /**
     *
     * @param c
     */
    public void ajouterCarte(CarteTresor c) {
        cartes.add(c);
    }

    public Tuile getPos() {
        return emplacement;
    }

    public Tuile getPosPrec() {
        return empPrec;
    }

    /**
     *
     * @param t
     */
    public void setPos(Tuile t) {
        empPrec = getPos();
        emplacement = t;
    }

    /**
     *
     * @param g
     */
    public void seDeplacer(Grille g) {
        Scanner st = new Scanner(System.in);
        for (Tuile t : getTuilesAcc(g, 1).values()) {
            System.out.println("- " + t);
        }
        String nom = st.nextLine();
        if (getTuilesAcc(g, 1).get(nom) != null) {
            getPos().retirerAv(this);
            getTuilesAcc(g, 1).get(nom).ajouterAv(this);
            setPos(getTuilesAcc(g, 1).get(nom));
            setNbactions(getNbactions() + 1);
        }
    }

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
        for (Tuile t : tuiles.values()) {
            System.out.println("- " + t.getNom());
        }
        String nom = st.nextLine();
        if (tuiles.get(nom) != null) {
            tuiles.get(nom).secher();
            setNbactions(getNbactions() + 1);
            System.out.println("Tuile " + getTuilesAcc(g, 2).get(nom) + " asséchée.");
        }
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
        if (getPos().getTresor() != null)
            setNbactions(getNbactions() + 1);
        return getPos().getTresor();
    }

    /**
     *
     * @param t
     */
    /**
     *
     * @param g
     * @param type
     */
    public HashMap<String, Tuile> getTuilesAcc(Grille g, int type) {
        HashMap<String, Tuile> ta = new HashMap();
        if (emplacement.getLigne() != 0) {
            if (g.getGrille()[emplacement.getLigne() - 1][emplacement.getColonne()] != null && !g.getGrille()[emplacement.getLigne() - 1][emplacement.getColonne()].estMorte()) {
                ta.put(g.getGrille()[emplacement.getLigne() - 1][emplacement.getColonne()].getNom(), g.getGrille()[emplacement.getLigne() - 1][emplacement.getColonne()]);
            }
        }
        if (emplacement.getLigne() != 5) {
            if (g.getGrille()[emplacement.getLigne() + 1][emplacement.getColonne()] != null && !g.getGrille()[emplacement.getLigne() + 1][emplacement.getColonne()].estMorte()) {
                ta.put(g.getGrille()[emplacement.getLigne() + 1][emplacement.getColonne()].getNom(), g.getGrille()[emplacement.getLigne() + 1][emplacement.getColonne()]);
            }
        }
        if (emplacement.getColonne() != 0) {
            if (g.getGrille()[emplacement.getLigne()][emplacement.getColonne() - 1] != null && !g.getGrille()[emplacement.getLigne()][emplacement.getColonne() - 1].estMorte()) {
                ta.put(g.getGrille()[emplacement.getLigne()][emplacement.getColonne() - 1].getNom(), g.getGrille()[emplacement.getLigne()][emplacement.getColonne() - 1]);
            }
        }
        if (emplacement.getColonne() != 5) {
            if (g.getGrille()[emplacement.getLigne()][emplacement.getColonne() + 1] != null && !g.getGrille()[emplacement.getLigne()][emplacement.getColonne() + 1].estMorte()) {
                ta.put(g.getGrille()[emplacement.getLigne()][emplacement.getColonne() + 1].getNom(), g.getGrille()[emplacement.getLigne()][emplacement.getColonne() + 1]);
            }
        }
        if (type == 2) {
            ta.put(emplacement.getNom(), emplacement);
            ArrayList<Tuile> at = new ArrayList();
            for (Tuile t : ta.values()) {
                if (!t.estInonde()) {
                    at.add(t);
                }
            }
            for (Tuile t : at) {
                ta.remove(t.getNom());
            }
        }
        return ta;
    }

    public abstract void deplacer(Grille g);

    /**
     * @return the helico
     */
    public abstract boolean getHelico();

    /**
     * @param helico the helico to set
     */
    public abstract void setHelico(boolean helico);

}
