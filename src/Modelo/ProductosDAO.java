/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author tagax
 */
public class ProductosDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean registrarProductos(Productos pd){
        String sql = "INSERT INTO productos (codigo, nombre, proveedor, stock, precio) VALUES (?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pd.getCodigo());
            ps.setString(2, pd.getNombre());
            ps.setString(3, pd.getProveedor());
            ps.setInt(4, pd.getStock());
            ps.setDouble(5, pd.getPrecio());
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
    
    public void consultarProveedor(JComboBox proveedor){
        String sql = "SELECT nombre FROM proveedor";
        try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               proveedor.addItem(rs.getString("nombre"));
           }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    
    public List listarProductos(){
       List<Productos> listaProducto = new ArrayList();
       String sql = "SELECT * FROM productos ";
       ResultSet rs;
       try{
           con=cn.getConnection();
           ps=con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               Productos pd = new Productos();
               pd.setId(rs.getInt("id"));
               pd.setCodigo(rs.getInt("codigo"));
               pd.setNombre(rs.getString("nombre"));
               pd.setProveedor(rs.getString("proveedor"));
               pd.setStock(rs.getInt("stock"));
               pd.setPrecio(rs.getDouble("precio"));
               listaProducto.add(pd);
           }
       }catch(Exception e){
           System.out.println(e.toString());
       }
       return listaProducto;
    }
    
    public boolean eliminarProductos(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    public boolean modificarProductos(Productos p) {
        String sql = "UPDATE productos SET codigo=?, nombre=?, proveedor=?, stock=?, precio=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getProveedor());
            ps.setInt(4, p.getStock());       
            ps.setDouble(5, p.getPrecio());
            ps.setInt(6, p.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public Productos buscarProductos(int codigo){
        Productos pd = new Productos();
        String sql = "SELECT * FROM productos WHERE codigo = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if(rs.next()){
               pd.setNombre(rs.getString("nombre"));
               pd.setStock(rs.getInt("stock"));
               pd.setPrecio(rs.getDouble("precio"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return pd;
    }
    
}
