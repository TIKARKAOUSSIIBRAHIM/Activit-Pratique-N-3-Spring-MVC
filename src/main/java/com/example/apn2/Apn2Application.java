package com.example.apn2;

import com.example.apn2.entities.Patient;
import com.example.apn2.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;

import javax.naming.Name;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Apn2Application implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(Apn2Application.class, args);
	}

	//@Bean
	CommandLineRunner commandLineRunner(PatientRepository patientRepository){
		return args ->{
			patientRepository.save(new Patient(null,"Hassan",new Date(),false,12));
			patientRepository.save(new Patient(null,"Hassan",new Date(),false,12));

			patientRepository.findAll().forEach(p->{
					//System.out.println(p.getNom());
		});

		};
	}


	@Override
	public void run(String... args) throws Exception {

	}
}
