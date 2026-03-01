package com.jaroso.trazabilidadproductos2026.controllers;

import com.jaroso.trazabilidadproductos2026.dtos.EventoCreateDto;
import com.jaroso.trazabilidadproductos2026.dtos.EventoDto;
import com.jaroso.trazabilidadproductos2026.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lotes")
public class EventoController {
    @Autowired
   private EventoService eventoService;

    @PostMapping("/{id}/eventos")
    public ResponseEntity<EventoDto> crearEvento(@PathVariable Long id , @RequestBody EventoCreateDto dto){
        return eventoService.crearEvento(id , dto)
                .map(e -> ResponseEntity.status(HttpStatus.CREATED).body(e))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/eventos")
    public ResponseEntity<List<EventoDto>> getAllEventosDeLote(@PathVariable Long id){
        return eventoService.findAllEventos(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/{id}/ruta")
    public ResponseEntity<List<String>> getRuta(@PathVariable Long id) {

        return eventoService.findRutas(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
