// Menú Principal
package centrodepor.t;

import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame {

    // Atributos
    private int salir;
    
    // Constructor
    public MenuPrincipal() {
        initComponents();
        setTitle("Centro de Capacitación Depor & T");
        setLocationRelativeTo(null);
        setResizable(false);   
    }
    
    // Métodos
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        cajasBoton = new javax.swing.JButton();
        registroBoton = new javax.swing.JButton();
        catalogosBoton = new javax.swing.JButton();
        facturacionBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 520));
        setPreferredSize(new java.awt.Dimension(550, 520));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido al Centro de Capacitación Depor & T");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 350, 30));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iniciar-sesion.png"))); // NOI18N
        jButton5.setToolTipText("Salir");
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        cajasBoton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        cajasBoton.setText("Cajas");
        cajasBoton.setToolTipText("Cajas");
        cajasBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajasBotonActionPerformed(evt);
            }
        });
        getContentPane().add(cajasBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 350, 60));

        registroBoton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        registroBoton.setText("Registro de Usuarios");
        registroBoton.setToolTipText("Registro de Usuarios");
        registroBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroBotonActionPerformed(evt);
            }
        });
        getContentPane().add(registroBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 350, 60));

        catalogosBoton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        catalogosBoton.setText("Catálogos");
        catalogosBoton.setToolTipText("Catálogos");
        catalogosBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catalogosBotonActionPerformed(evt);
            }
        });
        getContentPane().add(catalogosBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 350, 60));

        facturacionBoton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        facturacionBoton.setText("Facturación");
        facturacionBoton.setToolTipText("Facturación");
        facturacionBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturacionBotonActionPerformed(evt);
            }
        });
        getContentPane().add(facturacionBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 350, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Salir
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        salir = JOptionPane.showConfirmDialog(null, "¿Desea salir del sistema?",
                "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (salir == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cajasBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajasBotonActionPerformed
        this.dispose();
        System.out.println("Cargando...");
        new Cajas().show(true);
    }//GEN-LAST:event_cajasBotonActionPerformed

    private void registroBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroBotonActionPerformed
        this.dispose();
        new RegistroUsuarios().show(true);
    }//GEN-LAST:event_registroBotonActionPerformed

    private void catalogosBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catalogosBotonActionPerformed
        this.dispose();
        new EscogenciaCatalogos().show(true);
    }//GEN-LAST:event_catalogosBotonActionPerformed

    private void facturacionBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturacionBotonActionPerformed
        this.dispose();
        new Facturacion().show(true);
    }//GEN-LAST:event_facturacionBotonActionPerformed


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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton cajasBoton;
    private javax.swing.JButton catalogosBoton;
    private javax.swing.JButton facturacionBoton;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton registroBoton;
    // End of variables declaration//GEN-END:variables
}
