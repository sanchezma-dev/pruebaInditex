package app.inditex.infrastructure.sql.repository;

import app.inditex.infrastructure.sql.models.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceJPARepository extends JpaRepository<PriceEntity, Integer> {

    Optional<PriceEntity> findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            Integer productId, Integer BrandId, LocalDateTime startDate, LocalDateTime endDate);
}

