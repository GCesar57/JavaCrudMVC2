/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.vPrincipal;
import view.vProducto;

/**
 *
 * @author phoenix055
 */
public class ControladorPrincipal implements ActionListener{
    private vPrincipal frmPri;
    private vProducto frmPro;
    //

    public ControladorPrincipal(vPrincipal frmPri, vProducto frmPro) {
        this.frmPri = frmPri;
        this.frmPro = frmPro;
        this.frmPri.menuProducto.addActionListener(this);
        this.frmPri.MenuSalir.addActionListener(this);
    }
    //
    public void iniciar(){
        frmPro.setTitle("Producto.");
        frmPri.setTitle("Menu Principal.");
        frmPro.setLocationRelativeTo(null);
        frmPri.setLocationRelativeTo(null);
    }//
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //
        if(e.getSource() == frmPri.menuProducto){
            frmPro.setVisible(true);
            frmPri.dispose();
        }//
        if(e.getSource()== frmPri.MenuSalir){
            System.exit(0);
        }//
    }
}
