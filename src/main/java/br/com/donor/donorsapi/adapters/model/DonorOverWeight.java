package br.com.donor.donorsapi.adapters.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DonorOverWeight {
    private String sexo;
    private int total;
    private double porcent;
}
