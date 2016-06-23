package client;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import oracle.jdbc.OracleDriver;

public class ProfilDruzyna extends JFrame implements TableModelListener{
    private String nazwa;
    private int idDruzyny;
    private Icon logo;
    private String LeagueName;
    private int LeagueNumber;
    
    private int id_zawodnika_last;
    
    private Connection conn; 
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JButton wyjscie = new JButton();
    private JButton cofnij = new JButton();
    private JScrollPane jScrollPane1 = new JScrollPane();
    DefaultTableModel tbm = new DefaultTableModel();
    DefaultTableModel tbm1 = new DefaultTableModel();
    private JTable jTable1 = new JTable(tbm);
    private JButton pokaz_zawodnikow = new JButton();
    private JScrollPane jScrollPane2 = new JScrollPane();
    private JTable jTable2 = new JTable(tbm1);
    private JLabel jLabel3 = new JLabel();
    private JButton dodaj = new JButton();
    private JButton usun = new JButton();
    Map<Integer,Integer> idsByRow = new HashMap<Integer,Integer>();  
    Map<Integer,String> namesColumns = new HashMap<Integer,String>(); 
    Map<Integer,String> namesColumns_d = new HashMap<Integer,String>();
    Map<Integer,Integer> id_zawodnikow = new HashMap<Integer,Integer>();
    private JButton jButton1 = new JButton();
    /**
     * Konstruktor
     */
    public ProfilDruzyna(Connection conn, String nazwa, int idDruzyny, Icon logo, String LeagueName, int LeagueNumber) {
        this.conn = conn;
        this.nazwa = nazwa;
        this.idDruzyny=idDruzyny;
        this.logo=logo;
        this.LeagueName = LeagueName;
        this.LeagueNumber = LeagueNumber; 
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Funkcja, ktora z konstruktora odczytuje nazwe druzyny
     */
    public void setName(String nazwa){
        this.nazwa=nazwa;
    }
    /**
     * Funkcja, ktora zostala wygenerowana przez jdevelopera i inicjuje GUI okienka
     */
    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(730, 453));
        this.setTitle( "Menu/Edycja Druzyn,Zawodnikow/Profil Druzyny" );
        this.setBounds(new Rectangle(10, 10, 800, 600));
        jLabel1.setText("NAZWA DRUZYNY:");
        jLabel1.setBounds(new Rectangle(160, 15, 200, 30));
        jLabel1.setFont(new Font("Dialog", 1, 20));
        jLabel2.setText(nazwa);
        jLabel2.setBounds(new Rectangle(390, 20, 215, 20));
        jLabel2.setFont(new Font("Dialog", 2, 18));
        jLabel3.setIcon(logo);        
        wyjscie.setText("Wyjscie");
        wyjscie.setBounds(new Rectangle(605, 515, 145, 25));
        wyjscie.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    wyjscie_actionPerformed(e);
                }
            });
        cofnij.setText("Cofnij");
        cofnij.setBounds(new Rectangle(450, 515, 145, 25));
        cofnij.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cofnij_actionPerformed(e);
                }
            });
        jScrollPane1.setBounds(new Rectangle(25, 145, 735, 310));
        pokaz_zawodnikow.setText("Pokaz Zawodnikow");
        pokaz_zawodnikow.setBounds(new Rectangle(25, 465, 160, 25));
        pokaz_zawodnikow.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    pokaz_zawodnikow_actionPerformed(e);
                }
            });
        jScrollPane2.setBounds(new Rectangle(160, 60, 600, 50));
        jLabel3.setBounds(new Rectangle(10, 5, 140, 135));
        dodaj.setText("Dodaj");
        dodaj.setBounds(new Rectangle(505, 460, 125, 25));
        dodaj.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dodaj_actionPerformed(e);
                }
            });
        usun.setText("Usun");
        usun.setBounds(new Rectangle(635, 460, 125, 25));
        usun.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    usun_actionPerformed(e);
                }
            });
        jButton1.setText("Odswiez");
        jButton1.setBounds(new Rectangle(390, 460, 105, 25));
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    odswiez_actionPerformed(e);
                }
            });
        jScrollPane1.getViewport().add(jTable1, null);
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(usun, null);
        this.getContentPane().add(dodaj, null);
        this.getContentPane().add(jLabel3, null);
        jScrollPane2.getViewport().add(jTable2, null);
        this.getContentPane().add(jScrollPane2, null);
        this.getContentPane().add(pokaz_zawodnikow, null);
        this.getContentPane().add(jScrollPane1, null);
        this.getContentPane().add(cofnij, null);
        this.getContentPane().add(wyjscie, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel1, null);

        tbm.addColumn(" ");
        tbm.addColumn("Imie");
        tbm.addColumn("Nazwisko");
        tbm.addColumn("Kraj");
        tbm.addColumn("Data Urodzenia");
        tbm.addColumn("Pozycja");
        tbm.addColumn("Pozycja - szczegoly");
        tbm.addColumn("G_ZD");
        tbm.addColumn("G_ST");
        tbm.addColumn("Asysty");
        
        jTable1.getColumn(" ").setPreferredWidth(5);  
        jTable1.getColumn("Kraj").setPreferredWidth(5);
        jTable1.getColumn("Pozycja").setPreferredWidth(5);
        jTable1.getColumn("G_ZD").setPreferredWidth(8);  
        jTable1.getColumn("G_ST").setPreferredWidth(8);
        jTable1.getColumn("Asysty").setPreferredWidth(8);
        
        tbm1.addColumn("Kraj");
        tbm1.addColumn("Miasto");
        tbm1.addColumn("Budzet");
        tbm1.addColumn("Wygrane");
        tbm1.addColumn("Remisy");
        tbm1.addColumn("Porazki");
        
        
     
        String sql2="select * from druzyna where id_druzyny="+idDruzyny;
        Statement sql_stmt1;                
        sql_stmt1 = conn.createStatement();
        ResultSet rset = sql_stmt1.executeQuery(sql2);
        while (tbm1.getRowCount()!=0) tbm1.removeRow(0);
        while (rset.next()) {
            Vector a = new Vector();
            a.addElement(rset.getString("Kraj"));
            a.addElement(rset.getString("Miasto"));
            a.addElement(rset.getString("Budzet"));
            a.addElement(rset.getString("Wygrane_s"));
            a.addElement(rset.getString("Remisy_s"));
            a.addElement(rset.getString("Przegrane_s"));
            tbm1.addRow(a);
            
            namesColumns_d.put(1,"Kraj");
            namesColumns_d.put(2,"Miasto");
            namesColumns_d.put(3,"Budzet");
            namesColumns_d.put(4,"Wygrane_s");
            namesColumns_d.put(5,"Remisy_s");
            namesColumns_d.put(6,"Przegrane_s");
        }
        
        tbm.addTableModelListener(this);
        
    }
    /**
    * Funkcja, która pozwala uzytkownikowi cofnac sie do poprzedniego okna aplikacji
    * 
    */
    private void cofnij_actionPerformed(ActionEvent e) {
        JFrame frame = new EdycjaDruZawPL(conn, LeagueName, LeagueNumber);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        this.setVisible(false);
    }
    /**
    * Funkcja, która służy do zamknięcia aplikacji
    * 
    */
    private void wyjscie_actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    /**
    *Funckja, która w tabeli wypisuje wszystkich zawodnikow poszczegolnych zespolow oraz
    * ich statystyki oraz dane osobowe. Nastepuje tutaj polaczenie z baza danych
    * @param i - zmienna pomocnicza, która odpowiada nr indeksu zawondika
    */
    private void pokaz_zawodnikow_actionPerformed(ActionEvent e) {
        try {
            
            String sql="select * from pilkarze where id_druzyny="+idDruzyny + " order by id_pilkarza asc";
            String sql2="select id_pilkarza from pilkarze order by id_pilkarza asc";        
            
            Statement sql_stmt;
            sql_stmt = conn.createStatement();
            ResultSet rset = sql_stmt.executeQuery(sql);
           
            ZawodnikDAO zawd = new ZawodnikDAO(conn);
            
            Zawodnik zawo = new Zawodnik();
            
            List<Zawodnik> imiez = zawd.getAllByTeam(LeagueNumber);
            int i=0;
            while (tbm.getRowCount()!=0) tbm.removeRow(0);
            while (rset.next()) {
                           
                Vector r = new Vector();  
                r.addElement(i+1);
                r.addElement(zawo.imie);
                r.addElement(rset.getString("nazwisko"));
                r.addElement(rset.getString("kraj"));
                r.addElement(rset.getString("data_ur"));
                r.addElement(rset.getString("pozycja_ogolna"));
                r.addElement(rset.getString("pozycja_szczegolowa"));
                r.addElement(rset.getString("gole_zd_s"));
                r.addElement(rset.getString("gole_st_s"));
                r.addElement(rset.getString("asysty_s"));
                tbm.addRow(r);   
                
                idsByRow.put(i,rset.getInt("id_pilkarza"));
                namesColumns.put(1,"imie");
                namesColumns.put(2,"nazwisko");
                namesColumns.put(3,"kraj");
                namesColumns.put(4,"data_ur");
                namesColumns.put(5,"pozycja_ogolna");
                namesColumns.put(6,"pozycja_szczegolowa");
                namesColumns.put(7,"gole_zd_s");
                namesColumns.put(8,"gole_st_s");
                namesColumns.put(9,"asysty_s");
                i++;
                
            }
            
            
            Statement sql_stmt2;
            
            
            sql_stmt2 = conn.createStatement();
            
            
            ResultSet rset3 = sql_stmt2.executeQuery(sql2);
            int a=0;
            
            while (rset3.next()) {
                id_zawodnikow.put(a,rset3.getInt("id_pilkarza"));
                a++;
                System.out.println(a);
            }
            
            id_zawodnika_last=id_zawodnikow.get(a-1);
        } catch (SQLException f) {
            System.out.println(f.getMessage());        
        }
    }
    /**
     * Funkcja, która pozwala na edytowanie danych osobowych oraz statystyk piłkarzy. łaczy
     * sie z baza danych oraz ingeruje w nią
    */
    public void tableChanged(TableModelEvent e){
        if (e.getType() == TableModelEvent.UPDATE)
        {
            
            try {
                int row = e.getFirstRow();
                int column = e.getColumn();
                System.out.println(row);
                TableModel model = (TableModel)e.getSource();
                Integer lp = idsByRow.get(row);
                System.out.println(lp);
                String nc = (String)model.getValueAt(row, e.getColumn());
                System.out.println(nc);
                String name = namesColumns.get(column);
                System.out.println(name);
                
                
                Statement sql_stmt1;
                sql_stmt1 = conn.createStatement();
                System.out.println(namesColumns);
                System.out.println("UPDATE pilkarze SET "+ name + "=" + nc +" WHERE id_pilakrza="+lp);
                sql_stmt1.executeUpdate("UPDATE pilkarze SET "+ name + " = '" + nc +"' WHERE id_pilkarza="+lp);
                
                sql_stmt1.close();
                
            } catch (SQLException f) {
                System.out.println(f.getMessage());
            }
            
        }
    }
    /**
     * Funkcja, ktora odpowiada za usuwanie zawodnikow z druzyny. Laczy sie z baza danych.
     * @parma row - zmienna, ktora sluzy do wyznaczania numeru wiersza
     */
    private void usun_actionPerformed(ActionEvent e) {
        try{
            int row = jTable1.getSelectedRow();
            tbm.removeRow(row);
            
            Statement sql_stmt1;
            sql_stmt1 = conn.createStatement();
            Integer lp = idsByRow.get(row);
            sql_stmt1.executeUpdate("Delete From Pilkarze Where id_pilkarza="+lp);
            idsByRow.remove(row);
            
            sql_stmt1.close();
        }
        catch(SQLException ef){
            
        }
        
        
    }
    /**
     * Funkcja, która umozliwia dodanie zawodnikow do psozczegolniej druzyny. Funkcja laczy sie z 
     * baza danych
     * @param id_zaw - zmienna, która jest jednoczensnie id zawodnika z bazy danych
     */
    private void dodaj_actionPerformed(ActionEvent e) {
            int id_zaw=id_zawodnika_last+1;
            Accept accept = new Accept(conn, id_zaw, idDruzyny);
            accept.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            accept.setLocationRelativeTo(null);
            accept.setVisible(true);

    }
    /** 
     * Funkcja, ktora odwieza lsite zawdonikow. Wypisuje na nowo wszystkich zawodnikow z zespolu
     * 
     */
    private void odswiez_actionPerformed(ActionEvent e) {
        pokaz_zawodnikow_actionPerformed(e);
    }
}
