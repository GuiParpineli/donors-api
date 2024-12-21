package br.com.donor.donorsapi.adapters.service;

import br.com.donor.donorsapi.adapters.persistence.DonorMapper;
import br.com.donor.donorsapi.adapters.persistence.entity.AgeImcData;
import br.com.donor.donorsapi.adapters.persistence.repository.DonorRepositoryImpl;
import br.com.donor.donorsapi.domain.model.Donor;
import br.com.donor.donorsapi.domain.service.DonorService;
import br.com.donor.donorsapi.domain.service.DonorServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorServiceAdapterImpl implements DonorServiceAdapter {
    private final DonorService donorService;

    public DonorServiceAdapterImpl(DonorRepositoryImpl donorRepositoryImpl) {
        this.donorService = new DonorServiceImpl(donorRepositoryImpl);
    }

    @Override
    public boolean saveAll(List<Donor> donors) {
        return donorService.saveAll(donors);
    }

    @Override
    public List<Donor> findAll() {
        return donorService.findAll();
    }

    @Override
    public List<AgeImcData> findAllAgeAndImc() {
        return donorService.getIMCByAges();
    }

    @Override
    public List<Donor> findByState(String state) {
        return donorService.findByState(state);
    }
}
