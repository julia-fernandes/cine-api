package com.julia.Cine_API.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity //declara a classe como entidade no banco de dados
@Getter
@Setter
@Table(name = "TBDIRETOR") //nomeia a tabela no banco
@NoArgsConstructor //gera automaticamente o construtor vazio que a entidade é obrigada a ter

public class Diretor {

    @Id //declaração de pk como autoincrement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiretor;

    private String nome;
    private Integer idade;

    private String nacionalidade;
    private String biografia;


    //um diretor tem relação com vários filmes
    //mappedBy declara no relacionamento bidirecional onde está a foreing key
    @OneToMany(mappedBy = "diretor")
    private List<Filme> listaFilmes = new ArrayList<>();
    //lista porque muitos filmes relacionados com o diretor serão armazenados

}