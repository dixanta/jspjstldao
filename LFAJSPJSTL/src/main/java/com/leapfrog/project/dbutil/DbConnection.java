/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.project.dbutil;

import com.leapfrog.project.constant.DBConstant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class DbConnection {
    private Connection conn=null;
    private PreparedStatement stmt=null;
    public void open() throws ClassNotFoundException, SQLException{
        Class.forName(DBConstant.DB_DRIVER);
        conn=DriverManager.getConnection(DBConstant.DB_URL, DBConstant.DB_USERNAME, DBConstant.DB_PASSWORD);
    }
    
    public PreparedStatement initStatement(String sql) throws SQLException{
        stmt=conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        return stmt;
    }
    
    public int update() throws SQLException{
        return stmt.executeUpdate();
    }
    
    public ResultSet query() throws SQLException{
        return stmt.executeQuery();
    }
    
    public void close() throws SQLException{
        if(conn!=null && !conn.isClosed()){
            conn.close();
            conn=null;
        }
    }
}
