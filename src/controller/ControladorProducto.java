
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import model.ConsultasProducto;
import model.Producto;
import view.vProducto;

/**
 *
 * @author phoenix055
 *///Comunucar interfaz grafica con el modelo...
public class ControladorProducto implements ActionListener{
    private Producto pro;
    private vProducto frmProducto;
    private ConsultasProducto proC;
    //

    public ControladorProducto(Producto pro, vProducto frmProducto, ConsultasProducto proC) {
        this.pro = pro;
        this.frmProducto = frmProducto;
        this.proC = proC;
        this.frmProducto.btnAgregar.addActionListener(this);
        this.frmProducto.btnBuscar.addActionListener(this);
        this.frmProducto.btnEliminar.addActionListener(this);
        this.frmProducto.btnLimpiar.addActionListener(this);
        this.frmProducto.btnModificar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
        if(e.getSource()==frmProducto.btnAgregar){
            //Tomar los valores de la caja de texto para madarlos al modelo...
            pro.setCodigo(frmProducto.txtCodigo.getText());
            pro.setNombre(frmProducto.txtNombre.getText());
            pro.setPrecio(Double.parseDouble(frmProducto.txtPrecio.getText()));
            pro.setCantidad(Integer.parseInt(frmProducto.txtCantidad.getText()));
            //
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String startDateString = dateFormat.format(frmProducto.jDateChooser1.getDate());
            pro.setFecha(startDateString);
            //
            if(proC.registrar(pro)){
                JOptionPane.showMessageDialog(null, "Registro Insertado con exito...");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error Insertado con exito...");
                limpiar();
            }//
        }//
        //
        //BTN MODIFICAR
        //Modificar...
        if(e.getSource()==frmProducto.btnModificar){
            //Tomar los valores de la caja de texto para madarlos al modelo...
            pro.setId(Integer.parseInt(frmProducto.txtId.getText()));
            pro.setCodigo(frmProducto.txtCodigo.getText());
            pro.setNombre(frmProducto.txtNombre.getText());
            pro.setPrecio(Double.parseDouble(frmProducto.txtPrecio.getText()));
            pro.setCantidad(Integer.parseInt(frmProducto.txtCantidad.getText()));
            //
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String startDateString = dateFormat.format(frmProducto.jDateChooser1.getDate());
            pro.setFecha(startDateString);
            //
            if(proC.modificar(pro)){
                JOptionPane.showMessageDialog(null, "Registro Modificado con exito...");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error Modificando con exito...");
                limpiar();
            }//
        }//
        //
        //Eliminar
        if(e.getSource()==frmProducto.btnEliminar){
            //Tomar los valores de la caja de texto para madarlos al modelo...
            pro.setId(Integer.parseInt(frmProducto.txtId.getText()));
            //
            if(proC.eliminar(pro)){
                JOptionPane.showMessageDialog(null, "Registro Eliminado con exito...");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error Eliminando con exito...");
                limpiar();
            }//
        }//
        //
        //
        if(e.getSource()==frmProducto.btnBuscar){
            pro.setCodigo(frmProducto.txtCodigo.getText());
            //
            if(proC.buscar(pro)){
                frmProducto.txtId.setText(String.valueOf(pro.getId()));
                frmProducto.txtCodigo.setText(pro.getCodigo());
                frmProducto.txtNombre.setText(pro.getNombre());
                frmProducto.txtPrecio.setText(String.valueOf(pro.getPrecio()));
                frmProducto.txtCantidad.setText(String.valueOf(pro.getCantidad()));
                frmProducto.jDateChooser1.setDate(Date.valueOf(pro.getFecha()));
            }else{
                JOptionPane.showMessageDialog(null, "Error no se encontro resultado...");
                //limpiar();
            }//
        }//
        if(e.getSource()==frmProducto.btnLimpiar){limpiar();}//
    }
    //
    
    //
    //Limpiar formulario
    public void limpiar(){
        frmProducto.txtId.setText(null);
        frmProducto.txtCodigo.setText(null);
        frmProducto.txtNombre.setText(null);
        frmProducto.txtPrecio.setText(null);
        frmProducto.txtCantidad.setText(null);
        frmProducto.jDateChooser1.setDate(null);
    }//
}
