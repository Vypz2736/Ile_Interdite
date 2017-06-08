package controleur;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import models.*;
import util.*;
import view.*;
import java.math.*;

public class Controleur {

	private NivEau nivEau;
	private Grille grille;
	private VueAventurier vueAventurier;
	private ArrayList<Joueur> joueurs = new ArrayList();
	private ArrayList<Aventurier> aventuriers = new ArrayList();
	private ArrayList<Carte> deft = new ArrayList();
	private Stack<Carte> pilet = new Stack();
	private ArrayList<CarteInondation> defi = new ArrayList();
	private Stack<CarteInondation> pilei = new Stack();
	private ArrayList<Tresor> tresors = new ArrayList();
        private ArrayList<Tuile> at;
        private JFrame window = new JFrame();
        private VueGrille vuegrille;
        private VueJoueurs vuejoueurs;
        private VueNiveau vueniveau;
        private JPanel mainpanel;
        private JPanel saisiejoueurs;
        private ArrayList<String> noms = new ArrayList();
        private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        private Joueur joueurencours;
        private ArrayList<Tuile> tuilesaction = new ArrayList();
        private Message.TypeMessage action;
        private ArrayList<Tuile> tuilesacc = new ArrayList();
        private Tuile tuileav = null;
        private JPanel panelgauche = new JPanel(),paneldroit = new JPanel();
        private VueAventurier vuejcours;
        private VueTourJoueurs vuetourjoueurs;
        private JTextArea textepartie;

        public Controleur() {
            window = new JFrame("Île Interdite");
            window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            window.setMaximumSize(new Dimension((int)dim.getWidth()/2,(int)dim.getHeight()/2));window.setMinimumSize(new Dimension((int)dim.getWidth()/2,(int)dim.getHeight()/2));
            window.setLocation((int)(dim.getWidth()-dim.getWidth()/2)/2, (int)(dim.getHeight()-dim.getHeight()/2)/2);
            window.setLayout(new BorderLayout());
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
            vuejoueurs = new VueJoueurs(this);
            saisiejoueurs.add(vuejoueurs);
            mainpanel.add(saisiejoueurs);
            window.add(mainpanel,  BorderLayout.CENTER);
            window.setVisible(true);
        }
        
        public void initCartes() {
            for (int i = 0; i < 5; i++) {
                deft.add(new CTresor(Tresor.Calice));
                deft.add(new CTresor(Tresor.Cristal));
                deft.add(new CTresor(Tresor.Pierre));
                deft.add(new CTresor(Tresor.Statue));
                if (i < 1) {
                    if (i > 3)
                        deft.add(new CSacSable());
                    //deft.add(new CHelico());
                    deft.add(new CNiveauEau());
                }
            }
            
            for (Tuile t : at) {
                defi.add(new CarteInondation(t));
            }
            
            Collections.shuffle(deft);
            Collections.shuffle(defi);
            for (Carte c : deft) {
                pilet.add(c);
            }
            deft.clear();
            for (CarteInondation c : defi) {
                pilei.add(c);
            }
            defi.clear();
            for (int i = 0; i < 6; i++) {
                defi.add(pilei.pop());
                defi.get(defi.size()-1).getTuile().inonder();
            }
        }

	public Carte tirerCT() {
		// TODO - implement Controleur.tirerCT
		throw new UnsupportedOperationException();
	}

	public CarteInondation tirerCI() {
		// TODO - implement Controleur.tirerCI
		throw new UnsupportedOperationException();
	}
        
        public void nouveauJoueur(String nom) {
            getJoueurs().add(new Joueur(nom));
        }
        
        public void initGrille() {
            int i;
            at = new ArrayList();
            getAt().add(new Tuile("LePontdesabimes",0));
            getAt().add(new Tuile("LaPortedebronze",0));
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
            getAt().add(new Tuile("LesDunesdelillusion",0));
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
            getAt().add(new Tuile("LeLagonperdu",0));
            getAt().add(new Tuile("LeMaraisbrumeux",0));
            getAt().add(new Tuile("Observatoire",0));
            getAt().add(new Tuile("LeRocherfantome",0));
            getAt().add(new Tuile("LaCavernedubrasier",0));
            i = getAt().size()-1;
            getAt().get(i).setTresor(Tresor.Cristal);
            getAt().add(new Tuile("LeTempledusoleil",0));
            i = getAt().size()-1;
            getAt().get(i).setTresor(Tresor.Pierre);
            getAt().add(new Tuile("LeTempledelalune",0));
            i = getAt().size()-1;
            getAt().get(i).setTresor(Tresor.Pierre);
            getAt().add(new Tuile("LePalaisdesmarees",0));
            i = getAt().size()-1;
            getAt().get(i).setTresor(Tresor.Calice);
            getAt().add(new Tuile("LeValducrepuscule",0));
            getAt().add(new Tuile("LaTourdeguet",0));
            getAt().add(new Tuile("LeJardindesmurmures",0));
            i = getAt().size()-1;
            getAt().get(i).setTresor(Tresor.Statue);
            Collections.shuffle(at);
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
                i++;
            }
        }
        
        public void init() {
            initAventuriers();
            initJoueurs();
            initGrille();
            initCartes();
        }
        
        public ArrayList<Joueur> getJoueurs() {
            return joueurs;
        }
        
        public void lancerPartie() {
            for (String s : noms)
                nouveauJoueur(s);
            init();
            mainpanel.remove(saisiejoueurs);
            window.setMaximumSize(dim);
            window.setSize(new Dimension((int)dim.getWidth()/4*3,(int)dim.getHeight()/18*11));
            window.setLocation((int)dim.getWidth()/8*1, (int)dim.getHeight()/4);
            window.setExtendedState(JFrame.MAXIMIZED_BOTH);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.remove(mainpanel);
            window.setLayout(new BorderLayout());
            vuegrille = new VueGrille(getGrille(),this);
            vuegrille.setPreferredSize(new Dimension(dim.height,dim.height));
            window.add(vuegrille,  BorderLayout.CENTER);
            vueniveau = new VueNiveau(1,this);
            paneldroit.add(vueniveau);
            vueniveau.setBackground(new Color(35,35,35));
            vueniveau.setPreferredSize(new Dimension((dim.width-dim.height)/2,dim.height));
            window.add(panelgauche, BorderLayout.WEST);
            window.add(paneldroit, BorderLayout.EAST);
            panelgauche.setPreferredSize(new Dimension((dim.width-dim.height)/2,dim.height));
            paneldroit.setPreferredSize(new Dimension((dim.width-dim.height)/2,dim.height));
            panelgauche.setBackground(new Color(35,35,35));
            paneldroit.setBackground(new Color(35,35,35));
            window.setVisible(true);
            joueurencours = joueurs.get((int)(Math.random()*joueurs.size()));
            vuetourjoueurs = new VueTourJoueurs(joueurencours, joueurs);
            vuetourjoueurs.setPreferredSize(new Dimension((int)(dim.width-dim.height)/20*9,(int)vuetourjoueurs.getPreferredSize().getHeight()));
            textepartie = new JTextArea("Au tour de " + joueurencours.getNom() + " de jouer");
            textepartie.setEditable(false);
            textepartie.setFont(new Font(textepartie.getFont().getFontName(), textepartie.getFont().getStyle(), (int)dim.getWidth()/140));
            textepartie.setForeground(Color.white);
            textepartie.setBackground(new Color(35,35,35));
            textepartie.setBorder(BorderFactory.createEmptyBorder((int)dim.getWidth()/75, 0, 0, 0));
            vuejcours = new VueAventurier(joueurencours,this);
            vuejcours.setPreferredSize(new Dimension((int)(dim.width-dim.height)/2,(int)vuejcours.getPreferredSize().getHeight()));
            vuejcours.verifboutons(tresors, grille);
            textepartie.setPreferredSize(new Dimension((int)(dim.width-dim.height)/20*9,(int)vuejcours.getPreferredSize().getHeight()));
            panelgauche.add(vuetourjoueurs);
            panelgauche.add(textepartie);
            panelgauche.add(vuejcours);
        }

    /**
     * @return the at
     */
    public ArrayList<Tuile> getAt() {
        return at;
    }
    
    public ArrayList<Tuile> getTuilesI() {
        ArrayList<Tuile> ti = new ArrayList();
        for (Tuile t : at) {
            if (t.estInonde())
                ti.add(t);
        }
        return ti;
    }
    
    public void traiterMessage(Message msg) {
        if (msg.getType() == Message.TypeMessage.SAISIEFINIE) {
            noms = vuejoueurs.recupsaisie();
            lancerPartie();
        }
        else
            vuegrille.setTuilesSurbrillance(tuilesacc, false);
        
        if (msg.getType() == Message.TypeMessage.CASECLIQUEE) {
            if (!(action == Message.TypeMessage.ASSECHER && joueurencours.getAventurier() instanceof Ingenieur))
                tuilesaction.clear();
            tuilesaction.add(grille.getTuile(msg.getLigne(),msg.getColonne()));
            if (action == Message.TypeMessage.SEDEPLACER) {
                tuileav = null;
                joueurencours.getAventurier().seDeplacer(tuilesaction.get(0), grille);
                textepartie.setText(joueurencours.getNom() + " se déplace de " + joueurencours.getAventurier().getPosPrec().getNom() + " vers " + tuilesaction.get(0).getNom());
                tuilesaction.clear();
            }
            
            if (action == Message.TypeMessage.ASSECHER && joueurencours.getAventurier() instanceof Ingenieur && joueurencours.getAventurier().getSeche() == true) {
                tuileav = null;
                joueurencours.getAventurier().assecherG(tuilesaction);
                textepartie.setText(joueurencours.getNom() + " assèche " + tuilesaction.get(0).getNom() + " sans utiliser d'action");
                tuilesaction.clear();
                joueurencours.getAventurier().setSeche(false);
            }
            
            else if (action == Message.TypeMessage.ASSECHER) {
                tuileav = null;
                joueurencours.getAventurier().assecher(tuilesaction);
                textepartie.setText(joueurencours.getNom() + " assèche " + tuilesaction.get(0).getNom());
                tuilesaction.clear();
                if (joueurencours.getAventurier() instanceof Ingenieur) {
                    joueurencours.getAventurier().setSeche(true);
                }
            }
            
            if(action == Message.TypeMessage.DEPLACER && tuileav == null) {
                tuileav = tuilesaction.get(0);
                tuilesaction.clear();
                tuilesacc.clear();
                for (Tuile t : joueurencours.getAventurier().getTuilesAccDeplacer(grille, tuileav).values()) {
                tuilesacc.add(t);
                }
                vuegrille.setTuilesSurbrillance(tuilesacc, true);
            }
            
            else if (action == Message.TypeMessage.DEPLACER && tuileav != null) {
                joueurencours.getAventurier().deplacer(tuileav, tuilesaction.get(0));
                textepartie.setText(joueurencours.getNom() + " déplace le(s) joueur(s) de " + tuileav.getNom() + " vers " + tuilesaction.get(0).getNom());
                tuilesaction.clear();
                tuileav = null;
            }
            textepartie.setText(textepartie.getText() + "\nIl lui reste " + (3-joueurencours.getAventurier().getNbactions()) + " action(s) à faire");
            if (joueurencours.getAventurier() instanceof Ingenieur && joueurencours.getAventurier().getSeche() && (joueurencours.getAventurier().getNbactions() < 3) || (!joueurencours.getAventurier().getTuilesAcc(grille, 2).isEmpty()))
                textepartie.setText(textepartie.getText() + "\nMais il peut encore assécher une tuile sans utiliser d'action");
        }
                
        if (msg.getType() == Message.TypeMessage.SEDEPLACER) {
            action = msg.getType();
            tuilesacc.clear();
            for (Tuile t : joueurencours.getAventurier().getTuilesAcc(getGrille(), 1).values()) {
                tuilesacc.add(t);
            }
            vuegrille.setTuilesSurbrillance(tuilesacc, true);
        }
        if (msg.getType() == Message.TypeMessage.ASSECHER) {
            action = msg.getType();
            tuilesacc.clear();
            for (Tuile t : joueurencours.getAventurier().getTuilesAcc(getGrille(), 2).values()) {
                tuilesacc.add(t);
            }
            vuegrille.setTuilesSurbrillance(tuilesacc, true);
        }
        if (msg.getType() == Message.TypeMessage.DEPLACER) {
            action = msg.getType();
            tuilesacc.clear();
            for (Tuile t : joueurencours.getAventurier().getTuilesAv(grille).values()) {
                tuilesacc.add(t);
            }
            vuegrille.setTuilesSurbrillance(tuilesacc, true);
        }
        
        if (msg.getType() == Message.TypeMessage.PASSER)
            fintour();
        
        vuegrille.couleur(getGrille());
        
        if (getTuilesI().isEmpty()) {
            System.err.println("fin de la partie");
        }
        
        vuejcours.verifboutons(tresors, grille);
        
    }
    
    public void fintour() {
        if (joueurencours.getAventurier() instanceof Pilote)
            joueurencours.getAventurier().setHelico(false);
        joueurencours.getAventurier().setNbactions(0);
        joueurencours = joueurs.get(((joueurs.indexOf(joueurencours)+1) % joueurs.size()));
        vuejcours.changerj(joueurencours);
        vuetourjoueurs.fintour();
        textepartie.setText("Au tour de " + joueurencours.getNom() + " de jouer");
    }

}