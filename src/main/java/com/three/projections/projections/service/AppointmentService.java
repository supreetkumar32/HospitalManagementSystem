package com.three.projections.projections.service;

import com.three.projections.projections.entity.Appointment;
import com.three.projections.projections.entity.Doctor;
import com.three.projections.projections.entity.Patient;
import com.three.projections.projections.repository.AppointmentRepository;
import com.three.projections.projections.repository.DoctorRepository;
import com.three.projections.projections.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createANewAppointment(Appointment appointment, Long patientId, Long doctorId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);

        return appointment;
    }

}
