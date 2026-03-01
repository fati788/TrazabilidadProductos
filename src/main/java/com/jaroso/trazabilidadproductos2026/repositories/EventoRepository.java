package com.jaroso.trazabilidadproductos2026.repositories;

import com.jaroso.trazabilidadproductos2026.entities.EventoTrazabilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<EventoTrazabilidad , Long> {

    List<EventoTrazabilidad> findByLoteId(Long loteId);

    List<EventoTrazabilidad> findByLoteIdOrderByTimestampAsc(Long loteId);
    List<EventoTrazabilidad> findByLoteIdOrderByTimestampDesc(Long loteId);
    List<EventoTrazabilidad> findByLoteIdAndTipoEvento(Long loteId, String tipoEvento);
    List<EventoTrazabilidad> findByLoteIdAndTimestampBetween(Long loteId, LocalDateTime desde, LocalDateTime hasta);
    @Query("""
           SELECT e FROM  eventoTrazabilidads e
           WHERE e.lote.id = :loteId
           AND e.tipoEvento LIKE %:tipo%
           AND e.timestamp BETWEEN :desde AND :hasta
           ORDER BY e.timestamp ASC
           """)
    List<EventoTrazabilidad> filtrarEventos(
            @Param("loteId") Long loteId,
            @Param("tipo") String tipo,
            @Param("desde") LocalDateTime desde,
            @Param("hasta") LocalDateTime hasta
    );
}
