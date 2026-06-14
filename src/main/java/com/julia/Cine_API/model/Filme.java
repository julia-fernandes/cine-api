package com.julia.Cine_API.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "TBFILME")
@NoArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilme;

    private String titulo;
    private String genero;

    private Integer ano;
    private Integer duracao;

    @ManyToOne //muitos filmes são atrelados a um diretor

    //join nomeia a fk que é puxada automaticamente porque o tipo do atributo é uma entidade, então a pk da entidade é a fk da dependente
    @JoinColumn(name = "FK_idDiretor")

    private Diretor diretor;
    //apenas um objeto externo por Filme porque um filme se relaciona com apenas um diretor


    //um filme pode puxar suas avaliacoes dependentes
    @OneToMany(mappedBy = "filme")
    private List<Avaliacao> listaAvaliacao = new ArrayList<>();
}
