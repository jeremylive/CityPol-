/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controlador.LoginManager;
import GamePlay.Jugador;
import Programa.CityPoli;
import Programa.CityPoliTablero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author live
 */
public class Menu extends javax.swing.JFrame 
{
    //Variables
    private LoginManager lol;
    //Constructor
    public Menu(CityPoli cP, CityPoliTablero cP2) {
        initComponents();
        this.lol = cP.getControlador_login(cP, cP2);
    }
    //gets and sets
    public LoginManager getLol() {
        return lol;
    }
    public void setLol(LoginManager lol) {
        this.lol = lol;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nueva_partida = new javax.swing.JButton();
        registro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("BIENVENIDO A CITYPOLI");

        nueva_partida.setText("Nueva Partida");
        nueva_partida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nueva_partidaActionPerformed(evt);
            }
        });

        registro.setText("Registro");
        registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(nueva_partida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(registro)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nueva_partida)
                    .addComponent(registro))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroActionPerformed
        getLol().setBoton(1);
        getLol().menu();
        
    }//GEN-LAST:event_registroActionPerformed

    private void nueva_partidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nueva_partidaActionPerformed
        getLol().setBoton(2);
        getLol().menu();
    }//GEN-LAST:event_nueva_partidaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton nueva_partida;
    private javax.swing.JButton registro;
    // End of variables declaration//GEN-END:variables
}
