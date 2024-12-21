package br.com.donor.donorsapi.domain.service;

import br.com.donor.donorsapi.adapters.persistence.DonorImcMapper;
import br.com.donor.donorsapi.adapters.persistence.entity.AgeImcData;
import br.com.donor.donorsapi.domain.model.Donor;
import br.com.donor.donorsapi.domain.repository.DonorRepository;

import java.util.List;

public class DonorServiceImpl implements DonorService {
    private final DonorRepository donorRepository;

    public DonorServiceImpl(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @Override
    public boolean saveAll(List<Donor> donor) {
        return donorRepository.saveAll(donor).size() == donor.size();
    }

    @Override
    public List<Donor> findAll() {
        return donorRepository.findAll();
    }

    @Override
    public List<AgeImcData> getIMCByAges() {
        return donorRepository.getAllDonorImcByAge().stream().map(DonorImcMapper::toData).toList();
    }

    @Override
    public List<Donor> findByState(String state) {
        return donorRepository.findByState(state);
    }
}
