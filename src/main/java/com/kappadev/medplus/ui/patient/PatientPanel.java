/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kappadev.medplus.ui.patient;

import java.awt.Color;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import com.kappadev.medplus.ui.custom.MessagePopUp;
import com.kappadev.medplus.ui.appMenu.AppMenuPanel;
import com.kappadev.medplus.ui.search.SearchPanel;
import com.kappadev.medplus.data.DB.Database;
import com.kappadev.medplus.data.DB.DatabaseImpl;
import com.kappadev.medplus.data.DB.states.States;
import com.kappadev.medplus.data.DB.states.StatesService;
import com.kappadev.medplus.data.Patient.Patient;
import com.kappadev.medplus.data.Patient.PatientService;
import com.kappadev.medplus.data.PatientLog.PatientLog;
import com.kappadev.medplus.data.PatientLog.PatientLogService;
import com.kappadev.medplus.utils.ConvertUtils;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Tomasz
 */
@Component
public class PatientPanel extends javax.swing.JFrame {

    List<States> states;
    Database db;
    Patient patient;
    MessagePopUp peselError;
    MessagePopUp patientAdded;
    MessagePopUp patientEdit;
    MessagePopUp otherError;
    private static final String PESEL_ERROR_TXT = "Proszę wypełnić pole poprawnym numerem PESEL. W Polu wymagane jest 11 cyfr ";
    private static final String PESEL_REG_EXP = "^\\d{11}$";
    private static final String PATIENT_ADDED = "Dodano pacjenta o numerze PESEL: ";
    private static final String PATIENT_SAVED = "Zapisano zmiany dla pacjenta o numerze PESEL: ";
    private static final String PATIENT_NOT_ADDED_ERROR = "Nie udało się dodać pacjenta: ";
    private static final String OTHER_ERROR = "Wystąpił nieoczekiwany błąd ";

    @Autowired
    private AppMenuPanel registryPanel;
    
    @Autowired
    private StatesService statesService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientLogService patientLogService;

    public PatientPanel() {
    }

    public final void initPatientPanel() {
        initComponents();
        clearFields();
        infoLbl.setText("");
        db = new DatabaseImpl();
        peselError = new MessagePopUp();
        otherError = new MessagePopUp();
        patientAdded = new MessagePopUp();
        patientEdit = new MessagePopUp();
        states = statesService.getAllStates();

        stateComboBox.removeAllItems();
        DefaultComboBoxModel<States> comboBoxModel = new DefaultComboBoxModel<>();
        for (States state : states) {
            comboBoxModel.addElement(state);
        }
        stateComboBox.setModel(comboBoxModel);

    }

    public void initPatientPanel(Patient patient) {
        initComponents();
        clearFields();
        patientEdit = new MessagePopUp();
        this.patient = patient;
        infoLbl.setText("");
        states = statesService.getAllStates();

        stateComboBox.removeAllItems();
        DefaultComboBoxModel<States> comboBoxModel = new DefaultComboBoxModel<>();
        for (States state : states) {
            comboBoxModel.addElement(state);
        }
        stateComboBox.setModel(comboBoxModel);
        fillPatientFields(patient);

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
        jPanel1 = new javax.swing.JPanel();
        nameTxtFld = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        secondNameTxtFld = new javax.swing.JTextField();
        surnameTxtFld = new javax.swing.JTextField();
        streetTxtFld = new javax.swing.JTextField();
        houseNoTxtFld = new javax.swing.JTextField();
        flatTxtFld = new javax.swing.JTextField();
        cityTxtFld = new javax.swing.JTextField();
        postCodeTxtFld = new javax.swing.JTextField();
        phoneTxtFld = new javax.swing.JTextField();
        stateComboBox = new javax.swing.JComboBox();
        peselIdTxtFld = new javax.swing.JTextField();
        peselIdLbl = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        emailTxtFld = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        saveBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        infoLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setText("Med Plus v0.3");

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 15)); // NOI18N
        jLabel2.setText("Panel dodawania nowego pacjenta do bazy danych");

        nameTxtFld.setText("jTextField1");

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel3.setText("imię");

        secondNameTxtFld.setText("jTextField2");

        surnameTxtFld.setText("jTextField3");

        streetTxtFld.setText("jTextField4");

        houseNoTxtFld.setText("jTextField5");
        houseNoTxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                houseNoTxtFldActionPerformed(evt);
            }
        });

        flatTxtFld.setText("jTextField6");
        flatTxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flatTxtFldActionPerformed(evt);
            }
        });

        cityTxtFld.setText("jTextField7");

        postCodeTxtFld.setText("jTextField1");

        phoneTxtFld.setText("jTextField1");
        phoneTxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTxtFldActionPerformed(evt);
            }
        });

        stateComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        peselIdTxtFld.setText("jTextField1");

        peselIdLbl.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        peselIdLbl.setText("PESEL");

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel10.setText("województwo");

        jLabel12.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel12.setText("telefon");

        jLabel11.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel11.setText("kod pocztowy");

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel9.setText("miejscowość");

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel8.setText("nr lokalu");

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel7.setText("nr domu");

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel6.setText("ulica");

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel5.setText("Nazwisko");

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel4.setText("drugie imię");

        jLabel13.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel13.setText("e-mail");

        emailTxtFld.setText("jTextField1");
        emailTxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTxtFldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(peselIdLbl))
                        .addGap(107, 107, 107)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stateComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(peselIdTxtFld)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(156, 156, 156)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(171, 171, 171)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailTxtFld)
                            .addComponent(nameTxtFld, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(postCodeTxtFld)
                            .addComponent(flatTxtFld)
                            .addComponent(houseNoTxtFld)
                            .addComponent(streetTxtFld)
                            .addComponent(secondNameTxtFld)
                            .addComponent(surnameTxtFld)
                            .addComponent(phoneTxtFld)
                            .addComponent(cityTxtFld, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(secondNameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(streetTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(houseNoTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(flatTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postCodeTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(peselIdTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(peselIdLbl))
                .addContainerGap())
        );

        saveBtn.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
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

        clearBtn.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        clearBtn.setText("Wyczyść");
        clearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearBtnMouseExited(evt);
            }
        });
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(clearBtn)))
        );

        backBtn.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        backBtn.setText("Powrót");
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backBtnMouseExited(evt);
            }
        });
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        infoLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        infoLbl.setText("jLabel13");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(infoLbl)
                .addGap(0, 279, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoLbl)
                .addContainerGap(364, Short.MAX_VALUE))
        );

        infoLbl.getAccessibleContext().setAccessibleName("infoLbl");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        clearFields();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        registryPanel.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        //TODO fix this 
        
        String sName = secondNameTxtFld.getText();
        String surname = surnameTxtFld.getText();
        String street = streetTxtFld.getText();

        String postCode = postCodeTxtFld.getText().replace("-", "");
        String phone = phoneTxtFld.getText();
        
        States state = (States) stateComboBox.getSelectedItem();
        if (patient != null) {
            patient.setCity(cityTxtFld.getText());
            patient.setFlat(flatTxtFld.getText());
            patient.setHouseNo(houseNoTxtFld.getText());
            patient.setName(nameTxtFld.getText());
            patient.setPhone(phoneTxtFld.getText());
            patient.setPostCode(postCodeTxtFld.getText());
            patient.setSecondName(secondNameTxtFld.getText());
            patient.setState(state);
            patient.setStreet(streetTxtFld.getText());
            patient.setSurname(surnameTxtFld.getText());
            patient.setEmail(emailTxtFld.getText());
            patient.setPatientLog(patient.getPatientLog());
            patient.setPesel(peselIdTxtFld.getText());
            patientService.savePatient(patient);
            patientEdit.setText(PATIENT_SAVED + peselIdTxtFld.getText());
            patientEdit.setVisible(true);
            boolean result = patientEdit.getStateResult();
            if (result) {
                SearchPanel sp = new SearchPanel();
                sp.setVisible(true);
                this.dispose();
            }

        } else {
            Patient newPatient = new Patient();

            newPatient.setCity(cityTxtFld.getText());
            newPatient.setFlat(flatTxtFld.getText());
            newPatient.setHouseNo(houseNoTxtFld.getText());
            newPatient.setName(nameTxtFld.getText());
            newPatient.setPhone(phone);
            newPatient.setPostCode(postCode);
            newPatient.setSecondName(sName);
            newPatient.setState(state);
            newPatient.setStreet(street);
            newPatient.setSurname(surname);
            newPatient.setPesel(peselIdTxtFld.getText());
            newPatient.setEmail(emailTxtFld.getText());
            
            PatientLog newPatientLog = new PatientLog();
            newPatientLog.setModificationDate(new Date());

//            if (!peselIdTxtFld.getText().matches(PESEL_REG_EXP) || "".equals(peselIdTxtFld.getText()) || null == peselIdTxtFld.getText()) {
//                peselError.setText(PESEL_ERROR_TXT);
//                peselError.setVisible(true);
//                peselIdTxtFld.setBackground(Color.red);
//            } else {
                patientService.savePatient(patient);
                //TODO add this functionality correctly
                patientAdded.setText(PATIENT_ADDED + peselIdTxtFld.getText());
                patientAdded.setVisible(true);
                boolean result = patientAdded.getStateResult();
                if (result) {
                    SearchPanel sp = new SearchPanel();
                    sp.setVisible(true);
                    this.dispose();
                }

//            }
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void houseNoTxtFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_houseNoTxtFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_houseNoTxtFldActionPerformed

    private void flatTxtFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flatTxtFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_flatTxtFldActionPerformed

    private void saveBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseEntered
        infoLbl.setText("Zapisz zmiany w danych pacjenta");
    }//GEN-LAST:event_saveBtnMouseEntered

    private void clearBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseEntered
        infoLbl.setText("Wyczyść pola");
    }//GEN-LAST:event_clearBtnMouseEntered

    private void backBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseEntered
        infoLbl.setText("Powrót do poprzedniego ekranu");
    }//GEN-LAST:event_backBtnMouseEntered

    private void clearBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseExited
        infoLbl.setText("");
    }//GEN-LAST:event_clearBtnMouseExited

    private void saveBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseExited
        infoLbl.setText("");
    }//GEN-LAST:event_saveBtnMouseExited

    private void backBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseExited
        infoLbl.setText("");
    }//GEN-LAST:event_backBtnMouseExited

    private void phoneTxtFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneTxtFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneTxtFldActionPerformed

    private void emailTxtFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTxtFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTxtFldActionPerformed

    private void clearFields() {
        nameTxtFld.setText("");
        secondNameTxtFld.setText("");
        surnameTxtFld.setText("");
        streetTxtFld.setText("");
        houseNoTxtFld.setText("");
        flatTxtFld.setText("");
        cityTxtFld.setText("");
        postCodeTxtFld.setText("");
        phoneTxtFld.setText("");
        peselIdTxtFld.setText("");
    }

    private void fillPatientFields(Patient patient) {
        nameTxtFld.setText(patient.getName());
        secondNameTxtFld.setText(patient.getSecondName());
        surnameTxtFld.setText(patient.getSurname());
        streetTxtFld.setText(patient.getStreet());
        houseNoTxtFld.setText(patient.getHouseNo());
        flatTxtFld.setText(patient.getFlat());
        cityTxtFld.setText(patient.getCity());
        postCodeTxtFld.setText(ConvertUtils.convertPostCode(patient.getPostCode()));
        phoneTxtFld.setText(patient.getPhone());
        peselIdTxtFld.setText(String.valueOf(patient.getId()));
        stateComboBox.setSelectedItem(ConvertUtils.convertStatesListToMap(states).get(patient.getState()));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField cityTxtFld;
    private javax.swing.JButton clearBtn;
    private javax.swing.JTextField emailTxtFld;
    private javax.swing.JTextField flatTxtFld;
    private javax.swing.JTextField houseNoTxtFld;
    private javax.swing.JLabel infoLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField nameTxtFld;
    private javax.swing.JLabel peselIdLbl;
    private javax.swing.JTextField peselIdTxtFld;
    private javax.swing.JTextField phoneTxtFld;
    private javax.swing.JTextField postCodeTxtFld;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField secondNameTxtFld;
    private javax.swing.JComboBox stateComboBox;
    private javax.swing.JTextField streetTxtFld;
    private javax.swing.JTextField surnameTxtFld;
    // End of variables declaration//GEN-END:variables
}
