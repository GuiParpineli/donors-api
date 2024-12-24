package br.com.donor.donorsapi.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AgeImcData {
    String ageRange;
    double averageImc;
}
