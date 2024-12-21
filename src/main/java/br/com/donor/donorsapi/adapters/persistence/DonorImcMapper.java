package br.com.donor.donorsapi.adapters.persistence;

import br.com.donor.donorsapi.adapters.persistence.entity.dto.DonorImcDto;
import br.com.donor.donorsapi.domain.model.DonorImc;
import org.springframework.stereotype.Component;

@Component
public class DonorImcMapper {

    public static DonorImc toDomain(DonorImcDto donorImc) {
        return new DonorImc(
                donorImc.getAgeRangeStart(),
                donorImc.getAgeRangeEnd(),
                donorImc.getAverageImc()
        );
    }

    public static DonorImcDto donorImcDto(DonorImc donorImc) {
        return new DonorImcDto(
                donorImc.ageRangeStart(),
                donorImc.ageRangeEnd(),
                donorImc.averageImc()
        );
    }
}
