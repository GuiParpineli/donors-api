package br.com.donor.donorsapi.infrastructure.service.donor.crud;

import br.com.donor.donorsapi.domain.model.DefaultResponse;
import br.com.donor.donorsapi.domain.model.Donor;
import br.com.donor.donorsapi.domain.service.donor.crud.DonorCrudCrudServiceImpl;
import br.com.donor.donorsapi.domain.service.donor.crud.DonorCrudService;
import br.com.donor.donorsapi.infrastructure.persistence.repository.DonorRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorAdapterCrudServiceImpl implements DonorAdapterCrudService {
    private final DonorCrudService donorCrudService;

    public DonorAdapterCrudServiceImpl(DonorRepositoryImpl donorRepositoryImpl) {
        this.donorCrudService = new DonorCrudCrudServiceImpl(donorRepositoryImpl);
    }

    @Override
    public DefaultResponse saveAll(List<Donor> donors) {
        return donorCrudService.saveAll(donors);
    }

    @Override
    public List<Donor> getAll() {
        return donorCrudService.findAll();
    }
}
