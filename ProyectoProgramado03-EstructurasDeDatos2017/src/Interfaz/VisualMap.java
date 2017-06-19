package Interfaz;
//Bibliotecas a usar
import Estructura.Grafo;
import Programa.IConstants;
import Programa.IObserver;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
<<<<<<< HEAD
=======
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
>>>>>>> b0330ab6432ecef622f826d61acba6af119deb28
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
/**
 *
 * @author live y edgerik
 */
public class VisualMap extends javax.swing.JFrame implements IObserver
{
    //Variables globales
    private Image dbImage , icono;
    private final Toolkit tools;
    private VisualGraphics aux;
    private Graphics dbg;
    private Grafo grafo;
    private boolean sacarCarta, throwDice;
    private Ranking rank;
    /**
     * Constructor
     */
    public VisualMap() 
    {
        initComponents();
        tools = Toolkit.getDefaultToolkit();
        //Imagen default por si no se logra cargar png (poco probable)
        sacarCarta = false;
        aux = null;
        this.rank = new Ranking();
        
    }
    //Gets and sets

    public Ranking getRank() {
        return rank;
    }

    public void setRank(Ranking rank) {
        this.rank = rank;
    }
    
    //
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblA = new javax.swing.JLabel();
        lblB = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ranking1 = new javax.swing.JLabel();
        ranking2 = new javax.swing.JLabel();
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
        m_ranking = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setFont(new java.awt.Font("Comic Sans MS", 2, 18)); // NOI18N
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        setSize(new java.awt.Dimension(1550, 900));

        lblA.setText("Jugador A");

        lblB.setText("Jugador B");

        jLabel2.setText("Ranking Global");

        ranking1.setText("rating A");

        ranking2.setText("rating B");

        jLabel1.setText("Partida Actual");

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

        jLabel5.setText("Radio Juego");

        jButton1.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jButton1.setText("TIRAR DADO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblturno.setText("TURNO DE: A");

        jLabel4.setText("PROGRESO");

<<<<<<< HEAD
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
=======
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
>>>>>>> b0330ab6432ecef622f826d61acba6af119deb28

        lblDice.setText("DICE : ");

        m_ranking.setText("Mostrar Ranking");
        m_ranking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_rankingActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Ver Ranking");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
<<<<<<< HEAD
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
                        .addComponent(sacarCartaA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDice)
                        .addGap(48, 48, 48)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblturno)
                    .addComponent(jButton1))
                .addGap(49, 49, 49)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(150, 150, 150))))
            .addComponent(apiProgress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
=======
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
                                    .addComponent(ranking2)
                                    .addGap(55, 55, 55)
                                    .addComponent(lblPuntosB))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblA, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ranking1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPuntosA))))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(sacarCartaA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDice)
                                .addGap(48, 48, 48))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(apiProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblturno)
                            .addComponent(jButton1))
                        .addGap(49, 49, 49)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(150, 150, 150))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(m_ranking)
                        .addGap(534, 534, 534))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
>>>>>>> b0330ab6432ecef622f826d61acba6af119deb28
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblA, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPuntosA)
                                    .addComponent(ranking1)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(progressA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblRetoA))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(progressB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ranking2)
                                .addComponent(lblPuntosB)
                                .addComponent(lblRetoB))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblturno)
                        .addGap(1, 1, 1)
                        .addComponent(lblDice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sacarCartaA)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(apiProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(m_ranking)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
<<<<<<< HEAD
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
=======
                .addComponent(apiProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
<<<<<<< HEAD
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE))
=======
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
>>>>>>> d911a85ba57395dc9929f0587c93ae3ef13c8d98
                .addContainerGap())
>>>>>>> b0330ab6432ecef622f826d61acba6af119deb28
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sacarCartaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sacarCartaAActionPerformed
        // TODO add your handling code here:
        sacarCarta = true;
        
    }//GEN-LAST:event_sacarCartaAActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
<<<<<<< HEAD
        throwDice = true;
=======
        
>>>>>>> b0330ab6432ecef622f826d61acba6af119deb28
    }//GEN-LAST:event_jButton1ActionPerformed

    private void m_rankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_rankingActionPerformed
        // TODO add your handling code here:
        getRank().setVisible(true);
        
    }//GEN-LAST:event_m_rankingActionPerformed
    //Gets and Sets--------------------------------------------------------
    public void setRank1(String pt){
        ranking1.setText(pt);
    }
    public void setRank2(String pt){
        ranking2.setText(pt);
    }
    public void setname1(String pt){
        ranking1.setText(pt);
    }
    public void setname2(String pt){
        ranking2.setText(pt);
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
        return lblA;
    }
    public JLabel getLblB() {
        return lblB;
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
        return ranking1;
    }
    public JLabel getLblRateB() {
        return ranking2;
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
        this.lblA = lblA;
    }
    public void setLblB(JLabel lblB) {
        this.lblB = lblB;
    }
    public void setLblPuntosA(JLabel lblPuntosA) {
        this.lblPuntosA = lblPuntosA;
    }
    public void setLblPuntosB(JLabel lblPuntosB) {
        this.lblPuntosB = lblPuntosB;
    }
    public void setLblRateA(JLabel lblRateA) {
        this.ranking1 = lblRateA;
    }
    public void setLblRateB(JLabel lblRateB) {
        this.ranking2 = lblRateB;
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
    public void setAux(VisualGraphics aux) {
        this.aux = aux;
    }
    public VisualGraphics getAux() {
        return aux;
    }

    /**
     * Si cambia el observable, los observer deben actualizarse
     * @param obj Instancia a cambiar
     */
    @Override
    public void update(Object obj) {
        grafo = (Grafo) obj;
    }
    //Dibujo--------------------------------------------------------------------
    
    public void paneDB(){
        dbImage = createImage(IConstants.panelWidth, IConstants.panelHeight);
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        canvas.getGraphics().drawImage(dbImage, 0, 0, this);
    }
    public void paintComponent(Graphics g){
<<<<<<< HEAD
        try{
            aux.paintTablero(g);
        }catch(NullPointerException e)
        {
            
        }
=======
        super.paint(g);

        try{
            aux.paintTablero(g);
        }catch(NullPointerException e){
       
        }
        
        repaint();
>>>>>>> b0330ab6432ecef622f826d61acba6af119deb28
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
    private javax.swing.JProgressBar apiProgress;
    private javax.swing.JPanel canvas;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblB;
    private javax.swing.JLabel lblDice;
    private javax.swing.JLabel lblPuntosA;
    private javax.swing.JLabel lblPuntosB;
    private javax.swing.JLabel lblRetoA;
    private javax.swing.JLabel lblRetoB;
    private javax.swing.JLabel lblturno;
    private javax.swing.JButton m_ranking;
    private javax.swing.JProgressBar progressA;
    private javax.swing.JProgressBar progressB;
    private javax.swing.JLabel ranking1;
    private javax.swing.JLabel ranking2;
    private javax.swing.JButton sacarCartaA;
    // End of variables declaration//GEN-END:variables

}
