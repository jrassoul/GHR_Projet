package ghrFrance.France;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ghrFrance.MainFrance;
import Statistiques.GuiStatistiques;
import Statistiques.PageAccueil;

import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class PageFrance extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageFrance frame = new PageFrance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public PageFrance() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);




		JEditorPane dtrpnGg = new JEditorPane();
		dtrpnGg.setBackground(UIManager.getColor("EditorPane.inactiveBackground"));
		dtrpnGg.setEditable(false);
		dtrpnGg.setForeground(new Color(0, 51, 102));
		dtrpnGg.setText("Entrez le nom de l'employe");
		dtrpnGg.setBounds(20, 43, 306, 20);
		contentPane.add(dtrpnGg);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(UIManager.getColor("FormattedTextField.inactiveBackground"));
		textArea_1.setBounds(20, 67, 219, 28);
		contentPane.add(textArea_1);


		JEditorPane dtrpnEntrezLePrenom = new JEditorPane();
		dtrpnEntrezLePrenom.setText("Entrez le prenom de l'employe");
		dtrpnEntrezLePrenom.setForeground(new Color(0, 51, 102));
		dtrpnEntrezLePrenom.setEditable(false);
		dtrpnEntrezLePrenom.setBackground(Color.WHITE);
		dtrpnEntrezLePrenom.setBounds(20, 104, 306, 20);
		contentPane.add(dtrpnEntrezLePrenom);

		JButton btnNewButton = new JButton("FRANCE");
		btnNewButton.setForeground(UIManager.getColor("EditorPane.inactiveBackground"));
		btnNewButton.setBackground(new Color(66, 91, 138));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(172, 0, 118, 20);
		contentPane.add(btnNewButton);


		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setBackground(SystemColor.menu);
		textArea_1_1.setBounds(20, 125, 219, 28);
		contentPane.add(textArea_1_1);

		JButton btnNewButton_1 = new JButton("Rechercher");
		btnNewButton_1.setBounds(73, 175, 105, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_4 = new JButton("Retour");
		btnNewButton_4.setBounds(73, 225, 105, 23);
		contentPane.add(btnNewButton_4);


		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GuiStatistiques g=new GuiStatistiques();
				contentPane.removeAll();
				new PageAccueil().setVisible(true);
				//AfficherPanelGeneral().setVisible(true);
				contentPane.revalidate();
				contentPane.repaint();

				// String f= t.searchProfile(nomDeFamille,prenom,naissance);
				//    jtextpresult.setText(f);
			}
		});


		btnNewButton_1.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {


		    	if((JButton)e.getSource()==btnNewButton_1)
		    	{
		    		  System.out.println("Connexion à la base de données MySql effectuée avec succés");

		    	}
		    }
		});




		MainFrance con=new MainFrance();
		/*btnNewButton_1.addActionListener(new ActionListener() {

		   // @Override
		    //public void actionPerformed(ActionEvent e) {

		    	//textField.setText(con.infoEmploye());
		    	/*if((JButton)e.getSource()==btnFrance)
		    	{
		    	new PageFrance().setVisible(true);

		    	}*/
		    }
		}//);








