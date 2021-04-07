package ghrChine;

import Statistiques.GuiStatistiques;
import Statistiques.PageAccueil;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Map;

public class GuiApp_Chine {

    private JTextField name;
    private JButton RECHERCHEButton;
    private JPanel mainPanel;
    private JPanel resultPanel;
    private JTextPane jtextpresult;
    private JTextField lastName;
    private JLabel jLabResult;
    private JTextField dateOfBirth;
    private JButton employesRetraiteBtn;
    private JTextField anneeDepartRetraiteText;
    private JButton retourButton;
    private JTable table1;


    public GuiApp_Chine() {

        /**
         * mettre setvisible a false pour pouvoir afficher le panel apres le click bouton
         */
        PanelTabinfo("","juba","24/02/1996").setVisible(false);

        MainChine t=new MainChine();

        RECHERCHEButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                String nameText = name.getText();
                String dateOfBirthText = dateOfBirth.getText();
                String lastnameText = lastName.getText();
                /**
                 * revalidate()  reforcer le calcul du layout pour le reafficher
                 * removeAll() pour eviter la surcharge
                 */

                resultPanel.removeAll();
                PanelTabinfo(lastnameText,nameText,dateOfBirthText).setVisible(true);
                resultPanel.revalidate();
                resultPanel.repaint();

                // String f= t.searchProfile(nomDeFamille,prenom,naissance);
                //    jtextpresult.setText(f);
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


        /**
         * Listner btn retraite
         */

        employesRetraiteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                resultPanel.removeAll();
                try {
                    PanelTabinfoRetraite(Integer.valueOf(anneeDepartRetraiteText.getText()));
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                resultPanel.revalidate();
                resultPanel.repaint();

            }
        });
    }


    /**
     * Methode récupération d'un panle tableau affichage des employées qui parte en retraite
     * @param NumContrat
     * @return resultPanel
     * @throws FileNotFoundException
     */
    public JPanel PanelTabinfoRetraite(int NumContrat) throws FileNotFoundException {
        MainChine t = new MainChine();
        String[] columnNames = {"Contract"
                ,"First Name",
                "Last Name",
                "Date de debut",
                "mail",
                "T?l?phone"};

        //Object data=t.Retrait?Contats(t.employer_qui_parttent_en_retraite_en(2080));
        Object[][] data=t.RetraitéContats(t.employer_qui_parttent_en_retraite_en(NumContrat));
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        resultPanel.setLayout(new BorderLayout());
        resultPanel.add(table.getTableHeader(), BorderLayout.PAGE_START);
        resultPanel.add(table, BorderLayout.CENTER);
        resultPanel.setOpaque(true);

        return  resultPanel;
    };


    public JPanel PanelTabinfo(String lastName,String name,String dateOfBirth){
        MainChine t=new MainChine();
        //appel fonction Search
        Map HMapIG=t.searchProfile(lastName,name,dateOfBirth);

        String[] columnNames = {"Contract"
                ,"First Name",
                "Last Name",
                "Date de debut",
                "mail",
                "T?l?phone"};
        Object[][] data = {

                {HMapIG.get("contrat"), HMapIG.get("name"),HMapIG.get("lastname"),
                        HMapIG.get("dateDebut"),HMapIG.get("mail"),HMapIG.get("telephone")}
        };

        JTable table = new JTable(data, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);



        resultPanel.setLayout(new BorderLayout());
        resultPanel.add(table.getTableHeader(), BorderLayout.PAGE_START);
        resultPanel.add(table, BorderLayout.CENTER);
        resultPanel.setOpaque(true);

        return  resultPanel;
    };

    void searchResult(){
        RECHERCHEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"hello");
            }
        });
    };

    public JFrame affichage(){
        JFrame frame=new JFrame("Sous entreprise Chine");
        frame.setContentPane(new GuiApp_Chine().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000,800);
        frame.setLocationRelativeTo(null);


        try {
            UIManager.setLookAndFeel( new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        UIManager.put("Synthetica.window.opaque", false);
        UIManager.put("Synthetica.window.shape", "");

        return    frame;

    }


    public static void main(String[] args)  {
        //creation d'un object TestPerso pour la recuperation de la methode qui r?cup?re la m?thode
        //de lecture de fichier
        MainChine t= new MainChine();
        //parametre
        JFrame frame=new JFrame("GuiApp");
        frame.setContentPane(new GuiApp_Chine().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000,800);
        frame.setLocationRelativeTo(null);


        try {
            UIManager.setLookAndFeel( new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        UIManager.put("Synthetica.window.opaque", false);
        UIManager.put("Synthetica.window.shape", "");

        frame.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}