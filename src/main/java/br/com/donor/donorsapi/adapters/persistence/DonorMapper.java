package br.com.donor.donorsapi.adapters.persistence;

import br.com.donor.donorsapi.adapters.persistence.entity.DonorEntity;
import br.com.donor.donorsapi.domain.model.Donor;

public class DonorMapper {

    public static Donor toDomain(DonorEntity entity) {
        return new Donor(
                entity.getName(),
                entity.getCpf(),
                entity.getRg(),
                entity.getBirthDate(),
                entity.getGender(),
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
                donor.gender(),
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
}
