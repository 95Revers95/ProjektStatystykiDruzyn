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
}
