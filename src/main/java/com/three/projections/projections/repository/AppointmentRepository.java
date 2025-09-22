package com.three.projections.projections.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.three.projections.projections.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
