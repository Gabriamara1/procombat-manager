package com.gabriel.procombat_manager.domain.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "alunos")
public class Aluno {
    @Id //indica que o campo id é a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) //especifica que o valor do campo id deve ser gerado automaticamente pelo banco de dados, usando a estratégia de identidade
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    private String telefone;
    private LocalDate dataNascimento;


    @Enumerated(EnumType.STRING)
    private AlunoStatus status;

}
