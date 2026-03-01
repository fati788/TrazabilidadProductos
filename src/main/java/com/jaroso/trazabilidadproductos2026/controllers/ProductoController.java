package com.jaroso.trazabilidadproductos2026.controllers;

import com.jaroso.trazabilidadproductos2026.dtos.*;
import com.jaroso.trazabilidadproductos2026.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoDto>> getAllProductos(){
        return ResponseEntity.ok(productoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> getProducto(@PathVariable Long id){
        Optional<ProductoDto> productoDto = productoService.findById(id);
        return productoDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductoDto> deleteProducto(@PathVariable Long id){
        boolean encontrado = productoService.delete(id);
        if (encontrado){
            return ResponseEntity.noContent().build();
        }else {
            return  ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<ProductoDto> saveProducto(@RequestBody ProductoCreateDto productoCreateDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.create(productoCreateDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> updateProducto(@PathVariable Long id , @RequestBody ProductoUpdateDto producto){
       Optional<ProductoDto> actualizado = productoService.updateProducto(id , producto);

        return actualizado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/{id}/lotes")
    public ResponseEntity<LoteDto> saveLote(@PathVariable Long id , @RequestBody LoteCreateDto dto){
        return productoService.crearLote(id, dto)
                .map(l -> ResponseEntity.status(HttpStatus.CREATED).body(l))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/{id}/lotes")
    public ResponseEntity<List<LoteDto>> getLotes(@PathVariable Long id) {
        Optional<List<LoteDto>> lotes = productoService.listarLotes(id);
        return lotes.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }







}
