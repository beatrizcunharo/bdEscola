/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author Beatr
 */
public class ConnectionFactory {
    
    public static Connection connect() {
        String url = "jdbc:postgresql://localhost:5432/escola";
        String user = "postgres";
        String password = "admin";
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Banco conectado: bd escola");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
