package client;

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

public class WyborPL extends JFrame {
    private Connection conn;
    private String LeagueName;
    private int LeagueNumber;
    private JLabel jLabel1 = new JLabel();
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();
    private JButton jButton3 = new JButton();
    private JButton jButton4 = new JButton();
    /**
     * Konstruktor klasy WyborPL
     * @param conn - laczenie z baza danych
     * @param LeagueName - przekazywana nazwa ligi z bazzy danych
     * @param LeagueNumber - przekazywany id ligi z bazy danych
     */
    public WyborPL(Connection conn, String LeagueName, int LeagueNumber) {
        this.conn = conn;
        this.LeagueName = LeagueName;
        this.LeagueNumber = LeagueNumber;
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
        this.setSize(new Dimension(772, 234));
        this.setTitle( "Menu" );
        jLabel1.setText(LeagueName);
        jLabel1.setBounds(new Rectangle(205, 15, 330, 35));
        jLabel1.setFont(new Font("Dialog", 0, 24));
        jButton1.setText("Statystyki Sezonu 2015/2016");
        jButton1.setBounds(new Rectangle(40, 75, 230, 30));
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        staty_20152016_actionPerformed(e);
                    } catch (SQLException f) {
                    }
                }
            });
        jButton2.setText("Edycja Druzyn/Zawodnikow");
        jButton2.setBounds(new Rectangle(480, 75, 230, 30));
        jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    edycja_actionPerformed(e);
                }
            });
        jButton3.setText("Cofnij");
        jButton3.setBounds(new Rectangle(175, 140, 165, 30));
        jButton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cofnij_actionPerformed(e);
                }
            });
        jButton4.setText("Wyjscie");
        jButton4.setBounds(new Rectangle(400, 140, 165, 30));
        jButton4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    wyjscie_actionPerformed(e);
                }
            });
        this.getContentPane().add(jButton4, null);
        this.getContentPane().add(jButton3, null);
        this.getContentPane().add(jButton2, null);
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(jLabel1, null);
    }
    /**
    * Funkcja, która służy do wybrania zakłądki Statystyki Druzyn. Beda przekazywane tam informacje takie 
    * jak placzenie z baza danych, numer id ligi z bazy danych oraz nazwa ligi z bazy danych
    * @param e - 
    * @throws SQLException
    */
    private void staty_20152016_actionPerformed(ActionEvent e) throws SQLException {
   
        String sql="select * from druzyna, uczesnictwo where druzyna.id_druzyny = uczesnictwo.id_druzyny AND uczesnictwo.id_rozgrywki = "+LeagueNumber;
        StatyPL1516 frame = new StatyPL1516(conn, sql, LeagueName, LeagueNumber);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        this.setVisible(false);
    }
    /**
    * Funkcja, która pozwala uzytkownikowi cofnac sie do poprzedniego okna aplikacji
    * @param e - 
    */
    private void cofnij_actionPerformed(ActionEvent e) {
        JFrame frame = new Rozgrywki(conn);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        this.setVisible(false);
    }
    /**
    * Funkcja, która służy do zamknięcia aplikacji
    * @param e - 
    */
    private void wyjscie_actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    /**
    * Funkcja, która służy do wybrania zakładki Eydcja Druzyn/Zawodnikow. Będą przekazywane tam 
    * informacje takie jak polaczenie z baza danych, nazwa ligi z bazy danych oraz numer ligi z bazy danych
    * @param e - 
    */
    private void edycja_actionPerformed(ActionEvent e) {
        JFrame frame2 = new EdycjaDruZawPL(conn, LeagueName, LeagueNumber);       
        
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
        this.setVisible(false);
    }
}
