/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;

import java.sql.Connection;
import java.sql.DriverManager;
import Datos.PeliculasSQL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VtnPeliculas extends javax.swing.JFrame
{

    int xM, yM;
    private File archivoFoto = null;
    private File archivoTrailer = null;


    public VtnPeliculas()
    {
        initComponents();

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblCvePeli = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblFechaEstreno = new javax.swing.JLabel();
        lblIdIdioma = new javax.swing.JLabel();
        lblDuracion = new javax.swing.JLabel();
        lblSinopsis = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCvePeli = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtFechaEstreno = new javax.swing.JTextField();
        txtIdIdioma = new javax.swing.JTextField();
        txtDuracion = new javax.swing.JTextField();
        BtnRegistrar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        lblSubtitulos = new javax.swing.JLabel();
        txtSubtitulos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSinopsis = new javax.swing.JTextArea();
        lblReparto = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtReparto = new javax.swing.JTextArea();
        lblFoto = new javax.swing.JLabel();
        lblTrailer = new javax.swing.JLabel();
        txtIdClasificaion = new javax.swing.JTextField();
        lblIDClasif = new javax.swing.JLabel();
        txtRutaTrailer = new javax.swing.JTextField();
        txtRutaFoto = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        PanelArrba = new javax.swing.JPanel();
        BtnSalir = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(26, 43, 76));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(376, 520));

        lblCvePeli.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCvePeli.setText("Clave de película:");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNombre.setText("Nombre:");

        lblFechaEstreno.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFechaEstreno.setText("Fecha de estreno:");

        lblIdIdioma.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIdIdioma.setText("ID de idioma:");

        lblDuracion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDuracion.setText("Duración:");

        lblSinopsis.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSinopsis.setText("Sinopsis:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("REGISTRO DE PELÍCULAS");

        txtCvePeli.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtCvePeliActionPerformed(evt);
            }
        });

        BtnRegistrar.setBackground(new java.awt.Color(66, 133, 244));
        BtnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        BtnRegistrar.setText("Registrar");
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnRegistrarActionPerformed(evt);
            }
        });

        BtnCancelar.setBackground(new java.awt.Color(176, 190, 197));
        BtnCancelar.setForeground(new java.awt.Color(21, 21, 21));
        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnCancelarActionPerformed(evt);
            }
        });

        lblSubtitulos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSubtitulos.setText("Subtítulos");

        txtSubtitulos.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtSubtitulosActionPerformed(evt);
            }
        });

        txtSinopsis.setColumns(20);
        txtSinopsis.setRows(5);
        jScrollPane1.setViewportView(txtSinopsis);

        lblReparto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblReparto.setText("Reparto:");

        txtReparto.setColumns(20);
        txtReparto.setRows(5);
        jScrollPane2.setViewportView(txtReparto);

        lblFoto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFoto.setText("Foto:");

        lblTrailer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTrailer.setText("Tráiler:");

        txtIdClasificaion.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtIdClasificaionActionPerformed(evt);
            }
        });

        lblIDClasif.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIDClasif.setText("ID Clasificaion");

        txtRutaFoto.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtRutaFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(286, 286, 286))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lblSubtitulos, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSubtitulos, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lblCvePeli)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCvePeli, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lblFechaEstreno, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFechaEstreno, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lblIdIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIdIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblIDClasif))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIdClasificaion)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(lblSinopsis, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jSeparator8, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lblTrailer, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtRutaTrailer, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtRutaFoto, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnRegistrar)
                        .addGap(41, 41, 41)
                        .addComponent(BtnCancelar)
                        .addGap(129, 129, 129))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel1)
                .addGap(84, 84, 84)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCvePeli)
                            .addComponent(txtCvePeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReparto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdClasificaion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIDClasif))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaEstreno)
                            .addComponent(txtFechaEstreno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIdIdioma)
                            .addComponent(txtIdIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSubtitulos, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubtitulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblDuracion))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFoto)
                            .addComponent(txtRutaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTrailer)
                            .addComponent(txtRutaTrailer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSinopsis)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnRegistrar)
                        .addComponent(BtnCancelar)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 810, 640));

        PanelArrba.setBackground(new java.awt.Color(0, 0, 0));
        PanelArrba.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            public void mouseDragged(java.awt.event.MouseEvent evt)
            {
                PanelArrbaMouseDragged(evt);
            }
        });
        PanelArrba.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                PanelArrbaMousePressed(evt);
            }
        });

        BtnSalir.setBackground(new java.awt.Color(255, 0, 0));
        BtnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSalir.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                BtnSalirMouseClicked(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("X");

        javax.swing.GroupLayout BtnSalirLayout = new javax.swing.GroupLayout(BtnSalir);
        BtnSalir.setLayout(BtnSalirLayout);
        BtnSalirLayout.setHorizontalGroup(
            BtnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BtnSalirLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        BtnSalirLayout.setVerticalGroup(
            BtnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelArrbaLayout = new javax.swing.GroupLayout(PanelArrba);
        PanelArrba.setLayout(PanelArrbaLayout);
        PanelArrbaLayout.setHorizontalGroup(
            PanelArrbaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelArrbaLayout.createSequentialGroup()
                .addComponent(BtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelArrbaLayout.setVerticalGroup(
            PanelArrbaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(PanelArrba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 914, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void txtSubtitulosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtSubtitulosActionPerformed
    {//GEN-HEADEREND:event_txtSubtitulosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubtitulosActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnCancelarActionPerformed
    {//GEN-HEADEREND:event_BtnCancelarActionPerformed
        if (txtNombre.getText().equals("") && txtCvePeli.getText().equals("") 
                && txtDuracion.getText().equals("") && txtFechaEstreno.getText().equals("") && txtIdClasificaion.getText().equals("")
                && txtSinopsis.getText().equals("")&&txtIdIdioma.getText().equals("") && txtReparto.getText().equals("")
                && txtSinopsis.getText().equals("")&&txtRutaFoto.getText().equals("") && txtRutaTrailer.getText().equals(""))
        {
            this.dispose();
        } else
        {
            int confirma = JOptionPane.showConfirmDialog(null, "¿Desea descartar los cambios?", "CONFIRMACIÓN", JOptionPane.YES_NO_OPTION);
            if (confirma == JOptionPane.YES_OPTION)
            {
                txtNombre.setText("");
                txtCvePeli.setText("");
                txtDuracion.setText("");
                txtFechaEstreno.setText(""); 
                txtIdClasificaion.setText("");
                txtIdIdioma.setText("");
                txtReparto.setText(""); 
                txtRutaFoto.setText("");
                txtRutaTrailer.setText("");
                txtSinopsis.setText("");
                txtSubtitulos.setText("");
                this.dispose();
            } 
        } 
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnRegistrarActionPerformed
    {//GEN-HEADEREND:event_BtnRegistrarActionPerformed

    String url = "jdbc:oracle:thin:@//25.50.80.247:1521/xepdb1";
    String usuario = "equipoFBD";
    String password = "10714223";
    Connection conn = null;

    try {
        conn = DriverManager.getConnection(url, usuario, password);

        PeliculasSQL obj = new PeliculasSQL((java.sql.Connection) conn);

        String cvePelicula        = txtCvePeli.getText();
        String nombrePelicula     = txtNombre.getText();
        String fechaEstreno       = txtFechaEstreno.getText();
        String idIdioma           = txtIdIdioma.getText();
        String idClasificacion    = txtIdClasificaion.getText();
        String subtitulos         = txtSubtitulos.getText();
        String duracion           = txtDuracion.getText();
        String sipnosis           = txtSinopsis.getText();
        String reparto            = txtReparto.getText();
        String trailer            = txtRutaTrailer.getText();
        String fotoRepresentativa = txtRutaFoto.getText();
        
        obj.insertar(cvePelicula, nombrePelicula, fechaEstreno, idIdioma, idClasificacion, subtitulos, duracion, sipnosis, reparto, trailer, fotoRepresentativa);
    } catch (SQLException ex) {
        System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
    }   catch (FileNotFoundException ex)
        {
            Logger.getLogger(VtnPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
    }


    }//GEN-LAST:event_BtnRegistrarActionPerformed

    private void txtCvePeliActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtCvePeliActionPerformed
    {//GEN-HEADEREND:event_txtCvePeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCvePeliActionPerformed

    private void txtIdClasificaionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtIdClasificaionActionPerformed
    {//GEN-HEADEREND:event_txtIdClasificaionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdClasificaionActionPerformed

    private void txtRutaFotoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtRutaFotoActionPerformed
    {//GEN-HEADEREND:event_txtRutaFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutaFotoActionPerformed

    private void BtnSalirMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_BtnSalirMouseClicked
    {//GEN-HEADEREND:event_BtnSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_BtnSalirMouseClicked

    private void PanelArrbaMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_PanelArrbaMousePressed
    {//GEN-HEADEREND:event_PanelArrbaMousePressed
            xM=evt.getX();
            yM=evt.getY();
    }//GEN-LAST:event_PanelArrbaMousePressed

    private void PanelArrbaMouseDragged(java.awt.event.MouseEvent evt)//GEN-FIRST:event_PanelArrbaMouseDragged
    {//GEN-HEADEREND:event_PanelArrbaMouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-xM, y-yM);
    }//GEN-LAST:event_PanelArrbaMouseDragged

    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(VtnPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(VtnPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(VtnPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(VtnPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new VtnPeliculas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnRegistrar;
    private javax.swing.JPanel BtnSalir;
    private javax.swing.JPanel PanelArrba;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lblCvePeli;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JLabel lblFechaEstreno;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblIDClasif;
    private javax.swing.JLabel lblIdIdioma;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblReparto;
    private javax.swing.JLabel lblSinopsis;
    private javax.swing.JLabel lblSubtitulos;
    private javax.swing.JLabel lblTrailer;
    private javax.swing.JTextField txtCvePeli;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtFechaEstreno;
    private javax.swing.JTextField txtIdClasificaion;
    private javax.swing.JTextField txtIdIdioma;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtReparto;
    private javax.swing.JTextField txtRutaFoto;
    private javax.swing.JTextField txtRutaTrailer;
    private javax.swing.JTextArea txtSinopsis;
    private javax.swing.JTextField txtSubtitulos;
    // End of variables declaration//GEN-END:variables
}
