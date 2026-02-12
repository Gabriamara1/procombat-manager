package com.gabriel.procombat_manager.dto;

import com.gabriel.procombat_manager.domain.entity.AlunoStatus;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;




@Getter
@Setter
public class AlunoRequest {

    @NotBlank(message = "nome é obrigatório")
    private String nome;

    @NotBlank(message = "email é obrigatório")
    @Email(message = "email inválido")
    private String email;

    @NotBlank(message = "telefone é obrigatório")
    @Pattern(
            regexp = "^(\\+?55\\s?)?(\\(?\\d{2}\\)?\\s?)?(\\d{4,5}[-\\s]?\\d{4})$",
            message = "telefone inválido"
    )
    private String telefone;

    @NotNull(message = "dataNascimento é obrigatória")
    @Past(message = "dataNascimento deve ser no passado")
    private LocalDate dataNascimento;

    public void setStatus(AlunoStatus alunoStatus) {
    }
}






