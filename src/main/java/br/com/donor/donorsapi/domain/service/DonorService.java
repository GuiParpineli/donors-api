package br.com.donor.donorsapi.domain.service;

import br.com.donor.donorsapi.domain.model.Donor;

import java.util.List;

public interface DonorService {
    boolean saveAll(List<Donor> donor);
    List<Donor> findAll();
}