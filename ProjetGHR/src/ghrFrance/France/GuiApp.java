package ghrFrance.France;

import ghrFrance.MainFrance;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiApp extends JFrame  {

     JTextField name;
    JButton RECHERCHEButton;
    private JPanel mainPanel;
    private JPanel resultPanel;
    private JTextPane jtextpresult;
    private JTextField lastName;
    private JLabel jLabResult;
    private JTextField dateOfBirth;
    private JTextArea textArea1;
    private JButton employesRetraiteBtn;
    private JTextField textField1;
    private JTable table1;


    public GuiApp() {

        MainFrance c=new MainFrance();

        // Listner btn Recherche
        RECHERCHEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //        JOptionPane.showMessageDialog(null,"hello");

                textArea1.setText(String.valueOf(c.nbr_jeune_cadre()));
                //textArea1.setText(c.test(lastName.getText()));

            }
        });

    }



        //Methode récupération d'un panle tableau affichage des employées qui parte en retraite






    public static void main(String[] args) throws UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        //creation d'un object TestPerso pour la recuperation de la methode qui récupére la méthode
        //de lecture de fichier
        //parametre
        JFrame frame=new JFrame("GuiApp");
        frame.setContentPane(new GuiApp().mainPanel);
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