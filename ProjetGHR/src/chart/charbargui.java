package chart;

import javax.swing.*;

public class charbargui {
    private JPanel mainPanel;
    private JPanel graphePanel;
    private JPanel textPanel;


    public charbargui() {
            Chartbar ch=new Chartbar();
            BarChartEmployesTroisExperience bc=new BarChartEmployesTroisExperience("title");

            graphePanel.add(bc.panelGrapheEmployeSalaire());
           // graphePanel.setSize(200,200);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("charbargui");
        frame.setContentPane(new charbargui().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);


        UIManager.getColor("EditorPane.inactiveBackground");
        frame.setVisible(true);
    }

}



