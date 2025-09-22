package com.three.projections.projections.entity;

import com.three.projections.projections.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthDate;

    private String email;

    private String gender;

    @Enumerated(value=EnumType.STRING)
    private BloodGroupType bloodGroup;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodGroup=" + bloodGroup +
                ", createdAt=" + createdAt +
                '}';
    }

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="patient_insurance",unique=true)//for changing teh properties(name) of the column//join column is there in owning side
    private Insurance insurance;//owning side

    @OneToMany(mappedBy = "patient",cascade=CascadeType.ALL)//inverse side
    private Set<Appointment> appointments=new HashSet<>();

}
