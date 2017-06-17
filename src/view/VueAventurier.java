package view;

import controleur.Controleur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;
import models.CTresor;
import models.Carte;
import models.Explorateur;
import models.Grille;
import models.Ingenieur;
import models.Joueur;
import models.Messager;
import models.Navigateur;
import models.Pilote;
import models.Plongeur;
import models.Tuile;
import util.Message;
import util.Tresor;

 
public class VueAventurier extends JPanel {
     
    private final JPanel panelBoutons;
    private final JPanel panelAventurier;
    private final JButton btnAller  ;
    private final JButton btnAssecher;
    private final JButton btndeplacer;
    private final JButton btnTerminerTour;
    private final JButton btndonnercarte;
    private final JButton btnrecuptresor;
    private final JLabel nom;
    private Controleur c;
    private Color color;
    private String nomj;
    private String nomav;
    private Joueur j;
    
    public VueAventurier (Joueur joueur, Controleur controleur){

        setLayout(new BorderLayout());
        
        j = joueur;
        nomj = j.getNom();
        c = controleur;
        
        if (j.getAventurier() instanceof Pilote) {
            nomav = "Pilote";
            color = new Color(55,194,198);
        }
        if (j.getAventurier() instanceof Navigateur) {
            nomav = "Navigateur";
            color = new Color(255, 255, 0);
        }
        if (j.getAventurier() instanceof Plongeur) {
            nomav = "Plongeur";
            color = new Color(204, 94, 255);
        }  
        if (j.getAventurier() instanceof Explorateur) {
            nomav = "Explorateur";
            color = new Color(0, 195, 0);
        }
        if (j.getAventurier() instanceof Ingenieur) {
            nomav = "Ingénieur";
            color = new Color(255, 0, 0);
        }
        if (j.getAventurier() instanceof Messager) {
            nomav = "Messager";
            color = new Color(255, 148, 0);
        }
        
        this.setBackground(new Color(230, 230, 230));
        this.setBorder(BorderFactory.createLineBorder(color, 5));

        // =================================================================================
        // NORD : le titre = nom de l'aventurier + nom du joueur sur la couleurActive du pion

        this.panelAventurier = new JPanel();
        panelAventurier.setBackground(color);
        nom = new JLabel(nomj  + " : " + nomav,SwingConstants.CENTER);
        panelAventurier.add(nom);
        this.add(panelAventurier, BorderLayout.NORTH);
   
        this.panelBoutons = new JPanel(new GridLayout(3,2));
        this.panelBoutons.setOpaque(false);
        this.add(this.panelBoutons, BorderLayout.SOUTH);

        this.btnAller = new JButton("Se déplacer") ;
        btnAller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.traiterMessage(new Message(Message.TypeMessage.SEDEPLACER));
            }
        });
        this.btnAssecher = new JButton( "Assecher");
        btnAssecher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.traiterMessage(new Message(Message.TypeMessage.ASSECHER));
            }
        });
        if (nomav == "Navigateur") {
            this.btndeplacer = new JButton("Deplacer");
            btndeplacer.setEnabled(true);
        }
        else {
            this.btndeplacer = new JButton("Autre action");
            btndeplacer.setEnabled(false);
        }
        btndeplacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.traiterMessage(new Message(Message.TypeMessage.DEPLACER));
            }
        });
        this.btnTerminerTour = new JButton("Terminer tour") ;
        btnTerminerTour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.traiterMessage(new Message(Message.TypeMessage.PASSER));
            }
        });
        this.btndonnercarte = new JButton("Donner carte") ;
        btndonnercarte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.traiterMessage(new Message(Message.TypeMessage.DONNER));
            }
            
        });
        this.btnrecuptresor = new JButton("Récupérer tresor") ;
        btnrecuptresor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.traiterMessage(new Message(Message.TypeMessage.TRESOR));
            }
        });
        
        this.panelBoutons.add(btnAller);
        this.panelBoutons.add(btnAssecher);
        this.panelBoutons.add(btndonnercarte);
        this.panelBoutons.add(btnrecuptresor);
        this.panelBoutons.add(btndeplacer);
        this.panelBoutons.add(btnTerminerTour);
        this.repaint();
    }
    
    public void changerj(Joueur joueur) {
        j = joueur;
        nomj = j.getNom();
        if (j.getAventurier() instanceof Pilote) {
            nomav = "Pilote";
            color = new Color(55,194,198);
        }
        if (j.getAventurier() instanceof Navigateur) {
            nomav = "Navigateur";
            color = new Color(255, 255, 0);
        }
        if (j.getAventurier() instanceof Plongeur) {
            nomav = "Plongeur";
            color = new Color(204, 94, 255);
        }  
        if (j.getAventurier() instanceof Explorateur) {
            nomav = "Explorateur";
            color = new Color(0, 195, 0);
        }
        if (j.getAventurier() instanceof Ingenieur) {
            nomav = "Ingénieur";
            color = new Color(255, 0, 0);
        }
        if (j.getAventurier() instanceof Messager) {
            nomav = "Messager";
            color = new Color(255, 148, 0);
        }
        if (nomav == "Navigateur") {
            btndeplacer.setText("Deplacer");
            btndeplacer.setEnabled(true);
        }
        else {
            btndeplacer.setText("Autre action");
            btndeplacer.setEnabled(false);
        }
        this.setBorder(BorderFactory.createLineBorder(getColor(), 5));
        panelAventurier.setBackground(getColor());
        nom.setText(nomj  + " : " + nomav);
        
    }
    
    public void tresor(ArrayList<Tresor> at) {
        if (j.getAventurier().getPos().getTresor() != null && !at.contains(j.getAventurier().getPos().getTresor()) && j.getAventurier().getNbactions() < 3 && cartestresor(j.getAventurier().getPos().getTresor()))
            btnrecuptresor.setEnabled(true);
        else
            btnrecuptresor.setEnabled(false);
    }
    
    public boolean cartestresor(Tresor t) {
        int nb = 0;
        for (Carte c : j.getAventurier().getCartes())
            if (c instanceof CTresor) {
                CTresor ct = (CTresor) c;
                if (ct.getTresor().equals(t))
                    nb++;
            }
        return nb < 3;
    }
    
    public void donner() {
        if (j.getAventurier().getPos().getAventuriers().size() > 1 && !j.getAventurier().getCartes().isEmpty() && j.getAventurier().getNbactions() < 3)
            btndonnercarte.setEnabled(true);
        else
            btndonnercarte.setEnabled(false);
    }

    public void assecher(Grille g) {
        if (!j.getAventurier().getTuilesAcc(g, 2).isEmpty() && ((j.getAventurier().getNbactions() < 3 || (nomav == "Ingénieur" && j.getAventurier().getSeche()))))
            btnAssecher.setEnabled(true);
        else
            btnAssecher.setEnabled(false);
    }
    
    public void deplacer() {
        if (j.getAventurier().getNbactions() < 3) {
            if (j.getAventurier() instanceof Navigateur)
               btndeplacer.setEnabled(true);
            btnAller.setEnabled(true);
        }
        else {
            btndeplacer.setEnabled(false);
            btnAller.setEnabled(false);
        }
    }
    
    public void verifboutons(ArrayList<Tresor> at, Grille g) {
        tresor(at);
        donner();
        assecher(g);
        deplacer();
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }
}

 


