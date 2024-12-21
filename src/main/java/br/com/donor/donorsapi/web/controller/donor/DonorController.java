package br.com.donor.donorsapi.web.controller.donor;

import br.com.donor.donorsapi.adapters.persistence.DonorMapper;
import br.com.donor.donorsapi.adapters.persistence.entity.AgeImcData;
import br.com.donor.donorsapi.adapters.service.DonorServiceAdapter;
import br.com.donor.donorsapi.domain.model.Donor;
import br.com.donor.donorsapi.web.controller.donor.dto.DonorDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "public/api/donor", produces = MediaType.APPLICATION_JSON_VALUE)
public class DonorController {
    private final DonorServiceAdapter donorService;

    public DonorController(DonorServiceAdapter donorService) {
        this.donorService = donorService;
    }

    @PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody List<DonorDto> donors) {
        List<Donor> inputs = donors.stream().map(DonorMapper::toDomain).toList();
        return ResponseEntity.ok(donorService.saveAll(inputs));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Donor>> getAll() {
        return ResponseEntity.ok(donorService.findAll());
    }

    @GetMapping("/imcByAge")
    public ResponseEntity<List<AgeImcData>> getImcByAge() {
        return ResponseEntity.ok(donorService.findAllAgeAndImc());
    }
}
