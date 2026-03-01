package com.jaroso.trazabilidadproductos2026.mappers;

import com.jaroso.trazabilidadproductos2026.dtos.ProductoCreateDto;
import com.jaroso.trazabilidadproductos2026.dtos.ProductoDto;
import com.jaroso.trazabilidadproductos2026.dtos.ProductoUpdateDto;
import com.jaroso.trazabilidadproductos2026.entities.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    ProductoDto toDto(Producto producto);
    Producto productoCreateDtoToEntity(ProductoCreateDto dto);
    Producto updateToEntity(ProductoUpdateDto productoUpdateDto);

}
