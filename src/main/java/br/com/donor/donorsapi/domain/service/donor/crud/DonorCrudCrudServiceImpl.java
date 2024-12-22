package br.com.donor.donorsapi.domain.service.donor.crud;

import br.com.donor.donorsapi.domain.model.*;
import br.com.donor.donorsapi.domain.repository.DonorRepository;

import java.util.List;

public class DonorCrudCrudServiceImpl implements DonorCrudService {
    private final DonorRepository donorRepository;

    public DonorCrudCrudServiceImpl(DonorRepository donorRepository) {
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
