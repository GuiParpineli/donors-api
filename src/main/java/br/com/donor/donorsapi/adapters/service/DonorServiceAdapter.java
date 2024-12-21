package br.com.donor.donorsapi.adapters.service;

import br.com.donor.donorsapi.adapters.persistence.entity.AgeImcData;
import br.com.donor.donorsapi.domain.model.Donor;

import java.util.List;

public interface DonorServiceAdapter {
    boolean saveAll(List<Donor> donors);

    List<Donor> findAll();

    List<AgeImcData> findAllAgeAndImc();
}
