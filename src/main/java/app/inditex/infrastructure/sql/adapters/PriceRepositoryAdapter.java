package app.inditex.infrastructure.sql.adapters;

import app.inditex.application.domain.Price;
import app.inditex.application.ports.out.PriceRepositoryPort;
import app.inditex.infrastructure.sql.mappers.PriceDomainMapper;
import app.inditex.infrastructure.sql.repository.PriceJPARepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@AllArgsConstructor
public class PriceRepositoryAdapter implements PriceRepositoryPort {

    private final PriceJPARepository repository;
    private final PriceDomainMapper priceDomainMapper;

    @Override
    public Price findApplicablePrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        log.info("PriceRepositoryAdapter: consult the price of the product: {}", productId);
        return priceDomainMapper.toDomain(repository.findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                productId, brandId, applicationDate, applicationDate));
    }

}
