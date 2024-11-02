/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datosGenerales;

import interfaces.connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EventObject;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class CEmpleados {
    private DefaultTableModel modeloEmpleados;
    String nombreUsuario;
    int id;
    String email;
    String puesto;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
     public void mostrarEmpleados(JTable paramTablaEmpleados){
         
         connection objetoConexion = new connection();
        
         modeloEmpleados = new DefaultTableModel();
         
         TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<TableModel>(modeloEmpleados);
         paramTablaEmpleados.setRowSorter(ordenarTabla);
         
         String sql = "";
         
         modeloEmpleados.addColumn("No. Empleado");
         modeloEmpleados.addColumn("Nombre");
         modeloEmpleados.addColumn("Email");
         modeloEmpleados.addColumn("Puesto");
         
         
         
         paramTablaEmpleados.setModel(modeloEmpleados);
         
         sql = "select * from empleados";
         
         String [] datos = new String[4];
         
         
         try{
            java.sql.Statement st = objetoConexion.conectar().createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
                 datos[0] = String.valueOf(rs.getInt(1));
                 datos[1] = rs.getString(2);
                 datos[2] = rs.getString(3);
                 datos[3] = rs.getString(4);
              
                 modeloEmpleados.addRow(datos);
             }
             
             paramTablaEmpleados.setModel(modeloEmpleados);
         } catch (Exception e){
             JOptionPane.showMessageDialog(null, "No se pudieron mostrar los registros, error: "+e.toString());
         }
    }
     
    public void seleccionarEmpleados(JTable paramTablaEmpleados,JTextField paramIdEmpleado, JTextField paramNombre, JTextField paramEmail, JTextField paramPuesto){
        
        try{
            int fila = paramTablaEmpleados.getSelectedRow();
            if(fila >=0){
                paramIdEmpleado.setText(( (paramTablaEmpleados.getValueAt(fila, 0).toString())));
                paramNombre.setText( (paramTablaEmpleados.getValueAt(fila, 1).toString()));
                paramEmail.setText( (paramTablaEmpleados.getValueAt(fila, 2).toString()));
                paramPuesto.setText((paramTablaEmpleados.getValueAt(fila, 3).toString()));
                
            } else {
                JOptionPane.showMessageDialog(null, "La fila no se pudo seleccionar correctamente");
            }
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, "La fila no se pudo seleccionar correctamente: "+e.toString());
        }
    }
    
    
     public void insertarEmpleado(JTextField paramNombre, JTextField paramEmail, JTextField paramPuesto){
        
        setNombreUsuario(paramNombre.getText());
        setEmail(paramEmail.getText());
        setPuesto(paramPuesto.getText());
        

        
        connection objetoConexion = new connection();
        
        String consulta = "insert into empleados (nombre_empleado, email, puesto) values(?, ?, ?);";
        try{
            CallableStatement cs = objetoConexion.conectar().prepareCall(consulta);
          
            cs.setString(1,getNombreUsuario());
            cs.setString(2, getEmail());
            cs.setString(3,getPuesto());
           
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se insertó correctamente el producto.");
            //paramIdProducto.setText("");
            paramNombre.setText("");
            paramEmail.setText("");
            paramPuesto.setText("");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se insertó el producto, error: "+e.toString());
            
        }   
       
    }
    
    
    public void modificarEmpleados(JTextField paramIdProducto, JTextField paramNombre, JTextField paramEmail, JTextField paramPuesto){
        
        setId(Integer.parseInt(paramIdProducto.getText()));
        setNombreUsuario(paramNombre.getText());
        setEmail(paramEmail.getText());
        setPuesto(paramPuesto.getText());
    
        connection objetoConexion = new connection();
        
        String consulta = "UPDATE empleados SET nombre_empleado = ?, email = ?, puesto = ? WHERE id = ?;";
        
        try{
            CallableStatement cs = objetoConexion.conectar().prepareCall(consulta);
            
            cs.setString(1, getNombreUsuario());
            cs.setString(2, getEmail());
            cs.setString(3, getPuesto());
            cs.setInt(4, getId());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Modificacion exitosa!");
            
            
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudo realizar la modificacion, error: "+e.toString());
        }
        
    }
    
    public void eliminarEmpleados(JTextField paramIdEmpleado){
        
        setId(Integer.parseInt(paramIdEmpleado.getText()));
        
        connection objetoConexion = new connection();
        
        String consulta = "delete from empleados where id=?;";
        
        try{
            CallableStatement cs = objetoConexion.conectar().prepareCall(consulta);
            
            cs.setInt(1, getId());
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el empleado seleccionado");
        } catch (SQLException e){
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar el empleado, error: "+e.toString());

        }
    }
    
    
    
    
   
}
