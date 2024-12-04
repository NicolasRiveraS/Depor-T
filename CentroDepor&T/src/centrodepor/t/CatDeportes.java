package centrodepor.t;

import java.io.*;
import javax.swing.JOptionPane;

public class CatDeportes extends javax.swing.JFrame {
    
    // Constructor
    public CatDeportes() {
        initComponents();
        setTitle("Catálogo de Deportes");
        setLocationRelativeTo(null);
        setResizable(false);
        jButton4.setVisible(false);
    }
 
    public boolean camposVacios() {
        if (jTextField1.getText().equals("") || jTextArea1.getText().equals("")) {
            return true;
        } else {
            return false;
        }
    }
    
    public void agregarDeportes() {
        try {
            if (camposVacios()) {
                JOptionPane.showMessageDialog(null, "¡Debe completar todos los datos!",
                        "Campos vacíos", JOptionPane.ERROR_MESSAGE);
            } else {
                CatalogoDeportes cD = new CatalogoDeportes();
                
                cD.setNombreDeporte(jTextField1.getText());
                cD.setCaracteristicas(jTextArea1.getText());
                
                if (jRadioButton1.isSelected()) {
                    cD.setEstado("Activo");
                }
                else {
                    cD.setEstado("Inactivo");
                }
                
                // Agrega la información al LinkedList del Main
                Main.catDeportes.add(cD);

                JOptionPane.showMessageDialog(null,
                        "¡Datos guardados correctamente!", "Datos guardados",
                        JOptionPane.INFORMATION_MESSAGE);
                
                // Limpia los espacios
                jTextField1.setText("");
                jTextArea1.setText("");
                jRadioButton1.setSelected(true);
            }
        } 
        catch (Exception ex01) {
            JOptionPane.showMessageDialog(null,
                    "¡Ocurrió un error al guardar!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editarDeportes() {
        int encontrado = 0;
        String buscarNombreDeporte = jTextField1.getText();
        try {
            // Recorre el LinkedList y verifica si existe el Nombre
            for (int i = 0; i < Main.catDeportes.size(); i++) {

                if (buscarNombreDeporte.equals(Main.catDeportes.get(i).getNombreDeporte())) {
                    encontrado = 1;

                    int editar = JOptionPane.showConfirmDialog(null, "¿Desea editar este deporte?",
                            "Editar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    // Edita el deporte
                    if (editar == 0) {
                        jButton1.setEnabled(false);
                        jButton2.setEnabled(false);
                        jButton3.setEnabled(false);
                        jButton5.setEnabled(false);

                        jTextField1.setText(Main.catDeportes.get(i).getNombreDeporte());
                        jTextArea1.setText(Main.catDeportes.get(i).getCaracteristicas());

                        if ("Activo".equals(Main.catDeportes.get(i).getEstado())) {
                            jRadioButton1.setSelected(true);
                        } else {
                            jRadioButton2.setSelected(true);
                        }

                        // Elimina el original del LinkedList
                        Main.catDeportes.remove(i);

                        // Mediante el botón de Guardar Cambios "edita" el deporte (borra el original y crea uno nuevo)
                        jButton4.setVisible(true);
                    }
                }
            }
            if (encontrado == 0) {
                JOptionPane.showMessageDialog(null, "Dato no encontrado\nDigite solo el nombre o registre el dato primero", "Dato no encontrado", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex01) {
        }
    }
    
    public void inactivarDeportes() {
        int encontrado = 0;
        String buscarNombreDeporte = jTextField1.getText();
        try {
            // Recorre el LinkedList y verifica si existe el Nombre
            for (int i = 0; i < Main.catDeportes.size(); i++) {

                if (buscarNombreDeporte.equals(Main.catDeportes.get(i).getNombreDeporte())) {
                    encontrado = 1;

                    int deporteAsociado = 0;
                    // Verifica si el deporte está asociado con una rutina
                    for (int j = 0; j < Main.catRutinas.size(); j++) {
                        if (buscarNombreDeporte.equals(Main.catRutinas.get(j).getNombreDeporte())) {
                            deporteAsociado = 1;
                        }
                    }
                    
                    if (deporteAsociado == 1) {
                        JOptionPane.showMessageDialog(null, "¡Este deporte se encuentra asociado a una rutina!\nInactive la rutina para continuar", "Deporte asociado", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        int inactivar = JOptionPane.showConfirmDialog(null, "¿Desea inactivar este deporte?",
                                "Inactivar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        // Inactiva el deporte
                        if (inactivar == 0) {
                            Main.catDeportes.remove(i);
                            JOptionPane.showMessageDialog(null, "¡Deporte inactivado satisfactoriamente!", "Inactivación Completada", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    
                    // Limpia los espacios
                    jTextField1.setText("");
                    jTextArea1.setText("");
                    jRadioButton1.setSelected(true);
                }
            }

            if (encontrado == 0) {
                JOptionPane.showMessageDialog(null, "Dato no encontrado\nDigite solo el nombre", "Dato no encontrado", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex01) {
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        jButton2 = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Catálogo de Deportistas");
        setMinimumSize(new java.awt.Dimension(550, 310));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/back-button (1).png"))); // NOI18N
        jButton5.setToolTipText("Regresar");
        jButton5.setFocusPainted(false);
        jButton5.setOpaque(true);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Catálogo de Deportes");

        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.setToolTipText("");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        jButton1.setToolTipText("Agregar Usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);
        jToolBar1.add(filler1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/editar.png"))); // NOI18N
        jButton2.setToolTipText("Editar Usuario");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);
        jToolBar1.add(filler2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/quitar-usuario.png"))); // NOI18N
        jButton3.setToolTipText("Eliminar Usuario");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jLabel2.setText("Nombre del Deporte:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Características:");

        jLabel8.setText("Estado:");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Activo");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Inactivo");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton4.setText("Guardar cambios");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jButton5))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(28, 28, 28))))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton2)
                        .addComponent(jButton4)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
        new EscogenciaCatalogos().show(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        agregarDeportes();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        editarDeportes();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        agregarDeportes();

        jButton4.setVisible(false);

        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton5.setEnabled(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        inactivarDeportes();
    }//GEN-LAST:event_jButton3ActionPerformed


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
            java.util.logging.Logger.getLogger(CatDeportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CatDeportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CatDeportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CatDeportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CatDeportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
