
package Modelo;

import java.sql.*;

public class Conexion {
    Connection con;
    
    public Connection getConnection(){
        try{
            String myBD = "jdbc:mysql://localhost:3306/sistemaventas?serverTimezone=UTC";
            con = DriverManager.getConnection(myBD, "root", "");
            return con;
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return null;
    }
}
