package br.com.donor.donorsapi.infrastructure.service.donor.overweight;

import br.com.donor.donorsapi.adapters.mapper.DonorOverWeight;

import java.util.List;

public interface DonorAdapterOverWeightService {

    List<DonorOverWeight> getOverWeight();
}
