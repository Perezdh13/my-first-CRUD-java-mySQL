package CBootcamp;
import CCoders.Coders;
import Conection.ConnectionDB;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Bootcamp extends Coders {
    Connection con;
    PreparedStatement ps;
    Statement st;
    ResultSet r;

    DefaultListModel mod = new DefaultListModel<>();
    public JPanel PANEL_BOOTCAMP;
    public JList list1;
    public JButton readButton;
    public JTextField idBootcamp;
    public JTextField nameBootcamp;
    public JTextField directorBootcamp;
    public JTextField provinceBootcamp;
    public JTextField coders;
    public JTextField trainers;
    public JLabel Bootcamp_panel;
    public JButton upDateButton;
    public JButton createButton;
    public JButton deleteButton;
public Bootcamp() {
    createButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                CBCrud create = new CBCrud();
                create.createBootcamp(nameBootcamp,directorBootcamp,provinceBootcamp, coders, trainers);
                create.readBootcamp(list1);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    });
    readButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                CBCrud read = new CBCrud();
                read.readBootcamp(list1);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    });
    upDateButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                CBCrud update = new CBCrud();
                update.updateBootcamp(idBootcamp,nameBootcamp,directorBootcamp,provinceBootcamp, coders, trainers);
                update.readBootcamp(list1);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    });
    deleteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                CBCrud delete = new CBCrud();
                delete.deleteBootcamp(idBootcamp,nameBootcamp,directorBootcamp,provinceBootcamp, coders, trainers);
                delete.readBootcamp(list1);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    });

    list1.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(list1.getSelectedIndex() != -1){
                String selectedText = (String) list1.getSelectedValue();
                String[] splitText = selectedText.split("\\s+");
                int id = Integer.parseInt(splitText[0]);
                CBCopy copy = new CBCopy();
                copy.copyBootcamps(id, idBootcamp, nameBootcamp,directorBootcamp,provinceBootcamp,trainers,coders);
            }
        }
    });
}
    public void bootcampConect() {
        ConnectionDB conexionDB = new ConnectionDB();
        con = conexionDB.conectar();
    }
}
