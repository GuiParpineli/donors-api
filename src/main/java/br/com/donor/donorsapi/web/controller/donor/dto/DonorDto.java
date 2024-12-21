package br.com.donor.donorsapi.web.controller.donor.dto;

import br.com.donor.donorsapi.adapters.persistence.entity.DonorEntity;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link DonorEntity}
 */
public record DonorDto(
        String name,
        LocalDate birthDate,
        String gender,
        @NotNull Integer number,
        String city,
        String state,
        Double height,
        Integer weight,
        String bloodType
) implements Serializable {
}
