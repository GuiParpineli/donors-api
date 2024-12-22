package br.com.donor.donorsapi.domain.service.donor.recipient;

import br.com.donor.donorsapi.domain.model.BloodType;
import br.com.donor.donorsapi.domain.model.BloodTypeRecipientCount;
import br.com.donor.donorsapi.domain.model.Donor;
import br.com.donor.donorsapi.domain.repository.DonorRepository;

import java.util.List;

public class DonorBloodRecipientServiceImpl implements DonorBloodRecipientService {

    private final DonorRepository donorRepository;

    public DonorBloodRecipientServiceImpl(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @Override
    public List<BloodTypeRecipientCount> getTotalReceivesByBloodType() {
        List<Donor> donors = donorRepository.findAll();
        return List.of();
    }

    private boolean canDonateTo(BloodType donor, BloodType recipient) {
        return switch (donor) {
            case O_NEGATIVE -> true;
            case O_POSITIVE -> recipient == BloodType.O_POSITIVE || recipient == BloodType.A_POSITIVE
                    || recipient == BloodType.B_POSITIVE || recipient == BloodType.AB_POSITIVE;
            case A_NEGATIVE -> recipient == BloodType.A_NEGATIVE || recipient == BloodType.A_POSITIVE
                    || recipient == BloodType.AB_NEGATIVE || recipient == BloodType.AB_POSITIVE;
            case A_POSITIVE -> recipient == BloodType.A_POSITIVE || recipient == BloodType.AB_POSITIVE;
            case B_NEGATIVE -> recipient == BloodType.B_NEGATIVE || recipient == BloodType.B_POSITIVE
                    || recipient == BloodType.AB_NEGATIVE || recipient == BloodType.AB_POSITIVE;
            case B_POSITIVE -> recipient == BloodType.B_POSITIVE || recipient == BloodType.AB_POSITIVE;
            case AB_NEGATIVE -> recipient == BloodType.AB_NEGATIVE || recipient == BloodType.AB_POSITIVE;
            case AB_POSITIVE -> recipient == BloodType.AB_POSITIVE;
        };
    }
}
