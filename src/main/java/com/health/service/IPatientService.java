package com.health.service;

import com.health.model.Patient;

public interface IPatientService {
    Patient validAndSave(Patient patient);
}
