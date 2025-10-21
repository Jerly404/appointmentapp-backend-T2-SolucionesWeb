package com.health.controller;

import com.health.dto.LaboratoryDTO;
import com.health.model.Laboratory;
import com.health.service.ILaboratoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/laboratories")
@RequiredArgsConstructor
public class LaboratoryController {

    private final ILaboratoryService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    // GET: listar todos los laboratorios
    @GetMapping
    public ResponseEntity<List<LaboratoryDTO>> findAll() throws Exception {
        List<LaboratoryDTO> list = service.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    // GET: obtener laboratorio por ID
    @GetMapping("/{id}")
    public ResponseEntity<LaboratoryDTO> findById(@PathVariable("id") Integer id) throws Exception {
        LaboratoryDTO dto = convertToDto(service.findById(id));
        return ResponseEntity.ok(dto);
    }

    // POST: crear nuevo laboratorio
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody LaboratoryDTO dto) throws Exception {
        Laboratory obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdLaboratory())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    // PUT: actualizar laboratorio existente
    @PutMapping("/{id}")
    public ResponseEntity<LaboratoryDTO> update(@Valid @PathVariable("id") Integer id,
                                                @RequestBody LaboratoryDTO dto) throws Exception {
        Laboratory obj = service.update(convertToEntity(dto), id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    // DELETE: eliminar laboratorio por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Convertir de Entity a DTO
    private LaboratoryDTO convertToDto(Laboratory obj) {
        return modelMapper.map(obj, LaboratoryDTO.class);
    }

    // Convertir de DTO a Entity
    private Laboratory convertToEntity(LaboratoryDTO dto) {
        return modelMapper.map(dto, Laboratory.class);
    }
}
