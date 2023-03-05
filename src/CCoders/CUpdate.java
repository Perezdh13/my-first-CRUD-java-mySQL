package CCoders;

import javax.swing.*;
import java.sql.SQLException;

public class CUpdate extends Coders{
    public void updateCoder(JTextField nameText,JTextField surnameText, JTextField emailText, JTextField githubText, JTextField linkedinText,JTextField bootcampText,JTextField idText) throws SQLException {
        conect();
        ps = con.prepareStatement("UPDATE coders SET name=?, surname=?, email=?, github=?, linkedin=?,bootcamp=? WHERE id=?");
        ps.setString(1, nameText.getText());
        ps.setString(2, surnameText.getText());
        ps.setString(3, emailText.getText());
        ps.setString(4, githubText.getText());
        ps.setString(5, linkedinText.getText());
        ps.setString(6,bootcampText.getText());
        ps.setInt(7, Integer.parseInt(idText.getText()));

        if (ps.executeUpdate() > 0) {
            list.setModel(mod);
            mod.removeAllElements();


            idText.setText("");
            nameText.setText("");
            surnameText.setText("");
            emailText.setText("");
            githubText.setText("");
            linkedinText.setText("");

            JOptionPane.showMessageDialog(null, "Coder actualizado");
        }
    }
}
