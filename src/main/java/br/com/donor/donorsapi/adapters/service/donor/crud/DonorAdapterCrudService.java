package br.com.donor.donorsapi.adapters.service.donor.crud;

import br.com.donor.donorsapi.domain.model.Donor;

import java.util.List;

public interface DonorAdapterCrudService {

    boolean saveAll(List<Donor> donors);

    List<Donor> getAll();
}
