package br.com.donor.donorsapi.adapters.service.donor.bmi;

import br.com.donor.donorsapi.adapters.persistence.entity.AgeImcData;

import java.util.List;

public interface DonorAdapterBmiService {

    List<AgeImcData> findAllAgeAndImc();
}
