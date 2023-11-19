package com.example.apn2;

import com.example.apn2.entities.Patient;
import com.example.apn2.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 100 ; i++) {
			patientRepository.save(new Patient(
					(Long) null,"hassan",new Date(),Math.random()>0.5?true:false, (int) (Math.random() * 100
			)));
		}

		List<Patient> patients = patientRepository.findByMaladeAndScoreLessThan(true, 2);
		patients.forEach(p-> {
					System.out.println("===================");
					System.out.println(p.getId());
					System.out.println(p.getNom());
					System.out.println(p.getScore());
					System.out.println(p.getDateNaissance());
					System.out.println(p.isMalade());

					System.out.println("*******************");
				});

	}
}
