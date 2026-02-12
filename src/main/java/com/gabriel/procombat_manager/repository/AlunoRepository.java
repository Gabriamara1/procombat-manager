package com.gabriel.procombat_manager.repository;
import com.gabriel.procombat_manager.domain.entity.Aluno;
import com.gabriel.procombat_manager.domain.entity.AlunoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;



public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByStatus(AlunoStatus status);

}
