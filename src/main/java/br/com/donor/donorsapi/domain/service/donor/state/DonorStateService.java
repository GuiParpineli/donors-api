package br.com.donor.donorsapi.domain.service.donor.state;

import br.com.donor.donorsapi.domain.model.Donor;

import java.util.List;

public interface DonorStateService {
    List<Donor> getByState(String state);
}
