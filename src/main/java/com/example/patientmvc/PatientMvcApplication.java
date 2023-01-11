package com.example.patientmvc;

import com.example.patientmvc.entities.Patient;
import com.example.patientmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientMvcApplication.class, args);
    }
    @Bean
    CommandLineRunner CommandLineRunner(PatientRepository patientRepository) {
     return args -> {
         patientRepository.save(new Patient(null,"Hassan", new Date(),false, 12));
         patientRepository.save(new Patient(null,"Haifa", new Date(),true, 11));
         patientRepository.save(new Patient(null,"Ameni", new Date(),false, 13));
         patientRepository.save(new Patient(null,"Eya", new Date(),true, 15));
         patientRepository.findAll().forEach(p->{
             System.out.println(p.getNom());
         });
     };
    }

}
