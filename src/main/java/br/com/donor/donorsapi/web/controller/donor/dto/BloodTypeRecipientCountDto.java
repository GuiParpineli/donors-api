package br.com.donor.donorsapi.web.controller.donor.dto;

public record BloodTypeRecipientCountDto(
        String bloodType,
        int  totalRecipient
) {
}
