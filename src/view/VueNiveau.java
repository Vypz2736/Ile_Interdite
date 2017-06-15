package view;

import controleur.Controleur;
import java.awt.*;
import java.util.*;
import javax.swing.*;
 
public class VueNiveau extends JPanel {
   
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private Controleur c;
    private ArrayList<JPanel>[] inceptionpanel = new ArrayList[5];
    private ArrayList<JPanel> panelsgrad = new ArrayList();
    private ArrayList<JPanel> panels = new ArrayList();
    private JLabel labelimg = new JLabel();
       
    public VueNiveau(int niveauInitial) {
        labelimg.setText("img");
        setLayout(new GridLayout(5,1));
        for (int i = 0; i < 5; i++) {
            inceptionpanel[i] = new ArrayList();
            panels.add(new JPanel(new GridLayout(1,2)));
            if (i == 3) {
                panelsgrad.add(new JPanel(new GridLayout(3,1)));
                for (int j = 0; j < 3; j++) {
                    //inceptionpanel[i].add(new JPanel());
                    //panels.get(panels.size()-1).add(inceptionpanel[i].get(inceptionpanel[i].size()-1));
                }
            }
            else if (i == 0) {
                panelsgrad.add(new JPanel(new GridLayout(1,1)));
                inceptionpanel[i].add(new JPanel());
                panels.get(panels.size()-1).add(inceptionpanel[i].get(inceptionpanel[i].size()-1));
            }
            else {
                panelsgrad.add(new JPanel(new GridLayout(2,1)));
                for (int j = 0; j < 2; j++)
                   
                    inceptionpanel[i].add(new JPanel());
                    panels.get(panels.size()-1).add(inceptionpanel[i].get(inceptionpanel[i].size()-1));
            }
            panels.get(panels.size()-1).add(panelsgrad.get(panelsgrad.size()-1));
            if (i != 0)
                panels.get(panels.size()-1).add(new JLabel(Integer.toString(6-i)));
            else
                panels.get(panels.size()-1).add(labelimg);
            this.add(panels.get(panels.size()-1));
            for (JPanel p : inceptionpanel[i]) {
                switch (i) {
                    case 0:
                        panels.get(i).setBackground(new Color(186, 33, 51));
                        p.setBackground(new Color(186, 33, 51));
                        break;
                    case 1:
                        panels.get(i).setBackground(new Color(53, 67, 114));
                        p.setBackground(new Color(53, 67, 114));
                        break;
                    case 2:
                        panels.get(i).setBackground(new Color(67, 93, 144));
                        p.setBackground(new Color(67, 93, 144));
                        break;
                    case 3:
                        panels.get(i).setBackground(new Color(92, 131, 174));
                        p.setBackground(new Color(92, 131, 174));
                        break;
                    case 4:
                        panels.get(i).setBackground(new Color(138, 181, 200));
                        p.setBackground(new Color(138, 181, 200));
                        break;
                }
            }
        }
        
    }
   
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(400,1000);
        window.add(new VueNiveau(1));
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
}