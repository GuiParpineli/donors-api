package br.com.donor.donorsapi.domain.service.donor.overweight;

import br.com.donor.donorsapi.adapters.model.DonorOverWeight;

import java.util.List;

public interface DonorOverWeightService {
    List<DonorOverWeight> getOverWeights();
}
