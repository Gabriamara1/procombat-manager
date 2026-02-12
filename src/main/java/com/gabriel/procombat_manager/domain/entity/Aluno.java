package com.gabriel.procombat_manager.domain.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;


@Getter //gera os métodos getters para os campos da classe, permitindo acessar os valores dos atributos
@Setter  //gera os métodos getters e setters para os campos da classe, facilitando o acesso e modificação dos atributos
@NoArgsConstructor //gera um construtor sem argumentos, necessário para o JPA/Hibernate criar instâncias da entidade
@Entity //diz ao hibernate que essa classe é uma entidade e deve ser mapeada para uma tabela no banco de dados
@Table(name = "alunos") //especifica o nome da tabela no banco de dados que corresponde a essa entidade
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
