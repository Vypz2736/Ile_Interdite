/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import util.Message;


public class Main {

    public Controleur c;
    public Main() {
        c = new Controleur(this);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }
    
    public void traiterMessage(Message msg) {
        c = null;
        System.gc();
        c = new Controleur(this);
    }
    
}
