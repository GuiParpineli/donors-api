package br.com.donor.donorsapi.infrastructure.service.donor.bmi;

import br.com.donor.donorsapi.domain.service.donor.bmi.DonorImcService;
import br.com.donor.donorsapi.domain.service.donor.bmi.DonorImcServiceImpl;
import br.com.donor.donorsapi.infrastructure.model.AgeImcData;
import br.com.donor.donorsapi.infrastructure.persistence.repository.DonorRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorAdapterBmiServiceImpl implements DonorAdapterBmiService {
    private final DonorImcService donorImcService;

    public DonorAdapterBmiServiceImpl(DonorRepositoryImpl donorRepositoryImpl) {
        this.donorImcService = new DonorImcServiceImpl(donorRepositoryImpl);
    }

    @Override
    public List<AgeImcData> findAllAgeAndImc() {
        return donorImcService.getIMCByAges();
    }
}
