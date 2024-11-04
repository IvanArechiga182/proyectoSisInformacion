
package loginandsignup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connection {
    String bd="smartvault_database";
    String url="jdbc:mysql://localhost:3306/";
    String user= "root";
    String password="";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx;

    public Connection conectar(){
        try {
            Class.forName(driver);
            cx=DriverManager.getConnection(url+bd, user, password);
            System.out.println("Se conecto correctamente a la base "+bd);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se conecto a la base "+ bd);
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }
    
    
    
    
    
    
    
    
    
}
