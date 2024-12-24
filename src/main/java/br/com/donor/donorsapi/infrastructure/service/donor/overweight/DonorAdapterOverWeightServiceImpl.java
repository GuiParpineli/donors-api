package br.com.donor.donorsapi.infrastructure.service.donor.overweight;

import br.com.donor.donorsapi.adapters.mapper.DonorOverWeight;
import br.com.donor.donorsapi.domain.repository.DonorRepository;
import br.com.donor.donorsapi.domain.service.donor.overweight.DonorOverWeightService;
import br.com.donor.donorsapi.domain.service.donor.overweight.DonorOverWeightServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorAdapterOverWeightServiceImpl implements DonorAdapterOverWeightService {
    private final DonorOverWeightService service;

    public DonorAdapterOverWeightServiceImpl(DonorRepository repository) {
        this.service = new DonorOverWeightServiceImpl(repository);
    }

    @Override
    public List<DonorOverWeight> getOverWeight() {
        return service.getOverWeights();
    }
}
