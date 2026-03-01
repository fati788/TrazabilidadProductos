package com.jaroso.trazabilidadproductos2026.services;

import com.jaroso.trazabilidadproductos2026.dtos.*;
import com.jaroso.trazabilidadproductos2026.entities.Lote;
import com.jaroso.trazabilidadproductos2026.entities.Producto;
import com.jaroso.trazabilidadproductos2026.mappers.LoteMapper;
import com.jaroso.trazabilidadproductos2026.mappers.ProductoMapper;
import com.jaroso.trazabilidadproductos2026.repositories.LoteRepository;
import com.jaroso.trazabilidadproductos2026.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository repo;
     @Autowired
    private LoteRepository loteRepository;
    @Autowired
    private ProductoMapper mapper;

    @Autowired
    private LoteMapper loteMapper;

    @Override
    public ProductoDto create(ProductoCreateDto dto) {
        Producto producto = mapper.productoCreateDtoToEntity(dto);
        return mapper.toDto(repo.save(producto));
    }

    @Override
    public List<ProductoDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public Optional<ProductoDto> findById(Long id) {
       return repo.findById(id).map(mapper::toDto);
    }

    @Override
    public Optional<ProductoDto> updateProducto(Long id,ProductoUpdateDto producto) {
        Optional<Producto> productoEn = repo.findById((id));
       if (productoEn.isPresent()){
           Producto productoEncontrado = productoEn.get();

           //Update los datos
           productoEncontrado.setCodigo(producto.codigo());
           productoEncontrado.setNombre(producto.nombre());
           productoEncontrado.setDescripcion(producto.descripcion());
           //Guardar los cambios
           return Optional.of(mapper.toDto(repo.save(productoEncontrado)));
       }else {
           return Optional.empty();
       }
    }

    @Override
    public boolean delete(Long id) {
      Optional<Producto> producto = repo.findById((id));
      if (producto.isPresent()){
          repo.delete(producto.get());
          return true;
      }else {
          return false;
      }
    }

  @Override
  public Optional<LoteDto> crearLote(Long productoId, LoteCreateDto dto) {

      Optional<Producto> productoOptional = repo.findById(productoId);
      if (productoOptional.isEmpty()) return Optional.empty();

      Producto producto = productoOptional.get();

      // Crear Lote
      Lote lote = loteMapper.loteCreateDtoToEntity(dto);
      lote.setProducto(producto);

      // Guardar Lote directamente
      Lote guardado = loteRepository.save(lote);

      // Asociar al producto en memoria
      producto.getLotes().add(guardado);

      return Optional.of(loteMapper.toDto(guardado));
  }


    @Override
    public Optional<List<LoteDto>> listarLotes(Long productoId) {
        return repo.findById(productoId) // repo de Producto
                .map(producto ->
                        producto.getLotes()
                                .stream()
                                .map(loteMapper::toDto)
                                .toList()
                );
    }
}
