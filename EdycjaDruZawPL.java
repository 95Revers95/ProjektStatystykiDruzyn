package client;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPopupMenu;
/**
 * 
 * 
 */
public class EdycjaDruZawPL extends JFrame {
    private Connection conn; 
    private String LeagueName;
    private int LeagueNumber;
    private JButton Arsenal = new JButton();

    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();
    private JButton jButton3 = new JButton();
    private JComboBox jComboBox1 = new JComboBox();
    

    public EdycjaDruZawPL(Connection conn, String LeagueName, int LeagueNumber) {
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
     */
    private void jbInit() throws Exception {
        
        
        
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(807, 415));
        this.setTitle( "Menu/Edycja Druzyn, Zawodnikow" );
        jButton1.setText("Wyjscie");
        jButton1.setBounds(new Rectangle(635, 330, 140, 35));
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    wyjscie_actionPerformed(e);
                }
            });
        jButton2.setText("Cofnij");
        jButton2.setBounds(new Rectangle(635, 285, 140, 35));
        jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cofnij_actionPerformed(e);
                }
            });
        jButton3.setText("Potwierdz");
        jButton3.setBounds(new Rectangle(635, 240, 140, 35));
        jButton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    potwierdz_actionPerformed(e);
                }
            });
        DruzynaDAO dao = new DruzynaDAO(conn);
        
        jComboBox1.setBounds(new Rectangle(100, 30, 365, 45));      
        jComboBox1.setFont(new Font("Segoe Script", 2, 12)); // NOI18N
        dao.getAllByLeague(LeagueNumber);
        List<Druzyna> a = dao.getAllByLeague(LeagueNumber);        
        jComboBox1.setModel(new DefaultComboBoxModel(a.toArray(new Druzyna[a.size()])));       
        jComboBox1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jComboBox1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        getContentPane().add(jComboBox1);
      
        
        this.getContentPane().add(jComboBox1, null);
        this.getContentPane().add(jButton3, null);
        this.getContentPane().add(jButton2, null);
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(Arsenal, null);


    }
    /**
    * Funkcja, która pozwala uzytkownikowi cofnac sie do poprzedniego okna aplikacji
    *@param frame - jest to stworzony JFrame 
    */
    private void cofnij_actionPerformed(ActionEvent e) {
        JFrame frame = new WyborPL(conn, LeagueName, LeagueNumber);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);;
        frame.setVisible(true);
        this.setVisible(false);
    }
    /**
    * Funkcja, która powoduje zamknięcie aplikacji
    * @param -
    */
    private void wyjscie_actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    /**
    * Funkcja, która przekazuje informację o tym, która drużyna została wybana przez użytkownika
    * @param logo - jest to zmienna, która posiada informacje, które logo wyświetlić
    * @param nazwaProfil - zmienna typu ProfilDruzyna. Wyswietla informacje o druzynie
    */
     private void potwierdz_actionPerformed(ActionEvent e) {
       
        Druzyna dru = (Druzyna)jComboBox1.getSelectedItem();
        
        Icon logo;
        logo = new ImageIcon(this.getClass().getResource("/client/png/"+ dru.id_druzyny +".png"));
        
        ProfilDruzyna nazwaProfil = new ProfilDruzyna(conn, dru.nazwa, dru.id_druzyny,logo, LeagueName, LeagueNumber);
        nazwaProfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nazwaProfil.setLocationRelativeTo(null);
        this.setVisible(false);
        nazwaProfil.setVisible(true);
    }
}
