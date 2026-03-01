package com.jaroso.trazabilidadproductos2026.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "lotes")
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
     private String numeroLote;
     private LocalDate fechaProduccion;
     private Integer cantidad;
     private String estado;
     //Producto 1 → N Lote
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
     private Producto producto;

    //Lote 1 → N EventoTrazabilidad
    @OneToMany(mappedBy = "lote" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EventoTrazabilidad> eventoTrazabilidads = new ArrayList<>();
    public void addEvento(EventoTrazabilidad e){
        eventoTrazabilidads.add(e);
        e.setLote(this);
    }
}
