package com.jaroso.trazabilidadproductos2026.services;

import com.jaroso.trazabilidadproductos2026.dtos.*;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    public ProductoDto create(ProductoCreateDto dto);
    public List<ProductoDto> findAll();
    public Optional<ProductoDto> findById(Long id);
   Optional<ProductoDto> updateProducto(Long id, ProductoUpdateDto producto );

    public boolean delete(Long id);

    //relacionadas con el Lote
    public Optional<LoteDto> crearLote(Long productoId, LoteCreateDto dto);

    Optional<List<LoteDto>> listarLotes(Long productoId);



}
