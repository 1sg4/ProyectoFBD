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
        btnSeleccionarFoto = new javax.swing.JButton();
        lblArchivoSeleccionadoFoto = new javax.swing.JLabel();
        lblTrailer = new javax.swing.JLabel();
        btnSeleccionarVideo = new javax.swing.JButton();
        lblArchivoSeleccionadoTrailer = new javax.swing.JLabel();
        txtIdClasificaion = new javax.swing.JTextField();
        lblIDClasif = new javax.swing.JLabel();
        txtRutaTrailer = new javax.swing.JTextField();
        txtRutaFoto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(807, 708));

        jPanel2.setBackground(new java.awt.Color(26, 43, 76));

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

        btnSeleccionarFoto.setText("Seleccionar Archivo");
        btnSeleccionarFoto.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSeleccionarFotoActionPerformed(evt);
            }
        });

        lblArchivoSeleccionadoFoto.setText("(nombre del archivo)");
        lblArchivoSeleccionadoFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTrailer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTrailer.setText("Tráiler:");

        btnSeleccionarVideo.setText("Seleccionar Archivo");
        btnSeleccionarVideo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSeleccionarVideoActionPerformed(evt);
            }
        });

        lblArchivoSeleccionadoTrailer.setText("(nombre del archivo)");
        lblArchivoSeleccionadoTrailer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(lblSubtitulos, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSubtitulos, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtIdIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(lblCvePeli)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCvePeli, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(lblFechaEstreno, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFechaEstreno, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator3)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(lblDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblIdIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(lblSinopsis, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblIDClasif))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtIdClasificaion)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTrailer, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnRegistrar)
                                .addGap(27, 27, 27)
                                .addComponent(BtnCancelar)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSeleccionarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblArchivoSeleccionadoFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblArchivoSeleccionadoTrailer, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtRutaTrailer, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSeleccionarVideo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtRutaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCvePeli)
                    .addComponent(txtCvePeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblReparto)
                            .addComponent(txtIdClasificaion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIDClasif))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaEstreno)
                    .addComponent(txtFechaEstreno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIdIdioma)
                            .addComponent(txtIdIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFoto))
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSubtitulos, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubtitulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnSeleccionarFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblArchivoSeleccionadoFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRutaTrailer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDuracion)
                                    .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(lblTrailer)))
                        .addGap(1, 1, 1)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblSinopsis))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BtnRegistrar)
                                    .addComponent(BtnCancelar)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnSeleccionarVideo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblArchivoSeleccionadoTrailer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRutaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnSeleccionarVideoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSeleccionarVideoActionPerformed
    {//GEN-HEADEREND:event_btnSeleccionarVideoActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filtroVideo = new FileNameExtensionFilter(
            "Videos (*.mp4, *.avi, *.mov)", "mp4", "avi", "mov"
        );
        fileChooser.setFileFilter(filtroVideo);

        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION)
        {
            archivoTrailer = fileChooser.getSelectedFile();
            lblArchivoSeleccionadoTrailer.setText(archivoTrailer.getName());
        }
    }//GEN-LAST:event_btnSeleccionarVideoActionPerformed


    private void btnSeleccionarFotoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSeleccionarFotoActionPerformed
    {//GEN-HEADEREND:event_btnSeleccionarFotoActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter(
            "Imágenes (*.jpg, *.png)", "jpg", "jpeg", "png"
        );
        fileChooser.setFileFilter(filtroImagen);

        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION)
        {
            archivoFoto = fileChooser.getSelectedFile();
            lblArchivoSeleccionadoFoto.setText(archivoFoto.getName());
        }
    }//GEN-LAST:event_btnSeleccionarFotoActionPerformed

    private void txtSubtitulosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtSubtitulosActionPerformed
    {//GEN-HEADEREND:event_txtSubtitulosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubtitulosActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnCancelarActionPerformed
    {//GEN-HEADEREND:event_BtnCancelarActionPerformed
        // TODO add your handling code here:
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

        JOptionPane.showMessageDialog(this, "Registro insertado con éxito.");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error en la base de datos: " + ex.getMessage());
        ex.printStackTrace();
    }   catch (FileNotFoundException ex)
        {
            Logger.getLogger(VtnPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        // No olvides cerrar la conexión si no la usarás más
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
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
    private javax.swing.JButton btnSeleccionarFoto;
    private javax.swing.JButton btnSeleccionarVideo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblArchivoSeleccionadoFoto;
    private javax.swing.JLabel lblArchivoSeleccionadoTrailer;
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
