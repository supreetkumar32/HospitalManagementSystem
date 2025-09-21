package com.three.hotelManagementSystem.projections;

import com.three.projections.projections.HospitalManagementSystemApplication;
import com.three.projections.projections.dto.BloodGroupStats;
import com.three.projections.projections.dto.CPatientInfo;
import com.three.projections.projections.dto.IPatientInfo;
import com.three.projections.projections.entity.Patient;
import com.three.projections.projections.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes= HospitalManagementSystemApplication.class)
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatient(){
//        List<IPatientInfo> patientList=patientRepository.getAllPatientsInfo();
//        for(IPatientInfo p:patientList){
//            System.out.println(p);
//        }

//        List<CPatientInfo> patientList=patientRepository.getAllPatientsInfoConcrete();
//        for(CPatientInfo p:patientList){
//            System.out.println(p);
//        }

        List<BloodGroupStats> patientList=patientRepository.getBloodGroupStats();
        for(BloodGroupStats p:patientList){
            System.out.println(p);
        }
    }
}
