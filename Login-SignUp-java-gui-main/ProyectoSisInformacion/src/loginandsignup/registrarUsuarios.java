/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginandsignup;

import loginandsignup.connection;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class registrarUsuarios {
    
    String usuario;
    String email;
    String pass;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public void registrarUsuarios(JTextField paramUsuario, JTextField paramEmail, JTextField paramContrasena){
        
        setUsuario(paramUsuario.getText());
        setEmail(paramEmail.getText());
        setPass(paramContrasena.getText());
        
        connection objetoConexion = new connection();
        
        String consulta = "insert into usuarios (nombre_usuario, email, contraseña) values(?, ?, ?);";
        
        try{
            CallableStatement cs = objetoConexion.conectar().prepareCall(consulta);
          
            cs.setString(1,getUsuario());
            cs.setString(2, getEmail());
            cs.setString(3,getPass());
            
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Usuario creado correctamente");    
            paramUsuario.setText("");
            paramEmail.setText("");
            paramContrasena.setText("");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo crear el usuario, error: "+e.toString());
            
        }
    
    }
}
