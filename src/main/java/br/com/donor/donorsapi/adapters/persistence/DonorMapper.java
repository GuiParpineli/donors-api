package br.com.donor.donorsapi.adapters.persistence;

import br.com.donor.donorsapi.adapters.model.DonorOverWeight;
import br.com.donor.donorsapi.adapters.persistence.entity.DonorEntity;
import br.com.donor.donorsapi.domain.model.Donor;
import br.com.donor.donorsapi.domain.model.Gender;
import br.com.donor.donorsapi.web.controller.donor.dto.DonorDto;
import br.com.donor.donorsapi.web.controller.donor.dto.DonorInputDto;
import br.com.donor.donorsapi.web.controller.donor.dto.DonorOverweightDto;

public class DonorMapper {

    public static Donor toDomain(DonorEntity entity) {
        return new Donor(
                entity.getName(),
                entity.getCpf(),
                entity.getRg(),
                entity.getBirthDate(),
                Gender.of(entity.getGender()),
                entity.getMotherName(),
                entity.getFatherName(),
                entity.getEmail(),
                entity.getZipCode(),
                entity.getAddress(),
                entity.getNumber(),
                entity.getDistrict(),
                entity.getCity(),
                entity.getState(),
                entity.getLandline(),
                entity.getMobile(),
                entity.getHeight(),
                entity.getWeight(),
                entity.getBloodType()
        );
    }

    public static DonorEntity toEntity(Donor donor) {
        return new DonorEntity(
                null,
                donor.name(),
                donor.cpf(),
                donor.rg(),
                donor.birthDate(),
                donor.gender().getGender(),
                donor.motherName(),
                donor.fatherName(),
                donor.email(),
                donor.zipCode(),
                donor.address(),
                donor.number(),
                donor.district(),
                donor.city(),
                donor.state(),
                donor.landline(),
                donor.mobile(),
                donor.height(),
                donor.weight(),
                donor.bloodType()
        );
    }

    public static Donor toDomain(DonorInputDto dto) {
        return new Donor(
                dto.name(),
                dto.cpf(),
                dto.rg(),
                dto.birthDate(),
                Gender.of(dto.gender()),
                dto.motherName(),
                dto.fatherName(),
                dto.email(),
                dto.zipCode(),
                dto.address(),
                dto.number(),
                dto.district(),
                dto.city(),
                dto.state(),
                dto.landline(),
                dto.mobile(),
                dto.height(),
                dto.weight(),
                dto.bloodType()
        );
    }

    public static DonorDto toDto(Donor donor) {
        return new DonorDto(
                donor.name(),
                donor.birthDate(),
                donor.gender().getGender(),
                donor.number(),
                donor.city(),
                donor.state(),
                donor.height(),
                donor.weight(),
                donor.bloodType()
        );
    }

    public static DonorOverweightDto toOverweightDto(DonorOverWeight dto) {
        return new DonorOverweightDto(
                dto.getSexo(),
                dto.getTotal(),
                dto.getPorcent() + "%"
        );
    }
}
