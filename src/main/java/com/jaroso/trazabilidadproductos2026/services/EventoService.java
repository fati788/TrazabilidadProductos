package com.jaroso.trazabilidadproductos2026.services;

import com.jaroso.trazabilidadproductos2026.dtos.EventoCreateDto;
import com.jaroso.trazabilidadproductos2026.dtos.EventoDto;

import java.util.List;
import java.util.Optional;

public interface EventoService {
   public Optional<EventoDto> crearEvento(Long id , EventoCreateDto dto);
   public Optional<List<EventoDto>> findAllEventos(Long id);
   public Optional<List<String>> findRutas(Long id);

}
