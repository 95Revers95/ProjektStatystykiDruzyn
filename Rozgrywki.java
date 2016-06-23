package client;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Rozgrywki extends JFrame {
    private Connection conn;
    private JLabel jLabel1 = new JLabel();
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();
    private JButton jButton3 = new JButton();
    private JButton jButton4 = new JButton();
    private JButton jButton5 = new JButton();
    private JButton jButton6 = new JButton();
    private JButton jButton7 = new JButton();
    private JButton jButton8 = new JButton();
    private JButton jButton9 = new JButton();
    private JButton jButton10 = new JButton();
    /**
     * Konstruktor klasy Rozgrywki
     * @param conn - polaczenie z baza danych
     */
    public Rozgrywki(Connection conn) {
        this.conn = conn;
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Funkcja, ktora zostala wygenerowana przez jdevelopera i inicjuje GUI okienka
     * @throws Exception
     */
    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(647, 310));
        this.setTitle( "Rozgrywki" );
        this.setBounds(new Rectangle(10, 10, 640, 310));
        jLabel1.setText("WYBIERZ ROZGRYWKE");
        jLabel1.setBounds(new Rectangle(245, -10, 250, 70));
        jLabel1.setFont(new Font("SansSerif", 1, 15));
        jLabel1.setForeground(Color.red);
        jButton1.setText("Premier League");
        jButton1.setBounds(new Rectangle(25, 70, 135, 35));

        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        premier_league_actionPerformed(e);
                    } catch (SQLException f) {
                    }
                }
            });
        jButton2.setText("Championship");
        jButton2.setBounds(new Rectangle(25, 120, 135, 35));
        jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    championship_actionPerformed(e);
                }
            });
        jButton3.setText("Primera Division");
        jButton3.setBounds(new Rectangle(180, 70, 135, 35));
        jButton4.setText("Segunda Division");
        jButton4.setBounds(new Rectangle(180, 120, 135, 35));
        jButton5.setText("Bundesliga");
        jButton5.setBounds(new Rectangle(335, 70, 135, 35));
        jButton6.setText("2. Bundesliga");
        jButton6.setBounds(new Rectangle(335, 120, 135, 35));
        jButton7.setText("Serie A");
        jButton7.setBounds(new Rectangle(485, 70, 135, 35));
        jButton8.setText("Serie B");
        jButton8.setBounds(new Rectangle(485, 120, 135, 35));
        jButton9.setText("Football League 1");
        jButton9.setBounds(new Rectangle(25, 170, 135, 35));
        jButton10.setText("Football League 2");
        jButton10.setBounds(new Rectangle(25, 220, 135, 35));
        this.getContentPane().add(jButton10, null);
        this.getContentPane().add(jButton9, null);
        this.getContentPane().add(jButton8, null);
        this.getContentPane().add(jButton7, null);
        this.getContentPane().add(jButton6, null);
        this.getContentPane().add(jButton5, null);
        this.getContentPane().add(jButton4, null);
        this.getContentPane().add(jButton3, null);
        this.getContentPane().add(jButton2, null);
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(jLabel1, null);
    }
    /**
     * Funkcja, która pozwala wybrac rozgrywki Premier League. Przekazywany jest tam 
     * id rozgrywek z bazy danych
     * @param e - akcja
     * @throws SQLException 
     * 
     */
    private void premier_league_actionPerformed(ActionEvent e) throws SQLException {
        String LeagueName = "Barclays Premer League";
        int LeagueNumber = 1;
        JFrame frame3 = new WyborPL(conn, LeagueName, LeagueNumber);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setLocationRelativeTo(null);
        frame3.setVisible(true);
        this.setVisible(false);
    }
    /**
     * Funkcja, która pozwala wybrac rozgrywki Championship. Przekazywany jest tam 
     * id rozgrywek z bazy danych
     * @param e -
     * LeagueName - zmienna, ktora odpowiada nazwie ligi 
     * LeagueNumber - zmienna, ktora odpowiada numerze ligi z bazy danych
     */
    private void championship_actionPerformed(ActionEvent e) {
        String LeagueName = "Football League Championship";
        int LeagueNumber = 2;
        JFrame frame5 = new WyborPL(conn, LeagueName, LeagueNumber);
        frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame5.setLocationRelativeTo(null);
        frame5.setVisible(true);
        this.setVisible(false);
    }
}
