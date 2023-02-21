package com.example.msbourse;

import com.example.msbourse.entities.Etudiant;
import com.example.msbourse.entities.Virement;
import com.example.msbourse.repositories.EtudiantRepository;
import com.example.msbourse.repositories.VirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.sql.Date;

@SpringBootApplication
@EnableFeignClients
public class MsBourseApplication implements CommandLineRunner {
	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	VirementRepository virementRepository;

	public static void main(String[] args) {
		SpringApplication.run(MsBourseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Etudiant e1 = etudiantRepository.save(new Etudiant(1L,15156554645L,50000f,false,null,null));
		Etudiant e2 = etudiantRepository.save(new Etudiant(2L,15156554645L,50000f,false,null,null));
		Etudiant e3 = etudiantRepository.save(new Etudiant(3L,15156554645L,50000f,false,null,null));

		Virement v1 = virementRepository.save(new Virement(null,2000f,Date.valueOf("2022-04-20"),e1));
		Virement v2= virementRepository.save(new Virement(null,2000f,Date.valueOf("2022-04-20"),e2));
		Virement v3= virementRepository.save(new Virement(null,2000f,Date.valueOf("2022-04-20"),e3));


	}
}
