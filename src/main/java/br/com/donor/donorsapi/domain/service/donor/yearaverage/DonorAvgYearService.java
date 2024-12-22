package br.com.donor.donorsapi.domain.service.donor.yearaverage;

import br.com.donor.donorsapi.domain.model.DonorYearAverage;

import java.util.List;

public interface DonorAvgYearService {
    List<DonorYearAverage> getYearAverage();
}
