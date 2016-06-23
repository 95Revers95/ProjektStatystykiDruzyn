package client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

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
    
}
