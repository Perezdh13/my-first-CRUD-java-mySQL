package CBootcamp;

import javax.swing.*;
import java.sql.SQLException;

public class CBCopy extends Bootcamp{
    public void copyBootcamps(int id, JTextField idBootcamp, JTextField nameBootcamp, JTextField directorBootcamp, JTextField provinceBootcamp, JTextField trainers){
        try {
            bootcampConect();
            ps = con.prepareStatement("SELECT * FROM bootcamp WHERE id=?");
            ps.setInt(1, id);
            r = ps.executeQuery();

            if (r.next()) {
                idBootcamp.setText(String.valueOf(r.getInt("id")));
                nameBootcamp.setText(r.getString("name"));
                directorBootcamp.setText(r.getString("director"));
                provinceBootcamp.setText(r.getString("province"));
                trainers.setText(r.getString("trainers"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
