package br.com.donor.donorsapi.domain.service.donor.crud;

import br.com.donor.donorsapi.domain.model.Donor;

import java.util.List;

public interface DonorCrudService {
    boolean saveAll(List<Donor> donor);
    List<Donor> findAll();
}
