package controleur;

import java.awt.*;
import static java.awt.Image.SCALE_SMOOTH;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import models.*;
import util.*;
import view.*;
import java.math.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class Controleur {
        
        private VueFin vuefin;
	private NivEau nivEau;
	private Grille grille;
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
        private JPanel panelgauche,paneldroit = new JPanel(new BorderLayout());
        private VueAventurier vuejcours;
        private VueTourJoueurs vuetourjoueurs;
        private JTextArea textepartie;
        private VueCartesJoueur vuecartesj;
        private Tuile helico;
        private ArrayList<Tuile> cristal = new ArrayList();
        private ArrayList<Tuile> statue = new ArrayList();
        private ArrayList<Tuile> calice = new ArrayList();
        private ArrayList<Tuile> pierre = new ArrayList();
        private int nivini;
        private VueTresors vuetresor;
        private VueJoueursAction vuejoueursaction;
        private JPanel panelgvja = new JPanel();
        private JPanel panelgvc = new JPanel();
        private Carte cartedon;
        private Main main;
        private JPanel paneljeu = new JPanel(new BorderLayout());
        private Joueur joueurmort;
        private Carte carteaction;
        private Joueur joueuraction;
        private Color c = new Color(35,35,35,50);

        public Controleur(Main m) {
            try {
                this.panelgauche = new JPanel() {
                    private int fond;
                    private final Image[] images = {ImageIO.read(Main.class.getResource("/img/personnages/pilo.png")).getScaledInstance((int)dim.getHeight(), (int)(dim.width-dim.height)/2, Image.SCALE_SMOOTH),
                        ImageIO.read(Main.class.getResource("/img/personnages/navi.png")).getScaledInstance((int)dim.getHeight(), (int)(dim.width-dim.height)/2, Image.SCALE_SMOOTH),
                        ImageIO.read(Main.class.getResource("/img/personnages/plon.png")).getScaledInstance((int)dim.getHeight(), (int)(dim.width-dim.height)/2, Image.SCALE_SMOOTH),
                        ImageIO.read(Main.class.getResource("/img/personnages/expl.png")).getScaledInstance((int)dim.getHeight(), (int)(dim.width-dim.height)/2, Image.SCALE_SMOOTH),
                        ImageIO.read(Main.class.getResource("/img/personnages/inge.png")).getScaledInstance((int)dim.getHeight(), (int)(dim.width-dim.height)/2, Image.SCALE_SMOOTH),
                        ImageIO.read(Main.class.getResource("/img/personnages/mess.png")).getScaledInstance((int)dim.getHeight(), (int)(dim.width-dim.height)/2, Image.SCALE_SMOOTH)};
                    
                    @Override
                    public void setBackground(Color bg) {
                        if (bg.equals(new Color(55,194,198)))
                            fond = 0;
                        if (bg.equals(new Color(255, 255, 0)))
                            fond = 1;
                        if (bg.equals(new Color(204, 94, 255)))
                            fond = 2;
                        if (bg.equals(new Color(0, 195, 0)))
                            fond = 3;
                        if (bg.equals(new Color(255, 0, 0)))
                            fond = 4;
                        if (bg.equals(new Color(255, 148, 0)))
                            fond = 5;
                        if (bg.equals(new Color(255, 148, 0)))
                            repaint();
                    }
                    
                    @Override
                    protected void paintComponent(Graphics g) {
                        g.clearRect(0, 0, getWidth(), getHeight());
                        g.drawImage(images[fond], 0, 0, getWidth(), getHeight(), this);
                    }
                };
                main = m;
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
            } catch (IOException ex) {
                Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void initCartes() {
            for (int i = 0; i < 5; i++) {
                deft.add(new CTresor(Tresor.Calice));
                deft.add(new CTresor(Tresor.Cristal));
                deft.add(new CTresor(Tresor.Pierre));
                deft.add(new CTresor(Tresor.Statue));
                if (i > 1) {
                    if (i > 3)
                        deft.add(new CSacSable());
                    deft.add(new CHelico());
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
            for (Joueur j : joueurs) {
                Carte c;
                while (j.getAventurier().getCartes().size() < 2) {
                    c = pilet.pop();
                    if (c instanceof CNiveauEau) {
                        pilet.push(c);
                        Collections.shuffle(pilet);
                    }
                    else
                    j.getAventurier().ajouterCarte(c);
                }
            }
        }

	public ArrayList<Carte> tirerCT() {
            textepartie.setText("");
            if (pilet.size() < 2) {
                Collections.shuffle(deft);
                for (Carte c : deft) {
                    pilet.push(c);
                }
                defi.clear();
            }
            ArrayList<Carte> ac = new ArrayList();
            ac.add(pilet.pop());
            ac.add(pilet.pop());
            for (int i = 1; i > -1; i--) {
                if (ac.get(i) instanceof CNiveauEau) {
                        textepartie.setText(textepartie.getText() + "\n" + joueurencours.getNom() + " pioche une carte montée des eaux");
                        vueniveau.nivplus();
                        nivEau.gradPlus();
                        deft.add(ac.get(i));
                        ac.remove(ac.get(i));
                        Collections.shuffle(defi);
                        for (CarteInondation c : defi) {
                            pilei.push(c);
                        }
                        defi.clear();
                }
                else
                    textepartie.setText(textepartie.getText() + "\n" + joueurencours.getNom() + " pioche " + ac.get(i).getNom());
            }
            return ac;
	}

	public void tirerCI() {
            if (pilei.size()-nivEau.getNiv() <= 0 || pilei.size() <= 0 || pilei.size() <= nivEau.getNiv()) {
                Collections.shuffle(defi);
                for (CarteInondation c : defi) {
                    pilei.push(c);
                }
                defi.clear();
            }
            
            for (int i = 0; i < nivEau.getNiv(); i++) {
                defi.add(pilei.pop());
                defi.get(defi.size()-1).getTuile().inonder();
                if (defi.get(defi.size()-1).getTuile().estMorte()) {
                    if (cristal.contains(defi.get(defi.size()-1).getTuile())) {
                        cristal.remove(defi.get(defi.size()-1).getTuile());
                    }
                    else if (statue.contains(defi.get(defi.size()-1).getTuile())) {
                        statue.remove(defi.get(defi.size()-1).getTuile());
                    }
                    else if (calice.contains(defi.get(defi.size()-1).getTuile())) {
                        calice.remove(defi.get(defi.size()-1).getTuile());
                    }
                    else if (pierre.contains(defi.get(defi.size()-1).getTuile())) {
                        pierre.remove(defi.get(defi.size()-1).getTuile());
                    }
                    defi.remove(defi.get(defi.size()-1));
                }
            }
                
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
            cristal.add(getAt().get(i));
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
            calice.add(getAt().get(i));
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
            helico = getAt().get(i);
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
            statue.add(getAt().get(i));
            getAt().get(i).setTresor(Tresor.Statue);
            getAt().add(new Tuile("LaForetpourpre",0));
            getAt().add(new Tuile("LeLagonperdu",0));
            getAt().add(new Tuile("LeMaraisbrumeux",0));
            getAt().add(new Tuile("Observatoire",0));
            getAt().add(new Tuile("LeRocherfantome",0));
            getAt().add(new Tuile("LaCavernedubrasier",0));
            i = getAt().size()-1;
            cristal.add(getAt().get(i));
            getAt().get(i).setTresor(Tresor.Cristal);
            getAt().add(new Tuile("LeTempledusoleil",0));
            i = getAt().size()-1;
            pierre.add(getAt().get(i));
            getAt().get(i).setTresor(Tresor.Pierre);
            getAt().add(new Tuile("LeTempledelalune",0));
            i = getAt().size()-1;
            pierre.add(getAt().get(i));
            getAt().get(i).setTresor(Tresor.Pierre);
            getAt().add(new Tuile("LePalaisdesmarees",0));
            i = getAt().size()-1;
            calice.add(getAt().get(i));
            getAt().get(i).setTresor(Tresor.Calice);
            getAt().add(new Tuile("LeValducrepuscule",0));
            getAt().add(new Tuile("LaTourdeguet",0));
            getAt().add(new Tuile("LeJardindesmurmures",0));
            i = getAt().size()-1;
            statue.add(getAt().get(i));
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
            window.setMinimumSize(new Dimension((int)(dim.getWidth()),(int)(dim.getHeight())));
            window.setSize(new Dimension((int)dim.getWidth()/4*3,(int)dim.getHeight()/18*11));
            window.setLocation((int)dim.getWidth()/8*1, (int)dim.getHeight()/4);
            window.setExtendedState(JFrame.MAXIMIZED_BOTH);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.remove(mainpanel);
            window.setLayout(new BorderLayout());
            vuegrille = new VueGrille(getGrille(),this);
            vuegrille.setPreferredSize(new Dimension(dim.height,dim.height));
            vuegrille.setBackground(new Color(30,30,30));
            vuegrille.setBorder(BorderFactory.createLineBorder(new Color(30,30,30), 1));
            window.add(paneljeu);
            paneljeu.add(vuegrille,  BorderLayout.CENTER);
            nivEau = new NivEau(nivini);
            vueniveau = new VueNiveau(nivini);
            paneldroit.setLayout(new BorderLayout());
            vuetresor = new VueTresors(tresors);
            paneldroit.add(vuetresor, BorderLayout.NORTH);
            paneldroit.add(vueniveau, BorderLayout.SOUTH);
            vueniveau.setBackground(new Color(30,30,30));
            paneljeu.add(panelgauche, BorderLayout.WEST);
            paneljeu.add(paneldroit, BorderLayout.EAST);
            panelgauche.setPreferredSize(new Dimension((dim.width-dim.height)/2,dim.height));
            paneldroit.setPreferredSize(new Dimension((dim.width-dim.height)/2,dim.height));
            paneldroit.setBackground(new Color(30,30,30));
            vuetresor.setPreferredSize(new Dimension((int)paneldroit.getPreferredSize().getWidth(),(int)paneldroit.getPreferredSize().getWidth()*195/235));
            vueniveau.setPreferredSize(new Dimension((int)paneldroit.getPreferredSize().getWidth(),(int)paneldroit.getPreferredSize().getHeight()-(int)paneldroit.getPreferredSize().getWidth()*205/235));
            window.setVisible(true);
            joueurencours = joueurs.get((int)(Math.random()*joueurs.size()));
            vuetourjoueurs = new VueTourJoueurs(joueurencours, joueurs);
            textepartie = new JTextArea("Au tour de " + joueurencours.getNom() + " de jouer");
            textepartie.setEditable(false);
            textepartie.setFont(new Font(textepartie.getFont().getFontName(), textepartie.getFont().getStyle(), (int)dim.getWidth()/140));
            textepartie.setForeground(Color.WHITE);
            textepartie.setBorder(BorderFactory.createEmptyBorder((int)dim.getWidth()/75, 0, 0, 0));
            vuejoueursaction = new VueJoueursAction(joueurencours, joueurs, this);
            vuejcours = new VueAventurier(joueurencours,this);
            vuecartesj = new VueCartesJoueur(joueurencours, joueurs, this);
            vuejcours.setPreferredSize(new Dimension((int)panelgauche.getPreferredSize().getWidth(),(int)vuejcours.getPreferredSize().getHeight()));
            vuejcours.verifboutons(tresors, grille, joueurs);
            textepartie.setBorder(BorderFactory.createEmptyBorder((int)dim.getWidth()/200, (int)dim.getWidth()/200, (int)dim.getWidth()/200, 0));
            vuetourjoueurs.setBorder(BorderFactory.createEmptyBorder((int)dim.getWidth()/200, (int)dim.getWidth()/200, (int)dim.getWidth()/200, 0));
            vuetourjoueurs.setPreferredSize(new Dimension((int)panelgauche.getPreferredSize().getWidth(),(int)vuetourjoueurs.getPreferredSize().getHeight()));
            textepartie.setPreferredSize(new Dimension((int)panelgauche.getPreferredSize().getWidth(),(int)vuejcours.getPreferredSize().getHeight()));
            vuejoueursaction.setPreferredSize(new Dimension((int)(int)panelgauche.getPreferredSize().getWidth(),(int)dim.getHeight()/10));
            vuecartesj.setPreferredSize(new Dimension((int)(int)panelgauche.getPreferredSize().getWidth(),(int)dim.getHeight()/15*(2*joueurs.size()-1)));
            panelgauche.add(vuetourjoueurs);
            panelgauche.add(textepartie);
            panelgauche.add(vuejcours);
            panelgvja.add(vuejoueursaction);
            panelgauche.add(panelgvja);
            panelgvc.add(vuecartesj);
            panelgauche.add(panelgvc);
            int r = vuejcours.getColor().getRed()-70;
            int g = vuejcours.getColor().getGreen()-70;
            int b = vuejcours.getColor().getBlue()-70;
            panelgauche.setBackground(vuejcours.getColor());
            panelgauche.repaint();
            textepartie.setBackground(c);
            panelgauche.setBackground(vuejcours.getColor());
            vuetourjoueurs.setBackground(c);
            vuejoueursaction.setBackground(new Color(0,0,0,0));
            panelgvja.setBackground(c);
            panelgvc.setBackground(c);
            vuecartesj.setBackground(new Color(0,0,0,0));
            vuecartesj.images();
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
    
    public ArrayList<Tuile> getTuilesM() {
        ArrayList<Tuile> ti = new ArrayList();
        for (Tuile t : at) {
            if (t.estMorte())
                ti.add(t);
        }
        return ti;
    }
    
    public void traiterMessage(Message msg) {
        for (Joueur j : joueurs)
            vuecartesj.setCliquable(j, cartesaction(j.getAventurier().getCartes()), false);
        if (msg.getType() == Message.TypeMessage.SAISIEFINIE) {
            noms = vuejoueurs.recupsaisie();
            nivini = msg.getNiveau();
            lancerPartie();
        }
        else
            vuegrille.setTuilesSurbrillance(tuilesacc, false);
        
        if (!gagne() && !perdu()) {
            vuegrille.setTuilesSurbrillance(at, false);
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
                    textepartie.setText(joueurencours.getNom() + " doit choisir la tuile ou le(s) déplacer");
                    vuegrille.setTuilesSurbrillance(tuilesacc, true);
                }

                else if (action == Message.TypeMessage.DEPLACER && tuileav != null) {
                    joueurencours.getAventurier().deplacer(tuileav, tuilesaction.get(0));
                    textepartie.setText(joueurencours.getNom() + " déplace le(s) joueur(s) de " + tuileav.getNom() + " vers " + tuilesaction.get(0).getNom());
                    tuilesaction.clear();
                    tuileav = null;
                }
                
                if (action == Message.TypeMessage.DFORCE) {
                    tuileav = null;
                    joueurmort.getAventurier().getPos().retirerAv(joueurmort.getAventurier());
                    tuilesaction.get(0).ajouterAv(joueurmort.getAventurier());
                    joueurmort.getAventurier().setPos(tuilesaction.get(0));
                    tuilesaction.clear();
                    window.repaint();
                    fintour(true);
                }
                
                if (action != Message.TypeMessage.DFORCE) {
                    textepartie.setText(textepartie.getText() + "\nIl lui reste " + (3-joueurencours.getAventurier().getNbactions()) + " action(s) à faire");
                    if (joueurencours.getAventurier() instanceof Ingenieur && (joueurencours.getAventurier().getSeche() && ((joueurencours.getAventurier().getNbactions() < 3) || (!joueurencours.getAventurier().getTuilesAcc(grille, 2).isEmpty()))))
                        textepartie.setText(textepartie.getText() + "\nMais il peut encore assécher une tuile sans utiliser d'action");
                    if (toustresors() && !gagne())
                        textepartie.setText(textepartie.getText()+ "\nVous avez acquis tous les trésors, rendez vous à l'héliport");
                }
                
                if (action == Message.TypeMessage.CARTE && carteaction instanceof CSacSable) {
                    tuileav = null;
                    tuilesaction.get(0).secher();
                    textepartie.setText(joueuraction.getNom() + " assèche " + tuilesaction.get(0).getNom());
                    tuilesaction.clear();
                    deft.add(carteaction);
                    joueuraction.getAventurier().getCartes().remove(carteaction);
                    vuecartesj.images();
                }
                
                if (action == Message.TypeMessage.CARTE && carteaction instanceof CHelico && tuileav != null) {
                    Navigateur n = new Navigateur();
                    n.deplacer(tuileav, grille.getTuile(msg.getLigne(),msg.getColonne()));
                    textepartie.setText(joueuraction.getNom() + " déplace le(s) joueur(s) de " + tuileav.getNom() + " vers " + tuilesaction.get(0).getNom());
                    tuilesaction.clear();
                    tuileav = null;
                    deft.add(carteaction);
                    joueuraction.getAventurier().getCartes().remove(carteaction);
                    vuecartesj.images();
                }
                else if (action == Message.TypeMessage.CARTE && carteaction instanceof CHelico && tuileav == null) {
                    tuileav = grille.getTuile(msg.getLigne(),msg.getColonne());
                    tuilesaction.clear();
                    tuilesacc.clear();
                    for (Tuile t : grille.getTuiles()) {
                        if (!t.estMorte() && t != tuileav)
                            tuilesacc.add(t);
                    }
                    textepartie.setText(joueuraction.getNom() + " doit choisir la tuile ou le(s) déplacer");
                    vuegrille.setTuilesSurbrillance(tuilesacc, true);
                }
            }

            if (msg.getType() == Message.TypeMessage.SEDEPLACER) {
                action = msg.getType();
                tuilesacc.clear();
                for (Tuile t : joueurencours.getAventurier().getTuilesAcc(getGrille(), 1).values()) {
                    tuilesacc.add(t);
                }
                textepartie.setText(joueurencours.getNom() + " doit choisir la tuile où se déplacer");
                if (joueurencours.getAventurier() instanceof Pilote && !joueurencours.getAventurier().getHelico())
                    textepartie.setText(textepartie.getText()+ "\nSon hélicoptère est disponible");
                vuegrille.setTuilesSurbrillance(tuilesacc, true);
            }
            
            if (msg.getType() == Message.TypeMessage.ASSECHER) {
                action = msg.getType();
                tuilesacc.clear();
                for (Tuile t : joueurencours.getAventurier().getTuilesAcc(getGrille(), 2).values()) {
                    tuilesacc.add(t);
                }
                textepartie.setText(joueurencours.getNom() + " doit choisir la tuile à assécher avec sa carte");
                vuegrille.setTuilesSurbrillance(tuilesacc, true);
            }
            
            if (msg.getType() == Message.TypeMessage.DEPLACER) {
                action = msg.getType();
                tuilesacc.clear();
                for (Tuile t : joueurencours.getAventurier().getTuilesAv(grille).values()) {
                    tuilesacc.add(t);
                }
                vuegrille.setTuilesSurbrillance(tuilesacc, true);
                textepartie.setText(joueurencours.getNom() + " doit choisir la tuile ou se trouve(nt) le(s) joueur(s) à déplacer avec sa carte");
            }
            
            if (msg.getType() == Message.TypeMessage.DONNER) {
                action = msg.getType();
                tuilesacc.clear();
                textepartie.setText(joueurencours.getNom() + " doit choisir la carte à donner");
                vuecartesj.setCliquable(joueurencours, joueurencours.getAventurier().getCartes(), true);
                window.repaint();
            }
            
            if (action == Message.TypeMessage.DONNER && msg.getType() == Message.TypeMessage.CARTE) {
                action = msg.getType();
                cartedon = joueurencours.getAventurier().getCartes().get(msg.getIndice());
                vuejoueursaction.setCliquable(joueurencours.getAventurier().getJAcc(joueurs), true);
                textepartie.setText(joueurencours.getNom() + " doit choisir à qui donner sa carte");
                vuecartesj.setCliquable(joueurencours, joueurencours.getAventurier().getCartes(), false);
                window.repaint();
                
            }
            
            if (action == Message.TypeMessage.CARTE && msg.getType() == Message.TypeMessage.JOUEUR) {
                action = msg.getType();
                joueurencours.getAventurier().donnerCarte(joueurs.get(msg.getIndice()),cartedon);
                vuejoueursaction.setCliquable(joueurencours.getAventurier().getJAcc(joueurs), false);
                vuecartesj.images();
                window.repaint();
                if (joueurs.get(msg.getIndice()).getAventurier().getCartes().size() > 5) {
                    action = Message.TypeMessage.DEF;
                    joueuraction = joueurs.get(msg.getIndice());
                    window.repaint();
                    vuejcours.setBoutons(false, tresors, grille, joueurencours.getAventurier().getJAcc(joueurs));
                    window.repaint();
                    if (joueurs.get(msg.getIndice()).getAventurier().getCartes().size()-5 == 1)
                        textepartie.setText(textepartie.getText() + "\n" + joueurs.get(msg.getIndice()).getNom() + " doit choisir 1 carte à défausser");
                    else
                        textepartie.setText(textepartie.getText() + "\n" + joueurs.get(msg.getIndice()).getNom() + " doit choisir 2 carte à défausser");
                    vuecartesj.setCliquable(joueurs.get(msg.getIndice()), joueurs.get(msg.getIndice()).getAventurier().getCartes(), true);
                }
            }

            if (msg.getType() == Message.TypeMessage.TRESOR) {
                tresors.add(joueurencours.getAventurier().getPos().getTresor());
                vuetresor.majtresor(tresors);
                joueurencours.getAventurier().setNbactions(joueurencours.getAventurier().getNbactions()+1);
                String nmtresor = "rien";
                if (tresors.get(tresors.size()-1).equals(Tresor.Pierre))
                    nmtresor = "la Pierre sacrée";
                if (tresors.get(tresors.size()-1).equals(Tresor.Cristal))
                    nmtresor = "le Cristal ardent";
                if (tresors.get(tresors.size()-1).equals(Tresor.Calice))
                    nmtresor = "le Calice de l'onde";
                if (tresors.get(tresors.size()-1).equals(Tresor.Statue))
                    nmtresor = "la Statue du zéphyr";
                textepartie.setText(textepartie.getText()+ "\nVous récupérez " + nmtresor + " !");
                for (int i = 0; i < pilet.size();i++) {
                    if (!(pilet.get(i) instanceof CHelico) && !(pilet.get(i) instanceof CSacSable) && !(pilet.get(i) instanceof CNiveauEau)) {
                        CTresor ct = (CTresor) pilet.get(i);
                        if (ct.getTresor().equals(tresors.get(tresors.size()-1)))
                            pilet.remove(pilet.get(i));
                    }
                }
                for (int i = 0; i < deft.size();i++) {
                    if (!cartesaction(deft).contains(deft.get(i)) && !(deft.get(i) instanceof CNiveauEau)) {
                        CTresor ct = (CTresor) deft.get(i);
                        if (ct.getTresor().equals(tresors.get(tresors.size()-1)))
                            deft.remove(deft.get(i));
                    }
                }
                for (Joueur j : joueurs)
                    for (int i = 0; i < j.getAventurier().getCartes().size();i++) {
                        if (!cartesaction(j.getAventurier().getCartes()).contains(j.getAventurier().getCartes().get(i))) {
                            CTresor ct = (CTresor) j.getAventurier().getCartes().get(i);
                            if (ct.getTresor().equals(tresors.get(tresors.size()-1)))
                                j.getAventurier().getCartes().remove(j.getAventurier().getCartes().get(i));
                        }
                    }
                vuecartesj.images();
            }
            
            if (msg.getType() == Message.TypeMessage.CARTE && action != Message.TypeMessage.DONNER && joueurs.get(msg.getJoueur()).getAventurier().getCartes().get(msg.getIndice()) instanceof CSacSable) {
                tuilesacc.clear();
                joueuraction = joueurs.get(msg.getJoueur());
                carteaction = joueuraction.getAventurier().getCartes().get(msg.getIndice());
                textepartie.setText(joueurs.get(msg.getJoueur()).getNom() + " doit choisir la tuile à assécher");
                action = msg.getType();
                vuegrille.setTuilesSurbrillance(getTuilesI(), true);
            }
            
            if (msg.getType() == Message.TypeMessage.CARTE && action != Message.TypeMessage.DONNER && joueurs.get(msg.getJoueur()).getAventurier().getCartes().get(msg.getIndice()) instanceof CHelico) {
                tuilesacc.clear();
                joueuraction = joueurs.get(msg.getJoueur());
                carteaction = joueuraction.getAventurier().getCartes().get(msg.getIndice());
                textepartie.setText(joueurs.get(msg.getJoueur()).getNom() + " doit choisir la tuile ou se trouve(nt) le(s) joueur(s) à déplacer");
                action = msg.getType();
                Navigateur a = new Navigateur();
                for (Tuile t : a.getTuilesAv(grille).values())
                    tuilesacc.add(t);
                vuegrille.setTuilesSurbrillance(tuilesacc, true);
            }
            
            if (msg.getType() != Message.TypeMessage.DONNER && msg.getType() != Message.TypeMessage.CARTE && msg.getType() != Message.TypeMessage.JOUEUR) {
                vuejoueursaction.setCliquable(joueurencours.getAventurier().getJAcc(joueurs), false);
            }

            if (msg.getType() == Message.TypeMessage.PASSER)
                fintour(false);
            
            if(msg.getType() == Message.TypeMessage.CARTE && joueurencours.getAventurier().getCartes().size() > 5) {
                deft.add(joueurencours.getAventurier().getCartes().get(msg.getIndice()));
                joueurencours.getAventurier().getCartes().remove(joueurencours.getAventurier().getCartes().get(msg.getIndice()));
                vuecartesj.images();
                fintour(true);
            }
            
            if(action == Message.TypeMessage.DEF && msg.getType() == Message.TypeMessage.CARTE) {
                deft.add(joueuraction.getAventurier().getCartes().get(msg.getIndice()));
                joueuraction.getAventurier().getCartes().remove(joueuraction.getAventurier().getCartes().get(msg.getIndice()));
                vuecartesj.images();
            }
            
        }
            
        if (msg.getType() == Message.TypeMessage.RELANCER) {
            main.traiterMessage(msg);
            window.setVisible(false);
        }
        
        vuegrille.couleur(getGrille());
        
        if (perdu() && vuefin == null) {
            textepartie.setText("Vous avez perdu !");
            if (helico.estMorte())
                textepartie.setText(textepartie.getText() + "\nL'heliport est coulé");
            else
                textepartie.setText(textepartie.getText() + "\nUn des trésors est perdu");
            vuefin = new VueFin(false,helico,this);
            vuegrille.setVisible(false);
            paneljeu.add(vuefin, BorderLayout.CENTER);
            window.repaint();
        }
        if (gagne()) {
            textepartie.setText("Vous avez gagné !");
            vuefin = new VueFin(true,helico,this);
            vuegrille.setVisible(false);
            paneljeu.add(vuefin, BorderLayout.CENTER);
            window.repaint();
        }
        
        if (joueurencours.getAventurier().getCartes().size() < 6 && joueursmorts().size() == 0) {
            vuejcours.verifboutons(tresors, grille, joueurencours.getAventurier().getJAcc(joueurs));
            if (action != Message.TypeMessage.DONNER)
                for (Joueur j : joueurs)
                        vuecartesj.setCliquable(j, cartesaction(j.getAventurier().getCartes()), true);
        }
    }
    
    
    public void fintour(boolean bc) {
        if (!bc) {
            tirerCI();
            joueurencours.getAventurier().ajouterCarte(tirerCT());
        }
        else
            textepartie.setText("");
        vuecartesj.images();
        if (joueurencours.getAventurier().getCartes().size() > 5) {
            window.repaint();
            vuejcours.setBoutons(false, tresors, grille, joueurencours.getAventurier().getJAcc(joueurs));
            window.repaint();
            if (joueurencours.getAventurier().getCartes().size()-5 == 1)
                textepartie.setText(textepartie.getText() + "\n" + joueurencours.getNom() + " doit choisir 1 carte à défausser");
            else
                textepartie.setText(textepartie.getText() + "\n" + joueurencours.getNom() + " doit choisir 2 carte à défausser");
            vuecartesj.setCliquable(joueurencours, joueurencours.getAventurier().getCartes(), true);
        }
        else if (joueursmorts().size() > 0) {
            joueurmort  = joueursmorts().get(0);
            action = Message.TypeMessage.DFORCE;
            window.repaint();
            vuejcours.changerj(joueursmorts().get(0));
            vuejcours.setBoutons(false, tresors, grille, joueurencours.getAventurier().getJAcc(joueurs));
            textepartie.setText(joueursmorts().get(0).getNom() + " doit choisir une tuile non coulée ou se déplacer");
            tuilesacc.clear();
            Messager a = new Messager();
            for (Tuile t : joueurmort.getAventurier().getTuilesAcc(getGrille(), 1).values())
                tuilesacc.add(t);
            vuegrille.setTuilesSurbrillance(tuilesacc, true);
            textepartie.setForeground(new Color(35,35,35));
            textepartie.setBackground(vuejcours.getColor());
        }
        else {
            vuegrille.couleur(grille);
            if (joueurencours.getAventurier() instanceof Pilote)
                joueurencours.getAventurier().setHelico(false);
            joueurencours.getAventurier().setNbactions(0);
            joueurencours = joueurs.get(((joueurs.indexOf(joueurencours)+1) % joueurs.size()));
            vuejcours.changerj(joueurencours);
            vuejcours.verifboutons(tresors, grille, joueurencours.getAventurier().getJAcc(joueurs));
            vuetourjoueurs.fintour();
            vuejoueursaction.fintour();
            vuecartesj.fintour();
            textepartie.setText(textepartie.getText() + "\nAu tour de " + joueurencours.getNom() + " de jouer");
            panelgauche.setBackground(vuejcours.getColor());
            panelgauche.repaint();
            textepartie.setBackground(c);
            vuetourjoueurs.setBackground(c);
            vuejoueursaction.setBackground(new Color(0,0,0,0));
            panelgvja.setBackground(c);
            panelgvc.setBackground(c);
            vuecartesj.setBackground(new Color(0,0,0,0));
            textepartie.setForeground(Color.WHITE);
        }
    }
    
    public boolean perdu() {
        return (calice.size() == 0 && !tresors.contains(Tresor.Calice)) || (statue.size() == 0 && !tresors.contains(Tresor.Statue)) ||
               (cristal.size() == 0 && !tresors.contains(Tresor.Cristal)) || (pierre.size() == 0 && !tresors.contains(Tresor.Pierre)) || helico.estMorte() || aventurierDansLaMer_de();
    }
    
    public boolean gagne() {
        return toustresors() && helico.getAventuriers().size() == joueurs.size();
    }
    
    public boolean toustresors() {
        return tresors.size() == 4;
    }
    
    public ArrayList<Joueur> joueursmorts() {
        ArrayList<Joueur> aj = new ArrayList();
        for (Joueur j : joueurs) {
            if (j.getAventurier().getPos().estMorte())
                aj.add(j);
        }
        return aj;
    }
    
    public ArrayList<Carte> cartesaction(ArrayList<Carte> ca) {
        ArrayList<Carte> ac = new ArrayList();
        for (Carte c : ca)
            if (c instanceof CHelico || c instanceof CSacSable)
                ac.add(c);
        return ac;
    }
    
    public boolean aventurierDansLaMer_de() {
        for (Joueur j : joueurs)
            if (j.getAventurier().getPos().estMorte() && j.getAventurier().getTuilesAcc(grille, 1).isEmpty())
                return true;
        return false;
    }

}