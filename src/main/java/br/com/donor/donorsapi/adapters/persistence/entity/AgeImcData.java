package br.com.donor.donorsapi.adapters.persistence.entity;

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
