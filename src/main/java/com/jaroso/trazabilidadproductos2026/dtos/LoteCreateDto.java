package com.jaroso.trazabilidadproductos2026.dtos;

import java.time.LocalDate;


public record LoteCreateDto(String numeroLote, LocalDate fechaProduccion, Integer cantidad, String estado) {
}
