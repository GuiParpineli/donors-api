package br.com.donor.donorsapi.web.controller.donor.state;

import br.com.donor.donorsapi.adapters.persistence.DonorMapper;
import br.com.donor.donorsapi.domain.model.Donor;
import br.com.donor.donorsapi.domain.repository.DonorRepository;
import br.com.donor.donorsapi.domain.service.donor.state.DonorStateService;
import br.com.donor.donorsapi.domain.service.donor.state.DonorStateServiceImpl;
import br.com.donor.donorsapi.web.controller.donor.DonorController;
import br.com.donor.donorsapi.web.controller.donor.dto.DonorDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@DonorController
@Tag(name = "Estado")
public class DonorByStateController {

    private final DonorStateService donorService;

    public DonorByStateController(DonorRepository repository) {
        this.donorService = new DonorStateServiceImpl(repository);
    }

    @GetMapping("/byState")
    @Operation(summary = "Busca doadores por estado informado", description = "Deve ser informado a sigla do estado nos parametros da url(?)")
    public ResponseEntity<List<DonorDto>> getByState(@RequestParam String state) {
        List<Donor> byState = donorService.getByState(state);
        return ResponseEntity.ok(byState.stream().map(DonorMapper::toDto).toList());
    }
}
