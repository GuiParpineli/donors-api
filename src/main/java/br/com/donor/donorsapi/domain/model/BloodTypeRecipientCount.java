package br.com.donor.donorsapi.domain.model;

public record BloodTypeRecipientCount(
        BloodType bloodType,
        int totalRecipient
) {
}
