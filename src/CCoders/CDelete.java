package CCoders;

import javax.swing.*;

import java.sql.SQLException;

public class CDelete extends Coders{
    public void deleteCoder(JTextField idText,JTextField nameText,JTextField surnameText, JTextField emailText, JTextField githubText, JTextField linkedinText) throws SQLException {
        conect();
        ps = con.prepareStatement("DELETE FROM coders WHERE idcoders=?");
        ps.setInt(1, Integer.parseInt(idText.getText()));

        if (ps.executeUpdate() > 0) {
            list.setModel(mod);
            mod.removeAllElements();


            idText.setText("");
            nameText.setText("");
            surnameText.setText("");
            emailText.setText("");
            githubText.setText("");
            linkedinText.setText("");

            JOptionPane.showMessageDialog(null, "Coder eliminado");
        }
    }
}
