package co.com.poli.taller.projecttaskservice.controller;

import co.com.poli.taller.projecttaskservice.domain.ProjectTask;
import co.com.poli.taller.projecttaskservice.model.ErrorMessage;
import co.com.poli.taller.projecttaskservice.service.ProjectTaskService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/task")
public class ProjectTaskController {
    final ProjectTaskService projectTaskService;

    public ProjectTaskController(ProjectTaskService projectTaskService) {
        this.projectTaskService = projectTaskService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectTask>> listAllProjectTask() {
        List<ProjectTask> projectTasks = projectTaskService.findProjectTaskAll();
        if (projectTasks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(projectTasks);
    }

    @PostMapping
    public ResponseEntity<ProjectTask> createProjectTask(@Valid @RequestBody ProjectTask projectTask, BindingResult result) {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        ProjectTask projectTaskBD = projectTaskService.createProjectTask(projectTask);
        return ResponseEntity.status((HttpStatus.CREATED)).body(projectTaskBD);
    }

    private String formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
