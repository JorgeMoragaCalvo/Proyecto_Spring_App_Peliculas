package com.example.dbd.demodbd;

import com.example.dbd.demodbd.entities.ClasificacionEntity;
import com.example.dbd.demodbd.entities.PeliculaEntity;
import com.example.dbd.demodbd.repositories.ClasificacionRepository;
import com.example.dbd.demodbd.repositories.PeliculaRepository;
import com.example.dbd.demodbd.services.PeliculaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class DemodbdApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemodbdApplication.class, args);
	}

	/*
	@Bean
	CommandLineRunner commandLineRunner(
			PeliculaRepository peliculaRepository,
			ClasificacionRepository clasificacionRepository
	) {
		return args -> {
			PeliculaEntity peliculaEntity = peliculaRepository.save(
					new PeliculaEntity(null, "pelicula", 2023, "unapelicula", "120m", "archivo_pelicula"));
			ClasificacionEntity clasificacionEntity1 = clasificacionRepository
					.save(new ClasificacionEntity(null, "Class01", "Pelicula accion"));
		};
	}*/
}
