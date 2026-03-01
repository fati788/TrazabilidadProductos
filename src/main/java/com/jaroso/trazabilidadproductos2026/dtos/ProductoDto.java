package com.jaroso.trazabilidadproductos2026.dtos;

import java.util.List;

public record ProductoDto(Long id, String codigo , String nombre , List<LoteResumenDto> lotes) {
}

