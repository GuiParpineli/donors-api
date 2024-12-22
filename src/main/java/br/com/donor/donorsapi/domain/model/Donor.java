package br.com.donor.donorsapi.domain.model;

import java.time.LocalDate;

public record Donor(
        String name,
        String cpf,
        String rg,
        LocalDate birthDate,
        Gender gender,
        String motherName,
        String fatherName,
        String email,
        String zipCode,
        String address,
        Integer number,
        String district,
        String city,
        String state,
        String landline,
        String mobile,
        Double height,
        Integer weight,
        BloodType bloodType
) {
}
