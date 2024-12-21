package br.com.donor.donorsapi.adapters.persistence.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DonorImcDto {
    int ageRangeStart;
    int ageRangeEnd;
    double averageImc;
}
