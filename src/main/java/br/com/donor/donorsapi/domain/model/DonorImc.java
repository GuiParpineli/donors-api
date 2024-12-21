package br.com.donor.donorsapi.domain.model;

public record DonorImc(
        int ageRangeStart,
        int ageRangeEnd,
        double averageImc
) {
}
