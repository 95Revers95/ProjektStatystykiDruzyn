package client;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import oracle.jdbc.OracleDriver;


public class Login extends JFrame {
    Connection conn = null;
    private JPasswordField jPasswordField1 = new JPasswordField();
    private JTextField jTextField1 = new JTextField();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JButton PrzyciskPolacz = new JButton();

    public Login() throws SQLException {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        this.setSize(new Dimension(400, 300));
        this.setTitle("Logowanie");
        jPasswordField1.setBounds(new Rectangle(205, 35, 135, 35));
        jTextField1.setBounds(new Rectangle(30, 35, 135, 35));
        jLabel1.setText("Login");
        jLabel1.setBounds(new Rectangle(75, 5, 50, 25));
        jLabel1.setFont(new Font("Times New Roman", 0, 18));
        jLabel2.setText("Password");
        jLabel2.setBounds(new Rectangle(235, 5, 100, 25));
        jLabel2.setFont(new Font("Times New Roman", 0, 18));
        PrzyciskPolacz.setText("Polacz");
        PrzyciskPolacz.setBounds(new Rectangle(90, 110, 195, 90));
        PrzyciskPolacz.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        polacz_actionPerformed(e);
                    } catch (SQLException f) {
                    }
                }
            });
        this.getContentPane().add(PrzyciskPolacz, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jTextField1, null);
        this.getContentPane().add(jPasswordField1, null);
    }

    void polacz() throws SQLException {
        String a = jTextField1.getText();
        String b = new String(jPasswordField1.getPassword());
        ConnectDB connection = new ConnectDB(a, b);
        conn = connection.connectDb();
    }

    private void polacz_actionPerformed(ActionEvent e) throws SQLException {
        try
        {
            polacz();
            JOptionPane.showMessageDialog(this, "Zalogowano pomyślnie");
            JFrame frame3 = new Rozgrywki(conn);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setLocationRelativeTo(null);
        frame3.setVisible(true);
        this.setVisible(false);
        }
        catch(SQLException ef){
            JOptionPane.showMessageDialog(this, "Zły login lub haslo");
            //System.exit(0);
        }
        
        
        
        

    }
}
