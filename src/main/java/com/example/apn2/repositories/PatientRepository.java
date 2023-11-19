package com.example.apn2.repositories;

import com.example.apn2.entities.Patient;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByMalade(boolean malade, Pageable pageable);
    List<Patient> findByMaladeAndScoreLessThan(boolean m,int score);
}
