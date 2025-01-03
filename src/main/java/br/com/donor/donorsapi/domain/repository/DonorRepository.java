package br.com.donor.donorsapi.domain.repository;

import br.com.donor.donorsapi.domain.model.AgeImc;
import br.com.donor.donorsapi.domain.model.BloodType;
import br.com.donor.donorsapi.domain.model.Donor;

import java.util.List;

public interface DonorRepository {

    List<Donor> saveAll(List<Donor> donors);

    Donor findById(Integer id);

    List<Donor> findAll();

    List<AgeImc> getAllDonorImcByAge();

    List<Donor> findByState(String state);

    List<Donor> findByBloodType(BloodType bloodType);
}
