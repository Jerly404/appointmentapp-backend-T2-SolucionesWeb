package com.health.repository;

import com.health.model.Patient;

public interface IPatientRepository {
    Patient save(Patient patient);
}
