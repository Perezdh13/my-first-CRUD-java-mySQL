package CBootcamp;

import javax.swing.*;
import java.sql.SQLException;

public class CBCrud extends Bootcamp{
    public void createBootcamp(JTextField name, JTextField director, JTextField province,JTextField trainers)throws SQLException {
        bootcampConect();
        ps = con.prepareCall("INSERT INTO bootcamp(name,director,trainers, province)VALUES(?,?,?,?)");

        ps.setString(1,name.getText());
        ps.setString(2,director.getText());
        ps.setString(3,trainers.getText());
        ps.setString(4,province.getText());

        if(ps.executeUpdate()>0){
            name.setText("");
            director.setText("");
            province.setText("");
            trainers.setText("");
        }
    }
    public void readBootcamp(JList list) throws SQLException{
        bootcampConect();
        list.setModel(mod);
        st = con.createStatement();
        r = st.executeQuery("SELECT id,name, director FROM bootcamp");
        mod.removeAllElements();
        while (r.next()){
            mod.addElement(r.getString(1) + " " +r.getString(2) + " " +r.getString(3));
        }
    }
    public void updateBootcamp(JTextField idBootcamp,JTextField name, JTextField director,JTextField province,JTextField trainers) throws SQLException {
        bootcampConect();
        ps = con.prepareStatement("UPDATE bootcamp SET name=?, director=?, trainers=?, province=?, WHERE id=?");
        ps.setString(1, name.getText());
        ps.setString(2, director.getText());
        ps.setString(3, trainers.getText());
        ps.setString(4, province.getText());
        ps.setInt(5, Integer.parseInt(idBootcamp.getText()));

        if (ps.executeUpdate() > 0) {
            list.setModel(mod);
            idBootcamp.setText("");
            name.setText("");
            director.setText("");
            province.setText("");
            trainers.setText("");

            JOptionPane.showMessageDialog(null, "bootcamp actualizado");
        }
    }
    public void deleteBootcamp(JTextField idBootcamp, JTextField nameBootcamp,JTextField directorBootcamp, JTextField provinceBootcamp, JTextField trainers) throws SQLException {
        bootcampConect();
        ps = con.prepareStatement("DELETE FROM bootcamp WHERE id=?");
        ps.setInt(1, Integer.parseInt(idBootcamp.getText()));

        if(ps.executeUpdate() > 0){
            list1.setModel(mod);
            mod.removeAllElements();

            idBootcamp.setText("");
            nameBootcamp.setText("");
            directorBootcamp.setText("");
            provinceBootcamp.setText("");
            trainers.setText("");
        }
    }
}
