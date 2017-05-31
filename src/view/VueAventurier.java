package view;

import controleur.Controleur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;
import models.Explorateur;
import models.Ingenieur;
import models.Joueur;
import models.Messager;
import models.Navigateur;
import models.Pilote;
import models.Plongeur;
import util.Message;

 
public class VueAventurier extends JPanel {
     
    private final JPanel panelBoutons ;
    private final JPanel panelCentre ;
    private final JPanel panelAventurier;
    private final JPanel mainPanel;
    private final JButton btnAller  ;
    private final JButton btnAssecher;
    private final JButton btnAutreAction;
    private final JButton btnTerminerTour;
    private final JTextField position;
    private Controleur c;
    private Color color;
    private String nomj;
    private String nomav;
    
    public VueAventurier (Joueur j, Controleur controleur){

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

        mainPanel = new JPanel(new BorderLayout());
        this.add(mainPanel);
        
        mainPanel.setBackground(new Color(230, 230, 230));
        mainPanel.setBorder(BorderFactory.createLineBorder(color, 2)) ;

        // =================================================================================
        // NORD : le titre = nom de l'aventurier + nom du joueur sur la couleurActive du pion

        this.panelAventurier = new JPanel();
        panelAventurier.setBackground(color);
        panelAventurier.add(new JLabel(nomj  + " : " + nomav,SwingConstants.CENTER ));
        mainPanel.add(panelAventurier, BorderLayout.NORTH);
   
        // =================================================================================
        // CENTRE : 1 ligne pour position courante
        this.panelCentre = new JPanel(new GridLayout(2, 1));
        this.panelCentre.setOpaque(false);
        this.panelCentre.setBorder(new MatteBorder(0, 0, 2, 0, color));
        mainPanel.add(this.panelCentre, BorderLayout.CENTER);
        
        panelCentre.add(new JLabel ("Position", SwingConstants.CENTER));
        position = new  JTextField(30); 
        position.setHorizontalAlignment(CENTER);
        panelCentre.add(position);


        // =================================================================================
        // SUD : les boutons
        this.panelBoutons = new JPanel(new GridLayout(2,2));
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.SOUTH);

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
        this.btnAutreAction = new JButton("AutreAction") ;
        btnAutreAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nomav == "Navigateur")
                    c.traiterMessage(new Message(Message.TypeMessage.DEPLACER));
            }
        });
        this.btnTerminerTour = new JButton("Terminer Tour") ;
        btnTerminerTour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.traiterMessage(new Message(Message.TypeMessage.PASSER));
            }
        });
        
        this.panelBoutons.add(btnAller);
        this.panelBoutons.add(btnAssecher);
        this.panelBoutons.add(btnAutreAction);
        this.panelBoutons.add(btnTerminerTour);
        mainPanel.repaint();
    }  

     public JButton getBtnAutreAction() {
        return btnAutreAction;
    }

    public void setPosition(String pos) {
        this.position.setText(pos);
    }

    public JButton getBtnAller() {
        return btnAller;
    }
    
    public JButton getBtnAssecher() {
        return btnAssecher;
    }

    public JButton getBtnTerminerTour() {
        return btnTerminerTour;
    }
}

 


