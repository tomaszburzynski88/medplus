/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kappadev.medplus.ui.patientLog;

import com.kappadev.medplus.ui.patientLog.models.AttachmentTableModel;
import com.kappadev.medplus.ui.textTool.TextTools;
import com.kappadev.medplus.ui.printer.PrinterSelection;
import java.awt.Desktop;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.swing.JFileChooser;
import com.kappadev.medplus.ui.MessagePopUp;
import com.kappadev.medplus.ui.SearchPanel;
import com.kappadev.medplus.data.DB.DISEASE.entity.Disease;
import com.kappadev.medplus.data.DB.DISEASE.repository.DiseaseRepository;
import com.kappadev.medplus.data.DB.attachment.entity.Attachment;
import com.kappadev.medplus.data.DB.attachment.repository.AttachmentRepository;
import com.kappadev.medplus.data.Patient.entity.Patient;
import com.kappadev.medplus.data.PatientLog.entity.PatientLog;
import com.kappadev.medplus.data.PatientLog.repository.PatientLogRepository;
import com.kappadev.medplus.data.migration.DataMigrationConstants;
import com.kappadev.medplus.data.printing.PrintingManager;
import com.kappadev.medplus.data.printing.PrintingManagerImpl;
import com.kappadev.medplus.utils.FileCheckThread;
import com.kappadev.medplus.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Tomasz
 */
public class PatientLogPanel extends javax.swing.JFrame {

    /**
     * Creates new form PatientLogPanel
     */
    private Patient patient;
    private Disease disease;
    private AttachmentTableModel attachmentlistModel;
    private List<Attachment> attachmentList;
    private PatientLog patientLog;
    private MessagePopUp openFileDialogComplete;
    private MessagePopUp warning;
    private PrintingManager printingManager;
    private ExecutorService service;
    private Future<Boolean> task;
    private FileCheckThread fileCheckThread;
    private File tmpDir;

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private PatientLogRepository patientLogRepository;

    private static final String OPEN_FILE_DIALOG_COMPLETE = "Plik został zapisany w: ";
    private static final String DELETE_ATTACHMENT = "Czy aby napewno chcesz usunąć ten załącznik ?";
    private static final int CANCEL_NOT_VISIBLE = 63;
    private static final String TMP_DIR = "tmp";

    public PatientLogPanel(Patient patient) {
        initComponents();
        tmpDir = new File(FileUtils.getCurrentWorkingPath() + File.separatorChar + "tmp");
        if (!tmpDir.exists()) {
            tmpDir.mkdirs();
        }
        this.patient = patient;
        infoLbl.setText("");
        service = Executors.newFixedThreadPool(2);
        fileCheckThread = new FileCheckThread();
        nameLbl.setText(patient.getName());
        surnameLbl.setText(patient.getSurname());
        peselLbl.setText(String.valueOf(patient.getId()));
        openBtn.setEnabled(false);
        printingManager = new PrintingManagerImpl();
        warning = new MessagePopUp();
        openFileDialogComplete = new MessagePopUp();
        openFileDialogComplete.getCancel().setVisible(false);
        if (DataMigrationConstants.DATA_MIGRATION_WINDOWS != FileUtils.getOperatingSystemName()) {
            openBtn.setEnabled(false);
        }
        attachmentList = new ArrayList<>();
        attachmentList = attachmentRepository.findAllAttachmentsByPatientId(patient.getId());
        disease = patient.getDisease();
        patientLog = patientLogRepository.findPatientLogByPatientId(new Long(patient.getId()));

        if (patientLog != null) {
            descriptionTxtField.setText(patientLog.getNote());
        }
        attachmentlistModel = new AttachmentTableModel(attachmentList);
        attachmentsList.setModel(attachmentlistModel);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        addNewBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        openBtn = new javax.swing.JButton();
        printDescriptionBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        surnameLbl = new javax.swing.JLabel();
        peselLbl = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        attachmentsList = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionTxtField = new javax.swing.JTextPane();
        textToolBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        infoLbl = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        printAttach = new javax.swing.JButton();
        printAllBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setText("Med Plus v0.3");

        jLabel2.setText("historia choroby pacjenta");

        jLabel3.setText("opis");

        jLabel4.setText("lista załączników");

        addNewBtn.setText("Dodaj nowy");
        addNewBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addNewBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addNewBtnMouseExited(evt);
            }
        });
        addNewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Usuń");
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteBtnMouseExited(evt);
            }
        });
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        openBtn.setText("Otwórz");
        openBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                openBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                openBtnMouseExited(evt);
            }
        });
        openBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openBtnActionPerformed(evt);
            }
        });

        printDescriptionBtn.setText("Drukuj opis");
        printDescriptionBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printDescriptionBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printDescriptionBtnMouseExited(evt);
            }
        });
        printDescriptionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printDescriptionBtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Imię");

        jLabel6.setText("Nazwisko");

        jLabel7.setText("PESEL");

        nameLbl.setText("nameValue");

        surnameLbl.setText("surnameValue");

        peselLbl.setText("PESEL num");

        attachmentsList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        attachmentsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attachmentsListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(attachmentsList);

        jLabel9.setText("Telefon:");

        jLabel10.setText("telefon");

        jScrollPane2.setViewportView(descriptionTxtField);

        textToolBtn.setText("Formatuj tekst");
        textToolBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textToolBtnActionPerformed(evt);
            }
        });

        jButton2.setText("Info choroby");

        infoLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        infoLbl.setText("jLabel11");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoLbl)
                .addGap(138, 138, 138))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(infoLbl)
                .addGap(0, 0, 0))
        );

        infoLbl.getAccessibleContext().setAccessibleName("infoLbl");

        printAttach.setText("Drukuj załącznik");
        printAttach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printAttachMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printAttachMouseExited(evt);
            }
        });
        printAttach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printAttachActionPerformed(evt);
            }
        });

        printAllBtn.setText("Drukuj wszystko");
        printAllBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printAllBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printAllBtnMouseExited(evt);
            }
        });
        printAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printAllBtnActionPerformed(evt);
            }
        });

        closeBtn.setText("Zamknij");
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeBtnMouseExited(evt);
            }
        });
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        saveBtn.setText("Zapisz");
        saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveBtnMouseExited(evt);
            }
        });
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(printAllBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printAttach))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printAllBtn)
                    .addComponent(printAttach)
                    .addComponent(closeBtn)
                    .addComponent(saveBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(nameLbl))
                                    .addComponent(peselLbl)
                                    .addComponent(surnameLbl)
                                    .addComponent(jLabel10)))
                            .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addNewBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(openBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(printDescriptionBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textToolBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(nameLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(surnameLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(peselLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(74, 74, 74)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textToolBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(printDescriptionBtn))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(openBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addNewBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))))
        );

        jLabel1.getAccessibleContext().setAccessibleName("MedRegistry v0.3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        List<Attachment> selectedAttachments = attachmentlistModel.getSelectedAttachmentList(attachmentsList.getSelectedRows());
        warning.setText(DELETE_ATTACHMENT);
        warning.setVisible(true);
        boolean result = warning.getStateResult();
        if (result) {
            attachmentRepository.delete(selectedAttachments);
            attachmentList = attachmentRepository.findAllAttachmentsByPatientId(patient.getId());
            attachmentlistModel = new AttachmentTableModel(attachmentList);
            attachmentsList.setModel(attachmentlistModel);

        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void addNewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewBtnActionPerformed
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jFileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + File.separatorChar + "Desktop"));
        int result = jFileChooser.showOpenDialog(this);
        File selectedFile = null;
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = jFileChooser.getSelectedFile();
        }
        Attachment attachment = new Attachment();
        try {
            byte[] selectedFileByteArray = new byte[(int) selectedFile.length()];
            DataInputStream dataIs = new DataInputStream(new FileInputStream(selectedFile));
            dataIs.readFully(selectedFileByteArray);
            attachment.setBlob(selectedFileByteArray);
            attachment.setContentType("");
            attachment.setFileName(selectedFile.getName());
            attachment.setPatient(patient);
            attachmentRepository.save(attachment);
            attachmentList = attachmentRepository.findAllAttachmentsByPatientId(patient.getId());
            attachmentlistModel = new AttachmentTableModel(attachmentList);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PatientLogPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PatientLogPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        AttachmentTableModel listModel = new AttachmentTableModel(attachmentList);
        attachmentsList.setModel(listModel);
    }//GEN-LAST:event_addNewBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        SearchPanel sp = new SearchPanel();
        sp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        patientLog.setNote(descriptionTxtField.getText());
        patientLogRepository.save(patientLog);
    }//GEN-LAST:event_saveBtnActionPerformed

    private void openBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openBtnActionPerformed
        int selectedRow = attachmentsList.getSelectedRow();
        Attachment attachment = attachmentlistModel.getSelectedAttachment(selectedRow);
        File file = new File(tmpDir.getAbsolutePath() + File.separator + attachment.getFileName());
        FileOutputStream fos;
        FileTime lastModified;
        try {
            fos = new FileOutputStream(file);
            fos.write(attachment.getBlob());
            fos.close();
            lastModified = Files.getLastModifiedTime(Paths.get(file.getAbsolutePath()));
            Desktop.getDesktop().open(file);

            MessagePopUp message = new MessagePopUp();
            message.setText("Czy zakończyłeś edycję dokumentu ?");
            message.setVisible(true);
            boolean isFileNotOpen = message.getStateResult();
            if (isFileNotOpen) {
                if (lastModified != null) {
                    if (Files.getLastModifiedTime(Paths.get(file.getAbsolutePath())).compareTo(lastModified) > 1
                            && Files.readAllBytes(Paths.get(file.getAbsolutePath())) != attachment.getBlob()) {
                        attachmentRepository.save(attachment);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(PatientLogPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

//        JFileChooser jFileChooser = new JFileChooser();
//        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        jFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
//        int result = jFileChooser.showOpenDialog(this);
//        File selectedDir = null;
//        if(result == JFileChooser.APPROVE_OPTION){
//            selectedDir = jFileChooser.getSelectedFile();
//        }
//        try {
//            File file = new File(selectedDir.getAbsolutePath()+"/"+attachment.getFileName());
//            FileOutputStream fos = new FileOutputStream(file);
//            fos.write(attachment.getBlob());
//            fos.close();
//            openFileDialogComplete.setText(OPEN_FILE_DIALOG_COMPLETE+" "+file.getAbsolutePath());
//            openFileDialogComplete.pack();
//            openFileDialogComplete.setVisible(true);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(PatientLogPanel.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(PatientLogPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }//GEN-LAST:event_openBtnActionPerformed

    private void printAttachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printAttachActionPerformed
        if (attachmentsList.getSelectedRows().length > 0) {
            List<Attachment> attachments = attachmentlistModel.getSelectedAttachmentList(attachmentsList.getSelectedRows());
            PrintService[] printServices = printingManager.getPrintServices();
            PrinterSelection printerSelection = new PrinterSelection(printServices);
            printerSelection.setVisible(true);
            PrintService selectedPrintService = printerSelection.getSelectedPrinter();
            for (Attachment attachment : attachments) {
                File file = FileUtils.blobToFile(attachment.getBlob(), tmpDir.getAbsolutePath() + File.separator + attachment.getFileName());
                printingManager.printDocument(file, selectedPrintService);
            }
        }
    }//GEN-LAST:event_printAttachActionPerformed

    private void attachmentsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attachmentsListMouseClicked
        if (attachmentsList.getSelectedRows().length == 1) {
            openBtn.setEnabled(true);
        }
    }//GEN-LAST:event_attachmentsListMouseClicked

    private void printDescriptionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printDescriptionBtnActionPerformed
        byte[] descriptionData = descriptionTxtField.getText().getBytes();
        File filePrint = FileUtils.blobToFile(descriptionData, "opis.txt");
        PrintService[] printServices = printingManager.getPrintServices();
        PrinterSelection printerSelection = new PrinterSelection(printServices);
        printerSelection.setVisible(true);
        PrintService selectedPrintService = printerSelection.getSelectedPrinter();
        printingManager.printDocument(filePrint, selectedPrintService);
    }//GEN-LAST:event_printDescriptionBtnActionPerformed

    private void printAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printAllBtnActionPerformed
        byte[] descriptionData = descriptionTxtField.getText().getBytes();
        PrintService[] printServices = printingManager.getPrintServices();
        PrinterSelection printerSelection = new PrinterSelection(printServices);
        printerSelection.setVisible(true);
        PrintService selectedPrintService = printerSelection.getSelectedPrinter();
        for (Attachment attachment : attachmentList) {
            File file = FileUtils.blobToFile(attachment.getBlob(), tmpDir.getAbsolutePath() + File.separatorChar + attachment.getFileName());
            printingManager.printDocument(file, selectedPrintService);
        }
        File filePrint = FileUtils.blobToFile(descriptionData, tmpDir.getAbsolutePath() + File.separatorChar + "opis.txt");
        printingManager.printDocument(filePrint, selectedPrintService);
    }//GEN-LAST:event_printAllBtnActionPerformed

    private void saveBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseEntered
        infoLbl.setText(String.format("<html><div style=\"width:150px;\">%s</div><html>", "Zapisz historię pacjenta"));
    }//GEN-LAST:event_saveBtnMouseEntered

    private void closeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseEntered
        infoLbl.setText(String.format("<html><div style=\"width:150px;\">%s</div><html>", "Zamknij historię pacjenta i powróć do poprzedniego ekranu"));
    }//GEN-LAST:event_closeBtnMouseEntered

    private void printAllBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printAllBtnMouseEntered
        infoLbl.setText(String.format("<html><div style=\"width:150px;\">%s</div><html>", "Drukuj wszystkie załączniki i opis historii pacjenta"));
    }//GEN-LAST:event_printAllBtnMouseEntered

    private void printAttachMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printAttachMouseEntered
        infoLbl.setText(String.format("<html><div style=\"width:150px;\">%s</div><html>", "Drukuj zaznaczony załącznik"));
    }//GEN-LAST:event_printAttachMouseEntered

    private void addNewBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewBtnMouseEntered
        infoLbl.setText(String.format("<html><div style=\"width:150px;\">%s</div><html>", "Dodaj nowy załącznik"));
    }//GEN-LAST:event_addNewBtnMouseEntered

    private void deleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseEntered
        infoLbl.setText(String.format("<html><div style=\"width:150px;\">%s</div><html>", "Usuń załącznik"));
    }//GEN-LAST:event_deleteBtnMouseEntered

    private void openBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openBtnMouseEntered
        infoLbl.setText(String.format("<html><div style=\"width:150px;\">%s</div><html>", "Otwórz załącznik"));
    }//GEN-LAST:event_openBtnMouseEntered

    private void printDescriptionBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printDescriptionBtnMouseEntered
        infoLbl.setText(String.format("<html><div style=\"width:150px;\">%s</div><html>", "Drukuj opis"));
    }//GEN-LAST:event_printDescriptionBtnMouseEntered

    private void printAllBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printAllBtnMouseExited
        infoLbl.setText("");
    }//GEN-LAST:event_printAllBtnMouseExited

    private void printDescriptionBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printDescriptionBtnMouseExited
        infoLbl.setText("");
    }//GEN-LAST:event_printDescriptionBtnMouseExited

    private void openBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openBtnMouseExited
        infoLbl.setText("");
    }//GEN-LAST:event_openBtnMouseExited

    private void addNewBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewBtnMouseExited
        infoLbl.setText("");
    }//GEN-LAST:event_addNewBtnMouseExited

    private void deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseExited
        infoLbl.setText("");
    }//GEN-LAST:event_deleteBtnMouseExited

    private void printAttachMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printAttachMouseExited
        infoLbl.setText("");
    }//GEN-LAST:event_printAttachMouseExited

    private void closeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseExited
        infoLbl.setText("");
    }//GEN-LAST:event_closeBtnMouseExited

    private void saveBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseExited
        infoLbl.setText("");
    }//GEN-LAST:event_saveBtnMouseExited

    private void textToolBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textToolBtnActionPerformed
        TextTools textToolsWindow = new TextTools(this);
        textToolsWindow.setVisible(true);
    }//GEN-LAST:event_textToolBtnActionPerformed

    public javax.swing.JTextPane getDescriptionTxtField() {
        return descriptionTxtField;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewBtn;
    private javax.swing.JTable attachmentsList;
    private javax.swing.JButton closeBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextPane descriptionTxtField;
    private javax.swing.JLabel infoLbl;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JButton openBtn;
    private javax.swing.JLabel peselLbl;
    private javax.swing.JButton printAllBtn;
    private javax.swing.JButton printAttach;
    private javax.swing.JButton printDescriptionBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel surnameLbl;
    private javax.swing.JButton textToolBtn;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
