package Conection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionMySQL {
  Connection con ;
    public  Connection ConectionMySQL() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/factoriaf5","root","2202");
            System.out.println("conexion realizada");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
}



