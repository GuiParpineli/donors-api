package br.com.donor.donorsapi.adapters.service.donor.imc;

import br.com.donor.donorsapi.adapters.persistence.entity.AgeImcData;
import br.com.donor.donorsapi.adapters.persistence.repository.DonorRepositoryImpl;
import br.com.donor.donorsapi.domain.service.donor.crud.DonorCrudCrudServiceImpl;
import br.com.donor.donorsapi.domain.service.donor.imc.DonorImcService;
import br.com.donor.donorsapi.domain.service.donor.imc.DonorImcServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorAdapterImcServiceImpl implements DonorAdapterImcService {
    private final DonorImcService donorImcService;

    public DonorAdapterImcServiceImpl(DonorRepositoryImpl donorRepositoryImpl) {
        this.donorImcService = new DonorImcServiceImpl(donorRepositoryImpl);
    }

    @Override
    public List<AgeImcData> findAllAgeAndImc() {
        return donorImcService.getIMCByAges();
    }
}
