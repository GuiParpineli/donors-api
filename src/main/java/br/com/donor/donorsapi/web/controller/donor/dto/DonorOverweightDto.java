package br.com.donor.donorsapi.web.controller.donor.dto;

public record DonorOverweightDto(
        String sexo,
        int total,
        String porcent
) {
}
