package com.health.service;

import com.health.model.Patient;
import com.health.repository.IPatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService implements IPatientService {
    //@Autowired
    private final IPatientRepository repo;

    @Override
    public Patient save(Patient patient) throws Exception {
        return repo.save(patient);
    }

    @Override
    public Patient update(Patient patient, Integer id) throws Exception {
        // EVALUACION CON EL ID
        // API REFLEXION
        patient.setIdPatient(id);
        return repo.save(patient);
    }

    @Override
    public List<Patient> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Patient findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Patient());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }

    /*public PatientService(IPatientRepository repo) {
        this.repo = repo;
    }*/

    /*@Override
    public Patient validAndSave(Patient patient) {
        if(patient.getIdPatient() > 0){
            return repo.save(patient);
        }else{
            return new Patient();
        }
    }
     */
}
