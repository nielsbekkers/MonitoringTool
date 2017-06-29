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
    
    String TableName = "product_types";
    String uName = "root";
    String uPass= "";
    String uPassN = "root";
    Connection con;
    String connectionFlag = "F";
    
    public void createConnection() throws SQLException{
        switch(connectionFlag){
            case "N":   this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/monitoringtool",uName,uPassN);
                        break;
            case "F":   this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/monitoringtool",uName,uPass);
                        break;
        }
    }
    
    public ResultSet getTableData(String PId) throws Exception {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from " + TableName + " WHERE PId = " + PId);
        return rs;  
    }
    
    public boolean updateRowToDB(String v, String PId) throws Exception{
        
        String query = " UPDATE " + TableName + " SET Amount = ? WHERE PId = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString(2, PId);
        preparedStmt.setString(1, v);
       
        try {
                con.setAutoCommit(false);
                preparedStmt.executeUpdate();
                con.commit();
                return true;
        } 
        catch(Exception e)
        {
                System.out.println(e);
                preparedStmt.close();
                return false;
        }
       // preparedStmt.executeUpdate();
    }
}
