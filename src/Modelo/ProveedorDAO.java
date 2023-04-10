package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProveedorDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    
    public boolean registrarProveedor(Proveedor p){
        String sql = "INSERT INTO proveedor (dni, nombre, telefono, direccion, razon) VALUES (?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,p.getDni());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getTelefono());
            ps.setString(4, p.getDireccion());
            ps.setString(5, p.getRazon());
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    
    public List listarProveedor(){
       List<Proveedor> listaProveedor = new ArrayList();
       String sql = "SELECT * FROM proveedor ";
       ResultSet rs;
       try{
           con=cn.getConnection();
           ps=con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               Proveedor p = new Proveedor();
               p.setId(rs.getInt("id"));
               p.setDni(rs.getInt("dni"));
               p.setNombre(rs.getString("nombre"));
               p.setTelefono(rs.getString("telefono"));
               p.setDireccion(rs.getString("direccion"));
               p.setRazon(rs.getString("razon"));
               listaProveedor.add(p);
           }
       }catch(Exception e){
           System.out.println(e.toString());
       }
       return listaProveedor;
    }
    
    public boolean eliminarProveedor(int id){
        String sql = "DELETE FROM proveedor WHERE id = ?";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public boolean modificarCliente(Proveedor p){
        String sql = "UPDATE proveedor SET dni=?, nombre=?, telefono=?, direccion=?, razon=? WHERE id=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getDni());
            ps.setString(2,p.getNombre());
            ps.setString(3, p.getTelefono());
            ps.setString(4,p.getDireccion());
            ps.setString(5,p.getRazon());
            ps.setInt(6, p.getId());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
}
