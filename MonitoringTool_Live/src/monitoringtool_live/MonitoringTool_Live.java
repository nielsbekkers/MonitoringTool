package monitoringtool_live;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Niels
 */
public class MonitoringTool_Live extends ApplicationFrame implements ActionListener{

    private TimeSeries series;
    private double lastValue = 100.0;
    boolean start = true;
    Realtime RealtimeData;
    XYSeriesCollection dataset;
    ChartPanel chartPanel;
    String aantal;
    String name;
    int id; 

    public MonitoringTool_Live(final String title) throws SQLException {

        super(title);
        RealtimeData = new Realtime();
        RealtimeData.createConnection();
        this.series = new TimeSeries("Realtime Data", Millisecond.class);
        final TimeSeriesCollection dataset = new TimeSeriesCollection(this.series);
        final JFreeChart chart = createChart(dataset);

        final ChartPanel chartPanel = new ChartPanel(chart);
        final JButton button = new JButton("Start Live Weergave");
        button.setActionCommand("START");
        button.addActionListener(this);

        final JPanel content = new JPanel(new BorderLayout());
        content.add(chartPanel);
        content.add(button, BorderLayout.SOUTH);
        chartPanel.setPreferredSize(new java.awt.Dimension(900, 570));
        setContentPane(content);

    }

    private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart(
            "Realtime Data", 
            "Tijd", 
            "Aantal",
            dataset, 
            true, 
            true, 
            false
        );
        final XYPlot plot = result.getXYPlot();
        plot.getRenderer().setSeriesPaint(0, Color.BLUE);
        plot.setBackgroundPaint(Color.lightGray);
        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(120000.0);  // 120 seconden
        axis = plot.getRangeAxis();
        axis.setRange(0.0, 200.0); 
        return result;
    }
    
    public void actionPerformed(final ActionEvent e) {
        Thread thread = new Thread(){
            public void run(){
                    while (start = true){
                        if (e.getActionCommand().equals("START")) {
                            try {
                                Thread.sleep(1000);
                                ResultSet rs = RealtimeData.getRealtimeData();
                                while(rs.next()){
                                    id = rs.getInt("id");
                                    name = rs.getString("productnaam");
                                    aantal = rs.getString("aantal");
                                    lastValue = Double.parseDouble(aantal);
                                }
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                            final Millisecond now = new Millisecond();
                            System.out.println("Now = " + now.toString());
                            series.add(new Millisecond(), lastValue);
                        }
                    }
            }
        };
        thread.start();
    }

    public static void main(final String[] args) throws SQLException {

        final MonitoringTool_Live live = new MonitoringTool_Live("Monitoring Tool Live");
        live.pack();
        RefineryUtilities.centerFrameOnScreen(live);
        live.setVisible(true);

    }
    
}
