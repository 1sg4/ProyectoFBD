/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;
import java.awt.Color;
import java.sql.Connection;
import java.awt.event.KeyAdapter;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;

/**
 *
 * @author trist
 */
public class VtnRegisFinal extends javax.swing.JFrame
{

    /**
     * Creates new form VtnRegisFinal
     */
 // Constructor vacío
   
   public VtnRegisFinal() {
    initComponents();
    initValidation(); // Inicialización de validaciones en tiempo real
    generarIDCliente(); // Generar ID del Cliente
    
    // Establecer un valor temporal
    txtIdCine.setText("NO_ASIGNADO");
    txtIdCine.setEditable(false);
    txtIdCliente.setEditable(false);

    // Deshabilitar el botón al inicio
    btnGuardar.setEnabled(false);
}



  // ==========================
    // Inicialización de validaciones en tiempo real
    // ==========================
    private void initValidation() {
        // Listener del teléfono
        txtTelefono.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                validarFormulario();
            }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                validarFormulario();
            }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                validarFormulario();
            }
        });

        // Listener del correo
        txtCorreo.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                validarFormulario();
            }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                validarFormulario();
            }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                validarFormulario();
            }
        });
    }
    
    
    
    
public VtnRegisFinal(String idCine) {
    initComponents(); // Inicializa los componentes gráficos
    initValidation(); // Inicialización de validaciones en tiempo real

    // ==========================
    // Validación del ID de Cine
    // ==========================
    if (idCine == null || idCine.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Error: El ID del cine no fue recibido correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
        btnGuardar.setEnabled(false); // Deshabilitar el botón en caso de error
        txtIdCine.setText("NO_ASIGNADO");
        txtIdCine.setEditable(false);
        return; // Salir del constructor para evitar más errores
    }

    // ==========================
    // Asignar valores iniciales
    // ==========================
    generarIDCliente();                 // Generar el ID del cliente automáticamente
    txtIdCine.setText(idCine);          // Asignar el ID del cine recibido
    txtIdCine.setEditable(false);       // Bloquear edición
    txtIdCliente.setEditable(false);    // Bloquear edición

    // Deshabilitar el botón de guardar hasta que se llenen los datos correctamente
    btnGuardar.setEnabled(false);

    // ==========================
    // Validación de Campos Vacíos y Formato
    // ==========================
    KeyAdapter validarCampos = new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
            validarFormulario(); // Método que activa o desactiva el botón
        }
    };

    // Agregar el Listener a cada campo de texto
    txtCorreo.addKeyListener(validarCampos);
    txtTelefono.addKeyListener(validarCampos);
    txtNombre.addKeyListener(validarCampos);
    txtPApellido.addKeyListener(validarCampos);
    txtSApellido.addKeyListener(validarCampos);

    // ==========================
    // Comprobación rápida en consola
    // ==========================
    System.out.println("ID de Cine recibido correctamente: " + idCine);
}






    

    // Método para generar el ID del cliente automáticamente
  private void generarIDCliente() {
    String url = "jdbc:oracle:thin:@//25.50.80.247:1521/xepdb1";
    String usuario = "equipoFBD";
    String password = "10714223";

    try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
        System.out.println("Conexión exitosa para generar ID");

        String query = "SELECT MAX(ID_CLIENTE) AS ULTIMO_ID FROM CLIENTES";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        if (rs.next()) {
            String ultimoID = rs.getString("ULTIMO_ID");
            if (ultimoID == null) {
                txtIdCliente.setText("C00000001"); // Primer cliente
            } else {
                // Incrementar el ID
                int numero = Integer.parseInt(ultimoID.substring(1)); // Tomar solo los números
                numero++; // Incrementar en 1
                String nuevoID = String.format("C%08d", numero); // Formato "C00000001"
                txtIdCliente.setText(nuevoID); // Mostrar en el campo
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error al generar ID: " + ex.getMessage());
    }
}


    // Método para guardar en la base de datos
    private void guardarCliente() {
        String url = "jdbc:oracle:thin:@//25.50.80.247:1521/xepdb1";
        String usuario = "equipoFBD";
        String password = "10714223";

        String query = "INSERT INTO CLIENTES (ID_CLIENTE, CORREO_ELECTRONICO, TELEFONO, NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, ID_CINE) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, usuario, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, txtIdCliente.getText());
            stmt.setString(2, txtCorreo.getText());
            stmt.setString(3, txtTelefono.getText());
            stmt.setString(4, txtNombre.getText());
            stmt.setString(5, txtPApellido.getText());
            stmt.setString(6, txtSApellido.getText());
            stmt.setString(7, txtIdCine.getText());

            int resultado = stmt.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(this, "Cliente registrado exitosamente.");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar el cliente.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error en la base de datos: " + ex.getMessage());
        }
    }

    // ==========================
// Método de validación
    // ==========================
private void validarFormulario() {
    boolean camposLlenos = !txtCorreo.getText().isEmpty() &&
                           !txtTelefono.getText().isEmpty() &&
                           !txtNombre.getText().isEmpty() &&
                           !txtPApellido.getText().isEmpty() &&
                           !txtSApellido.getText().isEmpty();

    // ==========================
    // Validación del teléfono: Solo números y exactamente 10 dígitos
    // ==========================
    boolean telefonoCompleto = txtTelefono.getText().matches("\\d{10}");
    if (txtTelefono.getText().isEmpty()) {
        txtTelefono.setBackground(Color.WHITE); // Cuando está vacío, en blanco
    } else {
        txtTelefono.setBackground(telefonoCompleto ? Color.WHITE : Color.PINK);
    }

    // ==========================
    // Validación del correo: Formato estándar y dominio de al menos 3 caracteres
    // ==========================
    boolean correoValido = txtCorreo.getText().matches("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{3,}$");
    if (txtCorreo.getText().isEmpty()) {
        txtCorreo.setBackground(Color.WHITE); // Cuando está vacío, en blanco
    } else {
        txtCorreo.setBackground(correoValido ? Color.WHITE : Color.PINK);
    }

    // ==========================
    // Validación de los nombres: Solo letras y espacios
    // ==========================
    boolean nombreValido = txtNombre.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+");
    if (txtNombre.getText().isEmpty()) {
        txtNombre.setBackground(txtNombre.getText().isEmpty() && txtNombre.getDocument().getLength() > 0 ? Color.PINK : Color.WHITE);
    } else {
        txtNombre.setBackground(nombreValido ? Color.WHITE : Color.PINK);
    }

    boolean pApellidoValido = txtPApellido.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+");
    if (txtPApellido.getText().isEmpty()) {
        txtPApellido.setBackground(txtPApellido.getText().isEmpty() && txtPApellido.getDocument().getLength() > 0 ? Color.PINK : Color.WHITE);
    } else {
        txtPApellido.setBackground(pApellidoValido ? Color.WHITE : Color.PINK);
    }

    boolean sApellidoValido = txtSApellido.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]*");
    if (txtSApellido.getText().isEmpty()) {
        txtSApellido.setBackground(txtSApellido.getText().isEmpty() && txtSApellido.getDocument().getLength() > 0 ? Color.PINK : Color.WHITE);
    } else {
        txtSApellido.setBackground(sApellidoValido ? Color.WHITE : Color.PINK);
    }

    // ==========================
    // Activar el botón si todo está correcto
    // ==========================
    btnGuardar.setEnabled(camposLlenos && telefonoCompleto && correoValido && nombreValido && pApellidoValido && sApellidoValido);
}








    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        lblICine = new javax.swing.JLabel();
        txtIdCine = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblPApellido = new javax.swing.JLabel();
        txtPApellido = new javax.swing.JTextField();
        lblSApellido = new javax.swing.JLabel();
        txtSApellido = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblICliente = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblICine.setText("ID CINE:");

        lblNombre.setText("NOMBRE:");

        lblPApellido.setText("PRIMER APELLIDO:");

        lblSApellido.setText("SEGUNDO APELLIDO:");

        lblTelefono.setText("TELEFONO:");

        lblCorreo.setText("CORREO:");

        lblICliente.setText("ID CLIENTE:");

        btnGuardar.setText("GUARDAR EL REGISTRO");
        btnGuardar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(77, 77, 77)
                                    .addComponent(lblICine, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(txtIdCine, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(68, 68, 68)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(lblPApellido)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtPApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTelefono)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblSApellido)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCorreo)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(69, 69, 69)
                        .addComponent(lblICliente, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(btnGuardar)))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblICine)
                    .addComponent(txtIdCine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblICliente)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPApellido)
                    .addComponent(txtPApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSApellido)
                    .addComponent(txtSApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(122, 122, 122))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnGuardarActionPerformed
    {//GEN-HEADEREND:event_btnGuardarActionPerformed
          // ==========================
    // Validación adicional antes de guardar
    // ==========================
    if (btnGuardar.isEnabled()) {
        int confirm = JOptionPane.showConfirmDialog(this, 
                "¿Estás seguro de registrar al cliente?", 
                "Confirmación de Registro", 
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            guardarCliente(); // Llama al método para guardar
        }
    } else {
        JOptionPane.showMessageDialog(this, 
                "Hay campos que aún no son válidos. Revisa los datos.", 
                "Error de Validación", 
                JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VtnRegisFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(VtnRegisFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(VtnRegisFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(VtnRegisFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new VtnRegisFinal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblICine;
    private javax.swing.JLabel lblICliente;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPApellido;
    private javax.swing.JLabel lblSApellido;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtIdCine;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPApellido;
    private javax.swing.JTextField txtSApellido;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
