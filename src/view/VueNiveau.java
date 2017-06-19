package view;

import controleur.Controleur;
import controleur.Main;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
 
public class VueNiveau extends JPanel {
   
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private ArrayList<PanelTrait>[] panelsgauche = new ArrayList[5];
    private ArrayList<PanelGrad>[] panelsmid = new ArrayList[5];
    private ArrayList<JPanel> panelmid = new ArrayList();
    private ArrayList<JPanel> panelgauche = new ArrayList();
    private ArrayList<JPanel> paneldroit = new ArrayList();
    private ArrayList<PanelGrad> panelsgrad = new ArrayList();
    private int niveau;
    private int[] nbpanels = {1,2,2,3,2};
    private String[] num = {"5","4","3","2"};
    private JLabel[] labels = new JLabel[4];
    
    public VueNiveau(int niveauInitial) {
        niveau = niveauInitial;
        setLayout(new GridLayout(5,3));
        int n = 0;
        for (int i = 0; i < 5; i++) {
            panelsgauche[i] = new ArrayList();
            panelsmid[i] = new ArrayList();
            panelgauche.add(new JPanel(new GridLayout(nbpanels[i],1))); 
            panelmid.add(new JPanel(new GridLayout(nbpanels[i],1)));
            if (i != 0) {
                paneldroit.add(new JPanel(new GridBagLayout()));
                labels[i-1] = new JLabel(num[i-1]);
                labels[i-1].setForeground(Color.white);
                labels[i-1].setFont(new Font(labels[i-1].getFont().getFontName(), labels[i-1].getFont().getStyle(), (int)dim.getWidth()/25));
                paneldroit.get(i).add(labels[i-1]);
            }
            else
                paneldroit.add(new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    g.setColor(new Color(186, 33, 51));
                    g.fillRect(0, 0, getWidth(), getHeight());
                    try {
                        g.drawImage( ImageIO.read(Main.class.getResource("/img/tdm.png")), 0, (getHeight()-getWidth())/2, getWidth(), getWidth(), this);
                    } catch (IOException ex) {
                        Logger.getLogger(VueNiveau.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                });
            for (int j = 0;j < nbpanels[i]; j++) {
                panelsgauche[i].add(new PanelTrait(9-n));
                panelgauche.get(i).add(panelsgauche[i].get(j));
                panelsmid[i].add(new PanelGrad(9-n,getHeight()));
                panelmid.get(i).add(panelsmid[i].get(j));
                panelsgrad.add(panelsmid[i].get(j));
                n++;
            }
            this.add(panelgauche.get(i));
            this.add(panelmid.get(i));
            this.add(paneldroit.get(i));
            for (int j = 0; j < nbpanels[i]; j++) {
                switch (i) {
                    case 0:
                        panelsgauche[i].get(j).setBackground(new Color(186, 33, 51));
                        panelsmid[i].get(j).setBackground(new Color(186, 33, 51));
                        break;
                    case 1:
                        panelsgauche[i].get(j).setBackground(new Color(53, 67, 114));
                        panelsmid[i].get(j).setBackground(new Color(53, 67, 114));
                        break;
                    case 2:
                        panelsgauche[i].get(j).setBackground(new Color(67, 93, 144));
                        panelsmid[i].get(j).setBackground(new Color(67, 93, 144));
                        break;
                    case 3:
                        panelsgauche[i].get(j).setBackground(new Color(92, 131, 174));
                        panelsmid[i].get(j).setBackground(new Color(92, 131, 174));
                        break;
                    case 4:
                        panelsgauche[i].get(j).setBackground(new Color(138, 181, 200));
                        panelsmid[i].get(j).setBackground(new Color(138, 181, 200));
                        break;
                }
            }
        }
        Collections.sort(panelsgrad);
        panelsgrad.get(niveau-1).setActuel(true);
        panelsgrad.get(niveau-1).repaint();
        paneldroit.get(1).setBackground(new Color(53, 67, 114));
        paneldroit.get(2).setBackground(new Color(67, 93, 144));
        paneldroit.get(3).setBackground(new Color(92, 131, 174));
        paneldroit.get(4).setBackground(new Color(138, 181, 200));
        panelsgauche[4].get(1).setLayout(new BorderLayout());
        panelsgauche[4].get(0).setLayout(new BorderLayout());
        panelsgauche[3].get(2).setLayout(new BorderLayout());
        panelsgauche[3].get(1).setLayout(new BorderLayout());
        
        panelsgauche[4].get(1).setBorder(BorderFactory.createEmptyBorder((int)dim.getWidth()/75, (int)dim.getWidth()/400, 0, 0));
        panelsgauche[4].get(0).setBorder(BorderFactory.createEmptyBorder((int)dim.getWidth()/75, (int)dim.getWidth()/400, 0, 0));
        panelsgauche[3].get(2).setBorder(BorderFactory.createEmptyBorder((int)dim.getWidth()/75, (int)dim.getWidth()/400, 0, 0));
        panelsgauche[3].get(1).setBorder(BorderFactory.createEmptyBorder((int)dim.getWidth()/75, (int)dim.getWidth()/400, 0, 0));
        
        panelsgauche[4].get(1).add(new JLabel("Novice"), BorderLayout.WEST);
        panelsgauche[4].get(0).add(new JLabel("Normal"), BorderLayout.WEST);
        panelsgauche[3].get(2).add(new JLabel("Elite"), BorderLayout.WEST);
        panelsgauche[3].get(1).add(new JLabel("Légendaire"), BorderLayout.WEST);
    }
    
    public void nivplus() {
        panelsgrad.get(niveau-1).setActuel(false);
        panelsgrad.get(niveau-1).repaint();
        niveau++;
        panelsgrad.get(niveau-1).setActuel(true);
        panelsgrad.get(niveau-1).repaint();
    }
   
}