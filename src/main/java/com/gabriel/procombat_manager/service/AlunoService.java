package com.gabriel.procombat_manager.service;
import com.gabriel.procombat_manager.domain.entity.Aluno;
import com.gabriel.procombat_manager.domain.entity.AlunoStatus;
import com.gabriel.procombat_manager.dto.AlunoRequest;
import com.gabriel.procombat_manager.dto.AlunoResponse;
import com.gabriel.procombat_manager.repository.AlunoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public AlunoResponse criar(AlunoRequest alunoRequest) {

        Aluno aluno = new Aluno();
        aluno.setNome(alunoRequest.getNome());
        aluno.setEmail(alunoRequest.getEmail());
        aluno.setTelefone(alunoRequest.getTelefone());
        aluno.setDataNascimento(alunoRequest.getDataNascimento());
        aluno.setStatus(AlunoStatus.ATIVO);

        Aluno salvo = alunoRepository.save(aluno);

        AlunoResponse resp = new AlunoResponse();
        resp.setId(salvo.getId());
        resp.setNome(salvo.getNome());
        resp.setEmail(salvo.getEmail());
        resp.setTelefone(salvo.getTelefone());
        resp.setDataNascimento(salvo.getDataNascimento());
        resp.setStatus(salvo.getStatus().name());

        return resp;
    }


    @RestControllerAdvice
    public static class GlobalExceptionHandler {

        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
    private AlunoResponse toResponse(Aluno a) {
        AlunoResponse r = new AlunoResponse();
        r.setId(a.getId());
        r.setNome(a.getNome());
        r.setEmail(a.getEmail());
        r.setTelefone(a.getTelefone());
        r.setDataNascimento(a.getDataNascimento());
        r.setStatus(a.getStatus().name());
        return r;
    }


    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
    }



    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    public Aluno inativar(Long id) {
        Aluno aluno = buscarPorId(id);
        aluno.setStatus(AlunoStatus.INATIVO);
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarPorStatus(AlunoStatus status) {
        return alunoRepository.findByStatus(status);
    }

    public AlunoResponse ativar(Long id) {
        Aluno aluno = buscarPorId(id);     // ENTITY ✅
        aluno.setStatus(AlunoStatus.ATIVO);      // ENUM ✅

        Aluno salvo = alunoRepository.save(aluno); // salva ENTITY ✅
        return toResponse(salvo);                // retorna DTO ✅
    }

    public AlunoResponse atualizar(Long id, AlunoRequest dto) {

        Aluno aluno = buscarPorId(  id);

        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setTelefone(dto.getTelefone());
        aluno.setDataNascimento(dto.getDataNascimento());

        Aluno salvo = alunoRepository.save(aluno);

        return toResponse(salvo);
    }






}
