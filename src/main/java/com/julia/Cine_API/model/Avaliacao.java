package com.julia.Cine_API.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TBAVALIACAO")
@NoArgsConstructor
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvaliacao;

    private Integer nota;
    private String comentario;


    //muitas avaliações podem ser atreladas a um único filme
    @ManyToOne
    @JoinColumn(name = "FK_idFilme")
    private Filme filme;
}
