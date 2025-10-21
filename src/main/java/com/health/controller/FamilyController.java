package com.health.controller;

import com.health.dto.FamiyDTO;
import com.health.model.Family;
import com.health.service.IFamilyService;
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
@RequestMapping("/families")
@RequiredArgsConstructor
public class FamilyController {

    private final IFamilyService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    // GET: Listar todas las familias
    @GetMapping
    public ResponseEntity<List<FamiyDTO>> findAll() throws Exception {
        List<FamiyDTO> list = service.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    // GET: Buscar una familia por ID
    @GetMapping("/{id}")
    public ResponseEntity<FamiyDTO> findById(@PathVariable("id") Integer id) throws Exception {
        FamiyDTO obj = convertToDto(service.findById(id));
        return ResponseEntity.ok(obj);
    }

    // POST: Crear una nueva familia
    @PostMapping
    public ResponseEntity<FamiyDTO> save(@Valid @RequestBody FamiyDTO dto) throws Exception {
        Family obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdFamily())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    // PUT: Actualizar una familia existente
    @PutMapping("/{id}")
    public ResponseEntity<FamiyDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody FamiyDTO dto) throws Exception {
        Family obj = service.update(convertToEntity(dto), id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    // DELETE: Eliminar una familia por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Conversión de Entity → DTO
    private FamiyDTO convertToDto(Family obj) {
        return modelMapper.map(obj, FamiyDTO.class);
    }

    // Conversión de DTO → Entity
    private Family convertToEntity(FamiyDTO dto) {
        return modelMapper.map(dto, Family.class);
    }
}
