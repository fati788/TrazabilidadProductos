package com.jaroso.trazabilidadproductos2026.dtos;

import java.util.List;

public record AuthDto(String username, List<String> authorities, String token) {
}
