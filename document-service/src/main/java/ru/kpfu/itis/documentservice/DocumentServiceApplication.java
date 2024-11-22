package ru.kpfu.itis.documentservice;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.kpfu.itis.documentservice.service.DocumentServiceImpl;

import java.io.IOException;

@SpringBootApplication
public class DocumentServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(DocumentServiceApplication.class, args);
	}

}
