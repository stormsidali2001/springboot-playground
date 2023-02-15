package com.example.drh_crud;

import com.example.drh_crud.entities.Departement;
import com.example.drh_crud.entities.Diplome;
import com.example.drh_crud.entities.Employee;
import com.example.drh_crud.entities.Project;
import com.example.drh_crud.repositories.DepartementRepository;
import com.example.drh_crud.repositories.EmployeeRepository;
import com.example.drh_crud.repositories.ProjectRepository;
import com.example.drh_crud.types.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class DrhCrudApplication  implements CommandLineRunner {
	@Autowired
	private DepartementRepository departementRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ProjectRepository projectRepository;

	public static void main(String[] args) {
		SpringApplication.run(DrhCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ArrayList<Departement> dp_list = new ArrayList<>();
		ArrayList<Employee> emp_list= new ArrayList<>();
		ArrayList<Project> projects= new ArrayList<>();
		for(int i=0;i<2;i++){
			Departement dp = new Departement(null,"departement "+(i+1),null);
			dp = departementRepository.save(dp);
			dp_list.add(dp);
		}
		for(int i=0;i<2;i++){
			Project pr = new Project(null,"project"+(i+1),new Date(),new Date(),null);
			pr = projectRepository.save(pr);
			projects.add(pr);
		}
		for(int i=0;i<8;i++){
			Departement departement = dp_list.get(i%2);
			Project project = projects.get(i % 2);
			Diplome diplome = new Diplome("cv","Cs",2001);

			Employee emp = new Employee(null,"employee"+(i+1),Genre.Mr,new Date(),"emp"+"employee"+(i+1)+"@gmail.com",diplome,departement,project);

			emp = employeeRepository.save(emp);
			emp_list.add(emp);
		}
		System.out.println("Departement list -------------------------------");
		dp_list.forEach(System.out::println);
		System.out.println("Project list -------------------------------");
		projects.forEach(System.out::println);
		System.out.println("Employees list -------------------------------");
		emp_list.forEach(System.out::println);

		System.out.println("Tests -------------------------------");

		employeeRepository.findByEmailIsLike("com").forEach(System.out::println);

	}
}

