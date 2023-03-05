package CCoders;
import javax.swing.*;
import java.sql.*;

public class CCreate extends Coders{
    public void createCoder(JTextField nameText,JTextField surnameText, JTextField emailText, JTextField githubText, JTextField linkedinText,JTextField bootcampText) throws SQLException {
        conect();
        ps = con.prepareCall("INSERT INTO coders (name,surname, email, github, linkedin,bootcamp) VALUES (?,?,?,?,?,?)");


        ps.setString(1, nameText.getText());
        ps.setString(2, surnameText.getText());
        ps.setString(3, emailText.getText());
        ps.setString(4, githubText.getText());
        ps.setString(5, linkedinText.getText());
        ps.setString(6,bootcampText.getText());


        if (ps.executeUpdate()> 0) {
            nameText.setText("");
            surnameText.setText("");
            emailText.setText("");
            githubText.setText("");
            linkedinText.setText("");
            bootcampText.setText("");
            JOptionPane.showMessageDialog(null, "Coder añadido");
        }

    }


}
