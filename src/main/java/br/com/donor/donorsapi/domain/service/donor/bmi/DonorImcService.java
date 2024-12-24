package br.com.donor.donorsapi.domain.service.donor.bmi;

import br.com.donor.donorsapi.infrastructure.model.AgeImcData;

import java.util.List;

public interface DonorImcService {
    List<AgeImcData> getIMCByAges();
}
