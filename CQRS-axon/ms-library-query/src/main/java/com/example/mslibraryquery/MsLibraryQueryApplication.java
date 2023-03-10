package com.example.mslibraryquery;

import com.example.coreapi.config.AxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({AxonConfig.class})
public class MsLibraryQueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsLibraryQueryApplication.class, args);
	}

}
