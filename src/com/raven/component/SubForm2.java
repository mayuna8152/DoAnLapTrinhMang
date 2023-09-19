package com.raven.component;

import com.raven.main.MainProgram;

public class SubForm2 extends javax.swing.JPanel {

    public SubForm2(String name) {
        initComponents();
        setOpaque(false);
        jLabel1.setText("Form " + name);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        button1 = new com.raven.swing.Button();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(212, 212, 212));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Form");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 48, 997, 565));

        button1.setText("Back");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 70, -1));

        jButton1.setText("Ditmemay");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        MainProgram.getInstance().getSlideShow().slideTo(0);
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button button1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
