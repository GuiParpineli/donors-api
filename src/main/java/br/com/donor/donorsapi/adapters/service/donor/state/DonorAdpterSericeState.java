package br.com.donor.donorsapi.adapters.service.donor.state;

import br.com.donor.donorsapi.domain.model.Donor;

import java.util.List;

public interface DonorAdpterSericeState {

    List<Donor> getByState(String state);
}
