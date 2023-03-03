package CCoders;
import javax.swing.*;
import java.sql.SQLException;
public class CRead extends Coders {
    public void readCoders(JList list) throws SQLException {
        conect();
        list.setModel(mod);
        st = con.createStatement();
        r = st.executeQuery("SELECT idcoders,name,surname FROM coders");
        mod.removeAllElements();
        while (r.next()) {
            mod.addElement(r.getString(1) + "  " + r.getString(2) + "  "+r.getString(3));
        }
    }
}
