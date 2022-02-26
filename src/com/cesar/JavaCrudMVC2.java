/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar;

import controller.ControladorPrincipal;
import controller.ControladorProducto;
import model.Conexion;
import model.ConsultasProducto;
import model.Producto;
import view.vPrincipal;
import view.vProducto;

/**
 *
 * @author phoenix055
 */
public class JavaCrudMVC2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Conexion conn = new Conexion();
        //conn.getConnection();
        Producto pro = new Producto();
        ConsultasProducto prodC = new ConsultasProducto();
        vProducto frmPro = new vProducto();
        ControladorProducto controlPro = new ControladorProducto(pro, frmPro, prodC);
        vPrincipal frmPri = new vPrincipal();
        ControladorPrincipal controlPri = new ControladorPrincipal(frmPri, frmPro);
        controlPri.iniciar();
        frmPri.setVisible(true);
    }
    
}
