package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author phoenix055
 *///Extiende Conexion para evitar tener que crear muchos objetos de tipo conexion,...
public class ConsultasProducto extends Conexion{
    //REGISTRAR
    public boolean registrar(Producto p){
        PreparedStatement ps = null;
        Connection conn = getConnection();
        String sql = "INSERT INTO tienda(codigo, nombre, precio, cantidad, fecha)VALUES(?, ?, ?, ?, ?)";
        try {
            //
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getCantidad());
            ps.setString(5, p.getFecha());
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.getMessage();
            System.out.println(e.getMessage()+" Error: "+e.getStackTrace());
            return false;
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.getMessage();
                System.out.println(ex.getMessage()+" Error: "+ex.getStackTrace());
                Logger.getLogger(ConsultasProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//finally
    }//
    //
    //MODIFICAR
    public boolean modificar(Producto pro){
        PreparedStatement ps = null;
        Connection conn = getConnection();
        String sql = "UPDATE tienda SET codigo=?, nombre=?, precio=?, cantidad=?, fecha=? WHERE id=?";
        //Enviar los datos
        try {
            //
            ps = conn.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getCantidad());
            ps.setString(5, pro.getFecha());
            ps.setInt(6, pro.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            e.getMessage();
            System.out.println(e.getMessage()+" Error: "+e.getStackTrace());
            return false;
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.getMessage();
                System.out.println(ex.getMessage()+" Error: "+ex.getStackTrace());
            }
        }//
    }//
    //
    //ELIMINAR
    public boolean eliminar(Producto pro){
        PreparedStatement ps = null;
        Connection conn = getConnection();
        String sql = "Delete FROM tienda WHERE id=?";
        //Enviar los datos
        try {
            //
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.getMessage();
            System.out.println(e.getMessage()+" Error: "+e.getStackTrace());
            return false;
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.getMessage();
                System.out.println(ex.getMessage()+" Error: "+ex.getStackTrace());
                Logger.getLogger(ConsultasProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//
    }//
    //
    //BUSCAR
    public boolean buscar(Producto pro){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnection();
        String sql = "SELECT * FROM tienda WHERE codigo=?";
        //Enviar los datos
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            rs = ps.executeQuery();
            if(rs.next()){
                //Agregar valores al modelo...
                pro.setId(Integer.parseInt(rs.getString("id")));
                pro.setCodigo(rs.getString("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(Double.parseDouble(rs.getString("precio")));
                pro.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                pro.setFecha(rs.getString("fecha"));
                return true;
            }//
            return false;
        } catch (Exception e) {
            e.getMessage();
            System.out.println(e.getMessage()+" Error: "+e.getStackTrace());
            return false;
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.getMessage();
                System.out.println(ex.getMessage()+" Error: "+ex.getStackTrace());
            }
        }//
    }//
}
