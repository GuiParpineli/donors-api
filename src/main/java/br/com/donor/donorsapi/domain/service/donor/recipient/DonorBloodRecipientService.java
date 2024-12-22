package br.com.donor.donorsapi.domain.service.donor.recipient;

import br.com.donor.donorsapi.domain.model.BloodTypeRecipientCount;

import java.util.List;

public interface DonorBloodRecipientService {
    List<BloodTypeRecipientCount> getTotalReceivesByBloodType();
}
