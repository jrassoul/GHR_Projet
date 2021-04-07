package GestionGlobal;

import Statistiques.GuiStatistiques;
import ghrAllemagne.MainAllemagne;
import ghrChine.MainChine;
import ghrFrance.MainFrance;
import ghrUSA.MainUSA;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

    public class GuiGestion {
    private JPanel mainPanel;
        private JPanel graphPanel5;
        private JButton argentDebourséDansLesButton2;
        private JButton argentDebourséDansLesButton;
        private JButton nombreDEmloyésLicenciésButton;
        private JButton leNombreDesJeunesButton;
        private JLabel reqUn;
        private JLabel reqDeux;
        private JLabel reqTrois;
        private JLabel reqQuatre;
        private JLabel reqcinq;

        public GuiGestion(){

            reqUnArgentDebourseSurLesPretEmploye();
            reqDeuxmontant_employes_benef_plus_avantages();
            reqTroixNbempLicence();
            reqQuatreNbemployes();
            reqsinqNbemployes();

    }

    //Argent déboursé sur les pret emloyé
        public void reqUnArgentDebourseSurLesPretEmploye(){
            MainFrance mfr= new MainFrance();
              double f=  mfr.argent_pret();
            MainUSA mUSA=new MainUSA();
               double u= mUSA.argent_pret();
            MainAllemagne mAllemagne=new MainAllemagne();
                double a= mAllemagne.somme_argent_reste_a_recuperer_dans_les_prets();
            MainChine mChine=new MainChine();
              double c= mChine.somme_argent_reste_a_recuperer_dans_les_prets();
         String ab=Double.toString (f+u+a+c);
            reqUn.setText(ab+" Dollars");
        };



        public void reqDeuxmontant_employes_benef_plus_avantages(){
            double tab[] = new double[0];
            double var=0.0;
            MainFrance mfr= new MainFrance();
              double a=  mfr.montant_max_avantage();
            MainUSA mUSA=new MainUSA();
            double b= mUSA.emp_max_avnt();
            MainAllemagne  mAllemagne=new MainAllemagne();
            double d= mAllemagne.montant_employes_benef_plus_avantages() ;
            MainChine mChine=new MainChine();
            double e= mChine.montant_employes_benef_plus_avantages();

                String s=Double.toString(a+b+d+e);
                reqDeux.setText(s+" Dollars");
        };

        public void reqTroixNbempLicence(){


            MainFrance mfr= new MainFrance();
             int f=  mfr.nbr_emp_lic();
            MainUSA mUSA=new MainUSA();
            int u= mUSA.nbr_emp_lic();
            MainAllemagne  mAllemagne=new MainAllemagne();
             int a= mAllemagne.nombre_employer_licencier() ;
            MainChine mChine=new MainChine();
              int c = mChine.nb_de_personne_a_licencier();

              String s=Integer.toString((f+u+a+c));
              reqTrois.setText(s);
        };


        public void reqQuatreNbemployes(){

            MainFrance mfr= new MainFrance();
            int f=  mfr.nbr_jeune_cadre();
            MainUSA mUSA=new MainUSA();
            int u= mUSA.nbr_jeune_cadre();
            MainAllemagne  mAllemagne=new MainAllemagne();
            int a= mAllemagne.nombre_employer_jeune_recruter_en(2019,2020,"cadre");
            MainChine mChine=new MainChine();
            int c = mChine.nombre_employer_jeune_recruter_en(2019,2020,"cadre");

            String s=Double.toString(f+u+a+c);
            reqQuatre.setText(s);
        };

        public void reqsinqNbemployes(){

            MainFrance mfr= new MainFrance();
            int f=  mfr.retraite_2030();
            MainUSA mUSA=new MainUSA();
            int u= mUSA.retraire_2030();
            MainAllemagne  mAllemagne=new MainAllemagne();
            int a= mAllemagne.nombre_employer_qui_parttent_en_retraite_en(2030);
            MainChine mChine=new MainChine();
            int c = mChine.nombre_employer_qui_parttent_en_retraite_en(2030);

             String s= Double.toString(f+u+a+c);
             reqcinq.setText(s);
        };








    public JFrame afficherPanelGeneral(){
        JFrame frame = new JFrame("GuiGestion");
        frame.setContentPane(new GuiGestion().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null);




        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        UIManager.put("Synthetica.window.opaque", false);
        UIManager.put("Synthetica.window.shape", "");

        return  frame;


        }


        public JFrame afficherGestion(){
            GuiGestion g=new GuiGestion();

            JFrame frame = new JFrame("GuiAppGeneral");
            frame.setContentPane(new GuiGestion().mainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(900, 700);
            frame.setLocationRelativeTo(null);
            UIManager.getColor("EditorPane.inactiveBackground");
            frame.setVisible(true);

            return frame;
        }


    public static void main(String[] args) throws UnsupportedLookAndFeelException {

    }
}