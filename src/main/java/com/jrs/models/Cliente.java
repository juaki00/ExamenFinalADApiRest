package com.jrs.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class InformacionCliente {
    @Id
    Long id;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "total")
    Double total;
    @Column(name = "estado")
    Integer estado;

}
