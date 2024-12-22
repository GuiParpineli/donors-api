package br.com.donor.donorsapi.domain.service.donor.bmi;

import br.com.donor.donorsapi.adapters.persistence.DonorImcMapper;
import br.com.donor.donorsapi.adapters.persistence.entity.AgeImcData;
import br.com.donor.donorsapi.domain.repository.DonorRepository;
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
