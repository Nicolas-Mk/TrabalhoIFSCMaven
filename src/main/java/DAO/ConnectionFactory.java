/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author aluno
 */
public class ConnectionFactory {

    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String banco = "jdbc:mysql://localhost:3306/cantinaprd";
    public static final String usuario = "root";
    public static final String senha = "ifsc";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(banco + "?verifyServerCertificate=false"
                    + "&useSSL=false"
                    + "&requireSSL=false"
                    + "&USER=" + usuario + "&password=" + senha + "&serverTimezone=UTC"
            );
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public static void closeConnection(Connection conexao){
        try {
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void closeConnection(Connection conexao, PreparedStatement pstm){
        try {
           pstm.close();
           conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void closeConnection(Connection conexao, PreparedStatement pstm, ResultSet rst){
        try {
           
           pstm.close();
           rst.close();
           conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
