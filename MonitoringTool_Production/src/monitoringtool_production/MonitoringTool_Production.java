package monitoringtool_production;

import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author Niels
 */
public class MonitoringTool_Production {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        JFrame frm1 = new GUI();
        frm1.setVisible(true);
    }
    
}
