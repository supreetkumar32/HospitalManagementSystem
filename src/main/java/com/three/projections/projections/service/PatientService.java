package com.three.projections.projections.service;

import com.three.projections.projections.entity.Patient;
import com.three.projections.projections.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public void testPatientTransaction() {

        Patient p1 = patientRepository.findById(1L).orElseThrow();
        Patient p2 = patientRepository.findById(1L).orElseThrow();

        System.out.println(p1 +"  "+p2);
        System.out.println(p1 == p2);

        p1.setName("Random Name");
    }

    @Transactional
    public void deletePatient(Long patientId) {
        patientRepository.findById(patientId).orElseThrow();
        patientRepository.deleteById(patientId);
    }

}