package CBootcamp;
import javax.swing.*;
import java.sql.SQLException;

public class CBCreate extends Bootcamp{
    public void createBootcamp(JTextField name, JTextField director, JTextField province,JTextField coders, JTextField trainers)throws SQLException{
        bootcampConect();
        ps = con.prepareCall("INSERT INTO bootcamp(name,director,idtrainers, provincia,idcoders)VALUES(?,?,?,?,?)");

        ps.setString(1,name.getText());
        ps.setString(2,director.getText());
        ps.setString(3,trainers.getText());
        ps.setString(4,province.getText());
        ps.setString(5,coders.getText());

        if(ps.executeUpdate()>0){
            name.setText("");
            director.setText("");
            province.setText("");
            coders.setText("");
            trainers.setText("");
        }
    }
}
