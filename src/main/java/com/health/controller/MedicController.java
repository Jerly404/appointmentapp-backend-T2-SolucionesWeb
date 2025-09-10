package com.health.controller;

import com.health.model.Medic;
import com.health.service.IMedicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medics")
@RequiredArgsConstructor
public class MedicController {
    private final IMedicService service;

    @GetMapping
    public List<Medic> findAll() throws Exception{
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Medic findById(@PathVariable("id") Integer id) throws Exception{
        return service.findById(id);
    }

    @PostMapping
    public Medic save(@RequestBody Medic medic) throws Exception{
        return service.save(medic);
    }

    @PutMapping("/{id}")
    public Medic update(@PathVariable("id") Integer id, @RequestBody Medic medic) throws Exception{
        return service.update(medic, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}
