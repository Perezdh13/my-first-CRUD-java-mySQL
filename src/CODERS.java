import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CODERS extends JFrame {
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

    Connection con;

    public CODERS() {
        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conectar();
            }
        });

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
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/factoriaf5","root","");
            System.out.println("conexion realizada");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
