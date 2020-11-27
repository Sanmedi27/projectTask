package co.com.poli.taller.projecttaskservice.model;

import lombok.Data;

import java.util.Date;

@Data
public class Project {
    private Long id;

    private String projectName;


    private String projectIdentifier;

    private String description;

    private Date startDate;

    private Date endDate;
}
