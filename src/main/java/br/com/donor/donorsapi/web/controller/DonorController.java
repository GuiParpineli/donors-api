package br.com.donor.donorsapi.web.controller;

import br.com.donor.donorsapi.domain.model.Donor;
import br.com.donor.donorsapi.domain.service.DonorService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class DonorController {
    private final DonorService donorService;

    public DonorController(DonorService donorService) {
        this.donorService = donorService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody List<Donor> donors) {
        return ResponseEntity.ok(donorService.saveAll(donors));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Donor>> getAll() {
        return donorService.findAll();
    }
}
