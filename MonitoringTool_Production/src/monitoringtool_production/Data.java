package monitoringtool_production;

import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Niels
 */
public class Data {
    
    String TableName = "product";
    String uName = "root";
    String uPass= "root";
    Connection con;
    
    public void createConnection() throws SQLException{
        this.con = DriverManager.getConnection("jdbc:mysql://localhost:8889/MonitoringTool",uName,uPass);
    }
    
    public ResultSet getTableData() throws Exception {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from " + TableName);
        
        return rs;  
    }
    
    public void updateRowToDB(String v) throws Exception{
        
        String query = " UPDATE " + TableName + " SET aantal = ? ";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString(0, v);
       
        try {
                con.setAutoCommit(false);
                preparedStmt.executeUpdate();
                con.commit();
        } 
        catch(Exception e)
        {
                System.out.println(e);
                preparedStmt.close();
        }
       // preparedStmt.executeUpdate();
    }
}
