package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SqlUsuarios extends CConexion{


    public boolean registrar(CRegistro usr) throws SQLException{
        
        
        PreparedStatement ps = null;
        Connection conectar = estableceConexion(); 
        
        String sql = "INSERT INTO usuarios (usuario, password, nombre) VALUES(?,?,?)";
        
        try{
            
            ps = conectar.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            ps.setString(2, usr.getNombre());
            ps.setString(3, usr.getPassword());
            ps.execute();
            return true;
            
        }catch(SQLException ex){
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
         
    }
    
}
