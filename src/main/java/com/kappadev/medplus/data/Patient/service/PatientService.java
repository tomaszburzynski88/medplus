/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kappadev.medplus.data.Patient.service;

import com.kappadev.medplus.data.Patient.entity.Patient;
import com.kappadev.medplus.data.PatientLog.entity.PatientLog;
import java.util.List;

/**
 *
 * @author tburzynski
 */
public interface PatientService {

    public List<Patient> getAllPatients();
    
    public void savePatient(Patient patient);
    
    public void removePatient(Patient patient);
    
    public Patient getPatientById(Long id);
    
    public void removePatientList(List<Patient> patientList);
    
    public List<Patient> getFilteredPatients(Patient patient);
    
    public void addPatientLogToPatient(PatientLog patientLog, Patient patient);
    
    public PatientLog getPatientLogByPatientId(Long id);
}
