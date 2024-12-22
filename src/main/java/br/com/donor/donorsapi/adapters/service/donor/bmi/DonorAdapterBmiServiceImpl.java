package br.com.donor.donorsapi.adapters.service.donor.bmi;

import br.com.donor.donorsapi.adapters.persistence.entity.AgeImcData;
import br.com.donor.donorsapi.adapters.persistence.repository.DonorRepositoryImpl;
import br.com.donor.donorsapi.domain.service.donor.bmi.DonorImcService;
import br.com.donor.donorsapi.domain.service.donor.bmi.DonorImcServiceImpl;
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
