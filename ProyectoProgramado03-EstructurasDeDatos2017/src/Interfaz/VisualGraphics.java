package Interfaz;

//Bibliotecas a usar

import Controlador.LoginManager;
import Estructura.Grafo;
import Programa.IConstants;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
/**
 *
 * @author live y edgerik
 */
public class VisualGraphics extends javax.swing.JFrame 
{
    //Variables globales
    private Image dbImage , icono;
    private final Toolkit tools;
    private GeoMap aux;
    private Graphics dbg;
    private Grafo grafo;
    private boolean sacarCarta, throwDice;
    private Ranking rank;
    private LoginManager login;
    /**
     * Constructor
     */
    public VisualGraphics() 
    {
        initComponents();
        this.rank = new Ranking();
        tools = Toolkit.getDefaultToolkit();
        //Imagen default por si no se logra cargar png (poco probable)
        this.sacarCarta = false;
        this.aux = null;
    }
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nam1 = new javax.swing.JLabel();
        name2 = new javax.swing.JLabel();
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
        canvas = new javax.swing.JPanel();
        lblDice = new javax.swing.JLabel();
        apiProgress = new javax.swing.JProgressBar();
        boton_ranking = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblvisitasA = new javax.swing.JLabel();
        lblvisitasB = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblvisitasTotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblEstadoApi = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setFont(new java.awt.Font("Comic Sans MS", 2, 18)); // NOI18N
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(1550, 900));

        nam1.setText("Jugador A");

        name2.setText("Jugador B");

        jLabel2.setText("->Ranking Global");

        lblRateA.setText("rating A");

        lblRateB.setText("rating B");

        jLabel1.setText("->Partida Actual");

        lblPuntosA.setText("PuntosA");

        lblPuntosB.setText("PuntosB");

        sacarCartaA.setText("Sacar Carta");
        sacarCartaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sacarCartaAActionPerformed(evt);
            }
        });

        jLabel3.setText("Reto Actual");

        lblRetoA.setText("RetoA");

        lblRetoB.setText("RetoB");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "500", "1000", "1500" }));
        jComboBox1.setSelectedIndex(1);
        jComboBox1.setToolTipText("");

        jLabel5.setText("->Radio Juego");

        jButton1.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jButton1.setText("TIRAR DADO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblturno.setText("TURNO DE: A");

        jLabel4.setText("PROGRESO");

        canvas.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));

        javax.swing.GroupLayout canvasLayout = new javax.swing.GroupLayout(canvas);
        canvas.setLayout(canvasLayout);
        canvasLayout.setHorizontalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1498, Short.MAX_VALUE)
        );
        canvasLayout.setVerticalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 799, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(canvas);

        lblDice.setText("DICE : ");

        boton_ranking.setText("Ranking");
        boton_ranking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_rankingActionPerformed(evt);
            }
        });

        jLabel6.setText("->Nodos Visitados Partida");

        lblvisitasA.setText("visitasA");

        lblvisitasB.setText("visitasB");

        jLabel12.setText("->Players");

        lblvisitasTotal.setText("visitasTotal");

        jLabel7.setText("Total Visitas");

        lblEstadoApi.setText("estadoAPI");

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Ver Ranking");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Menu");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblRateB)
                                        .addGap(55, 55, 55)
                                        .addComponent(lblPuntosB))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(nam1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblRateA)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblPuntosA)))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblvisitasA)
                                    .addComponent(lblvisitasB)))
                            .addComponent(lblvisitasTotal))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEstadoApi)
                                .addGap(35, 35, 35)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton_ranking)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(sacarCartaA)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblturno)
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(lblDice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lblRetoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRetoA, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(25, 25, 25))
                    .addComponent(progressB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(apiProgress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblRetoA)
                                .addGap(18, 18, 18)
                                .addComponent(lblRetoB))
                            .addComponent(lblturno)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(29, 29, 29)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblEstadoApi))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel6))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(sacarCartaA, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(nam1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblPuntosA)
                                                            .addComponent(lblRateA)
                                                            .addComponent(lblvisitasA))
                                                        .addGap(9, 9, 9))
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblvisitasTotal)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblRateB)
                                                    .addComponent(lblPuntosB)
                                                    .addComponent(lblvisitasB)))))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(boton_ranking, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblDice))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(progressA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(progressB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apiProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sacarCartaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sacarCartaAActionPerformed

        // TODO add your handling code here:
        sacarCarta = true;
    }//GEN-LAST:event_sacarCartaAActionPerformed

    public void setLogin(LoginManager login) {
        this.login = login;
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // TODO add your handling code here:
        throwDice = true;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void boton_rankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_rankingActionPerformed
        // TODO add your handling code here:
        
        rank.setVisible(true);
        String result = null;
        result = login.botonR();
        //System.out.println("Imprime rank");
        //System.out.println(result);
        rank.getRanking().setText(result);
        
    }//GEN-LAST:event_boton_rankingActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        //Hago la interfaz menu true
        //.getMenu().setVisible(true);
        
               
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    

    //Gets and Sets--------------------------------------------------------
    public Ranking getRank() {
        return rank;
    }

    public void setRank(Ranking rank) {    
        this.rank = rank;
    }

    public void setName1(String pName1) {
        this.nam1.setText(pName1);
    }
    public void setName2(String pName2) {
        this.name2.setText(pName2);
    }
    public Image getIcono() {
        return icono;
    }
    public Graphics getDbg() {
        return dbg;
    }
    public Grafo getGrafo() {
        return grafo;
    }
    public boolean isSacarCarta() {
        return sacarCarta;
    }
    public JButton getjButton1() {

        return jButton1;

    }

    public JComboBox<String> getjComboBox1() {

        return jComboBox1;

    }

    public JLabel getLblA() {

        return nam1;

    }

    public JLabel getLblB() {

        return name2;

    }

    public JLabel getLblPuntosA() {

        return lblPuntosA;

    }

    public JLabel getLblPuntosB() {

        return lblPuntosB;

    }

    public JProgressBar getApiProgress() {

        return apiProgress;

    }

    public JLabel getLblDice() {

        return lblDice;

    }

    public JLabel getLblRateA() {

        return lblRateA;

    }

    public JLabel getLblRateB() {

        return lblRateB;

    }

    public JLabel getLblRetoA() {

        return lblRetoA;

    }

    public JLabel getLblRetoB() {

        return lblRetoB;

    }

    public JLabel getLblturno() {

        return lblturno;

    }

    public JProgressBar getProgressA() {

        return progressA;

    }

    public JProgressBar getProgressB() {

        return progressB;

    }

    public JButton getSacarCartaA() {

        return sacarCartaA;

    }

    public void setDbg(Graphics dbg) {

        this.dbg = dbg;

    }

    public void setGrafo(Grafo grafo) {

        this.grafo = grafo;

    }

    public void setSacarCarta(boolean sacarCarta) {

        this.sacarCarta = sacarCarta;

    }

    public void setjComboBox1(JComboBox<String> jComboBox1) {

        this.jComboBox1 = jComboBox1;

    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {

        this.jScrollPane1 = jScrollPane1;

    }

    public void setLblA(JLabel lblA) {

        this.nam1 = lblA;

    }

    public void setLblB(JLabel lblB) {

        this.name2 = lblB;

    }

    public void setLblPuntosA(JLabel lblPuntosA) {

        this.lblPuntosA = lblPuntosA;

    }

    public void setLblPuntosB(JLabel lblPuntosB) {

        this.lblPuntosB = lblPuntosB;

    }

    public void setLblRateA(JLabel lblRateA) {

        this.lblRateA = lblRateA;

    }

    public void setLblRateB(JLabel lblRateB) {

        this.lblRateB = lblRateB;

    }

    public void setLblRetoA(JLabel lblRetoA) {

        this.lblRetoA = lblRetoA;

    }

    public void setLblRetoB(JLabel lblRetoB) {

        this.lblRetoB = lblRetoB;

    }

    public void setLblturno(JLabel lblturno) {

        this.lblturno = lblturno;

    }

    public void setProgressA(JProgressBar progressA) {

        this.progressA = progressA;

    }

    public void setProgressB(JProgressBar progressB) {

        this.progressB = progressB;

    }

    public void setSacarCartaA(JButton sacarCartaA) {

        this.sacarCartaA = sacarCartaA;

    }

    public boolean isThrowDice() {

        return throwDice;

    }

    public void setThrowDice(boolean throwDice) {

        this.throwDice = throwDice;

    }

    public void cartaDesplegada()

    {

        setSacarCarta(false);

    }

    public void setAux(GeoMap aux) {

        this.aux = aux;

    }
    
    public GeoMap getAux() {
        return aux;
    }

    /**
     * Si cambia el observable, los observer deben actualizarse
     * @param obj Instancia a cambiar
     */

    public void update(Object obj) {

        grafo = (Grafo) obj;

    }

    //Dibujo--------------------------------------------------------------------

    public void paneDB()
    {
        dbImage = createImage(IConstants.panelWidth, IConstants.panelHeight);
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        canvas.getGraphics().drawImage(dbImage, 0, 0, this);
    }

    public void paintComponent(Graphics g)
    {
        try{
            aux.paintTablero(g);
        }catch(NullPointerException e){}
    }

    /**
     * Main interfaz principal
     * @param args the command line arguments
     */

    public static void main(String args[]) 
    {

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

            java.util.logging.Logger.getLogger(VisualGraphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {

            java.util.logging.Logger.getLogger(VisualGraphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {

            java.util.logging.Logger.getLogger(VisualGraphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {

            java.util.logging.Logger.getLogger(VisualGraphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }

        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualGraphics().setVisible(true);
            }
        });
    }

    public JLabel getLblvisitasA() {
        return lblvisitasA;
    }

    public void setLblvisitasA(JLabel lblvisitasA) {
        this.lblvisitasA = lblvisitasA;
    }

    public JLabel getLblvisitasB() {
        return lblvisitasB;
    }

    public JLabel getLblEstadoApi() {
        return lblEstadoApi;
    }

    public void setLblvisitasB(JLabel lblvisitasB) {
        this.lblvisitasB = lblvisitasB;
    }

    public JLabel getLblvisitasTotal() {
        return lblvisitasTotal;
    }

    public void setLblvisitasTotal(JLabel lblvisitasTotal) {
        this.lblvisitasTotal = lblvisitasTotal;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar apiProgress;
    private javax.swing.JButton boton_ranking;
    private javax.swing.JPanel canvas;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDice;
    private javax.swing.JLabel lblEstadoApi;
    private javax.swing.JLabel lblPuntosA;
    private javax.swing.JLabel lblPuntosB;
    private javax.swing.JLabel lblRateA;
    private javax.swing.JLabel lblRateB;
    private javax.swing.JLabel lblRetoA;
    private javax.swing.JLabel lblRetoB;
    private javax.swing.JLabel lblturno;
    private javax.swing.JLabel lblvisitasA;
    private javax.swing.JLabel lblvisitasB;
    private javax.swing.JLabel lblvisitasTotal;
    private javax.swing.JLabel nam1;
    private javax.swing.JLabel name2;
    private javax.swing.JProgressBar progressA;
    private javax.swing.JProgressBar progressB;
    private javax.swing.JButton sacarCartaA;
    // End of variables declaration//GEN-END:variables



}