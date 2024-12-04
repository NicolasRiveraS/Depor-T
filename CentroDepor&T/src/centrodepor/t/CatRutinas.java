package centrodepor.t;

import java.io.*;
import javax.swing.JOptionPane;

public class CatRutinas extends javax.swing.JFrame {
    
    // Constructor
    public CatRutinas() {
        initComponents();
        setTitle("Catálogo de Rutinas");
        setLocationRelativeTo(null);
        setResizable(false);
        jButton4.setVisible(false);
    }
 
    public boolean camposVacios() {
        if (jTextField1.getText().equals("") || jTextField2.getText().equals("") || jTextArea1.getText().equals("")) {
            return true;
        } else {
            return false;
        }
    }
    
    public void agregarRutinas() {
        int deporteEncontrado = 0;
        try {
            if (camposVacios()) {
                JOptionPane.showMessageDialog(null, "¡Debe completar todos los datos!",
                        "Campos vacíos", JOptionPane.ERROR_MESSAGE);
            } 
            else {
                for (int i = 0; i < Main.catDeportes.size(); i++) {
                    // Verifica en el Catálogo de Deportes si existe o no el ingresado
                    if (jTextField1.getText().equals(Main.catDeportes.get(i).getNombreDeporte())) {
                        deporteEncontrado = 1;
                        
                        CatalogoRutinas cR = new CatalogoRutinas();
                        
                        cR.setNombreDeporte(jTextField1.getText());
                        cR.setDescripcionRutina(jTextArea1.getText());
                        cR.setDuracion(jTextField2.getText());
                        
                        if (jRadioButton1.isSelected()) {
                            cR.setEstado("Activo");
                        } else {
                            cR.setEstado("Inactivo");
                        }
                        
                        int buscaRutinaExistente = 0;
                        // Verifica si la rutina ya fue ingresada anteriormente
                        for (int j = 0; j < Main.catRutinas.size(); j++) {
                            if (Main.catRutinas.get(j) == cR) {
                                buscaRutinaExistente = 1;
                            }
                        }
                        
                        if (buscaRutinaExistente == 1) {
                            JOptionPane.showMessageDialog(null, "¡Esta rutina ya se encuentra registrada!", "Rutina ya registrada", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else {
                            // Agrega la información al LinkedList del Main
                            Main.catRutinas.add(cR);

                            JOptionPane.showMessageDialog(null,
                                    "¡Datos guardados correctamente!", "Datos guardados",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        // Limpia los espacios
                        jTextField1.setText("");
                        jTextField2.setText("");
                        jTextArea1.setText("");
                        jRadioButton1.setSelected(true);
                    }
                }
                if (deporteEncontrado == 0) {
                    JOptionPane.showMessageDialog(null, "El deporte ingresado no existe\nPor favor agregue este deporte o verifique si está escrito correctamente", "Deporte no encontrado", JOptionPane.ERROR_MESSAGE);
                }
            }
        } 
        catch (Exception ex01) {
            JOptionPane.showMessageDialog(null,
                    "¡Ocurrió un error al guardar!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editarRutinas() {
        int encontrado = 0;
        String buscarDescripcionRutina = jTextArea1.getText();
        try {
            // Recorre el LinkedList y verifica si existe la Descripción de la rutina
            for (int i = 0; i < Main.catRutinas.size(); i++) {

                if (buscarDescripcionRutina.equals(Main.catRutinas.get(i).getDescripcionRutina())) {
                    encontrado = 1;

                    int editar = JOptionPane.showConfirmDialog(null, "¿Desea editar esta rutina?",
                            "Editar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    // Edita la rutina
                    if (editar == 0) {
                        jButton1.setEnabled(false);
                        jButton2.setEnabled(false);
                        jButton3.setEnabled(false);
                        jButton5.setEnabled(false);

                        jTextField1.setText(Main.catRutinas.get(i).getNombreDeporte());
                        jTextArea1.setText(Main.catRutinas.get(i).getDescripcionRutina());
                        jTextField2.setText(Main.catRutinas.get(i).getDuracion());

                        if ("Activo".equals(Main.catRutinas.get(i).getEstado())) {
                            jRadioButton1.setSelected(true);
                        } else {
                            jRadioButton2.setSelected(true);
                        }

                        // Elimina el original del LinkedList
                        Main.catRutinas.remove(i);

                        // Mediante el botón de Guardar Cambios "edita" la rutina (borra el original y crea uno nuevo)
                        jButton4.setVisible(true);
                    }
                }
            }
            if (encontrado == 0) {
                JOptionPane.showMessageDialog(null, "Dato no encontrado\nDigite solo la descripción o registre el dato primero", "Dato no encontrado", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex01) {
        }
    }
    
    public void inactivarRutinas() {
        int encontrado = 0;
        String buscarDescripcionRutina = jTextArea1.getText();
        try {
            // Recorre el LinkedList y verifica si existe la Descripción de la rutina
            for (int i = 0; i < Main.catRutinas.size(); i++) {

                if (buscarDescripcionRutina.equals(Main.catRutinas.get(i).getDescripcionRutina())) {
                    encontrado = 1;

                    int inactivar = JOptionPane.showConfirmDialog(null, "¿Desea inactivar esta rutina?",
                            "Inactivar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    // Inactiva la rutina
                    if (inactivar == 0) {
                        Main.catRutinas.remove(i);
                        JOptionPane.showMessageDialog(null, "¡Rutina inactivada satisfactoriamente!", "Inactivación Completada", JOptionPane.INFORMATION_MESSAGE);
                    }

                    // Limpia los espacios
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextArea1.setText("");
                    jRadioButton1.setSelected(true);
                }
            }

            if (encontrado == 0) {
                JOptionPane.showMessageDialog(null, "Dato no encontrado\nDigite solo la descripción", "Dato no encontrado", JOptionPane.ERROR_MESSAGE);
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
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Catálogo de Deportistas");
        setMinimumSize(new java.awt.Dimension(550, 380));

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
        jLabel1.setText("Catálogo de Rutinas");

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

        jLabel7.setText("Descripción");

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

        jLabel3.setText("Tiempo de duración:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(39, 39, 39)
                .addComponent(jLabel8)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton2)
                        .addComponent(jButton4)))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
        new EscogenciaCatalogos().show(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        agregarRutinas();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        editarRutinas();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        agregarRutinas();

        jButton4.setVisible(false);

        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton5.setEnabled(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        inactivarRutinas();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed


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
            java.util.logging.Logger.getLogger(CatRutinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CatRutinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CatRutinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CatRutinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CatRutinas().setVisible(true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
