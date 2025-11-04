package br.com.dev.osorio.felipe.TO_DO.repository;

import br.com.dev.osorio.felipe.TO_DO.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
