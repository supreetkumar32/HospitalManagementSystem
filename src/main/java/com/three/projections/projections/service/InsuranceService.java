package com.three.projections.projections.service;

import com.three.projections.projections.entity.Insurance;
import com.three.projections.projections.entity.Patient;
import com.three.projections.projections.repository.InsuranceRepository;
import com.three.projections.projections.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;

    private final PatientRepository patientRepository;

    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance); // dirty patient

        insurance.setPatient(patient); //optional,
        return insurance;
    }

    @Transactional
    public void deletePatient(Long patientId){
        patientRepository.findById(patientId).orElseThrow();
        patientRepository.deleteById(patientId);
    }
}
