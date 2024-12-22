package br.com.donor.donorsapi.web.controller.donor.overweight;

import br.com.donor.donorsapi.adapters.model.DonorOverWeight;
import br.com.donor.donorsapi.adapters.persistence.DonorMapper;
import br.com.donor.donorsapi.adapters.service.donor.overweight.DonorAdapterOverWeightService;
import br.com.donor.donorsapi.web.controller.donor.DonorController;
import br.com.donor.donorsapi.web.controller.donor.dto.DonorOverweightDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@DonorController
@Tag(name = "Acima do peso")
public class DonorOverWeightController {

    private final DonorAdapterOverWeightService service;

    public DonorOverWeightController(DonorAdapterOverWeightService service) {
        this.service = service;
    }

    @GetMapping("/overweight")
    @Operation(summary = "Busca quantidade de obesos entre homens e mulheres")
    public ResponseEntity<List<DonorOverweightDto>> getOverweight() {
        List<DonorOverWeight> overweight = service.getOverWeight();
        return ResponseEntity.ok(overweight.stream().map(DonorMapper::toOverweightDto).toList());
    }

}
