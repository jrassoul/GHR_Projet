package Statistiques;

import chart.*;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiStatistiques {
    private JPanel mainPanel;
    private JPanel graphPanel5;
    private JButton retourButton;
    private JButton employéesQuiParteEnButton;
    private JButton salaireEmployésAvec3Button;
    private JButton pourcentageEmployesTempsEtButton;
    private JButton poucentageDiversitéDesEntrepriseButton;
    private JButton nombreDeJeuneRecruteButton;

    public GuiStatistiques() {





        salaireEmployésAvec3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BarChartEmployesTroisExperience g=new BarChartEmployesTroisExperience("title");

                g.panelGrapheEmployeSalaire().setVisible(true);



                //AfficherPanelGeneral().setVisible(true);

                // String f= t.searchProfile(nomDeFamille,prenom,naissance);
                //    jtextpresult.setText(f);
            }
        });


        employéesQuiParteEnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BarChartEmployesRetraite g=new BarChartEmployesRetraite("title");

                g.panelGrapheEmployeRetraite().setVisible(true);



                //AfficherPanelGeneral().setVisible(true);

                // String f= t.searchProfile(nomDeFamille,prenom,naissance);
                //    jtextpresult.setText(f);
            }
        });

        pourcentageEmployesTempsEtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PourcentageEmployesTempsPlein g=new PourcentageEmployesTempsPlein("title");
                g.AfficherPourcentageEmployeTempsPlein().setVisible(true);



                //AfficherPanelGeneral().setVisible(true);

                // String f= t.searchProfile(nomDeFamille,prenom,naissance);
                //    jtextpresult.setText(f);
            }
        });

        poucentageDiversitéDesEntrepriseButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            PiepoucentageEmployesetrange g=new PiepoucentageEmployesetrange("title");
            g.AffichageEmloyesDiversiteEntreprise().setVisible(true);



            //AfficherPanelGeneral().setVisible(true);

            // String f= t.searchProfile(nomDeFamille,prenom,naissance);
            //    jtextpresult.setText(f);
        }
    });
        nombreDeJeuneRecruteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Nb_jeune_recrute_2020 n=new Nb_jeune_recrute_2020("Jeune rectute");
                n.afficherNbJeuneRecrute().setVisible(true);



                //AfficherPanelGeneral().setVisible(true);

                // String f= t.searchProfile(nomDeFamille,prenom,naissance);
                //    jtextpresult.setText(f);
            }
        });





        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiStatistiques g=new GuiStatistiques();

                new PageAccueil().setVisible(true);
                mainPanel.removeAll();


                //AfficherPanelGeneral().setVisible(true);

                // String f= t.searchProfile(nomDeFamille,prenom,naissance);
                //    jtextpresult.setText(f);
            }
        });


    }

    public JFrame AfficherPanelGeneral(){
        JFrame frame = new JFrame("GuiAppGeneral");
        frame.setContentPane(new GuiStatistiques().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        UIManager.put("Synthetica.window.opaque", false);
        UIManager.put("Synthetica.window.shape", "");

        return frame;
    }

    public JFrame afficherPanelGeneral(){
        JFrame frame = new JFrame("GuiAppGeneral");
        frame.setContentPane(new GuiStatistiques().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);

       // frame.setForeground(UIManager.getColor("EditorPane.inactiveBackground"));

        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        UIManager.put("Synthetica.window.opaque", false);
        UIManager.put("Synthetica.window.shape", "");

        return  frame;
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        JFrame frame = new JFrame("GuiAppGeneral");
        frame.setContentPane(new GuiStatistiques().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);


        UIManager.getColor("EditorPane.inactiveBackground");
        frame.setVisible(true);
    }
}