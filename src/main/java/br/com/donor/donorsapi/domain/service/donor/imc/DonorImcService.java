package br.com.donor.donorsapi.domain.service.donor.imc;

import br.com.donor.donorsapi.adapters.persistence.entity.AgeImcData;

import java.util.List;

public interface DonorImcService {
    List<AgeImcData> getIMCByAges();
}
