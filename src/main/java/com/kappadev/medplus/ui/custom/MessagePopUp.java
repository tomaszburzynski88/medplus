package com.kappadev.medplus.ui.custom;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 *
 * @author Tomasz
 */
public class MessagePopUp extends javax.swing.JDialog {

    /**
     * Creates new form MessagePopUp
     */
    private boolean state = false;

    public MessagePopUp() {
        setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
        initComponents();
        this.setPreferredSize(new Dimension(550, 300));
        this.setMaximumSize(new Dimension(550, 300));
        this.setMinimumSize(new Dimension(550, 300));
        this.pack();
    }

    public void setText(String text) {
        text = String.format("<html><div style=\"width:300px;\">%s</div><html>", text);
        messageLabel.setLayout(new GridLayout());
        messageLabel.setText(text);
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        messageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);

        okBtn.setText("OK");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Anuluj");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messageLabel.setText("put text here ...");
        messageLabel.setName(""); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(okBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelBtn)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(messageLabel)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okBtn)
                    .addComponent(cancelBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        state = true;
        this.dispose();
    }//GEN-LAST:event_okBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        state = false;
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    public void setStateResult(boolean state) {
        this.state = state;
    }

    public boolean getStateResult() {
        return state;
    }

    public javax.swing.JButton getOk() {
        return okBtn;
    }

    public javax.swing.JButton getCancel() {
        return cancelBtn;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JButton okBtn;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JLabel getMessageLabel() {
        return messageLabel;
    }
}
