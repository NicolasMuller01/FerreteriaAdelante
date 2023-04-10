
package Modelo;

public class Venta {
    private int id;
    private String cliente;;
    private String producto;
    private double total;
    
    public Venta(){}

    public Venta(int id, String cliente, String producto, double total) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}