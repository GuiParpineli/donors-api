package br.com.donor.donorsapi.adapters.persistence.repository;

import br.com.donor.donorsapi.adapters.persistence.entity.DonorEntity;
import br.com.donor.donorsapi.adapters.persistence.entity.dto.DonorImcDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaDonorRepository extends JpaRepository<DonorEntity, Integer> {
    List<DonorEntity> findByState(String state);

    @Query(value = """
            SELECT 
                FLOOR(DATEDIFF(CURRENT_DATE, d.birth_date) / 365 / 10) * 10 AS ageRangeStart,
                FLOOR(DATEDIFF(CURRENT_DATE, d.birth_date) / 365 / 10) * 10 + 9 AS ageRangeEnd,
                AVG(d.weight / (d.height * d.height)) AS averageImc
            FROM donors d
            WHERE d.height > 0 AND d.weight > 0
            GROUP BY FLOOR(DATEDIFF(CURRENT_DATE, d.birth_date) / 365 / 10)
            """, nativeQuery = true)
    List<DonorImcDto> calculateAverageImcByAgeRange();
}
