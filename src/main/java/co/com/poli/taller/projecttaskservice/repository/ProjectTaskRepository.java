package co.com.poli.taller.projecttaskservice.repository;

import co.com.poli.taller.projecttaskservice.domain.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Long> {
}
