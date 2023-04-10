
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class VentaDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
  public int registrarVenta(Venta v){
        String sql = "INSERT INTO ventas (cliente, total) VALUES (?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getCliente());
            ps.setDouble(2, v.getTotal());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }
  
  
  public int registrarDetalle(Detalle dv){
      String sql = "INSERT INTO detalle (codigo_pro, cantidad, precio, id_venta) VALUES (?, ?, ?, ?)";
      try{
          con= cn.getConnection();
          ps=con.prepareStatement(sql);
          ps.setInt(1, dv.getCodigoPro());
          ps.setInt(2,dv.getCantidad());
          ps.setDouble(3,dv.getPrecio());
          ps.setInt(4,dv.getId());
          ps.execute();
      }catch(SQLException e){
          System.out.println(e.toString());
      }finally{
          try{
              con.close();
          }catch(SQLException e){
              System.out.println(e.toString());
          }
      }
      return r;
  }
  
  public int idVenta(){
      int id = 0;
      String sql = "SELECT MAX(id) FROM ventas";
      try{
        con= cn.getConnection();
        ps=con.prepareStatement(sql);
        rs = ps.executeQuery();
        if(rs.next()){
            id=rs.getInt(1);
        }
      }catch(SQLException e){
          System.out.println(e.toString());
      }
      return id;
  }
 
  public boolean actualizarStock(int cant, int cod){
      String sql = "UPDATE productos SET stock = ? where codigo = ?";
      try{
          con=cn.getConnection();
          ps=con.prepareStatement(sql);
          ps.setInt(1,cant);
          ps.setInt(2,cod);
          ps.execute();
          return true;
      }catch(SQLException e){
          System.out.println(e.toString());
      }
      return false;
  }
  
  public List listarVentas(){
       List<Venta> listaVenta = new ArrayList();
       String sql = "SELECT * FROM ventas";
       ResultSet rs;
       try{
           con=cn.getConnection();
           ps=con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               Venta ven = new Venta();
               ven.setId(rs.getInt("id"));
               ven.setCliente(rs.getString("cliente"));
               ven.setTotal(rs.getDouble("total"));
               listaVenta.add(ven);
           }
       }catch(Exception e){
           System.out.println(e.toString());
       }
       return listaVenta;
    }
  
}
