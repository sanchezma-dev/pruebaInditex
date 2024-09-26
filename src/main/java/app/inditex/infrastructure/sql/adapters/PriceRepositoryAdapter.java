package app.inditex.infrastructure.sql.adapters;

import app.inditex.application.domain.Brand;
import app.inditex.application.domain.Price;
import app.inditex.application.ports.out.PriceRepositoryPort;
import app.inditex.exceptions.ApiResponseException;
import app.inditex.infrastructure.sql.mappers.BrandDomainMapper;
import app.inditex.infrastructure.sql.mappers.PriceDomainMapper;
import app.inditex.infrastructure.sql.models.BrandEntity;
import app.inditex.infrastructure.sql.models.PriceEntity;
import app.inditex.infrastructure.sql.repository.PriceJPARepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class PriceRepositoryAdapter implements PriceRepositoryPort {

    private final PriceJPARepository repository;
    private final PriceDomainMapper priceDomainMapper;
    private final BrandDomainMapper brandDomainMapper;

    @Override
    public Price findApplicablePrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        Optional<PriceEntity> priceEntityOptional = repository.findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                productId, brandId, applicationDate, applicationDate);

        return priceEntityOptional
                .map(priceDomainMapper::toDomain)
                .orElseThrow(() -> new ApiResponseException("Price not found for product: " + productId + " and brand: " + brandId, HttpStatus.NOT_FOUND));
    }

}
