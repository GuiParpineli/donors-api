package br.com.donor.donorsapi.infrastructure.service.donor.yearaverage;

import br.com.donor.donorsapi.domain.model.DonorYearAverage;

import java.util.List;

public interface DonorYearAverageService {

    List<DonorYearAverage> getYearAverage();
}
