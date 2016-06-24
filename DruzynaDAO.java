package client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DruzynaDAO extends DAO {
    public DruzynaDAO(Connection conn){
        super(conn);
        
    }
    public List<Druzyna> getAllByLeague(int LeagueNumber){
        List<Druzyna> listaDruzyn = new ArrayList<Druzyna>();
        String sql = "select * from druzyna, uczesnictwo where druzyna.id_druzyny = uczesnictwo.id_druzyny AND uczesnictwo.id_rozgrywki = "+LeagueNumber +"order by nazwa asc";
        try{
            Statement sql_stmt = conn.createStatement();
            ResultSet rset = sql_stmt.executeQuery(sql);
            while (rset.next()) {
                listaDruzyn.add(parseDruzyna(rset));        
            }
        }
        
        catch (SQLException f) {
                    System.out.println(f.getMessage());
                }
                return listaDruzyn;
        }

    private Druzyna parseDruzyna(ResultSet rset) throws SQLException {
        Druzyna dr= new Druzyna();
        dr.nazwa=rset.getString("nazwa");
        dr.id_druzyny=rset.getInt("id_druzyny");
        dr.stat = parseStaty(rset);
        
        return dr;
    }
    
    private StatystykiDruzyny parseStaty(ResultSet rset) throws SQLException {
        StatystykiDruzyny stdr = new StatystykiDruzyny();
        
        stdr.wygrane_s = rset.getInt("wygrane_s");
        stdr.remisy_s = rset.getInt("remisy_s");
        stdr.przegrane_s = rset.getInt("przegrane_s");
        
        return stdr;
    }
    
    String getSQLWyswietlDruzyny(int LeagueNumber){
        String sql = "select * from druzyna, uczesnictwo where druzyna.id_druzyny = uczesnictwo.id_druzyny AND uczesnictwo.id_rozgrywki = "+LeagueNumber +"order by nazwa asc";
        return sql;
    }
    
    String getSQLStrzelcy(int LeagueNumber){
        String sql = "select * from pilkarze, rozgrywki WHERE rozgrywki.id_rozgrywki="+LeagueNumber+ "order by gole_zd_s desc";
        return sql;
    }
    
    String getSQLAsystenci(int LeagueNumber){
        String sql = "select * from pilkarze, rozgrywki where rozgrywki.id_rozgrywki ="+LeagueNumber+ "order by asysty_s desc";
        return sql;
    }
    
    String getSQL(int idDruzyny){
        String sql2="select * from druzyna where id_druzyny="+idDruzyny;
        return sql2;
    }
    
    void utworzTabele(DefaultTableModel tbm1, int LeagueNumber) throws SQLException{
        Statement sql_stmt;
            sql_stmt = conn.createStatement();
            ResultSet rset = sql_stmt.executeQuery("\n" + 
            "select nazwa, wygrane_s, remisy_s, przegrane_s, gole_zd_s, gole_st_s, punkty_s,  (gole_zd_s - gole_st_s) as plusminus from druzyna, uczesnictwo where druzyna.kraj='ENG' AND druzyna.id_druzyny = uczesnictwo.id_druzyny AND uczesnictwo.id_rozgrywki="+LeagueNumber+ "order by punkty_s desc, plusminus desc");
            int i=0;
            while (tbm1.getRowCount()!=0) tbm1.removeRow(0);
            while (rset.next()) {
                i++;
                int M=rset.getInt("wygrane_s")+rset.getInt("remisy_s")+rset.getInt("przegrane_s");
                int plusminus=rset.getInt("gole_zd_s")-rset.getInt("gole_st_s");
                Vector r = new Vector();  
                r.addElement(i+".");
                r.addElement(rset.getString("nazwa"));    
                r.addElement(M);
                r.addElement(rset.getInt("wygrane_s"));
                r.addElement(rset.getInt("remisy_s"));
                r.addElement(rset.getInt("przegrane_s"));
                r.addElement(rset.getInt("gole_zd_s"));
                r.addElement(rset.getInt("gole_st_s"));
                r.addElement(plusminus);
                r.addElement(rset.getInt("punkty_s"));
                tbm1.addRow(r);        
            }
    }
}
