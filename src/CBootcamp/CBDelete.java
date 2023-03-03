package CBootcamp;

import javax.swing.*;
import java.sql.SQLException;

public class CBDelete extends Bootcamp{
    public void deleteBootcamp(JTextField idBootcamp, JTextField nameBootcamp,JTextField directorBootcamp, JTextField provinceBootcamp, JTextField coders, JTextField trainers) throws SQLException {
        bootcampConect();
       ps = con.prepareStatement("DELETE FROM bootcamp WHERE idbootcamp=?");
       ps.setInt(1, Integer.parseInt(idBootcamp.getText()));

       if(ps.executeUpdate() > 0){
           list1.setModel(mod);
           mod.removeAllElements();

           idBootcamp.setText("");
           nameBootcamp.setText("");
           directorBootcamp.setText("");
           provinceBootcamp.setText("");
           coders.setText("");
           trainers.setText("");
       }


    }
}
