package monitoringtool_live;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.MeterInterval;
import org.jfree.chart.plot.MeterPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.Range;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
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
    private static DefaultValueDataset datasetMeterPlot;
    ChartPanel chartPanel;
    JButton button;
    String aantal;
    String name;
    int id; 

    public MonitoringTool_Live(final String title) throws SQLException {

        super(title);
        JPanel mainPanel = new JPanel();
        mainPanel.add(chartContentPanel(), BorderLayout.WEST);
        mainPanel.add(MeterContentPanel(), BorderLayout.EAST);
        setContentPane(mainPanel);

    }
    
    private JPanel chartContentPanel() throws SQLException{
        RealtimeData = new Realtime();
        RealtimeData.createConnection();
        this.series = new TimeSeries("Realtime Data", Millisecond.class);
        final TimeSeriesCollection dataset = new TimeSeriesCollection(this.series);
        final JFreeChart chart = createXYChart(dataset);

        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(900, 570));
        button = new JButton("Start Live Weergave");
        button.setActionCommand("START");
        button.addActionListener(this);
        
        JPanel content = new JPanel(new BorderLayout());
        content.add(chartPanel);
        content.add(button, BorderLayout.SOUTH);
        return content;
    }
    
    private JPanel MeterContentPanel(){
        datasetMeterPlot = new DefaultValueDataset(50.0);
        JFreeChart chart = createMeterPlot(datasetMeterPlot);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new java.awt.Dimension(300, 1000));
        panel.add(new ChartPanel(chart));
        return panel;
    }
    
    private JFreeChart createMeterPlot(ValueDataset dataset) {
        MeterPlot plot = new MeterPlot(dataset);
        plot.addInterval(new MeterInterval("High", new Range(80.0, 100.0)));
        plot.setDialOutlinePaint(Color.white);
        JFreeChart chart = new JFreeChart("Live Data", 
                JFreeChart.DEFAULT_TITLE_FONT, plot, false);
        return chart;
    }

    private JFreeChart createXYChart(final XYDataset dataset) {
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
        axis.setRange(0.0, 1000.0); 
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
                                    id = rs.getInt("PId");
                                    name = rs.getString("Name");
                                    aantal = rs.getString("Amount");
                                    lastValue = Double.parseDouble(aantal);
                                }
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                            final Millisecond now = new Millisecond();
                            System.out.println("Now = " + now.toString());
                            series.add(new Millisecond(), lastValue);
                            datasetMeterPlot.setValue(lastValue);
                        }
                    }
            }
        };
        if(thread.isAlive()){
            System.out.println("Thread memory leak waarschuwing!");
        }else{
            thread.start();
        }  
    }

    public static void main(final String[] args) throws SQLException {

        final MonitoringTool_Live live = new MonitoringTool_Live("Monitoring Tool Live");
        live.pack();
        RefineryUtilities.centerFrameOnScreen(live);
        live.setExtendedState(JFrame.MAXIMIZED_BOTH);   //FULL SCREEN 
        live.setVisible(true);
    }   
}
