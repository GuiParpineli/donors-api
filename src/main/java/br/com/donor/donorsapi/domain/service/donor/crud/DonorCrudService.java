package br.com.donor.donorsapi.domain.service.donor.crud;

import br.com.donor.donorsapi.domain.model.DefaultResponse;
import br.com.donor.donorsapi.domain.model.Donor;

import java.util.List;

public interface DonorCrudService {
    DefaultResponse saveAll(List<Donor> donor);

    List<Donor> findAll();
}
