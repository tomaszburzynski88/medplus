package com.kappadev.medplus.ui.main;

import com.kappadev.medplus.ui.appMenu.AppMenuPanel;
import com.kappadev.medplus.ui.settings.SettingsPanel;
import com.kappadev.medplus.ui.tools.ToolsPanel;
import java.io.File;
import com.kappadev.medplus.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Tomasz
 */
@Component
public class MainMenuPanel extends javax.swing.JFrame {

    @Autowired
    private AppMenuPanel registryPanel;
    @Autowired
    private SettingsPanel settingsPanel;

    /**
     * Creates new form MainPanel
     */
    public MainMenuPanel() {
        initComponents();
        infoLbl.setText("");
    }
    
    public void initMainMenuPanel(){
        initComponents();
        infoLbl.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        browseRegistry = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        toolsBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        infoLbl = new javax.swing.JLabel();
        settingsBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setText("Med Plus v0.4");

        browseRegistry.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        browseRegistry.setText("Przeglądaj rejestr");
        browseRegistry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                browseRegistryMouseEntered(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                browseRegistryMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                browseRegistryMouseExited(evt);
            }
        });
        browseRegistry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseRegistryActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jButton2.setText("Zakończ");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        toolsBtn.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        toolsBtn.setText("Narzędzia");
        toolsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                toolsBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                toolsBtnMouseExited(evt);
            }
        });
        toolsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolsBtnActionPerformed(evt);
            }
        });

        infoLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        infoLbl.setText("jLabel2");
        infoLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                infoLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                infoLblMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(infoLbl)
                .addGap(390, 390, 390))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(infoLbl)
                .addGap(0, 0, 0))
        );

        infoLbl.getAccessibleContext().setAccessibleName("infoLbl");

        settingsBtn.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        settingsBtn.setText("Ustawienia");
        settingsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsBtnMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsBtnMouseEntered(evt);
            }
        });
        settingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(settingsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(browseRegistry, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                        .addComponent(toolsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(browseRegistry, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(toolsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(settingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseRegistryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseRegistryActionPerformed

        registryPanel.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_browseRegistryActionPerformed

    private void browseRegistryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseRegistryMouseClicked

    }//GEN-LAST:event_browseRegistryMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        File tmpDir = new File(FileUtils.getCurrentWorkingPath() + File.separatorChar + "tmp");
        if (!tmpDir.exists()) {
            tmpDir.delete();
        }
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void toolsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolsBtnActionPerformed
        ToolsPanel tools = new ToolsPanel();
        tools.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_toolsBtnActionPerformed

    private void browseRegistryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseRegistryMouseEntered
        infoLbl.setText(String.format("<html><div style=\"width:300px;\">%s</div><html>", "Przeglądanie istniejących historii pacjenta, dodawanie nowych pacjentów, edytowanie i usuwanie danych"));
    }//GEN-LAST:event_browseRegistryMouseEntered

    private void browseRegistryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseRegistryMouseExited
        infoLbl.setText("");
    }//GEN-LAST:event_browseRegistryMouseExited

    private void toolsBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toolsBtnMouseEntered
        infoLbl.setText(String.format("<html><div style=\"width:300px;\">%s</div><html>", "Narzędzia do importu i eksportu bazy danych na zewnętrzny dysk, pendrive"));
    }//GEN-LAST:event_toolsBtnMouseEntered

    private void toolsBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toolsBtnMouseExited
        infoLbl.setText("");
    }//GEN-LAST:event_toolsBtnMouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        infoLbl.setText(String.format("<html><div style=\"width:300px;\">%s</div><html>", "Wyjście z programu"));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        infoLbl.setText("");
    }//GEN-LAST:event_jButton2MouseExited

    private void infoLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoLblMouseExited

    }//GEN-LAST:event_infoLblMouseExited

    private void infoLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoLblMouseEntered

    }//GEN-LAST:event_infoLblMouseEntered

    private void settingsBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBtnMouseEntered
        infoLbl.setText(String.format("<html><div style=\"width:300px;\">%s</div><html>", "Ustawienia programu, powiadomień e-mail, sms"));
    }//GEN-LAST:event_settingsBtnMouseEntered

    private void settingsBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBtnMouseExited
        infoLbl.setText("");
    }//GEN-LAST:event_settingsBtnMouseExited

    private void settingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsBtnActionPerformed
        settingsPanel.initSettingsPanel();
        settingsPanel.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_settingsBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseRegistry;
    private javax.swing.JLabel infoLbl;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton settingsBtn;
    private javax.swing.JButton toolsBtn;
    // End of variables declaration//GEN-END:variables
}
