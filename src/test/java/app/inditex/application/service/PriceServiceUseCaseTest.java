package app.inditex.application.service;

import app.inditex.application.domain.Brand;
import app.inditex.application.domain.Price;
import app.inditex.application.service.PriceServiceUseCase;
import app.inditex.exceptions.ApiResponseException;
import app.inditex.infrastructure.sql.adapters.BrandRepositoryAdapter;
import app.inditex.infrastructure.sql.adapters.PriceRepositoryAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceServiceUseCaseTest {

    @Mock
    private PriceRepositoryAdapter mockAdapter;
    @Mock
    private BrandRepositoryAdapter mockBrandAdapter;

    @InjectMocks
    private PriceServiceUseCase service;

    private LocalDateTime application;
    private Integer productId, brandId;
    private Brand brand;
    private Price price;

    @BeforeEach
    void setup() {
        application = LocalDateTime.now();
        productId = 10;
        brandId = 1;

        brand = Brand.builder().id(brandId).build();
        price = Price.builder()
                .productId(productId)
                .brandId(brandId)
                .finalPrice(10.5)
                .build();
    }


    @DisplayName("Should get an exception for not finding the searched brand")
    @Test
    void getProductPricesErrorBrandTest() {
        when(mockBrandAdapter.findBrand(brandId)).thenReturn(null);

        assertThrows(ApiResponseException.class, () -> {
            service.getProductPrices(application, productId, brandId);
        });

    }

    @DisplayName("Should get a price for the indicated product")
    @Test
    void getProductPricesOkTest() {
        when(mockBrandAdapter.findBrand(brandId)).thenReturn(brand);
        when(mockAdapter.findApplicablePrice(application, productId, brandId)).thenReturn(price);

        var response = service.getProductPrices(application, productId, brandId);

        assertNotNull(response);
        assertThat(response.getProductId()).isEqualTo(price.getProductId());
        assertThat(response.getBrandId()).isEqualTo(price.getBrandId());
        assertThat(response.getFinalPrice()).isEqualTo(price.getFinalPrice());

    }
}
