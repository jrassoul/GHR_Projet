package chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.Color;
import java.awt.EventQueue;

public class Chartbar extends JFrame {

        public Chartbar() {
            initUI();
        }

        private void initUI() {


            CategoryDataset dataset = createDataset();

            JPanel Paneltotal=new JPanel();
            Paneltotal.setSize(400,400);
            JFreeChart chart = createChart(dataset);
            ChartPanel chartPanel = new ChartPanel(chart);
            //chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            chartPanel.setBounds(50, 80, 100, 100);
            chartPanel.setBackground(Color.white);

            JPanel panel=new JPanel();

            JButton button=new JButton("bouttonnnn");
            JTextArea j=new JTextArea("dddddddddddddddd" +
                    "sdfqsdf" +
                    "qsdfqsdfsdfqsdfqsd" +
                    "fqsdfqsdfqsdfsqdfhjqsdflkqsjdflkj");


            Paneltotal.add(j);
            Paneltotal.add(chartPanel);

            setContentPane(Paneltotal);

            pack();
            setTitle("Bar chart");
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        private CategoryDataset createDataset() {

            var dataset = new DefaultCategoryDataset();
            dataset.setValue(46, "Gold medals", "USA");
            dataset.setValue(38, "Gold medals", "Chine");
            dataset.setValue(29, "Gold medals", "Allemagne");
            dataset.setValue(22, "Gold medals", "France");


            return dataset;
        }



        private JFreeChart createChart(CategoryDataset dataset) {

            JFreeChart barChart = ChartFactory.createBarChart(
                    "Olympic gold medals in London",
                    "",
                    "Gold medals",
                    dataset,
                    PlotOrientation.VERTICAL,
                    true, true, false);

            return barChart;
        }

        public JFrame charBarFrame(){
            Chartbar ex = new Chartbar();
        //    ex.setSize(700,500);
            ex.setVisible(true);
            return ex;
        }


        public static void main(String[] args) {

            Chartbar ex = new Chartbar();
//            ex.setSize(1000,700);

            ex.setVisible(true);
        }
}
