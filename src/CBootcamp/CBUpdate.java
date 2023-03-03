package CBootcamp;

import javax.swing.*;
import java.sql.SQLException;

public class CBUpdate extends Bootcamp{
    public void updateBootcamp(JTextField idBootcamp,JTextField name, JTextField director,JTextField province,JTextField coders,JTextField trainers) throws SQLException {
        bootcampConect();
        ps = con.prepareStatement("UPDATE bootcamp SET name=?, director=?, idtrainers=?, provincia=?, idcoders=? WHERE idbootcamp=?");
        ps.setString(1, name.getText());
        ps.setString(2, director.getText());
        ps.setString(3, trainers.getText());
        ps.setString(4, province.getText());
        ps.setString(5, coders.getText());
        ps.setInt(6, Integer.parseInt(idBootcamp.getText()));

        if (ps.executeUpdate() > 0) {
            list.setModel(mod);
                idBootcamp.setText("");
                name.setText("");
                director.setText("");
                province.setText("");
                coders.setText("");
                trainers.setText("");

            JOptionPane.showMessageDialog(null, "bootcamp actualizado");
        }
    }
}
