package com.jaroso.trazabilidadproductos2026.repositories;

import com.jaroso.trazabilidadproductos2026.entities.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoteRepository extends JpaRepository<Lote , Long> {
}
