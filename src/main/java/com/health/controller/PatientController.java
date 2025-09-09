package com.health.controller;

import com.health.model.Patient;
import com.health.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
//@AllArgsConstructor
@RequiredArgsConstructor
public class PatientController {
    //@Autowired
    private final IPatientService service;

    @GetMapping
    public List<Patient> findAll() throws Exception{
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Patient findById(@PathVariable("id") Integer id) throws Exception{
        return service.findById(id);
    }

    @PostMapping
    public Patient save(@RequestBody Patient patient) throws Exception{
        return service.save(patient);
    }

    @PutMapping("/{id}")
    public Patient update(@PathVariable("id") Integer id, @RequestBody Patient patient) throws Exception{
        return service.update(patient, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
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
