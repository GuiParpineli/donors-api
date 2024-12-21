package br.com.donor.donorsapi.domain.service;

import br.com.donor.donorsapi.adapters.persistence.entity.AgeImcData;
import br.com.donor.donorsapi.domain.model.Donor;

import java.util.List;

public interface DonorService {
    boolean saveAll(List<Donor> donor);

    List<Donor> findAll();

    List<AgeImcData> getIMCByAges();

    List<Donor> findByState(String state);
}
