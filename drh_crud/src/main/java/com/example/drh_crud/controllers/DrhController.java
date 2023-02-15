package com.example.drh_crud.controllers;

import com.example.drh_crud.dtos.EmployeeDto;
import com.example.drh_crud.entities.Departement;
import com.example.drh_crud.entities.Diplome;
import com.example.drh_crud.entities.Employee;
import com.example.drh_crud.repositories.DepartementRepository;
import com.example.drh_crud.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("rsu")
public class DrhController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartementRepository departementRepository;
    @GetMapping("departement/employee-project")
    public List<Object> findIdAndProjectNameByDepartementName(@RequestParam("dn") String dn){
        return employeeRepository.findEmployeeIdAndProjectNameByDepartement(dn);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(
            @RequestParam("departementId") Long departementId,
            @RequestBody EmployeeDto employeeDto
    ) {
        Optional<Departement> departementOptional = departementRepository.findById(departementId);
        if (departementOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Departement departement = departementOptional.get();
        Optional<Diplome> diplomeOptional = employeeDto.getDiplome();
        Diplome diplome = diplomeOptional.isPresent() ?

                new Diplome(
                                diplomeOptional.get().getNiveau(),
                                diplomeOptional.get().getSpeciality(),
                                diplomeOptional.get().getAnneeObtention()
                           )
                : null;

        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setGenre(employeeDto.getGenre());
        employee.setStarting_work_date(employeeDto.getStarting_work_date());
        employee.setEmail(employeeDto.getEmail());
        employee.setDepartement(departement);
        employee.setDiplome(diplome);
        Employee savedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(savedEmployee);
    }
}
