
package Statistiques;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GestionGlobal.GuiGestion;
import ghrAllemagne.GuiAppAllemagne;
import ghrChine.GuiApp_Chine;
import ghrFrance.France.PageFrance;
import ghrUSA.GuiAppUSA;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import java.awt.Font;


public class PageAccueil extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageAccueil frame = new PageAccueil();
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
	public PageAccueil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 650, 420);
		contentPane = new JPanel();
		setResizable(false);

		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JButton btnGeneralitestat = new JButton("Statistiques");
		btnGeneralitestat.setForeground(Color.WHITE);
		btnGeneralitestat.setBackground(new Color(66, 91, 138));
		btnGeneralitestat.setBounds(10, 331, 170, 48);
		contentPane.add(btnGeneralitestat);

		JButton btnGeneraliteCalcule = new JButton("Gestion Globale");
		btnGeneraliteCalcule.setForeground(Color.WHITE);
		btnGeneraliteCalcule.setBackground(new Color(66, 91, 138));
		btnGeneraliteCalcule.setBounds(10, 272, 170, 48);
		contentPane.add(btnGeneraliteCalcule);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./src/Statistiques/Image/img_accueil.png"));
		lblNewLabel.setBounds(182, 0, 452, 473);
		contentPane.add(lblNewLabel);
		
		JEditorPane dtrpnGg = new JEditorPane();
		dtrpnGg.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 27));
		dtrpnGg.setEditable(false);
		dtrpnGg.setForeground(new Color(0, 51, 102));
		dtrpnGg.setText("Gestion de Paie des Employés");
		dtrpnGg.setBounds(270, 58, 306, 42);
		contentPane.add(dtrpnGg);

		
		JButton btnUsa = new JButton("USA");
		btnUsa.setForeground(Color.WHITE);
		btnUsa.setBackground(new Color(66, 91, 138));
		btnUsa.setBounds(10, 213, 170, 48);
		contentPane.add(btnUsa);
		
		JButton btnAllemagne = new JButton("Allemagne");
		btnAllemagne.setForeground(Color.WHITE);
		btnAllemagne.setBackground(new Color(66, 91, 138));
		btnAllemagne.setBounds(10, 154, 170, 48);
		contentPane.add(btnAllemagne);
		
		JButton btnFrance = new JButton("France");
		btnFrance.setForeground(Color.WHITE);
		btnFrance.setBackground(new Color(66, 91, 138));
		btnFrance.setBounds(10, 95, 170, 48);
		contentPane.add(btnFrance);

		JButton btnChine = new JButton("Chine");
		btnChine.setForeground(Color.WHITE);
		btnChine.setBackground(new Color(66, 91, 138));
		btnChine.setBounds(10, 36, 170, 48);
		contentPane.add(btnChine);


		btnGeneraliteCalcule.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				GuiGestion g=new GuiGestion();
				if((JButton)e.getSource()==btnGeneraliteCalcule)
				{
					g.afficherGestion().setVisible(true);
				}
			}
		});

		btnGeneralitestat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				GuiStatistiques g=new GuiStatistiques();
				if((JButton)e.getSource()==btnGeneralitestat)
				{
					g.AfficherPanelGeneral().setVisible(true);
				}
			}
		});


		//Action listner btn France
		btnFrance.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {



		    	if((JButton)e.getSource()==btnFrance)
		    	{
		    	new PageFrance().setVisible(true);

				}
		    }
		});

		//     Action listner btn Chine
		btnChine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GuiApp_Chine g=new GuiApp_Chine();

				if((JButton)e.getSource()==btnChine)
				{
					g.affichage().setVisible(true);

				}
			}
		});

		//     Action listner btn Allemagne
		btnAllemagne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//GuiApp_Chine g=new GuiApp_Chine();
				GuiAppAllemagne g=new GuiAppAllemagne();
				if((JButton)e.getSource()==btnAllemagne)
				{
					g.afficherPanelAllemagne().setVisible(true);
				}
			}
		});

		//	     Action listner btn USA
		btnUsa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//GuiApp_Chine g=new GuiApp_Chine();
				GuiAppUSA g=new GuiAppUSA();
				if((JButton)e.getSource()==btnUsa)
				{
					g.AfficherPanelUSA().setVisible(true);
				}
			}
		});
	}
}

