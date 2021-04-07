package chart;


import java.awt.*;

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

public class PourcentageEmployesTempsPlein extends ApplicationFrame {

	private static final long serialVersionUID = 1L;

	public PourcentageEmployesTempsPlein(String title) {

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
			JTextArea listeExplication=new JTextArea( "-  Utilisation de deux variables  qui recuperent dans lordre : le ombre d employes qui\n" +
					"  ne sont pas de nationalite Americaine, et une autre qui recupere le nombre total des\n" +
					"  employes.\n\n" +
					"-  Le pourcentage est calcule en fonction de ces deux valeurs pourcentage_variation \n" +
					"= nombre_employe_trangere/nombre_total_employes \n\n" +
					"-   Il s agit de compter le nombre d employes dans la table Employe qui verifie la \n" +
					"condition( !=Americaine ) dans la colonne nationalite d employe.	");

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

		MainFrance fr=new MainFrance();
		double nbpleinFR=fr.temps_plein();
		double nbpartielFR=100-fr.temps_plein();

		MainChine mChine=new MainChine();
		double nbpleinChine=mChine.pourcentage_tempsPlein() ;
		double nbpartielChine=100-mChine.pourcentage_tempsPlein();

		MainAllemagne mAllemagne=new MainAllemagne();
		double nbpleinAllemagne=mAllemagne.poucentage_des_employes_travail_temps_pleine();
		double nbpartielAllemagne=100-mAllemagne.poucentage_des_employes_travail_temps_pleine();

		MainUSA musa=new MainUSA();
		double nbpleinusa =musa.temps_plein();
		double nbpartielnusa=100- musa.temps_plein();


		String series1 = "Pourcentage des employes a temps plein";
		String series2 = "Pourcentage des employes a temps partiel";

		String category1 = "France";
		String category2 = "Chine";
		String category3 = "Allemagne";
		String category4 = "USA";

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(nbpleinFR, series1, category1);
		dataset.addValue(nbpleinChine, series1, category2);
		dataset.addValue(nbpleinAllemagne, series1, category3);
		dataset.addValue(nbpleinusa, series1, category4);

		dataset.addValue(nbpartielFR, series2, category1);
		dataset.addValue(nbpartielChine, series2, category2);
		dataset.addValue(nbpartielAllemagne, series2, category3);
		dataset.addValue(nbpartielnusa, series2, category4);


		return dataset;

	}

	private JFreeChart createChart(CategoryDataset dataset) {

		JFreeChart chart = ChartFactory.createBarChart("pourcentage employes temps plein et partiel", "Pays", "Pourcentage", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		return chart;

	}

	public JFrame AfficherPourcentageEmployeTempsPlein(){
		PourcentageEmployesTempsPlein demo = new PourcentageEmployesTempsPlein("Pourcentage des employes a temps plein et partiel");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
		return demo;
	};

	public static void main(String[] args) {

	}

}
