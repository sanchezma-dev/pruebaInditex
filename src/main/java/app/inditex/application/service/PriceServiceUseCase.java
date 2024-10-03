package app.inditex.application.service;

import app.inditex.application.domain.Price;
import app.inditex.application.ports.in.PriceServicePort;
import app.inditex.exceptions.ApiResponseException;
import app.inditex.infrastructure.sql.adapters.BrandRepositoryAdapter;
import app.inditex.infrastructure.sql.adapters.PriceRepositoryAdapter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class PriceServiceUseCase implements PriceServicePort {

    private final PriceRepositoryAdapter adapter;
    private final BrandRepositoryAdapter brandRepositoryAdapter;


    @Override
    public Price getProductPrices(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        log.info("PriceServiceUseCase: Fetching prices for productId={}, brandId={}, applicationDate={}", productId, brandId, applicationDate);
        var brand = brandRepositoryAdapter.findBrand(brandId);
        if (brand == null) {
            log.error("Error. Brand with id {} unregistered", brandId);
            throw ApiResponseException.of("No brand found with id: " + brandId, HttpStatus.NOT_FOUND);
        }
        var price = adapter.findApplicablePrice(applicationDate, productId, brandId);
        if (price == null) {
            var errorMessage = "No price found for productId " + productId + " and brandId " + brandId + " on date " + applicationDate;
            log.error(errorMessage);
           throw ApiResponseException.of(errorMessage, HttpStatus.NOT_FOUND);
        }

        return price;
    }

}
