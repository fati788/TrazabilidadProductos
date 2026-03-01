package com.jaroso.trazabilidadproductos2026.services;

import com.jaroso.trazabilidadproductos2026.dtos.EventoCreateDto;
import com.jaroso.trazabilidadproductos2026.dtos.EventoDto;
import com.jaroso.trazabilidadproductos2026.entities.EventoTrazabilidad;
import com.jaroso.trazabilidadproductos2026.entities.Lote;
import com.jaroso.trazabilidadproductos2026.mappers.EventoMapper;
import com.jaroso.trazabilidadproductos2026.repositories.EventoRepository;
import com.jaroso.trazabilidadproductos2026.repositories.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class EventoServiceImpl implements EventoService {
    @Autowired
    private LoteRepository loteRepository;

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private EventoMapper mapper;



    @Override
    public Optional<EventoDto> crearEvento(Long id, EventoCreateDto dto) {
        Optional<Lote> loteOptional = loteRepository.findById(id);
        if (loteOptional.isPresent()){
            Lote lote = loteOptional.get();
            //Crear el evento con el mapper
            EventoTrazabilidad evento = mapper.eventoCreateDtoToEntity(dto);

            //AsignarTimestamp
            evento.setTimestamp(LocalDateTime.now());
            evento.setLote(lote);
           return Optional.of(mapper.toDto(eventoRepository.save(evento)));
        }else {
            return  Optional.empty();
        }
    }

    @Override
    public Optional<List<EventoDto>> findAllEventos(Long id) {
        Optional<Lote> loteOptional = loteRepository.findById(id);

        if (loteOptional.isPresent()){
            // Buscar eventos del lote + ordenadas
            List<EventoDto> eventos = eventoRepository
                    .findByLoteIdOrderByTimestampAsc(id)
                    .stream()
                    .map(mapper::toDto)
                    .toList();

            return Optional.of(eventos);
        }else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<String>> findRutas(Long id) {
        Optional<Lote> loteOptional = loteRepository.findById(id);

        if (loteOptional.isPresent()) {

            List<String> ruta = eventoRepository
                    .findByLoteIdOrderByTimestampAsc(id)
                    .stream()
                    .map(EventoTrazabilidad::getUbicacion)
                    .toList();

            return Optional.of(ruta);

        } else {
            return Optional.empty();
        }
    }
}
