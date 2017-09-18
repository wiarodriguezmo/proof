/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.EntityManager;

/**
 *
 * @author williamvision
 */
public abstract class CrudDAO<E extends Entity> {
    private static final String usuario = "root";
    private static final String contrasena = "villavo23.";
    //private final String url = "jdbc:mysql://localhost:3306/bienestar";
    private static final String url = "jdbc:mysql://localhost:3306/beitechDB?zeroDateTimeBehavior=convertToNull";
    private static Connection conn;

    protected abstract E toEntity(ResultSet rs )throws Exception;
    
    private static boolean iniciarConeccion(){
        System.out.println("iniciarConexion");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, usuario, contrasena);
            return true;
        } catch (
            ClassNotFoundException |
            IllegalAccessException |
            InstantiationException |
            SQLException ex
        ) {
            Logger.getLogger(CrudDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private boolean cerrarConeccion(){
        System.out.println("cerrarConeccion");
        try {
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CrudDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

	/**
	 * Use esta funcion para los gets
	 * @param query
	 * @param values
	 * @return 
	 */
    protected static ResultSet query(String query, String[] values){
        if(conn == null)
            iniciarConeccion();
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            for (int i = 0; i < values.length; i++)
                ps.setString(i+1, values[i]);
            return ps.executeQuery();
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }

	/**
	 * Use esta funcion para los sets y deletes
	 * @param query
	 * @param values
	 * @return 
	 */
    protected static String update(String query, String[] values){
        if(conn == null)
            iniciarConeccion();
        try{
            PreparedStatement ps = conn.prepareStatement(query);
            for (int i = 0; i < values.length; i++)
                ps.setString(i+1, values[i]);
            ps.executeUpdate();
			return "OK";
        }
        catch (SQLException ex){
            System.out.println("CrudDAO.update: " + ex.getMessage());
            return ex.getMessage();
        }
    }

    protected abstract Class getEntityClass();
    
}
