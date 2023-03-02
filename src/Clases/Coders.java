package Clases;
import Conection.ConnectionDB;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.sql.*;
public class Coders extends JFrame{
    Connection con;
    PreparedStatement ps;
    Statement st;
    ResultSet r;
    DefaultListModel mod = new DefaultListModel<>();
    public JPanel PANEL_CODERS;
    public JTextField nameText;
    public JTextField githubText;
    public JTextField emailText;
    public JTextField idText;
    public JTextField surnameText;
    public JButton addButton;
    public JButton getButton;
    public JList list;
    public JTextField linkedinText;
    public JButton deleteButton;
    public JButton updateButton;

    public Coders() {

        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CRead read = new CRead();
                    read.readCoders(list);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CCreate create = new CCreate();
                    create.createCoder(nameText, surnameText, emailText, githubText, linkedinText);
                    CRead read = new CRead();
                    read.readCoders(list);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CUpdate update = new CUpdate();
                    update.updateCoder(nameText, surnameText, emailText, githubText, linkedinText, idText);
                    CRead read = new CRead();
                    read.readCoders(list);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CDelete delete = new CDelete();
                    delete.deleteCoder(idText, nameText, surnameText, emailText, githubText, linkedinText);
                    CRead read = new CRead();
                    read.readCoders(list);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (list.getSelectedIndex() != -1) {
                    String selectedText = (String) list.getSelectedValue();
                    String[] splitText = selectedText.split("\\s+");
                    int id = Integer.parseInt(splitText[0]);
                    CCopy copy = new CCopy();
                    copy.copyCoders(id, idText, nameText, surnameText, emailText, githubText, linkedinText);

                }
            }
        });
    }
    public void conect() {
        ConnectionDB conexionBD = new ConnectionDB();
        con = conexionBD.conectar();
    }
}
