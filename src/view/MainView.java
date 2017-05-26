/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controleur.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Vypz
 */
public class MainView {

    private final JFrame window;
    private VueGrille v;
    private Controleur c = new Controleur();
    JPanel mainpanel;
    
    public MainView() {
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setTitle("L'Île Interdite");
        window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        c.nouveauJoueur("Philippe");
        c.nouveauJoueur("André");
        c.nouveauJoueur("Gérard");
        c.nouveauJoueur("Hughes");
        c.init();
        v = new VueGrille(c.getGrille());
        window.setVisible(true);
    }
    
    public static void main(String[] args) {
        MainView m = new MainView();
    }
    
}
