package br.com.donor.donorsapi.domain.service.donor.yearaverage;

import br.com.donor.donorsapi.domain.model.BloodType;
import br.com.donor.donorsapi.domain.model.Donor;
import br.com.donor.donorsapi.domain.model.DonorYearAverage;
import br.com.donor.donorsapi.domain.repository.DonorRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DonorAvgYearServiceImpl implements DonorAvgYearService {
    private final DonorRepository donorRepository;

    public DonorAvgYearServiceImpl(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @Override
    public List<DonorYearAverage> getYearAverage() {
        Map<BloodType, List<Donor>> donorsByBloodType = new HashMap<>();
        List<Donor> donors = donorRepository.findAll();
        for (BloodType bloodType : BloodType.values()) {
            List<Donor> byBloodTYpe = donors.stream().filter(donor -> donor.bloodType() == bloodType).toList();
            donorsByBloodType.put(bloodType, byBloodTYpe);
        }
        List<DonorYearAverage> donorYearAverages = new ArrayList<>();
        getAverageAgeByBloodType(donorsByBloodType)
                .forEach((bloodType, averageAge) -> donorYearAverages.add(new DonorYearAverage(bloodType.getDescription(), Math.round(averageAge))));

        return donorYearAverages;
    }

    public Map<BloodType, Double> getAverageAgeByBloodType(Map<BloodType, List<Donor>> donorsByBloodType) {
        return donorsByBloodType.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            List<Donor> donors = entry.getValue();
                            if (donors.isEmpty()) {
                                return 0.0;
                            }
                            return donors.stream()
                                    .mapToInt(donor -> calculateAge(donor.birthDate()))
                                    .average()
                                    .orElse(0.0);
                        }
                ));
    }

    private int calculateAge(LocalDate localDate) {
        return LocalDate.now().getYear() - localDate.getYear();
    }
}
