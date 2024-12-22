package br.com.donor.donorsapi.web.controller.donor.bloodrecipient;


import br.com.donor.donorsapi.adapters.persistence.DonorMapper;
import br.com.donor.donorsapi.adapters.service.donor.recipient.DonorAdapterRecipientService;
import br.com.donor.donorsapi.domain.model.BloodTypeRecipientCount;
import br.com.donor.donorsapi.web.controller.donor.DonorController;
import br.com.donor.donorsapi.web.controller.donor.dto.BloodTypeRecipientCountDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@DonorController
public class DonorBloodRecipientController {

    private final DonorAdapterRecipientService donorService;

    public DonorBloodRecipientController(DonorAdapterRecipientService donorService) {
        this.donorService = donorService;
    }

    @GetMapping("/donorsForBloodType")
    @Operation(summary = "Buscar quantidade de possíveis doadores por tipo de sangue")
    public ResponseEntity<List<BloodTypeRecipientCountDto>> getPossibleDonors() {
        List<BloodTypeRecipientCount> donors = donorService.getDonorBloodType();
        return ResponseEntity.ok(donors.stream().map(DonorMapper::toBloodType).toList());
    }
}