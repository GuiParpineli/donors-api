package br.com.donor.donorsapi.web.controller.donor.yearaverage;

import br.com.donor.donorsapi.adapters.persistence.DonorMapper;
import br.com.donor.donorsapi.adapters.service.donor.yearaverage.DonorYearAverageService;
import br.com.donor.donorsapi.domain.model.DonorYearAverage;
import br.com.donor.donorsapi.web.controller.donor.DonorController;
import br.com.donor.donorsapi.web.controller.donor.dto.DonorYearAverageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@DonorController
public class DonorYearAverageController {
    private final DonorYearAverageService donorService;

    public DonorYearAverageController(DonorYearAverageService donorService) {
        this.donorService = donorService;
    }

    @GetMapping("/yearAverage")
    public ResponseEntity<List<DonorYearAverageDto>> getYearAverage() {
        List<DonorYearAverage> yearAverages = donorService.getYearAverage();
        return ResponseEntity.ok(yearAverages.stream().map(DonorMapper::toYearAverageDto).toList());
    }
}
