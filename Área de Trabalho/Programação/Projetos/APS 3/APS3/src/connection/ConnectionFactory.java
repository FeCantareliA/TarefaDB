/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class ConnectionFactory {
    private final String DRIVER="org.postgresql.jdbc.Driver";
    private final String URL="jdbc:postgresql://localhost:5432/dbAPS";
    private final String USER="postgres";
    private final String PASS="root";
    
    public Connection getConnection(){
        
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ",ex);   
        }      
    }
    public static void closeConnection(Connection con){
            try {
                if(con != null){
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    public static void closeConnection(Connection con, PreparedStatement stmt){
        closeConnection(con);
            try {
                if (stmt !=null) {
                    stmt.close();
                }      
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }   
    }
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con,stmt);
            try {
                if (rs !=null) {
                    rs.close();
                }      
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }   
    }
    
    
}
