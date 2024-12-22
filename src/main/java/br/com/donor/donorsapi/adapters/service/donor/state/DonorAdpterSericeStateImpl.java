package br.com.donor.donorsapi.adapters.service.donor.state;

import br.com.donor.donorsapi.domain.model.Donor;
import br.com.donor.donorsapi.domain.repository.DonorRepository;
import br.com.donor.donorsapi.domain.service.donor.state.DonorStateService;
import br.com.donor.donorsapi.domain.service.donor.state.DonorStateServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorAdpterSericeStateImpl implements DonorAdpterSericeState {
    private final DonorStateService service;

    public DonorAdpterSericeStateImpl(DonorRepository repository) {
        this.service = new DonorStateServiceImpl(repository);
    }

    @Override
    public List<Donor> getByState(String state) {
        return service.getByState(state);
    }
}
