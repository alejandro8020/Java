
package Model.dao;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author Alejandro
 */

public class JDBCUtilities {
    
    private final String base = "proyectosconstruccion";
    private final String user = "root";
    private final String password = "1234567890";
    private final String url = "jdbc:mariadb://localhost:3306/"+base;
    private Connection con = null;

    public Connection getConexion(){
    try{
        Class.forName("org.mariadb.jdbc.Driver");
        con = DriverManager.getConnection(this.url, this.user, this.password);
    }catch (SQLException | ClassNotFoundException e){
        System.err.println(e);
    }
    return con;
       
    }
}
