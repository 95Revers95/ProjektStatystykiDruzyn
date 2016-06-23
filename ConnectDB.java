package client;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectDB {
    String a;
    String b;
    ConnectDB(String ab, String bb) {
        a = ab;
        b = bb;
    }
    
    public Connection connectDb() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con;           
            con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORA2015",a,b);    //"GR5_eloelomno", "abc123"        
             return con; 
            
        } catch (ClassNotFoundException e){
               JOptionPane.showMessageDialog(null, e);
        }
        
        return null;
    }
}