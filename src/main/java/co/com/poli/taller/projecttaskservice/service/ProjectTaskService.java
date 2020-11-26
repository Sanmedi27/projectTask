package co.com.poli.taller.projecttaskservice.service;

import co.com.poli.taller.projecttaskservice.domain.ProjectTask;

import java.util.List;


public interface ProjectTaskService {
    List<ProjectTask> findProjectTaskAll();

    ProjectTask createProjectTask(ProjectTask projectTask);

    ProjectTask updateProjectTask(ProjectTask projectTask);

    ProjectTask deleteProjectTask(ProjectTask projectTask);

    ProjectTask gerProjectTask(Long id);
}