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

public class Nb_jeune_recrute_2020 extends ApplicationFrame {


	private static final long serialVersionUID = 1L;

	public Nb_jeune_recrute_2020(String title) {

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


		this.setLocationRelativeTo(null);
		Paneltotal.add( titreRequette, BorderLayout.SOUTH );
		Paneltotal.add(listeExplication,BorderLayout.SOUTH);
		setContentPane(Paneltotal);
	}


	private CategoryDataset createDataset() {

		 MainFrance mfr	=new MainFrance();
		 double nbretraiteFR= mfr.nbr_jeune_cadre();


		MainChine mchine=new MainChine();
		double nbretraiteChine=mchine.nombre_employer_jeune_recruter_en(2019,2020,"cadre");

		MainAllemagne mAllemagne=new MainAllemagne();
		double nbretraiteAllemagne=mAllemagne.nombre_employer_jeune_recruter_en(2019,2020,"cadre");

		MainUSA mUsa=new MainUSA();
		double nbretraiteUSA=mUsa.nbr_jeune_cadre();

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
		Nb_jeune_recrute_2020 demo = new Nb_jeune_recrute_2020("Bar Chart Demo");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);


		return demo;
	}


	public JFrame afficherNbJeuneRecrute(){
		Nb_jeune_recrute_2020 demo = new Nb_jeune_recrute_2020("Jeune recrute");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
		return demo;
	};

	public static void main(String[] args) {
		Nb_jeune_recrute_2020 demo = new Nb_jeune_recrute_2020("Bar Chart Demo");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}

}
