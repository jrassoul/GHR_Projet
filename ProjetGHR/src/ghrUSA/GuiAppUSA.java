package ghrUSA;

import Statistiques.GuiStatistiques;
import Statistiques.PageAccueil;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAppUSA {

     JTextField name;
    JButton RECHERCHEButton;
    private JPanel mainPanel;
    private JPanel resultPanel;
    private JTextPane jtextpresult;
    private JTextField lastName;
    private JLabel jLabResult;
    private JTextField dateOfBirth;
    private JTextArea textArea1;
    private JButton retourButton;
    private JButton employesRetraiteBtn;
    private JTextField textField1;
    private JTable table1;


    public GuiAppUSA() {

        MainUSA c=new MainUSA();

        // Listner btn Recherche
        RECHERCHEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //        JOptionPane.showMessageDialog(null,"hello");
                textArea1.setText(String.valueOf(c.affichage("Alani","Mimoun")));

                //textArea1.setText(c.test(lastName.getText()));}

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




        //Methode récupération d'un panle tableau affichage des employées qui parte en retraite





    public JFrame AfficherPanelUSA(){
        JFrame frame=new JFrame("GuiApp");
        frame.setContentPane(new GuiAppUSA().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600,300);
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
        //creation d'un object TestPerso pour la recuperation de la methode qui récupére la méthode
        //de lecture de fichier
        //parametre
        JFrame frame=new JFrame("GuiApp");
        frame.setContentPane(new GuiAppUSA().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600,300);
        frame.setLocationRelativeTo(null);



        UIManager.setLookAndFeel( new NimbusLookAndFeel());
        UIManager.put("Synthetica.window.opaque", false);
        UIManager.put("Synthetica.window.shape", "");

        frame.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}