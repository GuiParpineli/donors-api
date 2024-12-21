package br.com.donor.donorsapi.adapters.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "donors")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DonorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(nullable = false, unique = true)
    private String cpf;

    private String rg;

    private LocalDate birthDate;

    private String gender;

    private String motherName;

    private String fatherName;

    private String email;

    private String zipCode;

    private String address;

    private Integer number;

    private String district;

    private String city;

    private String state;

    private String landline;

    private String mobile;

    private Double height;

    private Integer weight;

    private String bloodType;
}
