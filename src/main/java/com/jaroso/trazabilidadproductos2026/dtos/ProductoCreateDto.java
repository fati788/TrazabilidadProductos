package com.jaroso.trazabilidadproductos2026.dtos;

import java.util.List;

public record ProductoCreateDto(String codigo , String nombre , String descripcion, List<LoteResumenDto> lotes) {
}
