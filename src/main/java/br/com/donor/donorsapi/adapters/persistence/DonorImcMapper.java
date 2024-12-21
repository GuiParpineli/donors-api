package br.com.donor.donorsapi.adapters.persistence;

import br.com.donor.donorsapi.adapters.persistence.entity.AgeImcData;
import br.com.donor.donorsapi.domain.model.AgeImc;
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
