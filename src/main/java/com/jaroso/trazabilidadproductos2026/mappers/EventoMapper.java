package com.jaroso.trazabilidadproductos2026.mappers;

import com.jaroso.trazabilidadproductos2026.dtos.EventoCreateDto;
import com.jaroso.trazabilidadproductos2026.dtos.EventoDto;
import com.jaroso.trazabilidadproductos2026.entities.EventoTrazabilidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventoMapper {
    EventoDto toDto(EventoTrazabilidad evento);
    EventoTrazabilidad eventoCreateDtoToEntity(EventoCreateDto dto);
}
