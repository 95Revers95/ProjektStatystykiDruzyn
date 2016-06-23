/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author eloelomno
 */
public class ZawodnikDAO extends DAO{
 
    public ZawodnikDAO(Connection conn){
        super(conn);
        
    }

    
    public List<Zawodnik> getAllByTeam(int TeamNumber){
        List<Zawodnik> listaZawodnikow = new ArrayList<Zawodnik>();
        String sql = "Select * From Pilkarze Where id_druzyny ="+TeamNumber +" order by nazwisko asc;";
        try{
            Statement sql_stmt = conn.createStatement();
            ResultSet rset = sql_stmt.executeQuery(sql);
            
            while (rset.next()) {
                listaZawodnikow.add(parseZawodnicy(rset));        
            }
        }
        
        catch (SQLException f) {
                    System.out.println(f.getMessage());
                }
                return listaZawodnikow;
        }
    
    
    
    private Zawodnik parseZawodnicy(ResultSet rset) throws SQLException {
        Zawodnik zaw= new Zawodnik();
        zaw.imie=rset.getString("imie");
        zaw.nazwisko=rset.getString("nazwisko");
        zaw.data=rset.getString("data_ur");
        zaw.kraj=rset.getString("kraj");
        zaw.pozycja=rset.getString("pozycja_ogolna");
        zaw.pozycja_sz=rset.getString("pozycja_szczegolowa");
        zaw.gole_zd_s=rset.getInt("gole_zd_s");
        zaw.gole_st_s=rset.getInt("gole_st_s");
        zaw.asysty=rset.getInt("asysty");            
        
        return zaw;
    }

    String getImie(ResultSet rset) throws SQLException{
        Zawodnik zaw = new Zawodnik();
        zaw.imie = rset.getString("imie");
        return zaw.imie;
    }
    
    String getNazwisko(ResultSet rset) throws SQLException{
        Zawodnik zaw = new Zawodnik();
        zaw.nazwisko = rset.getString("nazwisko");
        return zaw.nazwisko;
    }
    String getKraj(ResultSet rset) throws SQLException{
        Zawodnik zaw = new Zawodnik();
        zaw.kraj = rset.getString("kraj");
        return zaw.kraj;
    }
    String getDataUr(ResultSet rset) throws SQLException{
        Zawodnik zaw = new Zawodnik();
        zaw.data = rset.getString("data_ur");
        return zaw.data;
    }
    String getPozycja(ResultSet rset) throws SQLException{
        Zawodnik zaw = new Zawodnik();
        zaw.pozycja = rset.getString("pozycja_ogolna");
        return zaw.pozycja;
    }
    String getPozycjaSz(ResultSet rset) throws SQLException{
        Zawodnik zaw = new Zawodnik();
        zaw.pozycja_sz = rset.getString("pozycja_szczegolowa");
        return zaw.pozycja_sz;
    }
    int getGoleZdS(ResultSet rset) throws SQLException{
        Zawodnik zaw = new Zawodnik();
        zaw.gole_zd_s = rset.getInt("gole_zd_s");
        return zaw.gole_zd_s;
    }
    int getGoleStS(ResultSet rset) throws SQLException{
        Zawodnik zaw = new Zawodnik();
        zaw.gole_st_s = rset.getInt("gole_st_s");
        return zaw.gole_st_s;
    }
    int getAsysty(ResultSet rset) throws SQLException{
        Zawodnik zaw = new Zawodnik();
        zaw.asysty = rset.getInt("asysty_s");
        return zaw.asysty;
    }
}
