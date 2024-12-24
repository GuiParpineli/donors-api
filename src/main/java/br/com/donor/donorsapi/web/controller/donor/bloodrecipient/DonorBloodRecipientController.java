package br.com.donor.donorsapi.web.controller.donor.bloodrecipient;


import br.com.donor.donorsapi.adapters.mapper.DonorMapper;
import br.com.donor.donorsapi.domain.model.BloodTypeRecipientCount;
import br.com.donor.donorsapi.infrastructure.service.donor.recipient.DonorAdapterRecipientService;
import br.com.donor.donorsapi.web.controller.donor.DonorController;
import br.com.donor.donorsapi.web.controller.donor.dto.BloodTypeRecipientCountDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@DonorController
@Tag(name = "Quantidade de possiveis doadores")
public class DonorBloodRecipientController {

    private final DonorAdapterRecipientService donorService;

    public DonorBloodRecipientController(DonorAdapterRecipientService donorService) {
        this.donorService = donorService;
    }

    @GetMapping("/blood-types/compatibility")
    @Operation(summary = "Buscar quantidade de possíveis doadores por tipo de sangue")
    public ResponseEntity<List<BloodTypeRecipientCountDto>> getPossibleDonors() {
        List<BloodTypeRecipientCount> donors = donorService.getDonorBloodType();
        return ResponseEntity.ok(donors.stream().map(DonorMapper::toBloodType).toList());
    }
}
