package chart;

import java.awt.Dimension;

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

public class BarChartEmployesRetraite extends ApplicationFrame {

	private static final long serialVersionUID = 1L;


	public BarChartEmployesRetraite(String title) {

		super(title);
		CategoryDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(500, 270));
		setContentPane(chartPanel);

	}



	private CategoryDataset createDataset() {

		 MainFrance frretraite=new MainFrance();
		 int nbretraiteFR=frretraite.retraite_2030();


		MainChine mChine=new MainChine();
		int nbretraiteChine=mChine.getNbEmployesRetraiteChine();

		MainAllemagne mAllemagne=new MainAllemagne();
		int nbretraiteAllemagne=mAllemagne.nombre_employer_qui_parttent_en_retraite_en(2030);

		MainUSA musa=new MainUSA();
		int nbretraiteUSA=musa.retraire_2030();

		String series1 = "nb employées qui parte en retraite";
	//	String series2 = "Second";
	//	String series3 = "Third";

		String category1 = "Allemagne";
		String category2 = "France";
		String category3 = "Chine";
		String category4 = "USA";


		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(nbretraiteAllemagne, series1, category1);
		dataset.addValue(nbretraiteFR, series1, category2);
		dataset.addValue(nbretraiteChine, series1, category3);
		dataset.addValue(3, series1, category4);
;

		return dataset;

	}

	private JFreeChart createChart(CategoryDataset dataset) {

		JFreeChart chart = ChartFactory.createBarChart("Employés qui partent en retraite en 2030", "Category", "Nb emloyés", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		return chart;

	}

	public JFrame panelGrapheEmployeRetraite(){
		BarChartEmployesRetraite demo = new BarChartEmployesRetraite("Bar Chart Demo");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		return demo;
	}


	public static void main(String[] args) {

		BarChartEmployesRetraite demo = new BarChartEmployesRetraite("Bar Chart Demo");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}

}
