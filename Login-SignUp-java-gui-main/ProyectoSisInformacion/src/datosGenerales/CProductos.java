/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datosGenerales;


import java.sql.CallableStatement;
import javax.swing.JTextField;
import loginandsignup.connection;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CProductos {
    private DefaultTableModel modeloProductos;
    String nombreProducto;
    double precio;
    String estado;
    String categoria;
    int id;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public void insertarProducto(JTextField paramNombre, JTextField paramPrecio, JTextField paramEstado, JTextField paramCategoria ){
        setNombreProducto(paramNombre.getText());
        setPrecio(Double.parseDouble(paramPrecio.getText()));
        setEstado(paramEstado.getText());
        setCategoria(paramCategoria.getText());
        
        connection objetoConexion = new connection();
        
        String consulta = "insert into productos (nombre_producto, precio, estado, categoria) values(?, ?, ?, ?);";
        try{
            CallableStatement cs = objetoConexion.conectar().prepareCall(consulta);
          
            cs.setString(1,getNombreProducto());
            cs.setDouble(2, getPrecio());
            cs.setString(3,getEstado());
            cs.setString(4,getCategoria());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se insertó correctamente el producto.");
            //paramIdProducto.setText("");
            paramNombre.setText("");
            paramPrecio.setText("");
            paramEstado.setText("");
            paramCategoria.setText("");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se insertó el producto, error: "+e.toString());
            
        }    
        
       
    }
    
     public void mostrarProductos(JTable paramTablaProductos){
         
         connection objetoConexion = new connection();
    
          modeloProductos = new DefaultTableModel();
         
         TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<TableModel>(modeloProductos);
         paramTablaProductos.setRowSorter(ordenarTabla);
         
         String sql = "";
         
         modeloProductos.addColumn("Código");
         modeloProductos.addColumn("Nombre");
         modeloProductos.addColumn("Precio Unitario");
         modeloProductos.addColumn("Estado");
         modeloProductos.addColumn("Categoría");
         
         paramTablaProductos.setModel(modeloProductos);
         
         sql = "select * from productos";
         
         String [] datos = new String[5];
         
         
         try{
            java.sql.Statement st = objetoConexion.conectar().createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
                 datos[0] = String.valueOf(rs.getInt(1));
                 datos[1] = rs.getString(2);
                 datos[2] = String.valueOf(rs.getDouble(3));
                 datos[3] = rs.getString(4);
                 datos[4] = rs.getString(5);
                 
                 modeloProductos.addRow(datos);
             }
             
             paramTablaProductos.setModel(modeloProductos);
         } catch (Exception e){
             JOptionPane.showMessageDialog(null, "No se pudieron mostrar los registros, error: "+e.toString());
         }
    }
     
    public void seleccionarProductos(JTable paramTablaProductos,JTextField paramIdProducto, JTextField paramNombreProducto, JTextField paramPrecio, JTextField paramEstado, JTextField paramCategoria){
        
        try{
            int fila = paramTablaProductos.getSelectedRow();
            if(fila >=0){
                paramIdProducto.setText(( (paramTablaProductos.getValueAt(fila, 0).toString())));
                paramNombreProducto.setText( (paramTablaProductos.getValueAt(fila, 1).toString()));
                paramPrecio.setText( (paramTablaProductos.getValueAt(fila, 2).toString()));
                paramEstado.setText((paramTablaProductos.getValueAt(fila, 3).toString()));
                paramCategoria.setText( (paramTablaProductos.getValueAt(fila, 4).toString()));
                
            } else {
                JOptionPane.showMessageDialog(null, "La fila no se pudo seleccionar correctamente");
            }
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, "La fila no se pudo seleccionar correctamente: "+e.toString());
        }
    }
    
    public void modificarProductos(JTextField paramIdProducto, JTextField paramNombreProducto, JTextField paramPrecio, JTextField paramEstado, JTextField paramCategoria ){
        
        setId(Integer.parseInt(paramIdProducto.getText()));
        setNombreProducto(paramNombreProducto.getText());
        setPrecio(Double.parseDouble(paramPrecio.getText()));
        setEstado(paramEstado.getText());
        setCategoria(paramCategoria.getText());
        
        connection objetoConexion = new connection();
        
        String consulta = "UPDATE productos SET nombre_producto = ?, precio = ?, estado = ?, categoria = ? WHERE id = ?;";
        
        try{
            CallableStatement cs = objetoConexion.conectar().prepareCall(consulta);
            
            cs.setString(1, getNombreProducto());
            cs.setDouble(2, getPrecio());
            cs.setString(3, getEstado());
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
        
        String consulta = "delete from productos where id=?;";
        
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
