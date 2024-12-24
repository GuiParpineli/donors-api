package br.com.donor.donorsapi.domain.service.donor.bmi;

import br.com.donor.donorsapi.adapters.mapper.DonorImcMapper;
import br.com.donor.donorsapi.domain.repository.DonorRepository;
import br.com.donor.donorsapi.infrastructure.model.AgeImcData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorImcServiceImpl implements DonorImcService {

    private final DonorRepository donorRepository;

    public DonorImcServiceImpl(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @Override
    public List<AgeImcData> getIMCByAges() {
        return donorRepository.getAllDonorImcByAge().stream().map(DonorImcMapper::toData).toList();
    }
}
