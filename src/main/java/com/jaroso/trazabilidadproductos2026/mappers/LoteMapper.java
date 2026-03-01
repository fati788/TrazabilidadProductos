package com.jaroso.trazabilidadproductos2026.mappers;

import com.jaroso.trazabilidadproductos2026.dtos.LoteCreateDto;
import com.jaroso.trazabilidadproductos2026.dtos.LoteDto;
import com.jaroso.trazabilidadproductos2026.entities.Lote;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoteMapper {
   LoteDto toDto(Lote lote);

   Lote loteCreateDtoToEntity(LoteCreateDto dto);
}
