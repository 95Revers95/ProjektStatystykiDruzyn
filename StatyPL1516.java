package client;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class StatyPL1516 extends JFrame {
    private Connection conn;
    private String sql;
    private String LeagueName;
    private int LeagueNumber;

    
    private JButton jButton1 = new JButton();
    private JButton jButton3 = new JButton();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JButton jButton5 = new JButton();
    private JButton jButton6 = new JButton();
    private JButton jButton7 = new JButton();
    private JButton jButton9 = new JButton();
    
    DefaultTableModel tbm = new DefaultTableModel();
    DefaultTableModel tbm1 = new DefaultTableModel();
    DefaultTableModel tbm2 = new DefaultTableModel();
    DefaultTableModel tbm3 = new DefaultTableModel();
    private JTable BPLDruzyny = new JTable(tbm);
    
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JButton jButton10 = new JButton();
    private JScrollPane jScrollPane2 = new JScrollPane();
    private JTable TabelaPL = new JTable(tbm1);
    private JScrollPane jScrollPane3 = new JScrollPane();
    private JTable jTable1 = new JTable(tbm2);
    private JScrollPane jScrollPane4 = new JScrollPane();
    private JTable jTable2 = new JTable(tbm3);

    /**
     * Konstruktor klasy WyborPL
     * @param conn - parametr, ktora dotyczy laczenia z baza danych
     * @param sql - parametr, w ktorm zapisane jest zapytanie sql
     * @param LeagueName - parametr, w ktorym zapisana jest informacja o nazwie ligi
     * @param LeagueNumber - parametr, w ktorym zapisana jest informacja o numerze ligi
     * @throws SQLException
     */
    public StatyPL1516(Connection conn, String sql, String LeagueName, int LeagueNumber) throws SQLException {
        
        this.conn = conn;
        this.sql=sql;
        this.LeagueName=LeagueName;
        this.LeagueNumber=LeagueNumber;
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
        this.setSize(new Dimension(864, 484));
        this.setTitle( "Menu/"+LeagueName+" 2015/2016 - Statystyki" );
        this.setBackground(Color.black);
        jButton1.setText("Wyswietl Druzyny");
        jButton1.setBounds(new Rectangle(15, 15, 150, 30));
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    wyswietl_druzyny_actionPerformed(e);
                }
            });
        jButton3.setText("Wyjscie");
        jButton3.setBounds(new Rectangle(15, 310, 150, 30));
        jButton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    wyjscie_actionPerformed(e);
                }
            });
        jLabel1.setText("jLabel1");
        jLabel1.setBounds(new Rectangle(-65, 0, 65, 14));
        jLabel2.setText(LeagueName);
        jLabel2.setBounds(new Rectangle(305, 5, 290, 30));
        jLabel2.setFont(new Font("Dialog", 0, 19));
        jButton5.setText("Tabela");
        jButton5.setBounds(new Rectangle(675, 50, 150, 30));
        jButton5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    tabela_actionPerformed(e);
                }
            });
        jButton6.setText("Najlepszi Strzelcy");
        jButton6.setBounds(new Rectangle(675, 85, 150, 30));
        jButton6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    strzelcy_actionPerformed(e);
                }
            });
        jButton7.setText("Najlepszi Asystenci");
        jButton7.setBounds(new Rectangle(675, 120, 150, 30));


        jButton7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    asysty_actionPerformed(e);
                }
            });
        jButton9.setText("Cofnij");
        jButton9.setBounds(new Rectangle(15, 270, 150, 30));
        jButton9.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cofnij_actionPerformed(e);
                }
            });
        jScrollPane1.setBounds(new Rectangle(230, 50, 355, 325));
        jButton10.setText("Ukryj");
        jButton10.setBounds(new Rectangle(320, 390, 200, 25));
        jButton10.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ukryj_actionPerformed(e);
                }
            });
        jScrollPane2.setBounds(new Rectangle(180, 45, 480, 330));
        jScrollPane2.getViewport().add(TabelaPL, null);
        jScrollPane3.getViewport().add(jTable1, null);
        jScrollPane4.getViewport().add(jTable2, null);
        this.getContentPane().add(jScrollPane4, null);
        this.getContentPane().add(jScrollPane3, null);
        this.getContentPane().add(jScrollPane2, null);
        this.getContentPane().add(jButton10, null);
        jScrollPane1.getViewport().add(BPLDruzyny, null);
        this.getContentPane().add(jScrollPane1, null);
        this.getContentPane().add(jButton9, null);
        this.getContentPane().add(jButton7, null);
        this.getContentPane().add(jButton6, null);
        this.getContentPane().add(jButton5, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jButton3, null);
        this.getContentPane().add(jButton1, null);


        tbm.addColumn("Nazwa");
        
        tbm1.addColumn("Poz.");
        tbm1.addColumn("Nazwa Druzyny");
        tbm1.addColumn("M");
        tbm1.addColumn("Z");
        tbm1.addColumn("R");
        tbm1.addColumn("P");
        tbm1.addColumn("B. Zd.");
        tbm1.addColumn("B. St.");
        tbm1.addColumn("+/-");
        tbm1.addColumn("Pkt");
        
        tbm2.addColumn("Nazwisko");
        tbm2.addColumn("Wartosc");
        
        tbm3.addColumn("Nazwisko");
        tbm3.addColumn("Asysty");
          
        
        
        jScrollPane1.setVisible(false);
        jScrollPane2.setVisible(false);
        jScrollPane3.setVisible(false);
        jScrollPane4.setVisible(false);
        jScrollPane3.setBounds(new Rectangle(205, 50, 450, 325));
        jScrollPane4.setBounds(new Rectangle(200, 50, 450, 325));


    }
    /**
    * Funckja, któ©a wyświetla wszystkie druzyny należace do danej ligi w tabeli. Zostaje tutaj
    * wykorzystane połączenie z bazą danych
    * @param e - 
    */
    private void wyswietl_druzyny_actionPerformed(ActionEvent e) {     

        try{
            if(tbm.getRowCount()>0) {
                for(int i = tbm.getRowCount()-1;i >=0;i--) {
                    tbm.removeRow(i);
                }
            }
            DruzynaDAO dru = new DruzynaDAO(conn);
            ukryj_actionPerformed(e);
            jScrollPane1.setVisible(true);
            Statement sql_stmt = conn.createStatement();
            while (tbm.getRowCount()!=0) tbm1.removeRow(0);           
            ResultSet rset = sql_stmt.executeQuery(dru.getSQLWyswietlDruzyny(LeagueNumber));
            while (rset.next()) {
            Vector <String> r = new Vector<String>();  
            r.addElement(rset.getString("nazwa"));    
            tbm.addRow(r);            
            }
            
        }
        catch (SQLException ef) {
                    JOptionPane.showMessageDialog(this, 
                                                  "Blad, polacz ponownie",
                                                  "Bload", 
                                                  JOptionPane.ERROR_MESSAGE);
                    ef.printStackTrace();
                }

        
    }
    /**
    * Funkcja, która ukrywa informacje przekazane do tablicy
    * @param e -
    */
    private void ukryj_actionPerformed(ActionEvent e) {
        jScrollPane1.setVisible(false);
        jScrollPane2.setVisible(false);
        jScrollPane3.setVisible(false);
        jScrollPane4.setVisible(false);
    }
    /**
    * Funkcja, która służy do zamknięcia aplikacji
    * @param e -
    */
    private void wyjscie_actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    /**
    * Funkcja, która pozwala uzytkownikowi cofnac sie do poprzedniego okna aplikacji
    * @frame - jest to stworzony JFrame
    * @param e -
    */
    private void cofnij_actionPerformed(ActionEvent e) {
        JFrame frame3 = new WyborPL(conn, LeagueName, LeagueNumber);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setLocationRelativeTo(null);
        frame3.setVisible(true);
        this.setVisible(false);
    }

    /**
    * Funkcja, która służy do wysiwetlenia aktualnej tabeli w danej rozgrywce. 
    * Wykorzystane zostało tutaj połącznie z bazą danych
    * @param e -
    */
    private void tabela_actionPerformed(ActionEvent e) {
        ukryj_actionPerformed(e);
        jScrollPane2.setVisible(true);
        
        
        try {
            DruzynaDAO dru = new DruzynaDAO(conn);
            
            dru.utworzTabele(tbm1, LeagueNumber);
            
        } catch (SQLException f) {
            System.out.println(f.getMessage());
            
        }
    
}
    /**
    * Funkcja, która służy do Wyswietlenia najlepszych strzelcow danych rozgrywek
    * @param e - 
    */
    private void strzelcy_actionPerformed(ActionEvent e) {
        try{
            if(tbm.getRowCount()>0) {
                for(int i = tbm.getRowCount()-1;i >=0;i--) {
                    tbm.removeRow(i);
                }
            }  
            ukryj_actionPerformed(e);
            jScrollPane3.setVisible(true);
            Statement sql_stmt = conn.createStatement();
            DruzynaDAO dru = new DruzynaDAO(conn);
            ResultSet rset = sql_stmt.executeQuery(dru.getSQLStrzelcy(LeagueNumber));
            while (tbm2.getRowCount()!=0) tbm2.removeRow(0);
            while (rset.next()) {
            Vector <String> r = new Vector<String>();  
            r.addElement(rset.getString("nazwisko"));
            r.addElement(rset.getString("gole_zd_s"));
            tbm2.addRow(r);       
            
            }
        }
        catch (SQLException ef) {
                    JOptionPane.showMessageDialog(this, 
                                                  "B��d, po��cz si� ponownie",
                                                  "B��d", 
                                                  JOptionPane.ERROR_MESSAGE);
                    ef.printStackTrace();
                }
        
    }
    /**
    * Funkcja, która służy do wyswietlenia najlepszych asystentow w danych rozgrywach 
    * @param e -
    */
    private void asysty_actionPerformed(ActionEvent e) {
        try{
            if(tbm.getRowCount()>0) {
                for(int i = tbm.getRowCount()-1;i >=0;i--) {
                    tbm.removeRow(i);
                }
            }  
            ukryj_actionPerformed(e);
            jScrollPane3.setVisible(true);
            Statement sql_stmt = conn.createStatement();
            DruzynaDAO dru = new DruzynaDAO(conn);            
            ResultSet rset = sql_stmt.executeQuery(dru.getSQLAsystenci(LeagueNumber));
            while (tbm2.getRowCount()!=0) tbm2.removeRow(0);
            while (rset.next()) {
            Vector <String> r = new Vector<String>();  
            r.addElement(rset.getString("nazwisko"));
            r.addElement(rset.getString("asysty_s"));
            
            tbm2.addRow(r);
            
            }
        }
        catch (SQLException ef) {
                    JOptionPane.showMessageDialog(this, 
                                                  "B��d, po��cz si� ponownie",
                                                  "B��d", 
                                                  JOptionPane.ERROR_MESSAGE);
                    ef.printStackTrace();
                }
    }
}
