package com.example.msscolarity;

import com.example.msscolarity.entities.Etablissement;
import com.example.msscolarity.entities.Etudiant;
import com.example.msscolarity.repositories.EtablissementRepository;
import com.example.msscolarity.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.sql.Date;

@EnableFeignClients
@SpringBootApplication
public class MsScolarityApplication  implements CommandLineRunner {
	@Autowired
	EtudiantRepository etudiantRepository;

	@Autowired
	EtablissementRepository etablissementRepository;

	public static void main(String[] args) {
		SpringApplication.run(MsScolarityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Etablissement e1 = etablissementRepository.save(new Etablissement(null,"esi-sba",null));
		Etablissement e2 = etablissementRepository.save(new Etablissement(null,"univ-sba",null));

		etudiantRepository.save(new Etudiant(null,"malki","4isi" ,Date.valueOf("1991-01-01"),Date.valueOf("1991-01-01"),e1,1L,null,null));
		etudiantRepository.save(new Etudiant(null,"ali","4siw" ,Date.valueOf("1995-08-01"),Date.valueOf("1991-01-01"),e1,1L,null,null));
		etudiantRepository.save(new Etudiant(null,"karim","MasterSic" ,Date.valueOf("1996-11-22"),Date.valueOf("1995-08-01"),e2,2L,null,null));
		etudiantRepository.save(new Etudiant(null,"fouad","MasterR" ,Date.valueOf("2000-02-15"),Date.valueOf("1995-08-01"),e2,2L,null,null));

	}
}
