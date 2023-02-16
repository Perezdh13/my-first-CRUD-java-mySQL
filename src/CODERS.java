import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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



    public CODERS() {
        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    añadir();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public void lista() throws SQLException {
        conectar();
        list.setModel(mod);
        st = con.createStatement();
        r = st.executeQuery("SELECT id,name,surname FROM coders");
        mod.removeAllElements();
        while (r.next()) {
            mod.addElement(r.getString(1) + "  " + r.getString(2) + "  "+r.getString(3));
        }
    }

    public void añadir() throws SQLException {
        conectar();
        ps = con.prepareStatement("INSERT INTO coders VALUES (?,?,?,?,?,?)");
        ps.setInt(1, Integer.parseInt(idText.getText()));
        ps.setString(2, nameText.getText());
        ps.setString(3, surnameText.getText());
        ps.setString(4, emailText.getText());
        ps.setString(5, githubText.getText());
        ps.setString(6, linkedinText.getText());
        if (ps.executeUpdate() > 0) {
            list.setModel(mod);
            mod.removeAllElements();
            mod.addElement("coder añadido!!!");

            idText.setText("");
            nameText.setText("");
            surnameText.setText("");
            emailText.setText("");
            githubText.setText("");
            linkedinText.setText("");

        }
    }

    public static void main(String[] args) {
        CODERS f = new CODERS();
        f.setContentPane(new CODERS().PANEL_CODERS);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.pack();
    }

    public void conectar() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/factoriaf5", "root", "2202");
            System.out.println("conexion realizada");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
