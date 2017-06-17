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

}