package CBootcamp;
import javax.swing.*;
import java.sql.SQLException;

public class CBRead extends Bootcamp{
    public void readBootcamp(JList list) throws SQLException{
        bootcampConect();
        list.setModel(mod);
        st = con.createStatement();
        r = st.executeQuery("SELECT idbootcamp,name, director FROM bootcamp");
        mod.removeAllElements();
        while (r.next()){
            mod.addElement(r.getString(1) + " " +r.getString(2) + " " +r.getString(3));
        }
    }
}
