package chart;

import ghrAllemagne.MainAllemagne;
import ghrChine.MainChine;
import ghrFrance.MainFrance;
import ghrUSA.MainUSA;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;

public class Piemazalmazal extends ApplicationFrame {

	private static final long serialVersionUID = 1L;

	public Piemazalmazal(String title) {
		super(title);
		setContentPane(createDemoPanel());
	}

	private PieDataset createDataset() {

		MainFrance mfr=new MainFrance();
		double nbretraiteFR=mfr.emp_etrangers();


		MainChine mChine=new MainChine();
		double nbretraiteChine=mChine.poucentage_des_employes_etrange() ;

		MainAllemagne mAllemagne=new MainAllemagne();
		double nbretraiteAllemagne=mAllemagne.poucentage_des_employes_etrange();

		MainUSA musa=new MainUSA();
		double nbretraiteUSA=musa.variation_personnel();


		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("One", new Double(43.2));
		dataset.setValue("Two", new Double(10.0));
		dataset.setValue("Three", new Double(27.5));
		dataset.setValue("Four", new Double(17.5));
		return dataset;
	}

	private JFreeChart createChart(PieDataset dataset) {
		return ChartFactory.createPieChart("Pie Chart Demo 1", dataset, true, true, false);
	}

	public JPanel createDemoPanel() {
		JFreeChart chart = createChart(createDataset());
		return new ChartPanel(chart);
	}



	public static void main(String[] args) {
		Piemazalmazal demo = new Piemazalmazal("Pie Chart Demo");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}

}