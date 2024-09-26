package app.inditex.infrastructure.apirest.adapters;


import app.inditex.api.ProductPricesApi;
import app.inditex.application.ports.in.PriceServicePort;
import app.inditex.infrastructure.apirest.mappers.PricesRestMapper;
import app.inditex.model.PricesResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/app/inditex/v1")
public class PriceControllerAdapter implements ProductPricesApi {

    private PriceServicePort service;
    private final PricesRestMapper mapper;

    @Override
    public ResponseEntity<PricesResponse> productPrices(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        return ResponseEntity.ok(mapper.toRest(service.getProductPrices(applicationDate, productId, brandId)));
    }

}
