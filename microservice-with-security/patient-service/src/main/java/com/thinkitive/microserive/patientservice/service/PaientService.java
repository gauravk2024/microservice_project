package com.thinkitive.microserive.patientservice.service;

import com.thinkitive.microserive.patientservice.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PaientService {
    public Patient getOnePatient(int id);
    public Patient createPatient(Patient patient);
    public Patient updatePatient(int id, Patient patient);
    public void deletePatient(int id);
    public List<Patient> getAllList();
}
