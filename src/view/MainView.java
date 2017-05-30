/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controleur.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import models.Explorateur;
import models.Ingenieur;
import models.Joueur;
import models.Messager;
import models.Navigateur;
import models.Pilote;
import models.Plongeur;
import models.Tuile;

/**
 *
 * @author Vypz
 */
public class MainView {

    private final JFrame window;
    private VueGrille v;
    private Controleur c = new Controleur();
    private VueJoueurs j = new VueJoueurs();
    private JPanel mainpanel;
    private JPanel saisiejoueurs;
    private ArrayList<String> noms = new ArrayList();
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private VueAventurier pilote;
    private VueAventurier navigateur;
    private VueAventurier plongeur;
    private VueAventurier explorateur;
    private VueAventurier ingenieur;
    private VueAventurier messager;
    
    public MainView() {
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setTitle("L'Île Interdite");
        window.setMaximumSize(new Dimension((int)dim.getWidth()/2,(int)dim.getHeight()/2));window.setMinimumSize(new Dimension((int)dim.getWidth()/2,(int)dim.getHeight()/2));
        window.setLocation((int)(dim.getWidth()-dim.getWidth()/2)/2, (int)(dim.getHeight()-dim.getHeight()/2)/2);
        mainpanel = new JPanel(new GridBagLayout());
        mainpanel.setBackground(new Color(35,35,35));
        mainpanel.setSize(window.getHeight(),window.getHeight());
        saisiejoueurs = new JPanel(new GridLayout(2,1));
        JPanel titre = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {;
                g.drawImage(new ImageIcon(new ImageIcon(getClass().getResource("/img/titre.png")).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)).getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        saisiejoueurs.add(titre);
        saisiejoueurs.add(j);
        mainpanel.add(saisiejoueurs);
        window.add(mainpanel);
        window.setVisible(true);
        while (j.recupsaisie().size() == 0);
        noms = j.recupsaisie();
        for (String s : noms)
            c.nouveauJoueur(s);
        c.init();
        mainpanel.remove(saisiejoueurs);
        window.setMaximumSize(dim);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        v = new VueGrille(getC().getGrille());
        window.remove(mainpanel);
        window.add(v);
        window.setVisible(true);
    }

    /**
     * @return the v
     */
    public VueGrille getV() {
        return v;
    }

    /**
     * @return the c
     */
    public Controleur getC() {
        return c;
    }
    
    public static void main(String[] args) {
        MainView m = new MainView();
        int nbi = 0;
        for (Tuile t : m.getC().getAt()) {
            if (t.estInonde()) {
                nbi++;
            }
        }
        while (1 == 1) {
            for (Joueur j : m.getC().getJoueurs()) {
                if (j.getAventurier() instanceof Pilote && m.getPilote() == null)
                    m.setPilote(new VueAventurier(j));
                if (j.getAventurier() instanceof Navigateur)
                    m.setNavigateur(new VueAventurier(j));
                if (j.getAventurier() instanceof Plongeur && m.getPlongeur() == null)
                    m.setPlongeur(new VueAventurier(j));
                if (j.getAventurier() instanceof Explorateur && m.getExplorateur() == null)
                    m.setExplorateur(new VueAventurier(j));
                if (j.getAventurier() instanceof Ingenieur && m.getIngenieur() == null)
                    m.setIngenieur(new VueAventurier(j));
                if (j.getAventurier() instanceof Messager && m.getMessager() == null)
                    m.setMessager(new VueAventurier(j));
                while(j.getAventurier().getNbactions()<3) {
                    ArrayList<Tuile> tuiles = new ArrayList();
                    for (Tuile t : j.getAventurier().getTuilesAcc(m.getC().getGrille(), 1).values()) {
                        tuiles.add(t);
                    }
                    m.getV().setTuilesSurbrillance(tuiles, true);
                    m.getC().actionJoueur(j);
                    m.getV().setTuilesSurbrillance(tuiles, false);
                    m.getV().couleur(m.getC().getGrille());
                }
                if (j.getAventurier() instanceof Pilote)
                    j.getAventurier().setHelico(false);
                j.getAventurier().setNbactions(0);
            }
            nbi = 0;
            for (Tuile t : m.getC().getAt()) {
                if (t.estInonde()) {
                    nbi++;
                }
            }
        }
        
    }

    /**
     * @return the pilote
     */
    public VueAventurier getPilote() {
        return pilote;
    }

    /**
     * @return the navigateur
     */
    public VueAventurier getNavigateur() {
        return navigateur;
    }

    /**
     * @return the plongeur
     */
    public VueAventurier getPlongeur() {
        return plongeur;
    }

    /**
     * @return the explorateur
     */
    public VueAventurier getExplorateur() {
        return explorateur;
    }

    /**
     * @return the ingenieur
     */
    public VueAventurier getIngenieur() {
        return ingenieur;
    }

    /**
     * @return the messager
     */
    public VueAventurier getMessager() {
        return messager;
    }

    /**
     * @param pilote the pilote to set
     */
    public void setPilote(VueAventurier pilote) {
        this.pilote = pilote;
    }

    /**
     * @param navigateur the navigateur to set
     */
    public void setNavigateur(VueAventurier navigateur) {
        this.navigateur = navigateur;
    }

    /**
     * @param plongeur the plongeur to set
     */
    public void setPlongeur(VueAventurier plongeur) {
        this.plongeur = plongeur;
    }

    /**
     * @param explorateur the explorateur to set
     */
    public void setExplorateur(VueAventurier explorateur) {
        this.explorateur = explorateur;
    }

    /**
     * @param ingenieur the ingenieur to set
     */
    public void setIngenieur(VueAventurier ingenieur) {
        this.ingenieur = ingenieur;
    }

    /**
     * @param messager the messager to set
     */
    public void setMessager(VueAventurier messager) {
        this.messager = messager;
    }
    
}
