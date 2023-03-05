package CCoders;

import javax.swing.*;
import java.sql.SQLException;

public class CCopy extends Coders{
    public void copyCoders ( int id, JTextField idText, JTextField nameText, JTextField surnameText, JTextField emailText, JTextField githubText, JTextField linkedinText,JTextField bootcampText) {
        try {
            conect();
            ps = con.prepareStatement("SELECT * FROM coders WHERE id=?");
            ps.setInt(1, id);
            r = ps.executeQuery();

            if (r.next()) {
                idText.setText(String.valueOf(r.getInt("id")));
                nameText.setText(r.getString("name"));
                surnameText.setText(r.getString("surname"));
                emailText.setText(r.getString("email"));
                githubText.setText(r.getString("github"));
                linkedinText.setText(r.getString("linkedin"));
                bootcampText.setText((r.getString("bootcamp")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
