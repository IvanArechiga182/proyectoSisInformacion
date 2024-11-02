/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datosGenerales;

import interfaces.connection;
import java.sql.CallableStatement;
import javax.swing.JTextField;
import interfaces.connection;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;




public class CInventario {
     private DefaultTableModel modeloInventario;
    String nombreProducto;
    int cantidadExistencia;
    int codigoBarras;
    LocalDate fechaIngreso;
    String categoria;
    int id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidadExistencia() {
        return cantidadExistencia;
    }

    public void setCantidadExistencia(int cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
    }

    public int getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(int codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    public void insertarProducto(JTextField paramNombre, JTextField paramExistencias, JTextField paramCodigoBarras, JTextField paramCategoria){
        
        setNombreProducto(paramNombre.getText());
        setCantidadExistencia(Integer.parseInt(paramExistencias.getText()));
        setCodigoBarras(Integer.parseInt(paramCodigoBarras.getText()));
        setCategoria(paramCategoria.getText());

        
        connection objetoConexion = new connection();
        
        String consulta = "insert into inventario (nombre_producto, cantidad_existencia, codigo_barras, categoria) values(?, ?, ?, ?);";
        try{
            CallableStatement cs = objetoConexion.conectar().prepareCall(consulta);
          
            cs.setString(1,getNombreProducto());
            cs.setInt(2, getCantidadExistencia());
            cs.setInt(3,getCodigoBarras());
            cs.setString(4,getCategoria());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se insertó correctamente el producto.");
            //paramIdProducto.setText("");
            paramNombre.setText("");
            paramExistencias.setText("");
            paramCodigoBarras.setText("");
            paramCategoria.setText("");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se insertó el producto, error: "+e.toString());
            
        }   
       
    }
    

    
     public void mostrarProductos(JTable paramTablaInventario){
         
         connection objetoConexion = new connection();
        
         modeloInventario = new DefaultTableModel();
         
         TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<TableModel>(modeloInventario);
         paramTablaInventario.setRowSorter(ordenarTabla);
         
         String sql = "";
         
         modeloInventario.addColumn("Código");
         modeloInventario.addColumn("Nombre");
         modeloInventario.addColumn("Existencias");
         modeloInventario.addColumn("C. Barras");
         modeloInventario.addColumn("Categoría");
         
         paramTablaInventario.setModel(modeloInventario);
         
         sql = "select * from inventario";
         
         String [] datos = new String[5];
         
         
         try{
            java.sql.Statement st = objetoConexion.conectar().createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
                 datos[0] = String.valueOf(rs.getInt(1));
                 datos[1] = rs.getString(2);
                 datos[2] = String.valueOf(rs.getInt(3));
                 datos[3] = String.valueOf(rs.getInt(4));
                 datos[4] = rs.getString(5);
                 
                 modeloInventario.addRow(datos);
             }
             
             paramTablaInventario.setModel(modeloInventario);
         } catch (Exception e){
             JOptionPane.showMessageDialog(null, "No se pudieron mostrar los registros, error: "+e.toString());
         }
    }
     
    public void seleccionarProductos(JTable paramTablaInventario,JTextField paramIdProducto, JTextField paramNombreProducto, JTextField paramExistencias, JTextField paramCodigoBarras, JTextField paramCategoria){
        
        try{
            int fila = paramTablaInventario.getSelectedRow();
            if(fila >=0){
                paramIdProducto.setText(( (paramTablaInventario.getValueAt(fila, 0).toString())));
                paramNombreProducto.setText( (paramTablaInventario.getValueAt(fila, 1).toString()));
                paramExistencias.setText( (paramTablaInventario.getValueAt(fila, 2).toString()));
                paramCodigoBarras.setText((paramTablaInventario.getValueAt(fila, 3).toString()));
                paramCategoria.setText( (paramTablaInventario.getValueAt(fila, 4).toString()));
                
            } else {
                JOptionPane.showMessageDialog(null, "La fila no se pudo seleccionar correctamente");
            }
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, "La fila no se pudo seleccionar correctamente: "+e.toString());
        }
    }
    
    public void modificarProductos(JTextField paramIdProducto, JTextField paramNombreProducto, JTextField paramExistencias, JTextField paramCodigoBarras, JTextField paramCategoria ){
        
        setId(Integer.parseInt(paramIdProducto.getText()));
        setNombreProducto(paramNombreProducto.getText());
        setCantidadExistencia(Integer.parseInt(paramExistencias.getText()));
        setCodigoBarras(Integer.parseInt(paramCodigoBarras.getText()));
        setCategoria(paramCategoria.getText());
    
        connection objetoConexion = new connection();
        
        String consulta = "UPDATE inventario SET nombre_producto = ?, cantidad_existencia = ?, codigo_barras = ?, categoria = ? WHERE id = ?;";
        
        try{
            CallableStatement cs = objetoConexion.conectar().prepareCall(consulta);
            
            cs.setString(1, getNombreProducto());
            cs.setInt(2, getCantidadExistencia());
            cs.setInt(3, getCodigoBarras());
            cs.setString(4, getCategoria());
            cs.setInt(5, getId());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Modificacion exitosa!");
            
            
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudo realizar la modificacion, error: "+e.toString());
        }
        
    }
    
    public void eliminarProductos(JTextField paramIdProducto){
        
        setId(Integer.parseInt(paramIdProducto.getText()));
        
        connection objetoConexion = new connection();
        
        String consulta = "delete from inventario where id=?;";
        
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
