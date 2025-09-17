package com.health.controller;

import com.health.model.Patient;
import com.health.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/patients")
//@AllArgsConstructor
@RequiredArgsConstructor
public class PatientController {
    //@Autowired
    private final IPatientService service;

    @GetMapping
    public ResponseEntity<List<Patient>>  findAll() throws Exception{
        List<Patient> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient>  findById(@PathVariable("id") Integer id) throws Exception{
        Patient obj =  service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Patient> save(@RequestBody Patient patient) throws Exception{
        Patient obj = service.save(patient);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPatient()).toUri();
        // return ResponseEntity.ok(obj);
        //return new ResponseEntity<>(obj, HttpStatus.CREATED);
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> update(@PathVariable("id") Integer id, @RequestBody Patient patient) throws Exception{
        Patient obj =  service.update(patient, id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    /*public PatientController(IPatientService service) {
        this.service = service;
    }*/

    /*@GetMapping
    public Patient savePatient(){
        // Pedirle al servicio que me envie informacion
        //service = new PatientService();
        return service.validAndSave(new Patient());
        //return new Patient(1,"Carlos","Valdivia");
    }
     */
}
