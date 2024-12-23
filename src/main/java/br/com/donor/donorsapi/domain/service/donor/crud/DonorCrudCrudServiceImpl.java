package br.com.donor.donorsapi.domain.service.donor.crud;

import br.com.donor.donorsapi.domain.model.DefaultResponse;
import br.com.donor.donorsapi.domain.model.Donor;
import br.com.donor.donorsapi.domain.repository.DonorRepository;

import java.util.List;

public class DonorCrudCrudServiceImpl implements DonorCrudService {
    private final DonorRepository donorRepository;

    public DonorCrudCrudServiceImpl(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @Override
    public DefaultResponse saveAll(List<Donor> donor) {
        donorRepository.saveAll(donor);
        return DefaultResponse.succefully();
    }

    @Override
    public List<Donor> findAll() {
        return donorRepository.findAll();
    }
}
