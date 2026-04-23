package com.gabriel.procombat_manager.dto;


import com.gabriel.procombat_manager.domain.entity.AlunoStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AlunoResponse {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private AlunoStatus status;

}

