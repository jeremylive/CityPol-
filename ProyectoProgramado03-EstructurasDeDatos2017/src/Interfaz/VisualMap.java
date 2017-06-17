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
public class VisualMap extends javax.swing.JFrame implements Observer{

    private Image dbImage , icono;
    private Toolkit tools;
    private Graphics dbg;
    private Grafo grafo;
    
    /**
     * Creates new form GrafoGUI
     */
    public VisualMap() 
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblA = new javax.swing.JLabel();
        lblB = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblRateA = new javax.swing.JLabel();
        lblRateB = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblPuntosA = new javax.swing.JLabel();
        lblPuntosB = new javax.swing.JLabel();
        sacarCartaA = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblRetoA = new javax.swing.JLabel();
        lblRetoB = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblturno = new javax.swing.JLabel();
        progressA = new javax.swing.JProgressBar();
        progressB = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setSize(new java.awt.Dimension(1550, 900));

        lblA.setText("Jugador A");

        lblB.setText("Jugador B");

        jLabel2.setText("Ranking Global");

        lblRateA.setText("rating A");

        lblRateB.setText("rating B");

        jLabel1.setText("Partida Actual");

        lblPuntosA.setText("PuntosA");

        lblPuntosB.setText("PuntosB");

        sacarCartaA.setText("Sacar Carta");

        jLabel3.setText("Reto Actual");

        lblRetoA.setText("RetoA");

        lblRetoB.setText("RetoB");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "500", "1000", "1500" }));
        jComboBox1.setSelectedIndex(1);
        jComboBox1.setToolTipText("");

        jLabel5.setText("Radio Juego");

        jButton1.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jButton1.setText("TIRAR DADO");

        lblturno.setText("TURNO DE: A");

        jLabel4.setText("PROGRESO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel2)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblB, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblRateB)
                                    .addGap(55, 55, 55)
                                    .addComponent(lblPuntosB))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblA, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblRateA)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPuntosA))))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(sacarCartaA))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblturno)
                            .addComponent(jButton1))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(lblRetoA, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(lblRetoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(progressA, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                    .addComponent(progressB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(150, 150, 150))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblA, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPuntosA)
                                    .addComponent(lblRateA)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(progressA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblRetoA))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRateB)
                            .addComponent(lblPuntosB)
                            .addComponent(lblRetoB)
                            .addComponent(progressB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblturno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sacarCartaA)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VisualMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualMap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblB;
    private javax.swing.JLabel lblPuntosA;
    private javax.swing.JLabel lblPuntosB;
    private javax.swing.JLabel lblRateA;
    private javax.swing.JLabel lblRateB;
    private javax.swing.JLabel lblRetoA;
    private javax.swing.JLabel lblRetoB;
    private javax.swing.JLabel lblturno;
    private javax.swing.JProgressBar progressA;
    private javax.swing.JProgressBar progressB;
    private javax.swing.JButton sacarCartaA;
    // End of variables declaration//GEN-END:variables

    
    public void update(Grafo arg) {
        grafo = arg;
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
