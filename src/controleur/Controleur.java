package controleur;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import models.*;
import util.*;
import view.*;

public class Controleur {

	private NivEau nivEau;
	private Grille grille;
	private VueAventurier vueAventurier;
	private VueGrille vueGrille;
	private ArrayList<Joueur> joueurs = new ArrayList();
	private ArrayList<Aventurier> aventuriers = new ArrayList();
	private ArrayList<CarteTresor> deft = new ArrayList();
	private ArrayList<CarteTresor> pilet = new ArrayList();
	private ArrayList<CarteInondation> defi = new ArrayList();
	private ArrayList<CarteInondation> pilei = new ArrayList();
	private ArrayList<Tresor> tresors;
        private ArrayList<Tuile> at;
        private JFrame window = new JFrame();
        private VueGrille v;
        private VueJoueurs j;
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

        public Controleur() {
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
            j = new VueJoueurs(this);
            saisiejoueurs.add(j);
            mainpanel.add(saisiejoueurs);
            window.add(mainpanel);
            window.setVisible(true);
            lancerPartie();
        }

	public CarteTresor tirerCT() {
		// TODO - implement Controleur.tirerCT
		throw new UnsupportedOperationException();
	}

	public CarteInondation tirerCI() {
		// TODO - implement Controleur.tirerCI
		throw new UnsupportedOperationException();
	}

	public NivEau getNiv() {
		// TODO - implement Controleur.getNiv
		throw new UnsupportedOperationException();
	}
        
        public void nouveauJoueur(String nom) {
            getJoueurs().add(new Joueur(nom));
        }
        
        public void initGrille() {
            int i;
            at = new ArrayList();
            getAt().add(new Tuile("LePontdesabimes",0));
            getAt().add(new Tuile("LaPortedebronze",1));
            i = getAt().size()-1;
            for (Joueur j : getJoueurs()) {
                if (j.getAventurier() instanceof Ingenieur) {
                    getAt().get(i).ajouterAv(j.getAventurier());
                    j.getAventurier().setPos(getAt().get(i));
                }
            }
            getAt().add(new Tuile("LaCavernedesombres",0));
            i = getAt().size()-1;
            getAt().get(i).setTresor(Tresor.Cristal);
            getAt().add(new Tuile("LaPortedefer",0));
            i = getAt().size()-1;
            for (Joueur j : getJoueurs()) {
                if (j.getAventurier() instanceof Plongeur) {
                    getAt().get(i).ajouterAv(j.getAventurier());
                    j.getAventurier().setPos(getAt().get(i));
                }
            }
            getAt().add(new Tuile("LaPortedor",0));
            i = getAt().size()-1;
            for (Joueur j : getJoueurs()) {
                if (j.getAventurier() instanceof Navigateur) {
                    getAt().get(i).ajouterAv(j.getAventurier());
                    j.getAventurier().setPos(getAt().get(i));
                }
            }
            getAt().add(new Tuile("LesFalaisesdeloubli",0));
            getAt().add(new Tuile("LePalaisdecorail",0));
            i = getAt().size()-1;
            getAt().get(i).setTresor(Tresor.Calice);
            getAt().add(new Tuile("LaPortedargent",0));
            i = getAt().size()-1;
            for (Joueur j : getJoueurs()) {
                if (j.getAventurier() instanceof Messager) {
                    getAt().get(i).ajouterAv(j.getAventurier());
                    j.getAventurier().setPos(getAt().get(i));
                }
            }
            getAt().add(new Tuile("LesDunesdelillusion",2));
            getAt().add(new Tuile("Heliport",0));
            i = getAt().size()-1;
            for (Joueur j : getJoueurs()) {
                if (j.getAventurier() instanceof Pilote) {
                    getAt().get(i).ajouterAv(j.getAventurier());
                    j.getAventurier().setPos(getAt().get(i));
                }
            }
            getAt().add(new Tuile("LaPortedecuivre",0));
            i = getAt().size()-1;
            for (Joueur j : getJoueurs()) {
                if (j.getAventurier() instanceof Explorateur) {
                    getAt().get(i).ajouterAv(j.getAventurier());
                    j.getAventurier().setPos(getAt().get(i));
                }
            }
            getAt().add(new Tuile("LeJardindeshurlements",0));
            i = getAt().size()-1;
            getAt().get(i).setTresor(Tresor.Statue);
            getAt().add(new Tuile("LaForetpourpre",0));
            getAt().add(new Tuile("LeLagonperdu",1));
            getAt().add(new Tuile("LeMaraisbrumeux",2));
            getAt().add(new Tuile("Observatoire",1));
            getAt().add(new Tuile("LeRocherfantome",2));
            getAt().add(new Tuile("LaCavernedubrasier",1));
            i = getAt().size()-1;
            getAt().get(i).setTresor(Tresor.Cristal);
            getAt().add(new Tuile("LeTempledusoleil",0));
            i = getAt().size()-1;
            getAt().get(i).setTresor(Tresor.Pierre);
            getAt().add(new Tuile("LeTempledelalune",2));
            i = getAt().size()-1;
            getAt().get(i).setTresor(Tresor.Pierre);
            getAt().add(new Tuile("LePalaisdesmarees",0));
            i = getAt().size()-1;
            getAt().get(i).setTresor(Tresor.Calice);
            getAt().add(new Tuile("LeValducrepuscule",0));
            getAt().add(new Tuile("LaTourdeguet",0));
            getAt().add(new Tuile("LeJardindesmurmures",1));
            i = getAt().size()-1;
            getAt().get(i).setTresor(Tresor.Statue);
            //Collections.shuffle(at);
            grille = new Grille(getAt());
        }
        
        public Grille getGrille() {
            return grille;
        }
        
        public void initAventuriers() {
            aventuriers.add(new Pilote());
            aventuriers.add(new Navigateur());
            aventuriers.add(new Plongeur());
            aventuriers.add(new Explorateur());
            aventuriers.add(new Ingenieur());
            aventuriers.add(new Messager());
            Collections.shuffle(aventuriers);
        }
        
        public void initJoueurs() {
            int i = 0;
            for (Joueur j : getJoueurs()) {
                j.setAventurier(aventuriers.get(i));
                if (j.getAventurier() instanceof Pilote)
                    System.out.println(j.getNom() + " jouera le pilote.");
                if (j.getAventurier() instanceof Navigateur)
                    System.out.println(j.getNom() + " jouera le navigateur.");
                if (j.getAventurier() instanceof Plongeur)
                    System.out.println(j.getNom() + " jouera le plongeur.");
                if (j.getAventurier() instanceof Explorateur)
                    System.out.println(j.getNom() + " jouera l'explorateur.");
                if (j.getAventurier() instanceof Ingenieur)
                    System.out.println(j.getNom() + " jouera l'ingénieur.");
                if (j.getAventurier() instanceof Messager)
                    System.out.println(j.getNom() + " jouera le messager.");
                i++;
            }
            System.out.println("");
        }
        
        public void init() {
            initAventuriers();
            initJoueurs();
            initGrille();
        }
        
        public void actionJoueur(Joueur j) {
            Scanner sa = new Scanner(System.in);
            System.out.println(grille);
            if (j.getAventurier() instanceof Navigateur)
                System.out.println("Choisissez une action parmis : \n- 1 : se deplacer \n- 2 : assecher une tuile\n- 3 : terminer le tour\n- 4 : deplacer un joueur");
            else
                System.out.println("Choisissez une action parmis : \n- 1 : se deplacer \n- 2 : assecher une tuile\n- 3 : terminer le tour");
            int action = sa.nextInt(); 
            if (action == 1) {
                j.getAventurier().seDeplacer(grille);
            }
            else if (action == 2) {
                j.getAventurier().assecher(grille);
            }
            else if (action == 3) {
                j.getAventurier().setNbactions(3);
            }
            else if (j.getAventurier() instanceof Navigateur && action == 4) {
                j.getAventurier().deplacer(grille);
            }
            System.out.println(grille);
        }

        /**
         * @return the joueurs
         */
        public ArrayList<Joueur> getJoueurs() {
            return joueurs;
        }
        
        public void lancerPartie() {
            for (String s : noms)
                nouveauJoueur(s);
            nouveauJoueur("jayetlan");
            nouveauJoueur("laloule");
            System.err.println("avantinit");
            init();
            System.err.println("init");
            mainpanel.remove(saisiejoueurs);
            window.setMaximumSize(dim);
            window.setExtendedState(JFrame.MAXIMIZED_BOTH);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            v = new VueGrille(getGrille(),this);
            window.remove(mainpanel);
            window.add(v);
            window.setVisible(true);
            int nbi = 0;
            for (Tuile t : getAt()) {
                if (t.estInonde()) {
                    nbi++;
                }
            }
            while (1 == 1) {
            System.err.println("bouclejeu");
                for (Joueur j : getJoueurs()) {
                    if (j.getAventurier() instanceof Pilote && pilote == null)
                        pilote = (new VueAventurier(j));
                    if (j.getAventurier() instanceof Navigateur && navigateur == null)
                        navigateur = (new VueAventurier(j));
                    if (j.getAventurier() instanceof Plongeur && plongeur == null)
                        plongeur = (new VueAventurier(j));
                    if (j.getAventurier() instanceof Explorateur && explorateur == null)
                        explorateur = (new VueAventurier(j));
                    if (j.getAventurier() instanceof Ingenieur && ingenieur == null)
                        ingenieur = (new VueAventurier(j));
                    if (j.getAventurier() instanceof Messager && messager == null)
                        messager = (new VueAventurier(j));
                    while(j.getAventurier().getNbactions()<3) {
                        ArrayList<Tuile> tuiles = new ArrayList();
                        for (Tuile t : j.getAventurier().getTuilesAcc(getGrille(), 1).values()) {
                            tuiles.add(t);
                        }
                        v.setTuilesSurbrillance(tuiles, true);
                        actionJoueur(j);
                        v.setTuilesSurbrillance(tuiles, false);
                        v.couleur(getGrille());
                    }
                    if (j.getAventurier() instanceof Pilote)
                        j.getAventurier().setHelico(false);
                    j.getAventurier().setNbactions(0);
                }
                nbi = 0;
                for (Tuile t : getAt()) {
                    if (t.estInonde()) {
                        nbi++;
                    }
                }
            }
        }

    /**
     * @return the at
     */
    public ArrayList<Tuile> getAt() {
        return at;
    }
    
    public void traiterMessage(Message msg) {
        if (msg.getType() == Message.TypeMessage.SAISIEFINIE) {
            noms = j.recupsaisie();
            System.err.println(noms);
            lancerPartie();
        }
    }

}