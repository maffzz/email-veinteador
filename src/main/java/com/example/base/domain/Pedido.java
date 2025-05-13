package com.example.base.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer numeroDeCajas;}
