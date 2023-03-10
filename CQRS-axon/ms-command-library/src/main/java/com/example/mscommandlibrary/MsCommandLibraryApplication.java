package com.example.mscommandlibrary;

import com.example.coreapi.config.AxonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AxonConfiguration.class)
public class MsCommandLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCommandLibraryApplication.class, args);
	}

}
