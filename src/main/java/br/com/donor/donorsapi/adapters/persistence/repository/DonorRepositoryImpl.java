package br.com.donor.donorsapi.adapters.persistence.repository;

import br.com.donor.donorsapi.adapters.persistence.DonorImcMapper;
import br.com.donor.donorsapi.adapters.persistence.DonorMapper;
import br.com.donor.donorsapi.adapters.persistence.entity.DonorEntity;
import br.com.donor.donorsapi.domain.model.Donor;
import br.com.donor.donorsapi.domain.model.DonorImc;
import br.com.donor.donorsapi.domain.repository.DonorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DonorRepositoryImpl implements DonorRepository {
    private final JpaDonorRepository jpaDonorRepository;

    public DonorRepositoryImpl(JpaDonorRepository jpaDonorRepository) {
        this.jpaDonorRepository = jpaDonorRepository;
    }

    @Override
    public List<Donor> saveAll(List<Donor> donors) {
        List<DonorEntity> list = donors.stream().map(DonorMapper::toEntity).toList();
        return jpaDonorRepository.saveAll(list).stream().map(DonorMapper::toDomain).toList();
    }

    @Override
    public Donor findById(Integer id) {
        return DonorMapper.toDomain(jpaDonorRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<Donor> findAll() {
        return List.of();
    }

    @Override
    public List<Donor> donorByState(String state) {
        return List.of();
    }

    @Override
    public List<Donor> getAllFitDonors() {
        return List.of();
    }

    @Override
    public List<DonorImc> getAllDonorImcByAge() {
        return jpaDonorRepository.calculateAverageImcByAgeRange().stream().map(DonorImcMapper::toDomain).toList();
    }
}
