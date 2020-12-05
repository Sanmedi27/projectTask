package co.com.poli.taller.projecttaskservice.client;

import co.com.poli.taller.projecttaskservice.model.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "project-service")
@RequestMapping(value = "/project")
public interface ProjectClient {

    @GetMapping(value = "/{project_identifier}")
    ResponseEntity<Project> getProjectByProjectIdentifier(@PathVariable String project_identifier) ;
}
