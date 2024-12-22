package br.com.donor.donorsapi.web.controller.donor.imc;

import br.com.donor.donorsapi.adapters.persistence.entity.AgeImcData;
import br.com.donor.donorsapi.adapters.service.donor.imc.DonorAdapterImcService;
import br.com.donor.donorsapi.web.controller.donor.DonorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@DonorController
public class DonorImcController {
    private final DonorAdapterImcService service;

    public DonorImcController(DonorAdapterImcService service) {
        this.service = service;
    }

    @GetMapping("/imcByAge")
    public ResponseEntity<List<AgeImcData>> getImcByAge() {
        return ResponseEntity.ok(service.findAllAgeAndImc());
    }
}
