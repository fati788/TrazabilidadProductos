package com.jaroso.trazabilidadproductos2026.dtos;

import java.time.LocalDate;

public record LoteDto(Long id, String numeroLote, LocalDate fechaProduccion, Integer cantidad, String estado , ProductoBasicoDto producto) {
}
