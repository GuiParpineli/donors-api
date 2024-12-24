package br.com.donor.donorsapi.adapters.mapper;

import br.com.donor.donorsapi.domain.model.AgeImc;
import br.com.donor.donorsapi.infrastructure.model.AgeImcData;
import org.springframework.stereotype.Component;

@Component
public class DonorImcMapper {

    public static AgeImc toData(AgeImcData donorImc) {
        return new AgeImc(
                donorImc.getAgeRange(),
                donorImc.getAverageImc()
        );
    }

    public static AgeImcData toData(AgeImc ageImc) {
        return new AgeImcData(
                ageImc.ageRange(),
                ageImc.averageImc()
        );
    }
}
