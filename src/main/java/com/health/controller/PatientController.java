package com.health.controller;

import com.health.model.Patient;
import com.health.service.IPatientService;
import com.health.service.PatientService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
//@AllArgsConstructor
@RequiredArgsConstructor
public class PatientController {
    //@Autowired
    private final IPatientService service;
    private String atributoEjemplo;

    /*public PatientController(IPatientService service) {
        this.service = service;
    }*/

    @GetMapping
    public Patient savePatient(){
        // Pedirle al servicio que me envie informacion
        //service = new PatientService();
        return service.validAndSave(new Patient());
        //return new Patient(1,"Carlos","Valdivia");
    }
}
