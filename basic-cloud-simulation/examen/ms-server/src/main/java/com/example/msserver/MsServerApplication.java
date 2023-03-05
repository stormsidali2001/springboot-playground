package com.example.msserver;

import com.example.msserver.Entities.Configuration;
import com.example.msserver.Entities.Server;
import com.example.msserver.Repositories.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class MsServerApplication implements CommandLineRunner {

	@Autowired
	private ServerRepository serverRepository;
	public static void main(String[] args) {
		SpringApplication.run(MsServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Server> servers = new ArrayList<>();
		Server s1 = serverRepository.save(new Server(null,"bejaia-center",new Configuration(17L,2L,500L)));
		servers.add(s1);
		Server s2 = serverRepository.save(new Server(null,"bejaia-center",new Configuration(17L,7L,500L)));
		servers.add(s2);
		Server s3 = serverRepository.save(new Server(null,"bejaia-center",new Configuration(17L,7L,500L)));
		servers.add(s3);
		Server s4 = serverRepository.save(new Server(null,"bejaia-center",new Configuration(17L,7L,500L)));
		servers.add(s4);

		servers.forEach(System.out::println);

	}
}
