package br.com.donor.donorsapi.domain.service;

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
}
