package ghrAllemagne;

import Statistiques.GuiStatistiques;
import Statistiques.PageAccueil;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAppAllemagne {
    private JTextField prenomEmploye;
    private JTextField naissanceEmploye;
    private JTextField nomEmploye;
    private JButton RECHERCHEButton;
    private JPanel mainPanel;
    private JPanel resultPanel;
    private JTextPane jtextpresult;
    private JButton PRETButton;
    private JButton INFOS_GENERALLESButton;
    private JButton retourButton;
    private JLabel jLabResult;


    public GuiAppAllemagne() {

        MainAllemagne t= new MainAllemagne();


        mainPanel.setBackground(Color.lightGray);


        RECHERCHEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(" le valeurs envoyer a la methode searchProfile "+ nomEmploye.getText()+"  "+ prenomEmploye.getText()+" "+ naissanceEmploye.getText());
                jtextpresult.setText(t.salaire_employe(nomEmploye.getText(), prenomEmploye.getText(), naissanceEmploye.getText()));
            }
        });

        PRETButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(" le valeurs envoyer a la methode searchProfile "+ nomEmploye.getText()+"  "+ prenomEmploye.getText()+" "+ naissanceEmploye.getText());
                jtextpresult.setText(t.search_pret_employe(nomEmploye.getText(), prenomEmploye.getText(), naissanceEmploye.getText()));

                // affiche le nombre de pret de cet employer
                t.nombre_de_pret_d_un_employer(nomEmploye.getText(), prenomEmploye.getText(), naissanceEmploye.getText());
            }
        });

        INFOS_GENERALLESButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(" le valeurs envoyer a la methode searchProfile "+ nomEmploye.getText()+"  "+ prenomEmploye.getText()+" "+ naissanceEmploye.getText());
                jtextpresult.setText(t.infos_general_employe(nomEmploye.getText(), prenomEmploye.getText(), naissanceEmploye.getText()));

                // affiche le nombre d'absence de l'employer donn�
                t.nombre_absence_d_un_employer(nomEmploye.getText(), prenomEmploye.getText(), naissanceEmploye.getText());
            }
        });

        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiStatistiques g=new GuiStatistiques();
                resultPanel.removeAll();
                new PageAccueil().setVisible(true);

                //AfficherPanelGeneral().setVisible(true);
                resultPanel.revalidate();
                resultPanel.repaint();

                // String f= t.searchProfile(nomDeFamille,prenom,naissance);
                //    jtextpresult.setText(f);
            }
        });

    }

    public JFrame afficherPanelAllemagne(){
        MainAllemagne t= new MainAllemagne();
        //parametre
        JFrame frame=new JFrame("GuiApp");
        frame.setContentPane(new GuiAppAllemagne().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600,500);
        frame.setLocationRelativeTo(null);


        try {
            UIManager.setLookAndFeel( new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        UIManager.put("Synthetica.window.opaque", false);
        UIManager.put("Synthetica.window.shape", "");

        return frame;

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        //creation d'un object TestPerso pour la recuperation de la methode qui r�cup�re la m�thode
        //de lecture de fichier
        MainAllemagne t= new MainAllemagne();
        //parametre
        JFrame frame=new JFrame("GuiApp");
        frame.setContentPane(new GuiAppAllemagne().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600,500);
        frame.setLocationRelativeTo(null);



        UIManager.setLookAndFeel( new NimbusLookAndFeel());
        UIManager.put("Synthetica.window.opaque", false);
        UIManager.put("Synthetica.window.shape", "");

        frame.setVisible(true);


    }

}


