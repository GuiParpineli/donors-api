package br.com.donor.donorsapi.web.controller.donor.bmi;

import br.com.donor.donorsapi.adapters.persistence.entity.AgeImcData;
import br.com.donor.donorsapi.adapters.service.donor.bmi.DonorAdapterBmiService;
import br.com.donor.donorsapi.web.controller.donor.DonorController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@DonorController
@Tag(name = "IMC")
public class DonorBmiController {
    private final DonorAdapterBmiService service;

    public DonorBmiController(DonorAdapterBmiService service) {
        this.service = service;
    }

    @GetMapping("/imcByAge")
    @Operation(summary = "Busca  o ICM médio com base na idade de dez em dez anos")
    public ResponseEntity<List<AgeImcData>> getImcByAge() {
        return ResponseEntity.ok(service.findAllAgeAndImc());
    }
}
