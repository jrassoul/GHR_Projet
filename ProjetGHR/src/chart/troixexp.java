package chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class troixexp extends JFrame{
    private JPanel jchart;
    private JPanel panelRequette;
    private JPanel mainPanel;
    private JTextPane calculetext;


        public troixexp() {
            initUI();

        }

        private void initUI() {

            CategoryDataset dataset = createDataset();

            JPanel paneltt=new JPanel();

            JFreeChart chart = createChart(dataset);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            chartPanel.setBackground(Color.white);


            JPanel panel=new JPanel();
            JButton button=new JButton("bouttonnnn");
          //  panel.setSize(200,200);


           paneltt.add(button);
           paneltt.add(chartPanel);

            setContentPane(paneltt);
            //chartPanel.setSize(200,200);
            pack();
            setTitle("Bar chart");
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            chartPanel.setVisible(true);
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
                    false, true, false);

            return barChart;
        }


    public static void main(String[] args) {

        JFrame frame=new JFrame("troixexp");
        frame.setContentPane(new troixexp().panelRequette);
        //frame.setContentPane(new troixexp("title").jchart);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500,400);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        try {
            UIManager.setLookAndFeel( new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        UIManager.put("Synthetica.window.opaque", false);
        UIManager.put("Synthetica.window.shape", "");
    }

}
