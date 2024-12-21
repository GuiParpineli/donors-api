package br.com.donor.donorsapi.domain.repository;

import br.com.donor.donorsapi.domain.model.Donor;
import br.com.donor.donorsapi.domain.model.AgeImc;

import java.util.List;

public interface DonorRepository {

    List<Donor> saveAll(List<Donor> donors);

    Donor findById(Integer id);

    List<Donor> findAll();

    List<Donor> donorByState(String state);

    List<Donor> getAllFitDonors();

    List<AgeImc> getAllDonorImcByAge();
}
