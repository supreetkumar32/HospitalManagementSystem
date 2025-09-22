package com.three.hotelManagementSystem.projections;

import com.three.projections.projections.HospitalManagementSystemApplication;
import com.three.projections.projections.entity.Insurance;
import com.three.projections.projections.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest(classes= HospitalManagementSystemApplication.class)
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testAssignInsuranceToPatient() {
        Insurance insurance = Insurance.builder()
                .provider("HDFC Ergo")
                .policyNumber("HDFC_23G")
                .validUntil(LocalDate.of(2030, 1, 1))
                .build();
        var updatedInsurance = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(updatedInsurance);

        insuranceService.deletePatient(1L);

    }

}
