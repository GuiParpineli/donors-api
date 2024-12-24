package br.com.donor.donorsapi.domain.service.donor.overweight;

import br.com.donor.donorsapi.adapters.mapper.DonorOverWeight;
import br.com.donor.donorsapi.domain.model.Donor;
import br.com.donor.donorsapi.domain.model.Gender;
import br.com.donor.donorsapi.domain.repository.DonorRepository;

import java.util.List;

public class DonorOverWeightServiceImpl implements DonorOverWeightService {

    private final DonorRepository donorRepository;

    public DonorOverWeightServiceImpl(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @Override
    public List<DonorOverWeight> getOverWeights() {
        List<Donor> fatDonors = donorRepository.findAll();
        return List.of(
                calculateOverWeight(fatDonors, Gender.MALE),
                calculateOverWeight(fatDonors, Gender.FEMALE)
        );
    }

    private DonorOverWeight calculateOverWeight(List<Donor> donors, Gender gender) {
        List<Donor> filteredDonors = donors.stream()
                .filter(donor -> donor.gender() == gender)
                .toList();

        long overWeightTotal = filteredDonors.stream()
                .filter(this::isOverWeight)
                .count();

        double percent = overWeightTotal == 0
                ? 0
                : (double) (filteredDonors.size() * overWeightTotal) / 100;

        return new DonorOverWeight(gender.getGender(), filteredDonors.size(), percent);
    }

    private boolean isOverWeight(Donor donor) {
        double imc = donor.weight() / (donor.height() * donor.height());
        return imc > 30;
    }
}
