package com.jaroso.trazabilidadproductos2026.services;

import com.jaroso.trazabilidadproductos2026.dtos.LoteDto;
import com.jaroso.trazabilidadproductos2026.dtos.LoteEstadoUpdateDto;

import java.util.Optional;

public interface LoteService {
    public Optional<LoteDto> findById(Long id);
    public Optional<LoteDto> updateEstado(Long id , LoteEstadoUpdateDto dto);
}
