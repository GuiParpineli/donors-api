package br.com.donor.donorsapi.adapters.service.donor.recipient;

import br.com.donor.donorsapi.domain.model.BloodTypeRecipientCount;

import java.util.List;

public interface DonorAdapterRecipientService {
    List<BloodTypeRecipientCount> getDonorBloodType();
}
