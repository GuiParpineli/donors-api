package br.com.donor.donorsapi.adapters.service.donor.imc;

import br.com.donor.donorsapi.adapters.persistence.entity.AgeImcData;

import java.util.List;

public interface DonorAdapterImcService {

    List<AgeImcData> findAllAgeAndImc();
}
