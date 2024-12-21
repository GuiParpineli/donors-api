package br.com.donor.donorsapi.domain.service;

import br.com.donor.donorsapi.adapters.model.DonorOverWeight;
import br.com.donor.donorsapi.adapters.persistence.DonorImcMapper;
import br.com.donor.donorsapi.adapters.persistence.entity.AgeImcData;
import br.com.donor.donorsapi.domain.model.Donor;
import br.com.donor.donorsapi.domain.model.Gender;
import br.com.donor.donorsapi.domain.repository.DonorRepository;
import br.com.donor.donorsapi.web.controller.donor.dto.DonorOverweightDto;

import java.util.List;
import java.util.stream.Stream;

public class DonorServiceImpl implements DonorService {
    private final DonorRepository donorRepository;

    public DonorServiceImpl(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @Override
    public boolean saveAll(List<Donor> donor) {
        return donorRepository.saveAll(donor).size() == donor.size();
    }

    @Override
    public List<Donor> findAll() {
        return donorRepository.findAll();
    }

    @Override
    public List<AgeImcData> getIMCByAges() {
        return donorRepository.getAllDonorImcByAge().stream().map(DonorImcMapper::toData).toList();
    }

    @Override
    public List<Donor> findByState(String state) {
        return donorRepository.findByState(state);
    }

    @Override
    public List<DonorOverWeight> findOverWeights() {
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

        double porcent = overWeightTotal == 0
                ? 0
                : (double) (filteredDonors.size() * overWeightTotal) / 100;

        return new DonorOverWeight(
                gender.getGender(),
                filteredDonors.size(),
                porcent
        );
    }

    private boolean isOverWeight(Donor donor) {
        double imc = donor.weight() / (donor.height() * donor.height());
        return imc > 30;
    }
}
