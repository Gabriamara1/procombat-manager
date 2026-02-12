package com.gabriel.procombat_manager.domain.entity;

import com.gabriel.procombat_manager.domain.entity.Aluno;
import com.gabriel.procombat_manager.domain.entity.AlunoStatus;
import com.gabriel.procombat_manager.dto.AlunoRequest;
import com.gabriel.procombat_manager.dto.AlunoResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PatchMapping;

import com.gabriel.procombat_manager.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }


    @PostMapping
    public AlunoResponse criar(@Valid @RequestBody AlunoRequest alunoRequest) {
        return alunoService.criar(alunoRequest);
    }



    @GetMapping("/{id}")
    public Aluno buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id);
    }

     @GetMapping
     public List<Aluno> listar(@RequestParam(name = "status", required = false) AlunoStatus status) {
         if (status != null) {
             return alunoService.listarPorStatus(status);
         }
         return alunoService.listar();
     }

         @PatchMapping("/{id}/inativar")
    public Aluno inativar(@PathVariable Long id) {
        return alunoService.inativar(id);
    }

    @PatchMapping("/{id}/ativar")
    public AlunoResponse ativar(@PathVariable Long id) {
        return alunoService.ativar(id);
    }

    @PutMapping("/{id}")
    public AlunoResponse atualizar(
            @PathVariable Long id,
            @Valid @RequestBody AlunoRequest alunoRequest
    ) {
        return alunoService.atualizar(id, alunoRequest);
    }



}
