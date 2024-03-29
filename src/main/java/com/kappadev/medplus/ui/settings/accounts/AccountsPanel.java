/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kappadev.medplus.ui.settings.accounts;

import com.kappadev.medplus.ui.settings.SettingsPanel;
import com.kappadev.medplus.ui.settings.accounts.email.EmailSettingPopUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author tburzynski
 */
@Component
public class AccountsPanel extends javax.swing.JFrame {

    @Autowired
    private EmailSettingPopUp emailSettingPopUp;
    @Autowired
    private SettingsPanel settingsPanel;

    /**
     * Creates new form AccountsPanel
     */
    public AccountsPanel() {
        initComponents();
    }

    public void initAccountsPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        emailBtn = new javax.swing.JButton();
        smsBtn = new javax.swing.JButton();
        facebookBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        infoLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        emailBtn.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        emailBtn.setText("e-mail");
        emailBtn.setMaximumSize(new java.awt.Dimension(69, 27));
        emailBtn.setMinimumSize(new java.awt.Dimension(69, 27));
        emailBtn.setPreferredSize(new java.awt.Dimension(69, 27));
        emailBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailBtnMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emailBtnMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emailBtnMouseEntered(evt);
            }
        });
        emailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailBtnActionPerformed(evt);
            }
        });

        smsBtn.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        smsBtn.setText("sms");
        smsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smsBtnMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                smsBtnMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                smsBtnMouseEntered(evt);
            }
        });
        smsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smsBtnActionPerformed(evt);
            }
        });

        facebookBtn.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        facebookBtn.setText("Facebook");
        facebookBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                facebookBtnMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                facebookBtnMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                facebookBtnMouseEntered(evt);
            }
        });
        facebookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facebookBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        backBtn.setText("Powrót");
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backBtnMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backBtnMouseEntered(evt);
            }
        });
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(facebookBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(smsBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(smsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(facebookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
        );

        jLabel1.setText("Med Plus v0.4");

        infoLbl.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoLbl)
                .addContainerGap(351, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_emailBtnMouseClicked

    private void emailBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailBtnMouseExited
        infoLbl.setText("");
    }//GEN-LAST:event_emailBtnMouseExited

    private void emailBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailBtnMouseEntered
        infoLbl.setText(String.format("<html><div style=\"width:300px;\">%s</div><html>", "Ustawienia konta e-mail"));
    }//GEN-LAST:event_emailBtnMouseEntered

    private void emailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailBtnActionPerformed
        emailSettingPopUp.initEmailSettingPopUp();
        emailSettingPopUp.setVisible(true);
        emailSettingPopUp.setAlwaysOnTop(true);
    }//GEN-LAST:event_emailBtnActionPerformed

    private void smsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smsBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_smsBtnMouseClicked

    private void smsBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smsBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_smsBtnMouseExited

    private void smsBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smsBtnMouseEntered
        infoLbl.setText(String.format("<html><div style=\"width:300px;\">%s</div><html>", "Ustawienia bramki sms"));
    }//GEN-LAST:event_smsBtnMouseEntered

    private void smsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_smsBtnActionPerformed

    private void facebookBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facebookBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_facebookBtnMouseClicked

    private void facebookBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facebookBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_facebookBtnMouseExited

    private void facebookBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facebookBtnMouseEntered
        infoLbl.setText(String.format("<html><div style=\"width:300px;\">%s</div><html>", "Ustawienia konta Facebook"));
    }//GEN-LAST:event_facebookBtnMouseEntered

    private void facebookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facebookBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_facebookBtnActionPerformed

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backBtnMouseClicked

    private void backBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_backBtnMouseExited

    private void backBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseEntered
        infoLbl.setText(String.format("<html><div style=\"width:300px;\">%s</div><html>", "Powrót do poprzedniego ekranu"));
    }//GEN-LAST:event_backBtnMouseEntered

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        settingsPanel.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton emailBtn;
    private javax.swing.JButton facebookBtn;
    private javax.swing.JLabel infoLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton smsBtn;
    // End of variables declaration//GEN-END:variables
}
