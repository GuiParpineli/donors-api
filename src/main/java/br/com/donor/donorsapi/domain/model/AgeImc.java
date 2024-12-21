package br.com.donor.donorsapi.domain.model;

public record AgeImc(
        String ageRange,
        double averageImc
) {
}
