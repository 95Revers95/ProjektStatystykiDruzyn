/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.sql.Connection;

/**
 *
 * @author eloelomno
 */
public abstract class DAO {
    private Connection conn;
    
    public DAO (Connection conn){
        this.conn=conn;
    }
    
    Connection getConnection(Connection conn){
        return conn;
    };
    
    
    
    
}
