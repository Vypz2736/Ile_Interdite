package models;

import util.*;

public class CTresor extends Carte {

    /**
     * @return the tresor
     */
    public Tresor getTresor() {
        return tresor;
    }

    private Tresor tresor;

    public CTresor(Tresor t) {
        tresor = t;
    }

    @Override
    public String getNom() {
        return "une carte pour le tresor : " + tresor.toString();
    }

}