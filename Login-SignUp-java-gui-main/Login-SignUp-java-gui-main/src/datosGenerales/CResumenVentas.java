/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datosGenerales;

import interfaces.connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class CResumenVentas {
    
    private DefaultTableModel modeloVentas;
    
    int id;
    String nombre;
    int cantidad;
    double precio;
    double total;
    String fecha;
    
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    public void mostrarProductos(JTable paramTablaVentas){
         
         connection objetoConexion = new connection();
    
          modeloVentas = new DefaultTableModel();
         
         TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<TableModel>(modeloVentas);
         paramTablaVentas.setRowSorter(ordenarTabla);
         
         String sql = "";
         
         modeloVentas.addColumn("No. Venta");
         modeloVentas.addColumn("Nombre");
         modeloVentas.addColumn("C. Vendida");
         modeloVentas.addColumn("Precio unitario");
         modeloVentas.addColumn("Total");
         modeloVentas.addColumn("Fecha");
         
         paramTablaVentas.setModel(modeloVentas);
         
         sql = "select * from ventas_realizadas";
         
         String [] datos = new String[6];
         
         
         try{
            java.sql.Statement st = objetoConexion.conectar().createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
                 datos[0] = String.valueOf(rs.getInt(1));
                 datos[1] = rs.getString(2);
                 datos[2] = String.valueOf(rs.getInt(3));
                 datos[3] = rs.getString(4);
                 datos[4] = rs.getString(5);
                 datos[5] = rs.getString(6);
                 modeloVentas.addRow(datos);
             }
             
             paramTablaVentas.setModel(modeloVentas);
         } catch (Exception e){
             JOptionPane.showMessageDialog(null, "No se pudieron mostrar los registros, error: "+e.toString());
         }
    }
}
