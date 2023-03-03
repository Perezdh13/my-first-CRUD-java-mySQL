package CBootcamp;

import javax.swing.*;
import java.sql.SQLException;

public class CBCrud extends Bootcamp{
    public void createBootcamp(JTextField name, JTextField director, JTextField province, JTextField coders, JTextField trainers)throws SQLException {
        bootcampConect();
        ps = con.prepareCall("INSERT INTO bootcamp(name,director,idtrainers, provincia,idcoders)VALUES(?,?,?,?,?)");

        ps.setString(1,name.getText());
        ps.setString(2,director.getText());
        ps.setString(3,trainers.getText());
        ps.setString(4,province.getText());
        ps.setString(5,coders.getText());

        if(ps.executeUpdate()>0){
            name.setText("");
            director.setText("");
            province.setText("");
            coders.setText("");
            trainers.setText("");
        }
    }
    public void readBootcamp(JList list) throws SQLException{
        bootcampConect();
        list.setModel(mod);
        st = con.createStatement();
        r = st.executeQuery("SELECT idbootcamp,name, director FROM bootcamp");
        mod.removeAllElements();
        while (r.next()){
            mod.addElement(r.getString(1) + " " +r.getString(2) + " " +r.getString(3));
        }
    }
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
