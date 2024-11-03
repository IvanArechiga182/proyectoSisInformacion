/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datosGenerales;

import loginandsignup.connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CVentas {

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

    

  
    
    
    public void insertarVenta(JTextField paramNombre,JTextField paramCantidad, JTextField paramPrecio, JTextField paramTotal, JTextField paramFecha ){
        setNombre(paramNombre.getText());
        setCantidad(Integer.parseInt(paramCantidad.getText()));
        setPrecio((float) Double.parseDouble(paramPrecio.getText()));
        setTotal((float) Double.parseDouble(paramTotal.getText()));
        setFecha(paramFecha.getText());
        
        
        
        connection objetoConexion = new connection();
        
        String consulta = "insert into ventas_realizadas (nombre, cantidad, precio, total,fecha) values(?, ?, ?, ?, ?);";
        try{
            CallableStatement cs = objetoConexion.conectar().prepareCall(consulta);
          
            cs.setString(1, getNombre());
            cs.setInt(2, getCantidad());
            cs.setDouble(3, getPrecio());
            cs.setDouble(4, getTotal());
            cs.setString(5,getFecha());
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se insertó correctamente el producto.");
            //paramIdProducto.setText("");
            paramNombre.setText("");
            paramCantidad.setText("");
            paramPrecio.setText("");
            paramTotal.setText("");
            paramFecha.setText("");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se insertó el producto, error: "+e.toString());
            
        }    
        
       
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
     
    public void seleccionarVentas(JTable paramTablaVentas,JTextField paramIdVenta, JTextField paramNombre,JTextField paramCantidad, JTextField paramPrecio, JTextField paramTotal, JTextField paramFecha){
        
        try{
            int fila = paramTablaVentas.getSelectedRow();
            if(fila >=0){
                paramIdVenta.setText(( (paramTablaVentas.getValueAt(fila, 0).toString())));
                paramNombre.setText( (paramTablaVentas.getValueAt(fila, 1).toString()));
                paramCantidad.setText((paramTablaVentas.getValueAt(fila,2).toString()));
                paramPrecio.setText( (paramTablaVentas.getValueAt(fila, 3).toString()));
                paramTotal.setText((paramTablaVentas.getValueAt(fila, 4).toString()));
                paramFecha.setText( (paramTablaVentas.getValueAt(fila, 5).toString()));
                
            } else {
                JOptionPane.showMessageDialog(null, "La fila no se pudo seleccionar correctamente");
            }
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, "La fila no se pudo seleccionar correctamente: "+e.toString());
        }
    }
    
    public void modificarProductos(JTextField paramIdVenta, JTextField paramNombre,JTextField paramCantidad, JTextField paramPrecio, JTextField paramTotal, JTextField paramFecha ){
        
        setId(Integer.parseInt(paramIdVenta.getText()));
        setNombre(paramNombre.getText());
        setCantidad(Integer.parseInt(paramCantidad.getText()));
        setPrecio((float) Double.parseDouble(paramPrecio.getText()));
        setTotal((float) Double.parseDouble(paramTotal.getText()));
        setFecha(paramFecha.getText());
        
        connection objetoConexion = new connection();
        
        String consulta = "UPDATE ventas_realizadas SET nombre = ?, cantidad = ?, precio = ?, total = ?, fecha = ? WHERE id = ?;";
        
        try{
            CallableStatement cs = objetoConexion.conectar().prepareCall(consulta);
            
            cs.setString(1, getNombre());
            cs.setInt(2, getCantidad());
            cs.setDouble(3, getPrecio());
            cs.setDouble(4, getTotal());
            cs.setString(5,getFecha());
            cs.setInt(6, getId());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Modificacion exitosa!");
            
            
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudo realizar la modificacion, error: "+e.toString());
        }
        
    }
    
    public void eliminarProductos(JTextField paramIdVenta){
        
        setId(Integer.parseInt(paramIdVenta.getText()));
        
        connection objetoConexion = new connection();
        
        String consulta = "delete from ventas_realizadas where id=?;";
        
        try{
            CallableStatement cs = objetoConexion.conectar().prepareCall(consulta);
            
            cs.setInt(1, getId());
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el producto seleccionado");
        } catch (SQLException e){
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto, error: "+e.toString());

        }
    }
    
    
    
}
