package com.health.service;

import com.health.model.Patient;
import com.health.repository.IPatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService implements IPatientService {
    private final IPatientRepository repo;

    /*public PatientService(IPatientRepository repo) {
        this.repo = repo;
    }*/

    @Override
    public Patient validAndSave(Patient patient) {
        if(patient.getIdPatient() > 0){
            return repo.save(patient);
        }else{
            return new Patient();
        }
    }
}
