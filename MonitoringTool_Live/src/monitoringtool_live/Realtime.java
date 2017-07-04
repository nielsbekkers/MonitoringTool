package monitoringtool_live;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Niels
 */
public class Realtime {
    
    String TableName = "product_types";
    String uName = "root";
    String uPass= "";
    String uPassN = "root";
    Connection con;
    String connectionFlag = "F";
    
    public void createConnection() throws SQLException{
        switch(connectionFlag){
            case "N":   this.con = DriverManager.getConnection("jdbc:mysql://localhost:8889/monitoringtool",uName,uPassN);
                        break;
            case "F":   this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/monitoringtool",uName,uPass);
                        break;
        }
    }
    
    public ResultSet getRealtimeData() throws Exception {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from " + TableName);
        return rs;  
    }
    
}
