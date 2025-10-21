package com.health.controller;

import com.health.dto.ProductDTO;
import com.health.model.Product;
import com.health.service.IProductService;
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
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() throws Exception {
        List<ProductDTO> list = service.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Integer id) throws Exception {
        Product product = service.findById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(convertToDto(product));
    }

    // Crear un producto
    @PostMapping
    public ResponseEntity<ProductDTO> save(@Valid @RequestBody ProductDTO dto) throws Exception {
        Product product = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getIdProduct())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    // Actualizar un producto
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Integer id, @Valid @RequestBody ProductDTO dto) throws Exception {
        Product updated = service.update(convertToEntity(dto), id);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(convertToDto(updated));
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Convertir de Entity a DTO
    private ProductDTO convertToDto(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    // Convertir de DTO a Entity
    private Product convertToEntity(ProductDTO dto) {
        return modelMapper.map(dto, Product.class);
    }
}
