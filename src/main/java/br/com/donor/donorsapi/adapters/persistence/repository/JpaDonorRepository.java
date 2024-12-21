package br.com.donor.donorsapi.adapters.persistence.repository;

import br.com.donor.donorsapi.adapters.persistence.entity.DonorEntity;
import br.com.donor.donorsapi.adapters.persistence.entity.AgeImcData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaDonorRepository extends JpaRepository<DonorEntity, Integer> {
    List<DonorEntity> findByState(String state);

    @Query(value = """
        SELECT
            CASE
                WHEN TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 0 AND 10 THEN '0-10'
                WHEN TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 11 AND 20 THEN '11-20'
                WHEN TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 21 AND 30 THEN '21-30'
                WHEN TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 31 AND 40 THEN '31-40'
                WHEN TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 41 AND 50 THEN '41-50'
                WHEN TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 51 AND 60 THEN '51-60'
                ELSE '60+'
            END AS ageRange,
            AVG(weight / POWER(height, 2)) AS averageImc
        FROM donors
        WHERE height > 0 AND weight > 0
        GROUP BY ageRange
        ORDER BY ageRange
        """, nativeQuery = true)
    List<AgeImcData> calculateAverageImcByAgeRange();
}
