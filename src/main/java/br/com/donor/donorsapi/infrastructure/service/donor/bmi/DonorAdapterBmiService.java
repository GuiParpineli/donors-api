package br.com.donor.donorsapi.infrastructure.service.donor.bmi;

import br.com.donor.donorsapi.infrastructure.model.AgeImcData;

import java.util.List;

public interface DonorAdapterBmiService {

    List<AgeImcData> findAllAgeAndImc();
}
