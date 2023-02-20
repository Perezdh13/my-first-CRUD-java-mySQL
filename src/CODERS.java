import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.sql.*;


public class CODERS extends JFrame {
    Connection con;
    PreparedStatement ps;
    Statement st;
    ResultSet r;
    DefaultListModel mod = new DefaultListModel<>();
    private JPanel PANEL_CODERS;
    private JTextField nameText;
    private JTextField githubText;
    private JTextField emailText;
    private JTextField idText;
    private JTextField surnameText;
    private JButton addButton;
    private JButton getButton;
    private JList list;
    private JTextField linkedinText;
    private JButton deleteButton;
    private JButton updateButton;


    public CODERS() {
        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    readCoders();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    createCoder();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateCoder();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteCoder();
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
                    copyCoders(id);
                }
            }
        });
    }
    public void copyCoders (int id) {
                try {
                    conect();
                    ps = con.prepareStatement("SELECT * FROM coders WHERE idcoders=?");
                    ps.setInt(1, id);
                    r = ps.executeQuery();

                    if (r.next()) {
                        idText.setText(String.valueOf(r.getInt("idcoders")));
                        nameText.setText(r.getString("name"));
                        surnameText.setText(r.getString("surname"));
                        emailText.setText(r.getString("email"));
                        githubText.setText(r.getString("github"));
                        linkedinText.setText(r.getString("linkedin"));
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            public void createCoder() throws SQLException {
        conect();
        ps = con.prepareStatement("INSERT INTO coders (name,surname, email, github, linkedin) VALUES (?,?,?,?,?)");

        ps.setString(1, nameText.getText());
        ps.setString(2, surnameText.getText());
        ps.setString(3, emailText.getText());
        ps.setString(4, githubText.getText());
        ps.setString(5, linkedinText.getText());
        if (ps.executeUpdate() > 0) {
            list.setModel(mod);
            mod.removeAllElements();


            idText.setText("");
            nameText.setText("");
            surnameText.setText("");
            emailText.setText("");
            githubText.setText("");
            linkedinText.setText("");
            JOptionPane.showMessageDialog(null, "Coder añadido");
        }
    }
    public void readCoders() throws SQLException {
        conect();
        list.setModel(mod);
        st = con.createStatement();
        r = st.executeQuery("SELECT idcoders,name,surname FROM coders");
        mod.removeAllElements();
        while (r.next()) {
            mod.addElement(r.getString(1) + "  " + r.getString(2) + "  "+r.getString(3));
        }
    }

    public void updateCoder() throws SQLException {
        conect();
        ps = con.prepareStatement("UPDATE coders SET name=?, surname=?, email=?, github=?, linkedin=? WHERE idcoders=?");
        ps.setString(1, nameText.getText());
        ps.setString(2, surnameText.getText());
        ps.setString(3, emailText.getText());
        ps.setString(4, githubText.getText());
        ps.setString(5, linkedinText.getText());
        ps.setInt(6, Integer.parseInt(idText.getText()));

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

    public void deleteCoder() throws SQLException {
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

    public static void main(String[] args){
        CODERS f = new CODERS();
        f.setContentPane(new CODERS().PANEL_CODERS);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.pack();

    }

    public void conect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/factoriaf5", "root", "2202");
            System.out.println("conexion realizada");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
