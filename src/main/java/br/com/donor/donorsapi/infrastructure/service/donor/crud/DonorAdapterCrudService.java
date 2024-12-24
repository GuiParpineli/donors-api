package br.com.donor.donorsapi.infrastructure.service.donor.crud;

import br.com.donor.donorsapi.domain.model.DefaultResponse;
import br.com.donor.donorsapi.domain.model.Donor;

import java.util.List;

public interface DonorAdapterCrudService {

    DefaultResponse saveAll(List<Donor> donors);

    List<Donor> getAll();
}
