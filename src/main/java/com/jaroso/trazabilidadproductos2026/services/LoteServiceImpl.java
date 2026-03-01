package com.jaroso.trazabilidadproductos2026.services;

import com.jaroso.trazabilidadproductos2026.dtos.LoteDto;
import com.jaroso.trazabilidadproductos2026.dtos.LoteEstadoUpdateDto;
import com.jaroso.trazabilidadproductos2026.entities.Lote;
import com.jaroso.trazabilidadproductos2026.mappers.LoteMapper;
import com.jaroso.trazabilidadproductos2026.repositories.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoteServiceImpl implements LoteService {

    @Autowired
    private LoteRepository loteRepository;
    @Autowired
    private LoteMapper mapper;
    @Override
    public Optional<LoteDto> findById(Long id) {
        return loteRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public Optional<LoteDto> updateEstado(Long id, LoteEstadoUpdateDto dto) {
        Optional<Lote> loteOptional = loteRepository.findById(id);

        if (loteOptional.isPresent()){
            //Obtenir el lote
            Lote lote = loteOptional.get();
             //update el estado
            lote.setEstado(dto.estado());

            return Optional.of(mapper.toDto(loteRepository.save(lote)));

        }else {
            return Optional.empty();
        }
    }
}
