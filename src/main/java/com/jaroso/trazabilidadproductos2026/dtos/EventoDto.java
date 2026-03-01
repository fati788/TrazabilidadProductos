package com.jaroso.trazabilidadproductos2026.dtos;

import java.time.LocalDateTime;

public record EventoDto(Long id , LocalDateTime timestamp, String tipoEvento , String ubicacion , String observaciones) {
}
