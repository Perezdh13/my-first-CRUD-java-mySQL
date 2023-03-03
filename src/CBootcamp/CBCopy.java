package CBootcamp;

import javax.swing.*;
import java.sql.SQLException;

public class CBCopy extends Bootcamp{
    public void copyBootcamps(int id, JTextField idBootcamp, JTextField nameBootcamp, JTextField directorBootcamp, JTextField provinceBootcamp, JTextField trainers, JTextField coders){
        try {
            bootcampConect();
            ps = con.prepareStatement("SELECT * FROM bootcamp WHERE idbootcamp=?");
            ps.setInt(1, id);
            r = ps.executeQuery();

            if (r.next()) {
                idBootcamp.setText(String.valueOf(r.getInt("idbootcamp")));
                nameBootcamp.setText(r.getString("name"));
                directorBootcamp.setText(r.getString("director"));
                provinceBootcamp.setText(r.getString("provincia"));
                trainers.setText(r.getString("idtrainers"));
                coders.setText(r.getString("idcoders"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
