package chart;

import com.sun.source.tree.ReturnTree;
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

public class PiepoucentageEmployesetrange extends ApplicationFrame {


	private JButton retourButton;

	private static final long serialVersionUID = 1L;

	public PiepoucentageEmployesetrange(String title) {

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
		JTextArea listeExplication=new JTextArea( "•  Utilisation de deux variables  qui récupèrent dans l’ordre : le ombre d’employés qui\n" +
											    	"  ne sont pas de nationalité Américaine, et une autre qui récupère le nombre total des\n" +
												    "  employés.\n\n" +
													"•Le pourcentage est calculé en fonction de ces deux valeurs pourcentage_variation \n" +
													"= nombre_employé _trangère/nombre_total_employes \n\n" +
													"•  Il s’agit de compter le nombre d’employés dans la table Employe qui vérifie la \n" +
														"condition( !=Américaine ) dans la colonne nationalité_employé.		");

		listeExplication.setCaret(new javax.swing.text.DefaultCaret() {
			public void paint(Graphics g) {
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
		double nbretraiteFR=frretraite.emp_etrangers();

		MainChine mChine=new MainChine();
		double nbretraiteChine=mChine.poucentage_des_employes_etrange() ;

		MainAllemagne mAllemagne=new MainAllemagne();
		double nbretraiteAllemagne=mAllemagne.poucentage_des_employes_etrange();

		MainUSA musa=new MainUSA();
		double nbretraiteUSA=musa.variation_personnel();

		String series1 = "pourcentage / pays";
		String series2 = "Second";
	//	String series3 = "Third";


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

		JFreeChart chart = ChartFactory.createBarChart("pourcentage de variation dans les sous entreprise\n", "Pays", "pourcentage du Nb emloyés étragés", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		return chart;

	}

	public JFrame panelGrapheEmployeSalaire(){
		PiepoucentageEmployesetrange demo = new PiepoucentageEmployesetrange("Bar Chart Demo");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);


		return demo;
	}

	public JFrame AffichageEmloyesDiversiteEntreprise(){

		PiepoucentageEmployesetrange demo = new PiepoucentageEmployesetrange("Bar Chart Demo");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);

		demo.setVisible(true);

		return demo;
	};


	public static void main(String[] args) {
	}

}
