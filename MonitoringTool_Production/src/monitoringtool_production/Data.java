package monitoringtool_production;

import java.awt.Color;
import java.awt.Image;
import static java.lang.System.currentTimeMillis;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
    Random rnd = new Random();
    
    public void createConnection() throws SQLException{
        switch(connectionFlag){
            case "N":   this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/monitoringtool",uName,uPassN);
                        break;
            case "F":   this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/monitoringtool",uName,uPass);
                        break;
        }
    }
    
//    public ResultSet getTableData(String PId) throws Exception {
//        Statement stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery("select * from " + TableName + " WHERE PId = " + PId);
//        return rs;  
//    }
    
    public boolean updateRowToDB(String newAmount, String PId) throws Exception{
        //update the total amount of items of one product_type
        String query = " UPDATE product_types SET Amount = ? WHERE PId = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString(1, newAmount);
        preparedStmt.setString(2, PId);
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
    }
    
    public boolean updateLastUpdateDateToDB(String TimeUnix) throws Exception{
        //update the last modification date of the database in database_changed
        String query = " UPDATE database_changed SET Time_Unix = ? WHERE Id = 1";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString(1, TimeUnix);
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
    }
    
    public List<ProductType> getProductTypes() throws Exception {
        //get all product_types and return in an ArrayList
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from product_types");
        List<ProductType> productTypeArrayList = new ArrayList<ProductType>();
                    while(rs.next()){
                        ProductType productType = new ProductType();
                        productType.pId = rs.getInt("PId");
                        productType.name = rs.getString("Name");
                        productType.amount = rs.getInt("Amount");
                        productTypeArrayList.add(productType);
            }
        return productTypeArrayList;
    }     
    
    public ProductType getProduct(String name)throws Exception{
        //get full product_type information, search with the name/description property
        ProductType productType = new ProductType();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from product_types");
                    while(rs.next()){
                        if (rs.getString("Name").equals(name)) {
                            productType.pId = rs.getInt("PId");
                            productType.name = rs.getString("Name");
                            productType.amount = rs.getInt("Amount");
                        }
            }
        return productType;
    }
    
    public String generateSerialNumber(ProductType productType){
        //generate a unique serial number out of: PId + Unix Time + random number between 0-1.000.000
        String serialNumber = "";
        serialNumber = String.valueOf(productType.pId);
        serialNumber += String.valueOf(currentTimeMillis() / 1000);
        serialNumber += String.valueOf(rnd.nextInt(1000000));
        return serialNumber;
    }
    
    public boolean insertNewProduction(Product product) throws SQLException{
        //insert a new product of an existing product_type with unique serial number, creation time in Unix Time and 3 optional properties
        long TimeUnixLong = currentTimeMillis() / 1000;
        String TimeUnix = String.valueOf(TimeUnixLong);
        String query = " INSERT INTO product_detail (PId,Serial_Number,Time_Unix,Property_1,Property_2,Property_3) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString(1, String.valueOf(product.pId));
        preparedStmt.setString(2, product.serialNumber);
        preparedStmt.setString(3, TimeUnix);
        preparedStmt.setString(4, product.property1);
        preparedStmt.setString(5, product.property2);
        preparedStmt.setString(6, product.property3);
       
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
    }
    
    
    
}
