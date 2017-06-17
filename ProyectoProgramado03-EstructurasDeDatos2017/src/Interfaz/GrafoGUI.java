/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Estructura.Borde;
import Estructura.Grafo;
import Estructura.NodoGrafo;
import Programa.IConstants;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.ConcurrentModificationException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;

/**
 *
 * @author Curso
 */
public class GrafoGUI extends javax.swing.JFrame implements Observer{

    private Image dbImage , icono;
    private Toolkit tools;
    private Graphics dbg;
    private Grafo grafo;
    
    /**
     * Creates new form GrafoGUI
     */
    public GrafoGUI() 
    {
        initComponents();
        tools = Toolkit.getDefaultToolkit();
        icono = tools.getImage("C:\\Users\\JUaNIGNaCIO\\Desktop\\foto.jpg");
        icono = icono.getScaledInstance(IConstants.medidaNodo * IConstants.escalaImagen, IConstants.medidaNodo * IConstants.escalaImagen, Image.SCALE_SMOOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        PanelGrafo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setSize(new java.awt.Dimension(1550, 900));

        PanelGrafo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelGrafoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelGrafoLayout = new javax.swing.GroupLayout(PanelGrafo);
        PanelGrafo.setLayout(PanelGrafoLayout);
        PanelGrafoLayout.setHorizontalGroup(
            PanelGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1980, Short.MAX_VALUE)
        );
        PanelGrafoLayout.setVerticalGroup(
            PanelGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PanelGrafoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelGrafoMouseClicked
        // TODO add your handling code here:
        int posX = evt.getX();
        int posY = evt.getY();
        System.out.println(posX + " , "+ posY);
        
    }//GEN-LAST:event_PanelGrafoMouseClicked

    @Override
    public void paint(Graphics g)
    {        
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }
    
    public int getMid(int origen, int destino){
        
        int diferencia;
        if(origen < destino)
            diferencia = destino - origen;
        else{
                diferencia = origen - destino;
                origen = destino;    
        }
        origen += diferencia /2;
        return origen;
    }
    
    public void paintComponent(Graphics g)
    {
        super.paint(g);
    
        //Pintado del grafo
        //g.setColor(Color.GREEN);
        int medida = IConstants.medidaNodo/2;
        int x,y;
        
        
        for (Borde conexion : grafo.getConexiones()) {
            g.setColor(Color.white);
            NodoGrafo origen = conexion.getOrigen();
            NodoGrafo destino = conexion.getDestino();
            //Dibuja la linea de origen a destino
            g.drawLine(origen.getPosX()+medida, origen.getPosY()+medida, destino.getPosX()+medida, destino.getPosY()+medida);
            
            x = getMid(origen.getPosX(), destino.getPosX());
            y = getMid(origen.getPosY(), destino.getPosY());
            
            //Pone el texto en medio del la linea con el peso correspondiente
            g.setColor(Color.black);
            g.drawString(Double.toString(conexion.getDistancia()),  x,  y);
        }
        medida *= 2;
        try{
            
        
            for(NodoGrafo nodo : grafo.getNodos())
            {
                //g.fillOval(nodo.getPosX(), nodo.getPosY(), medida * 5/4, medida);
                g.drawImage(nodo.getLugar().getFoto_lugar(), nodo.getPosX(), nodo.getPosY(), this);

                //g.setColor(Color.BLACK);
                g.drawString(nodo.getName(), nodo.getPosX()-(medida/4),nodo.getPosY()-(medida - medida/4) );
            }
        }catch(ConcurrentModificationException e)
        {
            System.out.println("Se ha cambiado el grafo");
        }
        
        
        
        
        repaint();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GrafoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GrafoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GrafoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GrafoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GrafoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelGrafo;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    
    public void update(Grafo arg) {
        grafo = arg;
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
