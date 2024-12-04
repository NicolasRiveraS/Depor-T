



/* 
El código comentado es el que el profe nos dio en clase, lo dejo por si
se puede modificar y usarse en el proyecto.
Los otros métodos funcionan bien así como están.

Falta implementar lo de los Socket (ver "Módulo 4, punto 2" de las indicaciones).

Pd: La base de datos la hice con usuario "root" y contraseña "Fidelitasw2!"
Como sale en las líneas 27 y 28.
*/




package centrodepor.t;

import java.sql.*;
import javax.swing.JOptionPane;

public class Cajas extends javax.swing.JFrame {
    // Atributos
    private static final String URL = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String usuario = "root";
    private static final String clave = "Fidelitasw2!";
    private Statement st;
    private Connection conn;

    // Constructor
    public Cajas() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Cajas");
        this.conn = null;
        this.st = null;
        //llenarCombo();
    }

    // Métodos
    public void conectar() {
        try {
            conn = DriverManager.getConnection(
                    URL, usuario, clave);
            System.out.println("¡Conectado!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al conectar\nError: " + ex.getMessage());
        }
    }

    public void desconectar() {
        try {
            if (!conn.isClosed()) {
                conn.close();
                System.out.println("¡Desconectado!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Error al desconectar\nError: " + ex.getMessage());
        }
    }

//    public void llenarCombo() {
//        jComboBox1.addItem("Programación Básica");
//        jComboBox1.addItem("Introd. a la Programación");
//        jComboBox1.addItem("Programación Cliente Servidor");
//        jComboBox1.addItem("Estructuras de Datos");
//        jComboBox1.addItem("Fundamentos de Diseño de B.D.");
//        jComboBox1.setSelectedIndex(0);
//    }
//
//    public void insertar() {
//        try {
//            if (jTextField2.getText().equals("")) {
//                JOptionPane.showMessageDialog(null,
//                        "Error, ¡no puede dejar campos vacíos!",
//                        "Campos vacíos", JOptionPane.ERROR_MESSAGE);
//            } else {
//                conectar();
//                st = conn.createStatement();
//                String SQL = "INSERT INTO Curso(nombreCurso,precio) "
//                        + "VALUES( '" + jComboBox1.getSelectedItem().toString() + "', " + jTextField2.getText() + ")";
//                int estado = st.executeUpdate(SQL);
//                JOptionPane.showMessageDialog(null, "¡Datos agregados correctamente!");
//                desconectar();
//            }
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null,
//                    "Error al insertar" + ex.getMessage());
//        }
//    }
//
//    public void consultar() {
//        int cont = 0;
//        String dato;
//        boolean existe = false;
//        try {
//            jTextField2.setText("");
//
//            conectar();
//            dato = jComboBox1.getSelectedItem().toString();
//            Statement s = conn.createStatement();
//            ResultSet rs = s.executeQuery("select * from Curso where nombreCurso = '" + dato + "'");    // Conjunto de filas y columnas
//
//            while (rs.next()) {
//                if (dato.equals(rs.getString(2))) {                             // Usa 2 porque es la columna del nombre
//                    jTextField2.setText(rs.getString(3));                       // Usa 3 porque es la columna del precio
//                    cont++;                                                     //     ↑ Ambos index empiezan en 1 ↑    
//                }
//            }
//
//            if (cont > 0) {
//                existe = true;
//            } else {
//                JOptionPane.showMessageDialog(null, "¡El dato consultado no se encuentra registrado!", "Dato no encontrado", JOptionPane.INFORMATION_MESSAGE);
//            }
//            desconectar();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "¡Error al consultar!\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    public void eliminar() {
//        String dato;
//
//        try {
//            conectar();
//            dato = jComboBox1.getSelectedItem().toString();
//            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); // Ponemos la tabla en "modo actualizable"
//            s.executeUpdate("delete from Curso where nombreCurso = '" + dato + "'");
//
//            JOptionPane.showMessageDialog(null, "¡Registro eliminado!");
//
//            jTextField2.setText("");
//            jTextField2.requestFocus();
//
//            desconectar();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "¡Error al eliminar!\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Nombre");

        jLabel3.setText("Precio");

        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Consultar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/back-button (1).png"))); // NOI18N
        jButton6.setToolTipText("Regresar");
        jButton6.setFocusPainted(false);
        jButton6.setOpaque(true);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE))
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //insertar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //consultar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //eliminar();
    }//GEN-LAST:event_jButton5ActionPerformed

    // Regresa al Menú Principal
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
        new MenuPrincipal().show(true);
    }//GEN-LAST:event_jButton6ActionPerformed
    

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Cajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cajas().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
