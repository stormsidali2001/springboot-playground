package com.example.msuser;

import com.example.msuser.Entities.Configuration;
import com.example.msuser.Entities.User;
import com.example.msuser.Entities.VirtualMachine;
import com.example.msuser.Repositories.UserRepository;
import com.example.msuser.Repositories.VirtualMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class MsUserApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VirtualMachineRepository virtualMachineRepository;

	public static void main(String[] args) {
		SpringApplication.run(MsUserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<User> users = new ArrayList<>();


		User u1 = userRepository.save( new User(null,"sidali1","assoulsidali@gmail.com",null));
		users.add(u1);
		User u2 = userRepository.save( new User(null,"sidali2","assoulsidali@gmail2.com",null));
		users.add(u2);
		User u3 = userRepository.save( new User(null,"sidali3","assoulsidali3@gmail.com",null));
		users.add(u3);
		users.forEach(System.out::println);

		List<VirtualMachine> vms = new ArrayList<>();
		VirtualMachine vm1 = virtualMachineRepository.save(new VirtualMachine(null,new Configuration(17L,2L,500L),u1,1L,null));
		vms.add(vm1);
		VirtualMachine vm2 = virtualMachineRepository.save(new VirtualMachine(null,new Configuration(17L,2L,500L),u2,1L,null));
		vms.add(vm2);
		VirtualMachine vm3 = virtualMachineRepository.save(new VirtualMachine(null,new Configuration(17L,2L,500L),u3,1L,null));
		vms.add(vm3);
		vms.forEach(System.out::println);




	}
}
