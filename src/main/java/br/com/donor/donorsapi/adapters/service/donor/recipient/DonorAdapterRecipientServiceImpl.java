package br.com.donor.donorsapi.adapters.service.donor.recipient;

import br.com.donor.donorsapi.domain.model.BloodTypeRecipientCount;
import br.com.donor.donorsapi.domain.repository.DonorRepository;
import br.com.donor.donorsapi.domain.service.donor.recipient.DonorBloodRecipientService;
import br.com.donor.donorsapi.domain.service.donor.recipient.DonorBloodRecipientServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorAdapterRecipientServiceImpl implements DonorAdapterRecipientService {
    private final DonorBloodRecipientService service;

    public DonorAdapterRecipientServiceImpl(DonorRepository repository) {
        this.service = new DonorBloodRecipientServiceImpl(repository);
    }

    @Override
    public List<BloodTypeRecipientCount> getDonorBloodType() {
        return service.getTotalReceivesByBloodType();
    }
}
