package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mavenproject1 {
    public static void main(String[] args) {
        String usuario="root";
        String password="";
        String url="jdbc:mysql://localhost:3306/usuarios";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM ingreso");
            while (rs.next()){
                System.out.println(rs.getString("nombre"));
            }  
            
            // insertar dato
            statement.execute("INSERT INTO `ingreso`(`id`, `nombre`) VALUES (NULL,'Milena Ochoa');");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM ingreso");
            while (rs.next()){
                System.out.println(rs.getString("nombre"));
            }  
            
            // actualizar dato
            statement.execute("UPDATE `ingreso` SET `nombre` = 'Carolina Herrera' WHERE `ingreso`.`id` = 1;");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM ingreso");
            while (rs.next()){
                System.out.println(rs.getString("nombre"));
            }
             
              // Eliminar dato
            statement.execute("DELETE FROM ingreso WHERE `ingreso`.`id` = 3;");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM ingreso");
            while (rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Mavenproject1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
