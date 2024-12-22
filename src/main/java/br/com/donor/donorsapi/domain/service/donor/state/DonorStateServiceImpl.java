package br.com.donor.donorsapi.domain.service.donor.state;

import br.com.donor.donorsapi.domain.model.Donor;
import br.com.donor.donorsapi.domain.repository.DonorRepository;

import java.util.List;

public class DonorStateServiceImpl implements DonorStateService {

    private final DonorRepository donorRepository;

    public DonorStateServiceImpl(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @Override
    public List<Donor> getByState(String state) {
        return donorRepository.findByState(state);
    }
}
