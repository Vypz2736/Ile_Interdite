/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controleur.Controleur;
import controleur.Main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util.Message;

/**
 *
 * @author Vypz
 */
public class VueFin extends JPanel {
       
    private JLabel text;
    private boolean gagne = true;
    private JButton replay;
    private JButton finish;
    private JPanel layout;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private Controleur c;
   
    public VueFin(boolean g, Controleur controleur){
        c = controleur;
        gagne = g;
        layout = new JPanel(new GridLayout(2,1));
        setLayout(new GridLayout(2,1));
        setBackground(new Color(35,35,35));
        JPanel titre = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                try {
                    g.drawImage(ImageIO.read(Main.class.getResource("/img/titre.png")), (int) (getWidth()-getHeight()/350*154), 0, (int) ((getHeight()/350)*154), getHeight(), this);
                } catch (IOException ex) {
                    Logger.getLogger(VueFin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        this.add(titre);
        this.add(layout);
        JPanel label = new JPanel(new GridBagLayout());
        label.setBackground(new Color(35,35,35));
        if (gagne)
            text = new JLabel("Bravo, vous avez gagné !!!");
        else
            text = new JLabel("Dommage, vous avez perdu...");
        text.setFont(new Font(text.getFont().getFontName(), text.getFont().getStyle(), (int)dim.getWidth()/50));
        text.setForeground(new Color(0,192,255));
        label.add(text);
        layout.add(label);
        JPanel boutons = new JPanel(new GridLayout(1,5));
        boutons.setBackground(new Color(35,35,35));
        layout.setBackground(new Color(35,35,35));
        replay = new JButton("Rejouer");
        boutons.add(new JLabel());
        boutons.add(replay);
        boutons.add(new JLabel());
        replay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.traiterMessage(new Message(Message.TypeMessage.RELANCER));
            }
        });
        finish = new JButton("Quitter");
        boutons.add(finish);
        boutons.add(new JLabel());
        finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        layout.add(boutons);
        boutons.setBorder(BorderFactory.createEmptyBorder((int)dim.getWidth()/100, 0, (int)dim.getWidth()/150, 0));
        this.setBorder(BorderFactory.createEmptyBorder((int)dim.getWidth()/300, (int)dim.getWidth()/300, (int)dim.getWidth()/300, (int)dim.getWidth()/300));
        setVisible(true);
    }
   
}