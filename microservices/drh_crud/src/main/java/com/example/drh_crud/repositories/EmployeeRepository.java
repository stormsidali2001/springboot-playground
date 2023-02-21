package com.example.drh_crud.repositories;

import com.example.drh_crud.entities.Employee;
import com.example.drh_crud.types.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    public List<Employee>  findEmployeesByEmailContaining(String email);
    @Query("SELECT COUNT(e) FROM Employee e WHERE e.genre = :genre")
    long countByGenre(@Param("genre") Genre genre);
    @Query("SELECT e.id, p.name " +
            "FROM Employee e " +
            "JOIN e.project p " +
            "JOIN e.departement d " +
            "WHERE d.name = :departementName")
    List<Object[]> findEmployeeIdAndProjectNameByDepartement(@Param("departementName") String departementName);
    /*
        output example:
        [
            [
                1,
                "project1"
            ],
            [
                3,
                "project1"
            ],
            [
                5,
                "project1"
            ],
            [
                7,
                "project1"
            ]
        ]
        since there are no notion of Objects in javascript spring boot uses an array to return the raw sql fields
        note that indicating the join explicitlcy is optional:
        select e.id , e.project.id from Employee e where e.departement.name = :departementName
        jpql will automaticly understand that there is a join operation which should be performed
     */

    @Modifying
    @Query("UPDATE Employee e SET e.starting_work_date = :starting_work_date WHERE e.name IN (:names)")
    int updateHireDateByNames(@Param("starting_work_date") Date starting_work_date, @Param("names") List<String> names);
}
