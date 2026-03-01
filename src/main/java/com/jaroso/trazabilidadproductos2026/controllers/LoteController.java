package com.jaroso.trazabilidadproductos2026.controllers;

import com.jaroso.trazabilidadproductos2026.dtos.LoteDto;
import com.jaroso.trazabilidadproductos2026.dtos.LoteEstadoUpdateDto;
import com.jaroso.trazabilidadproductos2026.services.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/lotes")
public class LoteController {
    @Autowired
    private LoteService service;

    @GetMapping("/{id}")
    public ResponseEntity<LoteDto> getLote(@PathVariable Long id){
        Optional<LoteDto> lote = service.findById(id);
        return lote.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<LoteDto> updateEstado(@PathVariable Long id , @RequestBody LoteEstadoUpdateDto dto){
        return service.updateEstado(id , dto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
