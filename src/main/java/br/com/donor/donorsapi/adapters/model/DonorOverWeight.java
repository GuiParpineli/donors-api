package br.com.donor.donorsapi.adapters.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DonorOverWeight {
    private String gender;
    private int total;
    private double percent;
}
