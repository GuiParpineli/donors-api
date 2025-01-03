package br.com.donor.donorsapi.web.controller.donor.crud;

import br.com.donor.donorsapi.adapters.mapper.DonorMapper;
import br.com.donor.donorsapi.domain.model.DefaultResponse;
import br.com.donor.donorsapi.domain.model.Donor;
import br.com.donor.donorsapi.infrastructure.service.donor.crud.DonorAdapterCrudService;
import br.com.donor.donorsapi.web.controller.donor.DonorController;
import br.com.donor.donorsapi.web.controller.donor.dto.DonorDto;
import br.com.donor.donorsapi.web.controller.donor.dto.DonorInputDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@DonorController
@Tag(name = "CRUD")
public class DonorCrudController {
    private final DonorAdapterCrudService donorService;

    public DonorCrudController(DonorAdapterCrudService donorService) {
        this.donorService = donorService;
    }

    @PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Operação para salvar doadores")
    public ResponseEntity<DefaultResponseDto> save(@RequestBody List<DonorInputDto> donors) {
        List<Donor> inputs = donors.stream().map(DonorMapper::toDomain).toList();
        DefaultResponse response = donorService.saveAll(inputs);
        return ResponseEntity.ok(new DefaultResponseDto(response.code(), response.message()));
    }

    @GetMapping("/all")
    @Operation(summary = "Obter todos doadores salvos no banco")
    public ResponseEntity<List<DonorDto>> getAll() {
        List<DonorDto> donors = donorService.getAll().stream().map(DonorMapper::toDto).toList();
        return ResponseEntity.ok(donors);
    }
}
