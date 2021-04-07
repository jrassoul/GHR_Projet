package chart;

import ghrAllemagne.MainAllemagne;
import ghrChine.MainChine;
import ghrFrance.MainFrance;
import ghrUSA.MainUSA;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;

public class BarChartEmployesTroisExperience extends ApplicationFrame {


	private JButton retourButton;

	private static final long serialVersionUID = 1L;

	public BarChartEmployesTroisExperience(String title) {

		super(title);
		JPanel Paneltotal=new JPanel();
		CategoryDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(500, 400));
		Paneltotal.add(chartPanel, BorderLayout.NORTH );
		Paneltotal.setPreferredSize(new Dimension(540, 650));
		Paneltotal.setBackground(Color.WHITE);


		// partie explication
		JTextArea titreRequette=new JTextArea( "Requette : Explication ");
		titreRequette.setFont(new Font("Serif", Font.BOLD, 15));
		JTextArea listeExplication=new JTextArea( "• Utilisation de la fonction date(now) qui renvoie la date du jour-la date du \n" +
				                   " debut de travail. Gette fonction renvoie la difference en nombre de jours \n" +
						            " (d'ou le 1095=365*3=3ans)\n\n" +
								    "• Projection sur la table employe avec condition : statut_ employe==cadre\n\n" +
									"• Recuperation du salaire moyen de la table employe en effectuant une jointure\n" +
								   " entre cette table et la table contrat ou id_l'employe de la table employe est a\n" +
									" egal id_employe de la table contrat avec les condition : statut employe==cadre\n" +
								    " et experience> 3");

		listeExplication.setCaret(new javax.swing.text.DefaultCaret() {
			public void paint(java.awt.Graphics g) {
				// do nothing
			}
		});
		this.setLocationRelativeTo(null);
		Paneltotal.add( titreRequette, BorderLayout.SOUTH );
		Paneltotal.add(listeExplication,BorderLayout.SOUTH);
		setContentPane(Paneltotal);
	}


	private CategoryDataset createDataset() {

		MainFrance frretraite=new MainFrance();
		double nbretraiteFR=frretraite.salaire_moy();


		MainChine mChine=new MainChine();
		double nbretraiteChine=mChine.le_salaire_moyen_des_employes_ayant_experience_et_un_status(3,"cadre");

		MainAllemagne mAllemagne=new MainAllemagne();
		double nbretraiteAllemagne=mAllemagne.le_salaire_moyen_des_employes_ayant_experience(3);

		MainUSA musa=new MainUSA();
		double nbretraiteUSA=musa.salaire_moy();

		String series1 = "nombre d'employés par sous entreprise 	";
		String series2 = "Second";
	//	String series3 = "Third";

		String a= " calculé la moyenne des salaire (on utilisant la fonction avg définie en sql sur la colonne salaire_base_empl ) des employés avec une condition sur le statut employé (dois être =\"cadre\") et sur son expérience au sein de l'entreprise (dois être >=3ans ) pour cela on a utilisé la fonction date(now) qui nous renvoie la date de jour- date de début travail por avoir le nombre d'années d'expérience .\n" +
				"cette fonction renvoie la différence en jour (d'ou le  1095=365*3=3ans )";

		String category1 = "Allemagne";
		String category2 = "France";
		String category3 = "Chine";
		String category4 = "USA";


		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(nbretraiteAllemagne, series1, category1);
		dataset.addValue(nbretraiteFR, series1, category2);
		dataset.addValue(nbretraiteChine, series1, category3);
		dataset.addValue(nbretraiteUSA, series1, category4);

		return dataset;

	}

	private JFreeChart createChart(CategoryDataset dataset) {

		JFreeChart chart = ChartFactory.createBarChart("Salaire moyen des employés cadres ayant au moins  3 ans d'expérience\n", "Category", "Nb emloyés", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		return chart;

	}

	public JFrame panelGrapheEmployeSalaire(){
		BarChartEmployesTroisExperience demo = new BarChartEmployesTroisExperience("Bar Chart Demo");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);


		return demo;
	}


	public static void main(String[] args) {
		BarChartEmployesTroisExperience demo = new BarChartEmployesTroisExperience("Bar Chart Demo");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);

		demo.setVisible(true);
	}

}
