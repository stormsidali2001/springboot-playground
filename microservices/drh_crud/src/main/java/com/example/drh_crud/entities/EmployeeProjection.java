package com.example.drh_crud.entities;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="emp",types={Employee.class})
public interface EmployeeProjection {
    @Value("#{target.name}")
    String getEmployeeName();

    @Value("#{target.departement.name}")
    String getDepartmentName();

    @Value("#{T(java.time.Duration).between(target.project.startRealisationDate.toInstant(), target.project.endRealisationDate.toInstant()).toDays()}")
    long getProjectDuration();

}
