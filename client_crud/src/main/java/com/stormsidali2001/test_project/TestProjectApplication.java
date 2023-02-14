package com.stormsidali2001.test_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import com.stormsidali2001.test_project.entities.*;
import com.stormsidali2001.test_project.types.Civility;
import java.util.Arrays;
import java.util.List;
import java.util.Date;

import com.stormsidali2001.test_project.repositories.ClientRepository;
import com.stormsidali2001.test_project.repositories.CompteRepository;

@SpringBootApplication
public class TestProjectApplication implements CommandLineRunner {
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	CompteRepository compteRepository;
	public static void main(String[] args) {
		SpringApplication.run(TestProjectApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		Client client1 = new Client(null,"sidali","assoulsidali@gmail.com",Civility.Homme,null,null,null);
		Client client2 = new Client(null,"sidali1","assoulsidali1@gmail.com",Civility.Homme,null,null,null);
		Client client3 = new Client(null,"sidali2","assoulsidali2@gmail.com",Civility.Homme,null,null,null);

		List<Client> lc =  clientRepository.saveAll(Arrays.asList(client1,client2,client3));
	clientRepository.findAll().forEach(System.out::println);

		Client clientDB = clientRepository.findById(1L).get();

		Adresse adresseDB = new Adresse(1124,"dsad","dasads","bejaia");
		clientDB.setAddrese(adresseDB);
		Compte compte = new Compte(null,"123456","sidali",new Date(),clientDB);
		compteRepository.save(compte);

		clientRepository.findClientsByNom("sidali").forEach(System.out::println);
		Client c1 = clientRepository.findByLogin("sidali");
		System.out.println(c1);


	}

}
