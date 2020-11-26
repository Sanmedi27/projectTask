package co.com.poli.taller.projecttaskservice.service;

import co.com.poli.taller.projecttaskservice.domain.ProjectTask;
import co.com.poli.taller.projecttaskservice.repository.ProjectTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTaskServiceImpl implements ProjectTaskService {
    final ProjectTaskRepository projectTaskRepository;

    public ProjectTaskServiceImpl(ProjectTaskRepository projectTaskRepository) {
        this.projectTaskRepository = projectTaskRepository;
    }

    @Override
    public List<ProjectTask> findProjectTaskAll() {
        return projectTaskRepository.findAll();
    }

    @Override
    public ProjectTask createProjectTask(ProjectTask projectTask) {
        ProjectTask projectTaskDB = projectTaskRepository.findById(projectTask.getId()).orElse(null);
        if (projectTaskDB != null) {
            return projectTaskDB;
        }
        if (projectTask.getStatus().isEmpty()) {
            projectTask.setStatus("NOT STARTED");
        }
        return projectTaskRepository.save(projectTask);
    }

    @Override
    public ProjectTask updateProjectTask(ProjectTask projectTask) {
        ProjectTask projectTaskDB = projectTaskRepository.findById(projectTask.getId()).orElse(null);
        if (projectTaskDB == null) {
            return null;
        }
        projectTaskDB.setName(projectTask.getName());
        projectTaskDB.setSummary(projectTask.getSummary());
        projectTaskDB.setAcceptanceCriteria(projectTask.getAcceptanceCriteria());
        projectTaskDB.setStatus(projectTask.getStatus());
        projectTaskDB.setPriority(projectTask.getPriority());
        projectTaskDB.setHours(projectTask.getHours());
        projectTaskDB.setStartDate(projectTask.getStartDate());
        projectTaskDB.setEndDate(projectTask.getEndDate());
        return projectTaskRepository.save(projectTaskDB);
    }

    @Override
    public ProjectTask deleteProjectTask(ProjectTask projectTask) {
        ProjectTask projectTaskDB = projectTaskRepository.findById(projectTask.getId()).orElse(null);
        if (projectTaskDB == null) {
            return null;
        }
        projectTaskDB.setStatus("DELETED");
        return projectTaskRepository.save(projectTaskDB);
    }

    @Override
    public ProjectTask gerProjectTask(Long id) {
        return projectTaskRepository.findById(id).orElse(null);
    }
}
