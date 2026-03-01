package com.jaroso.trazabilidadproductos2026.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "eventoTrazabilidads")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EventoTrazabilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private LocalDateTime timestamp;
    private String tipoEvento ;
    private String ubicacion;
    private String observaciones;
    //Lote 1 → N EventoTrazabilidad
     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "lote_id")
    private Lote lote;

}
