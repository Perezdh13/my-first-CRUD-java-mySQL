package Conection;
import java.sql.Connection;



public class ConnectionDB  {
    ConectionMySQL conectionMySQL = new ConectionMySQL();
    Connection con;
    public Connection conectar() {
       con = conectionMySQL.ConectionMySQL();
        return con;
    }
}