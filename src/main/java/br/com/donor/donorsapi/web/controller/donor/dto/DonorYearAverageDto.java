package br.com.donor.donorsapi.web.controller.donor.dto;

public record DonorYearAverageDto(
        String bloodType,
        long averageYear
) {
}
