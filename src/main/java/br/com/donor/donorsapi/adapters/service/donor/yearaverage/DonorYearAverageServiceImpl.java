package br.com.donor.donorsapi.adapters.service.donor.yearaverage;

import br.com.donor.donorsapi.domain.model.DonorYearAverage;
import br.com.donor.donorsapi.domain.repository.DonorRepository;
import br.com.donor.donorsapi.domain.service.donor.yearaverage.DonorAvgYearService;
import br.com.donor.donorsapi.domain.service.donor.yearaverage.DonorAvgYearServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorYearAverageServiceImpl implements DonorYearAverageService {
    private final DonorAvgYearService service;

    public DonorYearAverageServiceImpl(DonorRepository repository) {
        this.service = new DonorAvgYearServiceImpl(repository);
    }

    @Override
    public List<DonorYearAverage> getYearAverage() {
        return service.getYearAverage();
    }

}
